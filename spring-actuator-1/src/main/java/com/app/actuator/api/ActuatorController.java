package com.app.actuator.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ActuatorController {

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
}
