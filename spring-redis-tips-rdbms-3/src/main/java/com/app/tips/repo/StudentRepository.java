package com.app.tips.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.app.tips.bean.Student;

public interface StudentRepository extends CrudRepository<Student, UUID> {

}
