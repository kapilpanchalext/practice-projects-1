package com.app04.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app04.demo.model.Course;
import com.app04.demo.model.Student;
import com.app04.demo.service.StudentService;

@RestController
@RequestMapping(path = "/student/api/v1")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping(path = "/get-all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> student = service.getAllStudents();
		return ResponseEntity.ok(student);
	}

	@PostMapping(path = "/add-student")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		int status = service.addStudent(student);
		String statusMessage = "";
		if(status >= 0) {
			statusMessage = "Update Successful!";
		} else {
			statusMessage = "Update Failed!";
		}
		return ResponseEntity.ok(statusMessage);
	}

	@PutMapping(path = "/update-student-course")
	public ResponseEntity<String> updateStudentCourse(@RequestBody Student student){
		int status = service.updateStudentCourse(student);
		String statusMessage = "";		
		if(status >= 0) {
			statusMessage = "Update Successful!";
		} else {
			statusMessage = "Update Failed!";
		}
		return ResponseEntity.ok(statusMessage);
	}
	
	@PostMapping(path = "/add-course")
	public ResponseEntity<String> addCourse(@RequestBody Course course){
		int status = service.addCourse(course);
		String statusMessage = "";
		if(status >= 0) {
			statusMessage = "Update Successful!";
		} else {
			statusMessage = "Update Failed!";
		}
		return ResponseEntity.ok(statusMessage);
	}
	
	@GetMapping(path = "/get-all-student-courses")
	public ResponseEntity<List<Student>> getAllStudentCourses(){
		List<Student> student = service.getAllStudentCourses();
		return ResponseEntity.ok(student);
	}
}