package com.redisexample.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student1")
//@Entity(name = "Student1")
//@Table(name = "student1", 
//		catalog = "mydb",
//		schema = "public")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 7459280203975902731L;

	@Id
	@SequenceGenerator(name = "redis_seq",
						sequenceName = "redis_seq",
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,
					generator = "redis_seq")
	
	private Long id;	
	private String name;

	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Student() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}	
}