package com.app.pdf.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pdf.service.PDFService;

@RestController
@RequestMapping(path = "/api/v1")
public class PDFController {

	@Autowired
	private PDFService service;
	
	@GetMapping(path = "/write")
	public ResponseEntity<String> writePdf(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.writePdfBox()); //service.writeNewPdf() //service.writePdf() //
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}		
	}
}
