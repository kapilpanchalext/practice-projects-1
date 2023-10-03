package com.app.annotation.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.annotation.bean.CustomBean;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomAnnotationController {

	@GetMapping(path = "hello")
	public ResponseEntity<String> getHello(){
		CustomBean bean = new CustomBean();
		
		System.err.println("CUSTOM BEAN: " + bean);
		return ResponseEntity.status(HttpStatus.OK).body(bean.toString());
	}
}
