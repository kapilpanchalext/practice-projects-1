package com.app04.ldap.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ldap/api/v1")
public class LDAPController {

	@GetMapping(path = "hello")
	public String index() {
		return "Welcome to the Home Page!";
	}
}