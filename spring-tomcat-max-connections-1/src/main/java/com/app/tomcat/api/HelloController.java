package com.app.tomcat.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloController {
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello() throws InterruptedException{
		
		Thread.sleep(5000);		
		return ResponseEntity.status(HttpStatus.OK).body("Hello Controller Max Connections - Task Completed");
	}
}