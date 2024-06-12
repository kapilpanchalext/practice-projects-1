package com.app.hello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.hello.bean.AnswersBean;
import com.app.hello.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate template;
	
	public List<StudentBean> getAllStudents() {		
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("SELECT * FROM `many-to-many`.`registration`;");		
		return template.query(sqlString.toString(), new BeanPropertyRowMapper<>(StudentBean.class));
	}
	
	public List<AnswersBean> getAllAnswers(){
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("SELECT * FROM `many-to-many`.`answers`;");		
		return template.query(sqlString.toString(), new BeanPropertyRowMapper<>(AnswersBean.class));
	}
}
