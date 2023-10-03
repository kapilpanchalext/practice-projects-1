package com.app.tips.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.tips.bean.Program;
import com.app.tips.bean.Student;
import com.app.tips.service.StudentProgramService;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentProgramController {
	
	@Autowired
	private StudentProgramService service;
	
	@GetMapping(path = "get-name")
	public ResponseEntity<Student> getStudentByStudentDetails(@RequestParam ("firstName") String firstName){
		Student status = service.getStudentByStudentDetails(firstName);
		System.err.println("PARAM: " + firstName);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	

	@PostMapping(path = "add-student")
	public ResponseEntity<String> addStudentToRedis(@RequestBody Student student) {
		Student status = service.addStudentToRedis(student);
		System.err.println("Student: " + status);
		return ResponseEntity.status(HttpStatus.OK).body("Student Data Saved Successfully!");
	}
	
	@PostMapping(path = "add-program")
	public ResponseEntity<String> addProgramToRedis(@RequestBody Program program) {
		Program status = service.addProgramToRedis(program);
		System.err.println("Program: " + status);
		return ResponseEntity.status(HttpStatus.OK).body("Program Data Saved Successfully!");
	}
}
