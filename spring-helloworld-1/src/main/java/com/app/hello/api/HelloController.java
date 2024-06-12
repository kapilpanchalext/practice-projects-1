package com.app.hello.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

	@GetMapping(path = "/hello")
	public ResponseEntity<String> helloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
}
