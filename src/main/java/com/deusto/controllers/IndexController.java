package com.deusto.controllers;

import com.deusto.models.Book;
import com.deusto.models.Registr;
import com.deusto.repositories.BookRepository;
import com.deusto.services.EmailTemplate;
import com.google.common.collect.ImmutableMap;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    Configuration freemarkerConfiguration;


    @GetMapping(path = "/sendEmailExample")
    public HttpEntity<?> send() throws Exception {

        Registr reg = new Registr();
        reg.setFirstname("iobana");

        String form = FreeMarkerTemplateUtils.processTemplateIntoString(
                freemarkerConfiguration.getTemplate("template.ftl"),
                new BeanMap(reg));

        return new ResponseEntity<>(form, HttpStatus.OK);
    }
}