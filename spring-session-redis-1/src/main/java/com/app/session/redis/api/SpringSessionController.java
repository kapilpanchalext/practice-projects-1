package com.app.session.redis.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/api/v1")
public class SpringSessionController {

	@GetMapping(path = "/session")
	public ResponseEntity<String> getHelloSession(@RequestParam String userId, HttpSession session){
		
		session.setAttribute("userId", userId);
		String id = (String) session.getAttribute("userId");
		return ResponseEntity.status(HttpStatus.OK).body("Hello From Session Controller: " + id);
	}
}
