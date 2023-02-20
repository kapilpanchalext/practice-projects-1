package com.redisexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redisexample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}