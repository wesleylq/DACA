package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo.models", "com.example.demo.controllers","com.example.demo.services","com.example.demo.repositories"})
public class LozApplication {

	public static void main(String[] args) {
		SpringApplication.run(LozApplication.class, args);
	}

}
