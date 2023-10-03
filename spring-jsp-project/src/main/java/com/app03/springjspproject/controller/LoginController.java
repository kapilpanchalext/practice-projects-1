package com.app03.springjspproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app03.springjspproject.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
//	@RequestMapping(value = "/login")
	
	
}
