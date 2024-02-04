package com.writer.cymmetri.apibasedsso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.writer.cymmetri.apibasedsso"})
public class ApiBasedSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBasedSsoApplication.class, args);
        System.out.println("Welcome to API BASED SSO");
    }
}
