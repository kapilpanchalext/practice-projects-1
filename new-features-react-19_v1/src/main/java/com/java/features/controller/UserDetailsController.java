package com.java.features.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.features.model.UserDetails;
import com.java.features.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/")
@RequiredArgsConstructor
public class UserDetailsController {
	private final UserService userService;

	@GetMapping(path = "/user")
	public ResponseEntity<List<UserDetails>> getUserDetailsList() {
		List<UserDetails> userDetails = userService.getUserDetails();
		return ResponseEntity.status(HttpStatus.OK)
				.body(userDetails);
	}
	
	@PostMapping(path = "/update-name")
	public ResponseEntity<String> updateName(@RequestBody UserDetails userDetails) {
		
		try {
			Thread.sleep(5000); // Simulate a delay
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error updating name: " + e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("Name updated successfully");
	}
}
