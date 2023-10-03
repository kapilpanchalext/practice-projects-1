package com.app.map.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.map.service.MapAliasingService;

@RestController
@RequestMapping(path = "/api/v1")
public class MapAliasingController {

	@Autowired
	private MapAliasingService service;
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello From Map Key Aliasing");
	}
	
	@GetMapping(path = "/alias-key")
	public ResponseEntity<String> getMapAliasKey(){
		service.MapKeyAlias();
		return ResponseEntity.status(HttpStatus.OK).body("Map Key Alias");
	}
}
