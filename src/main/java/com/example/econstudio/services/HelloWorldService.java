package com.example.econstudio.services;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class HelloWorldService{
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/sum/{A}/{B}")
	public Integer sum(
			@PathVariable("A") Integer A,
			@PathVariable("B") Integer B) {
		return A+B;
	}

	@GetMapping("/my/hello/object")
	public HelloObject getHelloObject() {
		HelloObject ho = new HelloObject();
		ho.setId(123);
		ho.setName("New Hello Object");
		return ho;
	}

	@GetMapping("/hello/{name}")
	public String sayHelloToNameWithMessage(
			@RequestParam("message") String msg,
			@PathVariable("name") String nameVariable) {
		return "Hello " + nameVariable + ", message = " + msg;
	}

//	@GetMapping("/message")
	@RequestMapping(value = "/getmessage",
			method = RequestMethod.GET,
			produces = "application/json")
	public Message getMessage() {
		Message msg = new Message();
//		return msg.text + " created at " + msg.createdAt;
		return msg;
	}
}

class Message {
	String text = "Default text";
	Date createdAt = new Date(); // setters & getters
}
