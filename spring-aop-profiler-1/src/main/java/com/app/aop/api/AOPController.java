package com.app.aop.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.aop.service.AOPService;

@RestController
@RequestMapping(path = "/api/v1")
public class AOPController {

	Logger logger = LoggerFactory.getLogger(AOPController.class);
	
	@Autowired
	private AOPService service;
	
	@GetMapping(path = "/aop")
	public ResponseEntity<String> getAopData() throws InterruptedException {
		
		logger.info("Controller");
		service.getAopData();
		
		return ResponseEntity.status(HttpStatus.OK).body("Hello from Spring AOP - Profiler");
	}
}
