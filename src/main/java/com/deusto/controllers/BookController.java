package com.deusto.controllers;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.dtos.FilterDTO;
import com.deusto.models.Book;
import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAllBooks() {
        return new ResponseEntity(bookService.findAll(), OK);
    }

    /* pentru mine ca sa pot introduce carti */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> createBook(@RequestBody BookDTO bookDTO) {

        return new ResponseEntity(bookService.insert(BookBuilder.get(bookDTO)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity(bookService.findById(id), OK);
    }

//    /* trial pentru parametri de filtrare */
//    @GetMapping
//    public HttpEntity<?> getAllBooksFilter(@RequestParam(value = "title") String title) {
//        return new ResponseEntity(bookService.findByTitle(title), OK);
//    }

    @PostMapping(path = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> getAllBooksFilter1(@RequestBody FilterDTO filterDTO) {
        Set set = new HashSet();
        Long nullValue = null;
        List<Book> bookList = new ArrayList<>(); // set rather than list
        if(filterDTO.getTitle() != null) {
            set.addAll(bookService.findByTitle(filterDTO.getTitle()));
        }

        if (filterDTO.getGenre() != null) {
            set.addAll(bookService.findByGenre(filterDTO.getTitle()));
        }
        bookList.addAll(set);
        return new ResponseEntity<>(bookList, OK);
    }
}
