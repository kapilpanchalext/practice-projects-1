package com.app.unittest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.unittest.bean.StudentBean;
import com.app.unittest.dao.StudentDao;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AddStudentVoidMethodTest {

	@InjectMocks
	private StudentServiceImpl underTest;
	
	@Mock
	private StudentDao dao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Disabled
	@Test
	void testAddStudentVoidMethod() {		
		StudentBean student = new StudentBean();
		underTest.addStudentVoidMethod(student);		
		Mockito.verify(dao).addStudentVoidMethod(student);
	}
	
	@Test
	void testAddStudentVoidMethodWithThisMethods() {
		/*
		StudentBean student = new StudentBean();
		underTest.addStudentVoidMethod(student);
		Mockito.verify(dao).addStudent(student);
		*/

		StudentBean studentBean = Mockito.any(StudentBean.class);
		underTest.addStudentVoidMethod(studentBean);
		Mockito.verify(dao).addStudent(studentBean);
	}
}