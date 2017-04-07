package com.deusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//TODO this disable basic-error-controller
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BookitApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookitApplication.class, args);
    }
}