package com.deusto.controllers;

import com.deusto.models.Book;
import com.deusto.models.Registr;
import com.deusto.repositories.BookRepository;
import com.deusto.services.EmailTemplate;
import freemarker.template.Configuration;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @Autowired
    BookRepository bRepository;

    @Autowired
    EmailTemplate emailTemplate;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> post(@RequestBody Book book) {
        return new ResponseEntity<>(bRepository.insert(book), HttpStatus.OK);
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> json() {
        return new ResponseEntity<>(bRepository.findByTitle("not use this"), HttpStatus.OK);
    }

    @GetMapping(path = "/insertFake")
    public HttpEntity<?> index() {
        Book bok = new Book();
        bok.setTitle("not use this");
        bok.setAuthorFirstName("not use this");
        return new ResponseEntity<>(bRepository.insert(bok), HttpStatus.OK);
    }


    @Autowired
    @Qualifier("freeMarkerConfiguration")
    Configuration freeMarkerConfiguration;


    @GetMapping(path = "/sendEmailExample")
    public HttpEntity<?> send() throws Exception {

        Registr reg = new Registr();
        reg.setFirstname("iobana");

        String form = FreeMarkerTemplateUtils.processTemplateIntoString(
                freeMarkerConfiguration.getTemplate("template.ftl"),
                new BeanMap(reg));

        return new ResponseEntity<>(form, HttpStatus.OK);
    }
}