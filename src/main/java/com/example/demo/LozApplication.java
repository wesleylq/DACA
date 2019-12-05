package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching

@SpringBootApplication(scanBasePackages = {"com.example.demo.models", "com.example.demo.controllers",
		"com.example.demo.services","com.example.demo.repositories","com.example.demo.config"})
public class LozApplication {

	public static void main(String[] args) {
		SpringApplication.run(LozApplication.class, args);
	}
	

}
