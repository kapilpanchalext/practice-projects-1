package com.app.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.redis.bean.Todo;

public interface TodoRepo extends CrudRepository<Todo, Long>{

	
}
