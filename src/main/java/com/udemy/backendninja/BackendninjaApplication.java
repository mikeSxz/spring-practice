package com.udemy.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.udemy.backendninja")
@EnableJpaRepositories("com.udemy.backendninja.repository")
@EntityScan("com.udemy.backendninja.entity")
public class BackendninjaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}
}