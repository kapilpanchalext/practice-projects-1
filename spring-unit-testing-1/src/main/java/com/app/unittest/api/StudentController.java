package com.app.unittest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.unittest.bean.StudentBean;
import com.app.unittest.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World from JUnit 5 Tests");
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<String> addStudent(@RequestBody StudentBean student){
		
		String status = service.addStudent(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@PostMapping(path = "/addVoid")
	public ResponseEntity<String> addStudentVoidMethod(@RequestBody StudentBean student){
		
		service.addStudentVoidMethod(student);
		
		return ResponseEntity.status(HttpStatus.OK).body("Add Student Successful");
	}
}
