package com.app.docker.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloWorldController {

	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHelloWorld(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Hello World Docker from Controller!");
	}
}
