package com.app.pdf.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PDFController {
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHelloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
	
	@PostMapping(path = "/get-html")
	public ResponseEntity<String> getHtml(@RequestBody String htmlData){
		
		System.err.println("HTML DATA: " + htmlData);
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
}
