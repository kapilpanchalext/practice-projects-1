package com.app.binary.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.binary.bean.StudentBean;

public interface RedisRepository extends CrudRepository<StudentBean, String>{

}
