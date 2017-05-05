package com.deusto.controllers;

import com.deusto.builders.ReserveBuilder;
import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Book;
import com.deusto.models.Reserve;
import com.deusto.repositories.BookRepository;
import com.deusto.security.AuthenticationService;
import com.deusto.security.SecurityUser;
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
    BookRepository bookRepository;

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAll() {
        return new ResponseEntity(reserveService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> newReserve(@RequestBody ReserveDTO reserveDTO) {

        SecurityUser user = authenticationService.getUserFromRequest();
        if (bookRepository.findAllById(reserveDTO.getBookId()).getCount() <= 0 ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if ( user != null) {
            return new ResponseEntity<>(reserveService.insert(reserveDTO, user), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
