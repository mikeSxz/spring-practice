package com.udemy.backendninja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.udemy.backendninja")
@EnableJpaRepositories("com.udemy.backendninja.repository")
@EntityScan("com.udemy.backendninja.entity")
@EnableScheduling
public class BackendninjaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}
}