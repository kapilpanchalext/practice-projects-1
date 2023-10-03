package com.app.unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.unittest.bean.StudentBean;
import com.app.unittest.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;

	@Override
	public String addStudent(StudentBean student) {
		System.err.println("Inside addStudent Method");
		return dao.addStudent(student);
	}

//	@Override
//	public void addStudentVoidMethod(StudentBean student) {
//		System.err.println("Inside addStudentVoidMethod");
//		dao.addStudentVoidMethod(student);
//	}
	
	@Override
	public void addStudentVoidMethod(StudentBean student) {
		System.err.println("Inside addStudentVoidMethod");
		this.addStudent(student);
	}
}
