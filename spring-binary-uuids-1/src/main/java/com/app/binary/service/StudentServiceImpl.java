package com.app.binary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.binary.bean.StudentBean;
import com.app.binary.dao.StudentDao;
import com.app.binary.repo.RedisRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private RedisRepository repo;

	@Override
	public void addStudentData(StudentBean student) {
		dao.addStudentData(student);
		StudentBean status = this.getStudentDataByName(student);
		repo.save(status);
	}

	@Override
	public List<StudentBean> getAllStudentsList() {
		List<StudentBean> studentsList = dao.getAllStudentsList();
		repo.saveAll(studentsList);
		return studentsList;
	}

	@Override
	public StudentBean getStudentDataByName(StudentBean student) {
		StudentBean studentStatus = dao.getStudentDataByName(student);
		StudentBean status = repo.save(studentStatus);
		return studentStatus;
	}
}
