package com.app.unittest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.unittest.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addStudent(StudentBean student) {
		
		StringBuilder sqlString = new StringBuilder();
		
		sqlString.append("INSERT INTO `junittests`.`junit_tests`(`studentId`,`firstName`,`lastName`,`age`,`programName`)VALUES(?,?,?,?,?);");
		
		int status = jdbcTemplate.update(sqlString.toString(), student.getStudentId().toString(), student.getFirstName(), 
				student.getLastName(), student.getAge(), student.getProgramName());
		
		if(status > 0) {
			return "Insert Successful!";
		} else {
			return "Insert Failure";
		}
	}

	public void addStudentVoidMethod(StudentBean student) {
		StringBuilder sqlString = new StringBuilder();
		
		sqlString.append("INSERT INTO `junittests`.`junit_tests`(`studentId`,`firstName`,`lastName`,`age`,`programName`)VALUES(?,?,?,?,?);");
		
		int status = jdbcTemplate.update(sqlString.toString(), student.getStudentId().toString(), student.getFirstName(), 
				student.getLastName(), student.getAge(), student.getProgramName());
		
		System.err.println("STATUS: " + status);		
	}
}
