package com.example.hw3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.hw3.survey"})
public class Hw3Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw3Application.class, args);
	}

}
