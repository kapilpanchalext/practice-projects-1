package com.app02.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app02.userservice.VO.ResponseTemplateVO;
import com.app02.userservice.model.UserDetails;
import com.app02.userservice.service.UserService;

@RestController
@RequestMapping(path = "/users")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/")
	public UserDetails saveUser(@RequestBody UserDetails userDetails) {
		return userService.saveUser(userDetails);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable ("id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
}
