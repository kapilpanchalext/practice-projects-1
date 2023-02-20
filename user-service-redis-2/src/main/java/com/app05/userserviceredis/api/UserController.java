package com.app05.userserviceredis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app05.userserviceredis.model.UserDetails;
import com.app05.userserviceredis.service.UserService;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(path = "/")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {
		return service.saveUser(userDetails);
	}
	
	@GetMapping(path = "/get-user/{userId}")
	public UserDetails getUserDetailsById(@PathVariable(name = "userId") Long userId) {
		return service.getUserDetailsById(userId);
	}
}