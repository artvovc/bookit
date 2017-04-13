package com.deusto.controllers;

import com.deusto.builders.RegistrBuilder;
import com.deusto.builders.UserBuilder;
import com.deusto.dtos.LoginDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.dtos.RegistrDTO;
import com.deusto.forms.email.RegistrForm;
import com.deusto.models.Registr;
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
        //TODO avoid try catch block in controllers
        try {
            emailService.send(
                    env.getProperty("mail.template"),
                    RegistrForm.get(registrService.insert(RegistrBuilder.get(registrDTO)), format("%s%s", env.getProperty("app.url"), env.getProperty("registration.path"))));
        } catch (Exception e) {
            return new ResponseEntity<>(ImmutableMap.of("error", e.getMessage()), BAD_REQUEST);
        }
        return new ResponseEntity<>(ImmutableMap.of("message", env.getProperty("mail.message")), OK);
    }

    @GetMapping(path = "/activate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> secondStep(@PathVariable String id) {
        Registr registr = registrService.findById(id);
        registr.setActiv(true);
        registrService.update(registr);
        return new ResponseEntity<>(ImmutableMap.of("message", "successfull activated"), OK);
    }

    @PostMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> lastStep(@RequestBody @Valid PersonDTO person) {
        //TODO ADD CONTROLLERADVICE
            Registr registr = registrService.findByEmail(person.getEmail());
        if (!registr.isActiv()) return new ResponseEntity<>(ImmutableMap.of("message", "activate email"), BAD_REQUEST);
        LoginDTO loginDTO = UserBuilder.get(userService.insert(UserBuilder.get(registr, person)));
        registrService.delete(registr);
        return authenticationService.authentication(loginDTO);
    }

}

