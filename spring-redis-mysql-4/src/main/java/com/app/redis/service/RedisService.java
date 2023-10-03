package com.app.redis.service;

import java.util.List;

import com.app.redis.bean.StudentBean;

public interface RedisService {

	StudentBean addStudentToRedis(StudentBean student);

	StudentBean getById(String id);

	List<StudentBean> addStudentListToRedis(List<StudentBean> studentList);
}
