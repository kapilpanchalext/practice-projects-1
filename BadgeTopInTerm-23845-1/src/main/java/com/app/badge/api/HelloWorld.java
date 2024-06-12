package com.app.badge.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping(path = "/hello-world")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Hello World");
	}
}
