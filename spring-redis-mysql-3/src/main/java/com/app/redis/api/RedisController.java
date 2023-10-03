package com.app.redis.api;

import java.util.List;

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
	public ResponseEntity<List<TodoBean>> getHello() {
		long startRedisFetch = System.nanoTime();
		List<TodoBean> response = (List<TodoBean>) service.getResponseFromRedis();
		long endRedisFetch = System.nanoTime();
		System.err.println("OverAll Time To Execute: NANOSECONDS " + ((endRedisFetch - startRedisFetch)));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<TodoBean> addRedisData(@RequestBody TodoBean bean) {
		TodoBean response = service.addRedisData(bean);		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	@PostMapping(path = "/addList")
	public ResponseEntity<List<TodoBean>> addRedisDataList(@RequestBody List<TodoBean> beanList) {
		List<TodoBean> response = service.addRedisDataList(beanList);		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
}