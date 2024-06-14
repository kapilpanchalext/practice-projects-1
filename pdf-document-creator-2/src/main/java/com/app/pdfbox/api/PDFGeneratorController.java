package com.app.pdfbox.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pdfbox.DocumentBean;
import com.app.pdfbox.TableOfContents;
import com.app.pdfbox.pdf.PDFFrontPage;
import com.app.pdfbox.pdf.PDFGenerator;

@RestController
@RequestMapping(path = "/api/v1")
public class PDFGeneratorController {
	
	@Autowired
	private PDFGenerator pdf;
	
	@Autowired
	private PDFFrontPage pdfFront;
	
	@Autowired
	private TableOfContents toc;

	@GetMapping(path = "/hello-world")
	private ResponseEntity<String> getHelloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}
	
	@PostMapping(path = "/generate-pdf")
	private ResponseEntity<String> generatePdf(@RequestBody DocumentBean document) {
		
//		pdf.generate(string);
		pdfFront.createFrontPage(document);
		toc.createTableOfContents();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("PDF Generated!");
	}
}
