package com.app.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.redis.bean.TodoBean;
import com.app.redis.repo.RedisRepository;

@Service
public class RedisService {

	@Autowired
	private RedisRepository repo;

	public Iterable<TodoBean> getAllData() {		
		Iterable<TodoBean> iterableTodos = repo.findAll();
		return iterableTodos;
	}

	public TodoBean saveBean(TodoBean todoBean) {
		TodoBean status = repo.saveAndFlush(todoBean);
		return status;
	}	
}