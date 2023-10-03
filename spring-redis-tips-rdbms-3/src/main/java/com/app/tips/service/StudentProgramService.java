package com.app.tips.service;

import java.util.List;

import com.app.tips.bean.Student;

public interface StudentProgramService {

	List<Student> getAllStudents();

	Student addToHashMap(Student student);

	Student getFromHashMap(Student student);

	Student addStudent(Student student);
	
}