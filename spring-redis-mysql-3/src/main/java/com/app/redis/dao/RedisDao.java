package com.app.redis.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.redis.bean.TodoBean;


@Repository
public class RedisDao {
	
	@Autowired
	private JdbcTemplate template;

	public List<TodoBean> findAllList() {
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("SELECT * FROM rediscache3.todotable;");		
		return template.query(sqlString.toString(), new BeanPropertyRowMapper<>(TodoBean.class));		
	}
	
	public int addTodoBean(TodoBean bean) {
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("INSERT INTO rediscache3.todotable (id,title,completed,`order`,url) VALUES(?, ?, ?, ?, ?);");		
		int status = template.update(sqlString.toString(), bean.getId().toString(), bean.getTitle(), bean.getCompleted(),bean.getOrder(), bean.getUrl());		
		return status;
	}
}
