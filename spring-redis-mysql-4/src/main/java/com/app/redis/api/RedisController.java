package com.app.redis.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.redis.bean.StudentBean;
import com.app.redis.service.RedisService;

@RestController
@RequestMapping(path = "/api/v1")
public class RedisController {

	@Autowired
	private RedisService service;
	
	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		return ResponseEntity.status(HttpStatus.OK).body("Hello World Redis Repo - 4");
	}
	
	@GetMapping(path = "/get-by-id/{id}")
	public ResponseEntity<StudentBean> getById(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<StudentBean> addStudentToRedis(@RequestBody StudentBean student){
		StudentBean status = service.addStudentToRedis(student);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
	
	@PostMapping(path = "/add-list")
	public ResponseEntity<List<StudentBean>> addStudentListToRedis(@RequestBody List<StudentBean> studentList){
		List<StudentBean> status = service.addStudentListToRedis(studentList);
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
}