package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.**")
public class MovieRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsApplication.class, args);
	}

}
