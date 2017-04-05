package com.deusto.services;

import java.util.Arrays;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class EmailTemplate {
	
	@Autowired
	public EmailService emailService;
	
	public void sendMail() throws Exception{
		final Email email = DefaultEmail.builder()
		        .from(new InternetAddress("bookit1617@gmail.com", "BOOKIT"))
		        .to(Arrays.asList(new InternetAddress("bookit1617@gmail.com", "BOOKIT")))
		        .subject("Bookit test email")
		        .body("hello from bootkit system")
		        .encoding("UTF-8").build();
		emailService.send(email);
	}
}
