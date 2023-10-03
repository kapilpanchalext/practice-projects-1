package com.app.map.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloController {

	@GetMapping(path = "/hello-maps")
	public ResponseEntity<Map<String, String>> getHelloMaps(){
		
		Map<String, String> originalMap = new HashMap<>();		
		originalMap.put("Key1", "Value1");
		
		Map<String, String> newMap = new HashMap<>();
//		newMap.put("newKey1", originalMap.get("Key1"));
		newMap.put("newKey1", "Key1");
		
		Map<String, String> newMap2 = new HashMap<>();
//		newMap2.put("newKey2", newMap.get("newKey1"));
		newMap2.put("newKey2", "Key1");
		
		return ResponseEntity.status(HttpStatus.OK).body(newMap2.get("newKey2"));
	}
}
