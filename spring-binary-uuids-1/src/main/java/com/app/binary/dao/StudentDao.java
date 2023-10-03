package com.app.binary.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.binary.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate template;

	public void addStudentData(StudentBean student) {		
		StringBuilder sqlString = new StringBuilder();

		sqlString.append("INSERT INTO `student_service_uuid`.`student_uuid`"
				+ "(`id`, `firstName`, `lastName`, `age`)"
				+ "VALUES(UUID_TO_BIN(?, true), ?, ?, ?);");
		
//		sqlString.append("INSERT INTO `student_service_uuid`.`student_uuid`"
//				+ "(`id`, `firstName`, `lastName`, `age`)"
//				+ "VALUES(?, ?, ?, ?);");

		Integer status = template.update(
				sqlString.toString(),
				student.getId(),
				student.getFirstName(),
				student.getLastName(),
				student.getAge());

		System.err.println("STATUS: " + status);
	}
	
	public List<StudentBean> getAllStudentsList(){
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("SELECT HEX(id) AS id, firstName, lastName, age FROM `student_service_uuid`.`student_uuid`");		
		List<StudentBean> studentsList = template.query(sqlString.toString(), new BeanPropertyRowMapper<>(StudentBean.class));
		return studentsList;
	}
	
	public StudentBean getStudentDataByName(StudentBean student) {
		String sql = "SELECT HEX(id) AS id, firstName, lastName, age FROM student_uuid WHERE age = ?";

		List<StudentBean> studentBeans = template.query(
			    sql,
			    new PreparedStatementSetter() {
			        @Override
			        public void setValues(PreparedStatement ps) throws SQLException {
			            ps.setShort(1, student.getAge());
			        }
			    },
			    new RowMapper<StudentBean>() {
			        @Override
			        public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			            StudentBean studentBean = new StudentBean();
			            studentBean.setId(rs.getString("id"));
			            studentBean.setFirstName(rs.getString("firstName"));
			            studentBean.setLastName(rs.getString("lastName"));
			            studentBean.setAge(rs.getShort("age"));
			            return studentBean;
			        }
			    }
			);

		System.err.println("STUDENT BEANS: " + studentBeans);
		
	    if (studentBeans.isEmpty()) {
	        System.err.println("RETURNS NULL");
	        return null;
	    }

	    return studentBeans.get(0);
	}
}
