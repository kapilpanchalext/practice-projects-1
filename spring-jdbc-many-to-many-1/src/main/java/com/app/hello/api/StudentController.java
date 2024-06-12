package com.app.hello.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hello.bean.AnswersBean;
import com.app.hello.bean.StudentBean;
import com.app.hello.service.StudentService;

@RestController
@RequestMapping(path = "/student/api/v1")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHelloWorld() {
		
		List<StudentBean> studentsList = service.getAllStudents();
		System.err.println("STUDENTS LIST: " + studentsList);
		
		List<AnswersBean> answersList = service.getAllAnswers();
		System.err.println("ANSWERS LIST: " + answersList);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(studentsList.toString());
	}
}