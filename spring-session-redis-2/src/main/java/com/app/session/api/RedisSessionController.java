package com.app.session.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/api/v1")
public class RedisSessionController {

	@GetMapping(path = "/session")
	public ResponseEntity<String> getSessionUserId(HttpSession session){
		String id = (String) session.getAttribute("userId");
		System.err.println("SESSION ID: " + id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
}