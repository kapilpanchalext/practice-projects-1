package com.java.nodes;

public class SomeData {
	
	private String name;
	private Integer age;
	
	public SomeData(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public SomeData() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "SomeData [name=" + name + ", age=" + age + "]";
	}	
}
