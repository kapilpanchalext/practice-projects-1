package com.app.redis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.redis.bean.StudentBean;
import com.app.redis.repo.CustomRedisRepository;
import com.app.redis.repo.RedisRepository;

@Service
public class RedisServiceImpl implements RedisService{
	
	@Autowired
	private CustomRedisRepository repository;
	
	@Autowired
	private RedisRepository repo;

	@Override
	public StudentBean addStudentToRedis(StudentBean student) {
		
//		String key = "firstName:lastName:age:gender:programName:" + student.getFirstName() + ":" + student.getLastName() + ":" + student.getAge() + ":"
//		+ student.getGender() + ":" + student.getProgramName();
		
//		String key = student.getFirstName() + ":" + student.getLastName() + ":" + student.getAge();
		
//		String hashKey = "hashId:" + student.getStudentId().toString(); 
				
//		repository.addToHashMap(key, hashKey, student);
//		repository.addToHashMap(hashKey, key, student);
//		repository.addToSortedSet(hashKey, student.toString(), 1);
		StudentBean status = repo.save(student);
		
		System.err.println("SAVE TO REDIS: " + student);		
		
//		StudentBean status = (StudentBean) repository.getFromHashMap(hashKey, "");
		
//		System.err.println("GET FROM REDIS: " + status);
		
//		List<StudentBean> statusObject = (List<StudentBean>) repo.findAll();
//		
//		System.err.println("STATUS OBJECT: " + statusObject);
		
		return student;
	}

	@Override
	public StudentBean getById(String id) {
//		String hashKey = "hashId:" + id;
		String hashKey = id;
//		StudentBean status = (StudentBean) repository.getFromHashMap(hashKey, "");
		
//		System.err.println("GETBYID FROM REDIS : " + status);
		return null;
	}

	@Override
	public List<StudentBean> addStudentListToRedis(List<StudentBean> studentList) {
		studentList.stream().map((student) -> {
			String key = student.getFirstName() + ":" + student.getLastName() + ":" + student.getAge();
			String hashKey = "hashId:" + student.getStudentId().toString();
			repository.addToHashMap(key, hashKey, student);
			return student;
			}).collect(Collectors.toList());
		return null;
	}
}
