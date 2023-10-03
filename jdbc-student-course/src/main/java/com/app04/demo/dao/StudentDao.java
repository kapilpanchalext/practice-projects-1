package com.app04.demo.dao;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app04.demo.model.Course;
import com.app04.demo.model.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate template;

	public List<Student> getAllStudents() {		
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("SELECT id, name, courses FROM studentcourse.students;");		
		return template.query(sqlString.toString(), new BeanPropertyRowMapper<>(Student.class));
	}

	public int addStudent(Student student) {
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("INSERT INTO studentcourse.students (name) VALUES (?);");
		return template.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString.toString());            
            preparedStatement.setString(1, student.getName());            
            return preparedStatement;
        });		
	}

	public int addCourse(Course course) {
		StringBuilder sqlString = new StringBuilder();		
		sqlString.append("INSERT INTO studentcourse.courses (name, credits) VALUES (?, ?);");
		return template.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString.toString());            
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getCredits());
            return preparedStatement;
        });	
	}

	public int updateStudentCourse(Student student) {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("UPDATE studentcourse.students SET courseId = 1 WHERE id = 1");
			    
		template.update(sqlString.toString());
		
		return 1;
	}

	public List<Student> getAllStudentCourses() {
		StringBuilder sqlString = new StringBuilder();
		sqlString.append("SELECT s.id, s.name, c.id AS course_id, c.name, c.credits FROM studentcourse.students s INNER JOIN studentcourse.courses c ON s.courseId = c.id; ");
		
		return template.query(sqlString.toString(), (rs, rowNum) -> {
	        Student student = new Student();
	        student.setId(rs.getLong("id"));
	        student.setName(rs.getString("name"));
	        
	        Course course = new Course();
	        course.setId(rs.getLong("id"));
	        course.setName(rs.getString("name"));
	        course.setCredits(rs.getString("credits"));
	        
	        student.setCourses(Collections.singletonList(course));
	        
	        return student;
	    });
	}
}