package com.app02.departmentservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "DepartmentService")
@Table(name = "departmentservice",
		schema = "appServiceSch", 
		uniqueConstraints = @UniqueConstraint(columnNames = {"departmentId"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department implements Serializable{

	private static final long serialVersionUID = -4449364205407760403L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;	
	private String departmentName;	
	private String departmentAddress;	
	private String departmentCode;
}