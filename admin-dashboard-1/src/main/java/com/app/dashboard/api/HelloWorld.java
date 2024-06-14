package com.app.dashboard.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dashboard.pagination.Page;
import com.app.dashboard.util.PaginationUtil;

@RestController
@RequestMapping(path = "/api/v1")
public class HelloWorld {

	@GetMapping(path = "/hello")
	ResponseEntity<String> helloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
	}
	
	@GetMapping(path = "/pagination")
	ResponseEntity<Page<String>> pagination(
			@RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "2") int size){
		
		List<String> list = Arrays.asList("Item1", "Item2", "Item3", "Item4", "Item5");
		
//		int page = 0;
//	    int size = 2;

        Page<String> pagedList = PaginationUtil.convertListToPage(list, page, size);

        System.err.println("Total Pages: " + pagedList.getTotalPages());
        System.err.println("Total Elements: " + pagedList.getTotalElements());
        System.err.println("Current Page Content: " + pagedList.getContent());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(pagedList);
	}
}
