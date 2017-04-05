package com.deusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@SpringBootApplication
@EnableEmailTools
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BookitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);
	}
}