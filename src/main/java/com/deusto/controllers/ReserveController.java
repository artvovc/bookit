package com.deusto.controllers;

import com.deusto.builders.ReserveBuilder;
import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Reserve;
import com.deusto.security.AuthenticationService;
import com.deusto.services.BookService;
import com.deusto.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @Autowired
    BookService bookService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> create(@RequestBody Reserve reserve) {
        return new ResponseEntity<>(reserveService.insert(reserve), HttpStatus.OK);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> json() {
        return new ResponseEntity( HttpStatus.OK);
    }

    @PostMapping(path = "/other", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> newReserve(@RequestBody ReserveDTO reserveDTO) {
        if (authenticationService.getUserFromRequest() != null) {
            return new ResponseEntity<>(reserveService.insert(ReserveBuilder.get(reserveDTO)), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
