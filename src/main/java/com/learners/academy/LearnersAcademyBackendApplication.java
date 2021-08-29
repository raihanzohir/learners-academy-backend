package com.learners.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.learners.academy.entity"})
public class LearnersAcademyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnersAcademyBackendApplication.class, args);
	}

}
