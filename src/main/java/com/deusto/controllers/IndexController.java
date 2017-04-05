package com.deusto.controllers;

import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.Mongo;
import com.deusto.models.Book;
import com.deusto.repositories.BookRepository;
import com.deusto.services.EmailTemplate;

@Controller
public class IndexController {

	@Autowired
	BookRepository bRepository;
	
	@Autowired
	EmailTemplate emailTemplate;
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> post(@RequestBody Book book){    	
		return new ResponseEntity(bRepository.insert(book),HttpStatus.OK);
	}
	
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> json(){
    	return new ResponseEntity(bRepository.findByTitle("not use this"),HttpStatus.OK);
    }
	
    @GetMapping(path = "/insertFake")
    public HttpEntity<?> index() {
    	Book bok = new Book();
    	bok.setTitle("not use this");
    	bok.setAuthorFirstName("not use this");
        return new ResponseEntity(bRepository.insert(bok),HttpStatus.OK);
    }

    
    @GetMapping(path = "/sendEmailExample")
    public HttpEntity<?> send() throws Exception{
    	//https://github.com/ozimov/spring-boot-email-tools
    	// access link and teach... 
    	emailTemplate.sendMail();
    	return new ResponseEntity("email was send",HttpStatus.OK);
    }
}