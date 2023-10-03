package com.app.redis.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.redis.bean.TodoBean;
import com.app.redis.service.RedisService;

@RestController
@RequestMapping(path = "/api/v1")
public class RedisController {
	
	@Autowired
	private RedisService service;
	
	@GetMapping(path = "/hello")
	public ResponseEntity<List<TodoBean>> getHelloWorld() {
		
		Iterable<TodoBean> iterableTodos  = service.getAllData();
		
		List<TodoBean> todos = StreamSupport.stream(iterableTodos.spliterator(), false)
                .collect(Collectors.toList());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(todos);
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<TodoBean> addTodoList(@RequestBody TodoBean todoBean){
		
		TodoBean status = service.saveBean(todoBean);
		
		return ResponseEntity.status(HttpStatus.OK).body(status);
	}
}