package com.deusto.controllers;

import com.deusto.models.Book;
import com.deusto.security.AuthenticationService;
import com.deusto.services.BookService;
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

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/index")
public class IndexController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> post(@RequestBody @Valid Book book) {
        return new ResponseEntity<>(bookService.insert(book), HttpStatus.OK);
    }

    @GetMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> auth() {
        Book book = new Book();
        book.setAuthorFirstName("test");
        book.setAuthorLastName("test");
        book.setAgeLimit(18);
        book.setCount(3);
        return new ResponseEntity(bookService.insert(book), HttpStatus.OK);
    }

    @GetMapping(path = "/authUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> authUser() {
        return new ResponseEntity(authenticationService.getUserFromRequest(), HttpStatus.OK);
    }

    @GetMapping(path = "/unauth", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> unAuth() {
        Book book = new Book();
        book.setAuthorFirstName("test");
        book.setAuthorLastName("test");
        book.setAgeLimit(18);
        book.setCount(3);
        return new ResponseEntity(bookService.insert(book), HttpStatus.OK);
    }

    @GetMapping(path = "/insertFake")
    public HttpEntity<?> index() {
        Book bok = new Book();
        bok.setTitle("not use this");
        bok.setAuthorFirstName("not use this");
        return new ResponseEntity(bookService.insert(bok), HttpStatus.OK);
    }

}