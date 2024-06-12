package com.app.badge.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/m")
public class OpenBadgesController {

	@GetMapping(path = "/runTopInTermBadgeSchedulerMBAWX")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.status(HttpStatus.OK).body("RunTopInTermBadgeSchedulerMBAWX");
	}
}
