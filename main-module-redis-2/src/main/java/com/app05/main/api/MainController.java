package com.app05.main.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app05.main.model.MainData;
import com.app05.main.service.MainService;

@RestController
@RequestMapping(path = "/api/v1")
public class MainController {

	@Autowired
	private MainService service;
	
	@PostMapping(path = "/")
	public MainData saveMainData(@RequestBody MainData data) {	
		return service.saveMainData(data);
	}
	
	@GetMapping(path = "/get-main-id/{mainId}")
	public MainData getMainDataById(@PathVariable(name = "mainId") Long mainId) {
		return service.getMainDataById(mainId);		
	}
}