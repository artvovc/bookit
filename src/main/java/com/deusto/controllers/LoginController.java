package com.deusto.controllers;

import com.deusto.dtos.LoginDTO;
import com.deusto.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return authenticationService.authentication(loginDTO);
    }
}
