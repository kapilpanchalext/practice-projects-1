package com.java.features.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
