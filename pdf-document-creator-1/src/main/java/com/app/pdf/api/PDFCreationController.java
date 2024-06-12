package com.app.pdf.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pdf.create.PDFGenerator;

@RestController
@RequestMapping(path = "/api/v1")
public class PDFCreationController {
	
	@Autowired
	private PDFGenerator pdfGenerator;

	@GetMapping(path = "/hello-world")
	public ResponseEntity<String> getHelloWorld(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Hello World from PDF Creator");
	}
	
	@GetMapping(path = "/generate-pdf")
	public ResponseEntity<String> generatePdf(@RequestBody String string) {
		
		try {
			pdfGenerator.generatePdf(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Generated: " + string);
	}
}
