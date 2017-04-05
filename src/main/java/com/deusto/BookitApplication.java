package com.deusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableEmailTools
public class BookitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);
	}
}
