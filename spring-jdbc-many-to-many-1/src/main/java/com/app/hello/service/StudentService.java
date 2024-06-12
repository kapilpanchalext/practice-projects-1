package com.app.hello.service;

import java.util.List;

import com.app.hello.bean.AnswersBean;
import com.app.hello.bean.StudentBean;

public interface StudentService {

	List<StudentBean> getAllStudents();

	List<AnswersBean> getAllAnswers();

}
