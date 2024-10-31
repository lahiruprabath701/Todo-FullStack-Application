package com.example.Todo_FullStack_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

public class TodoFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoFullStackApplication.class, args);
	}

}
