package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineController {
	
	@RequestMapping("/greet") //localhost:8082/greet
	public String greetMessage() {
		return "Welcome to Online Exam System";
	}

}
