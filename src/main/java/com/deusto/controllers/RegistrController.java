package com.deusto.controllers;

import com.deusto.builders.RegistrBuilder;
import com.deusto.builders.UserBuilder;
import com.deusto.dtos.LoginDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.dtos.RegistrDTO;
import com.deusto.forms.email.RegistrForm;
import com.deusto.security.AuthenticationService;
import com.deusto.services.RegistrService;
import com.deusto.services.UserService;
import com.deusto.services.mail.EmailService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/registration")
public class RegistrController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private Environment env;

    @Autowired
    private RegistrService registrService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> firstStep(@RequestBody @Valid RegistrDTO registrDTO) {
        if (!registrService.exists(registrDTO.getEmail()))
            try {
                emailService.send(env.getProperty("mail.template"), RegistrForm.get(registrService.insert(RegistrBuilder.get(registrDTO)), format("%s%s", env.getProperty("app.url"), env.getProperty("registration.path"))));
            } catch (Exception e) {
                return new ResponseEntity<>(ImmutableMap.of("error", e.getMessage()), BAD_REQUEST);
            }
        return new ResponseEntity<>(ImmutableMap.of("message", env.getProperty("mail.message")), OK);
    }

    @GetMapping(path = "/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> secondStep(@PathVariable String id) {
        return new ResponseEntity<>(registrService.updateReg(id), OK);
    }

    @PostMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> lastStep(@RequestBody @Valid PersonDTO person) {
        return registrService.findByEmail(person.getEmail()).map(
                registr -> {
                    registrService.delete(registr);
                    LoginDTO loginDTO = UserBuilder.get(userService.insert(UserBuilder.get(registr, person)));
                    return authenticationService.authentication(loginDTO);
                }
        ).orElse(
                new ResponseEntity<>(ImmutableMap.of("message", "activate email"), BAD_REQUEST)
        );
    }

}

