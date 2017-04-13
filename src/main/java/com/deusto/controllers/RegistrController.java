package com.deusto.controllers;

import com.deusto.builders.RegistrBuilder;
import com.deusto.dtos.RegistrDTO;
import com.deusto.forms.email.RegistrForm;
import com.deusto.repositories.RegistrRepository;
import com.deusto.repositories.UserRepository;
import com.deusto.services.RegistrService;
import com.deusto.services.mail.EmailService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private RegistrRepository registrRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> registr(@RequestBody @Valid RegistrDTO registrDTO) {
        //TODO avoid try catch block in controllers
        try {
            emailService.send(
                    env.getProperty("mail.template"),
                    RegistrForm.get(registrService.insert(RegistrBuilder.get(registrDTO)), format("%s%s", env.getProperty("app.url"), env.getProperty("registration.path"))));
        } catch (Exception e) {
            return new ResponseEntity<>(ImmutableMap.of("error", e.getMessage()), BAD_REQUEST);
        }
        return new ResponseEntity<>(ImmutableMap.of("email", env.getProperty("mail.message")), OK);
    }

//    fignea nea
//    @PostMapping(path = "/path/to/be/specified", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public HttpEntity<?> post(@RequestBody User user) {
//        // de sters
//        user = UserBuilder.get(registrRepository.findById("58ee15fb5304b81078dee964"));
//        return new ResponseEntity<>(userRepository.insert(user), HttpStatus.OK);
//    }

}

