package com.app.badge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.badge.service.OpenBadgesService1;


@RestController
@RequestMapping(path = "/m")
public class OpenBadgesController {
	
	@Autowired
	private OpenBadgesService1 service;
	
	@GetMapping(path = "/runTopInProgramBadgeSchdulerMBAWX")
	ResponseEntity<String> runTopInProgramBadgeSchdulerMBAWX(
			@RequestParam(name = "passoutMonth") String passoutMonth, 
			@RequestParam(name = "passoutYear") int passoutYear) {
		
		System.err.println("PASSOUT MONTH: " + passoutMonth);
		System.err.println("PASSOUT YEAR: " + passoutYear);
		
		service.callTopInProgramBadgeForAllStudentMBAWX(passoutMonth, passoutYear);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Successful");
	}
}
