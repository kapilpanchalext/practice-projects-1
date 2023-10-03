package com.app.docker.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		logger.info("Hello World from Docker Application");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Hello World from Docker Application");
	}
}
