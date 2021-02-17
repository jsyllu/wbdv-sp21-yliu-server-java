package com.example.econstudio.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorldService{
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/hello/{name}")
	public String sayHelloToNameWithMessage(
			@RequestParam("message") String msg,
			@PathVariable("name") String nameVariable) {
		return "Hello " + nameVariable + ", message = " + msg;
	}

	@GetMapping("/message")
	public String getMessage() {
		Message msg = new Message();
		return msg.text + " created at " + msg.createdAt;
	}
}

class Message {
	String text = "Default text";
	Date createdAt = new Date(); // setters & getters
}
