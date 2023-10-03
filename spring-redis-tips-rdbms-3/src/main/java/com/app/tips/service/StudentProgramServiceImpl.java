package com.app.tips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tips.bean.Student;
import com.app.tips.repo.ProgramRepository;
import com.app.tips.repo.RedisRepository;
import com.app.tips.repo.StudentRepository;

@Service
public class StudentProgramServiceImpl implements StudentProgramService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ProgramRepository programRepo;
	
	@Autowired
	private RedisRepository repo;

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Student addToHashMap(Student student) {
		
		StringBuilder key = new StringBuilder();		
		StringBuilder hashKey = new StringBuilder();
		
		key.append(student.getFirstName());
		key.append(":");
		key.append(student.getLastName());
		
		hashKey.append(student.getStudentId());
		
		return repo.addToHashMap(key.toString(), hashKey.toString(), student);
	}
	
	@Override
	public Student getFromHashMap(Student student) {
		
		StringBuilder key = new StringBuilder();		
		
		key.append(student.getFirstName());
		key.append(":");
		key.append(student.getLastName());
	
		return repo.getFromHashMap(key.toString());
	}

	@Override
	public Student addStudent(Student student) {
		Student status = studentRepo.save(student);
		return status;
	}
}

