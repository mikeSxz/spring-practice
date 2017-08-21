package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examplethymeleaferrors")
public class Example4Controller {

	@GetMapping("/")
	public String getNotFound() {
		return "404";
	}
	
	@GetMapping("/500")
	public String getError() {
		return "500";
	}

}
