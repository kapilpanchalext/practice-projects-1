package com.app.tips.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.app.tips.bean.Program;
import com.app.tips.bean.Student;
import com.app.tips.repo.ProgramRepository;
import com.app.tips.repo.StudentRepository;

@Service
public class StudentProgramServiceImpl implements StudentProgramService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ProgramRepository programRepo;

	@Override
	public Student addStudentToRedis(Student student) {
		List<Program> programList = (List<Program>) programRepo.findAll();
		student.setPrograms(programList);
		Student status = studentRepo.save(student);
		return status;
	}

	@Override
	public Program addProgramToRedis(Program program) {
		Program status = programRepo.save(program);
		return status;
	}

	@Override
	public Student getStudentByStudentDetails(String firstName) {
		
//		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("firstName", );
		
		Student student = new Student();
		
		student.setFirstName(firstName);
		
		ExampleMatcher matcher = ExampleMatcher.matching()     
//				  .withIgnorePaths("lastname")                         
//				  .withIncludeNullValues()                             
				  .withStringMatcher(StringMatcher.ENDING);            

		Example<Student> example = Example.of(student, matcher);		

		System.err.println("Student Example: " + example.getProbe());
		
//		return studentRepo.findById(example.getProbe().getStudentId()).get();
		
//		studentRepo.findAll(example);
		
//		Optional<Student> match = studentRepo.findById(example,
//			    q -> q
//			        .sortBy(Sort.by("lastname").descending())
//			        .first()
//			);
		
		
		return student;
//		return studentRepo.findAll(example.getProbe());
	}
}
