package com.app.tips.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tips.bean.Student;
import com.app.tips.service.StudentProgramService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentProgramController {

	@Autowired
	private StudentProgramService service;
	
	@GetMapping(path = "/get")
	public ResponseEntity<List<Student>> getAllStudents(){		
		List<Student> studentsList = service.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(studentsList);
	}
	
	@PostMapping(path = "/add-student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student status = service.addStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(service.addToHashMap(student));
	}
	
	@GetMapping(path = "/get-firstname-lastname")
	public ResponseEntity<Student> getByFirstNameLastName(@RequestBody Student student){		
		Student status = service.getFromHashMap(student);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
}