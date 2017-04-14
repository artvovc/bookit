package com.deusto.controllers;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.models.Book;
import com.deusto.repositories.BookRepository;
import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
//    public HttpEntity<?> getAllBooks() {
//        return new ResponseEntity(bookService.findAll(), OK);
//    }

    /* pentru mine ca sa pot introduce carti */
    @PostMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> createBook(@RequestBody BookDTO bookDTO) {

        return new ResponseEntity(bookService.insert(BookBuilder.get(bookDTO)), HttpStatus.OK);
    }

    @GetMapping(path = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity(bookService.findById(id), OK);
    }

    /* trial pentru parametri de filtrare */
    @GetMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAllBooksFilter(@RequestParam(value = "title") String title) {
        return new ResponseEntity(bookService.findByTitle(title), OK);
    }
}
