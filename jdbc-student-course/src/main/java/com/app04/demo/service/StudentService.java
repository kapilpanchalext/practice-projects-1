package com.app04.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app04.demo.dao.StudentDao;
import com.app04.demo.model.Course;
import com.app04.demo.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;

	public List<Student> getAllStudents() {		
		return dao.getAllStudents();
	}

	public int addStudent(Student student) {
		int status = dao.addStudent(student);
		return status;
	}


	public int addCourse(Course course) {
		int status = dao.addCourse(course);
		return status;
	}

	public int updateStudentCourse(Student student) {
		int status = dao.updateStudentCourse(student);
		return status;
	}

	public List<Student> getAllStudentCourses() {
		
		return dao.getAllStudentCourses();
	}
}