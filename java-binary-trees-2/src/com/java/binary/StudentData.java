package com.java.binary;

import javax.print.attribute.IntegerSyntax;

public class StudentData implements Comparable<StudentData>{

	private String firstName;
	private String lastName;
	private Integer age;
	
	public StudentData() {

	}
	
	public StudentData(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "StudentData [" + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "") + (age != null ? "age=" + age : "") + "]";
	}

	@Override
	public int compareTo(StudentData arg0) {
		return Integer.compare(this.getAge(), arg0.getAge());
	}
}