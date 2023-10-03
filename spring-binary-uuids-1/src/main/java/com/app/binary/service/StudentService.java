package com.app.binary.service;

import java.util.List;

import com.app.binary.bean.StudentBean;

public interface StudentService {

	public void addStudentData(StudentBean student);

	public List<StudentBean> getAllStudentsList();

	public StudentBean getStudentDataByName(StudentBean student);
}
