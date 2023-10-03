package com.app.markov.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class MarkovCustomHeaderController {

	@GetMapping(path = "/custom-header")
	public ResponseEntity<String> getCustomHeader(@RequestHeader(value = "click-handler-header") String requestHeader){
		String status = requestHeader;
		log.info(status);
		
//		AtomicInteger clickHandler1 = new AtomicInteger();
//		AtomicInteger clickHandler2 = new AtomicInteger();
//		
//		double total = 100.00;
//		
//		switch(status) {
//			case "CustomHeaderFromPostMan 1":
//				clickHandler1.getAndIncrement();
//				System.err.println("Probability of 1: " + (clickHandler1.get()/total));
//				break;
//				
//			case "CustomHeaderFromPostMan 2":
//				clickHandler2.getAndIncrement();
//				System.err.println("Probability of 2: " + (clickHandler2.get()/total));
//				break;
//		}
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
}
