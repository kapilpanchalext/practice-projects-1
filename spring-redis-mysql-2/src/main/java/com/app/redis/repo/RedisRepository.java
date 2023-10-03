package com.app.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.redis.bean.TodoBean;

public interface RedisRepository extends JpaRepository<TodoBean, Long> {
	
}