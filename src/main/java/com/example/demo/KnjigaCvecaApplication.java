package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo") // Adjust the package as needed
@EntityScan("model")
public class KnjigaCvecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnjigaCvecaApplication.class, args);
	}

}
