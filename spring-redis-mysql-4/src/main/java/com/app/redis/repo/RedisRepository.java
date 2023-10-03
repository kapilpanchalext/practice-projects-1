package com.app.redis.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.app.redis.bean.StudentBean;

public interface RedisRepository extends CrudRepository<StudentBean, UUID>{

}
