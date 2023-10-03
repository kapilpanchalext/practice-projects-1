package com.app.tips.service;

import com.app.tips.bean.Program;
import com.app.tips.bean.Student;

public interface StudentProgramService {

	Student addStudentToRedis(Student student);
	
	Program addProgramToRedis(Program program);

	Student getStudentByStudentDetails(String firstName);
}
