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
	
	@PostMapping(path = "/")
	public ModelAndView post(@ModelAttribute Book book, Model model){
		
		/* The below code should not be present. To erase. */
//		Mongeez mongeez = new Mongeez();
//    	mongeez.setFile(new ClassPathResource("/db/mongeez.xml"));
//    	mongeez.setMongo(new Mongo("localhost", 27017));
//    	mongeez.setDbName("bookit_db");
//    	mongeez.process();
    	
    	bRepository.insert(book);
		model.addAttribute("content", bRepository.findAll());
		return new ModelAndView("list");
	}
	
    @GetMapping(path = "/")
    public ModelAndView index(Model model) {
    	
    	
    	Book bok = new Book();
    	bok.setTitle("not use this");
    	bok.setAuthorFirstName("not use this");
    	bRepository.insert(bok);
        return new ModelAndView("index","book", new Book());
    }
    
    @GetMapping(path = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> json(){
    	return new ResponseEntity(bRepository.findByTitle("not use this"),HttpStatus.OK);
    }
    
    @GetMapping(path = "/sendEmailExample")
    public HttpEntity<?> send() throws Exception{
    	//https://github.com/ozimov/spring-boot-email-tools
    	// access link and teach... 
    	emailTemplate.sendMail();
    	return new ResponseEntity("email was send",HttpStatus.OK);
    }
}