package com.app.hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hello.bean.AnswersBean;
import com.app.hello.bean.StudentBean;
import com.app.hello.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentDao dao;
	
	@Override
	public List<StudentBean> getAllStudents() {
		List<StudentBean> studentsList = dao.getAllStudents(); 
		return studentsList;
	}

	@Override
	public List<AnswersBean> getAllAnswers() {
		List<AnswersBean> answersList = dao.getAllAnswers();
		return answersList;
	}
}
