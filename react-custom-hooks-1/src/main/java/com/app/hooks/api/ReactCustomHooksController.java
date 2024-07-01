package com.app.hooks.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.hooks.model.PlacesBean;
import com.app.hooks.service.ReactCustomHooksService;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ReactCustomHooksController {
	
	@Autowired
	private ReactCustomHooksService service;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> reactCustomHooksHello() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("React CustomHooks Hello");
	}
	
	@GetMapping(path = "/places")
	public ResponseEntity<List<PlacesBean>> getPlaces() {
		
		List<PlacesBean> placesBeanList = service.getPlacesList();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(placesBeanList);
	}
	
	@GetMapping(path = "/get-user-places")
	public ResponseEntity<List<PlacesBean>> getUserPlaces() {
		
		List<PlacesBean> placesBeanSubList = service.getPlacesSublist();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(placesBeanSubList);
	}
	
	@PutMapping(path = "/update-user-places")
	public ResponseEntity<String> updateUserPlaces(@RequestBody List<PlacesBean> placesBeanList) {
		
		System.err.println(placesBeanList);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Update User Places");
	}
}
