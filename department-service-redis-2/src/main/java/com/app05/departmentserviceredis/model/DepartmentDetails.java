package com.app05.departmentserviceredis.model;

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

@Entity(name = "DepartmentServiceRedis")
@Table(name = "departmentserviceredis",
		schema = "appServiceSch",
		uniqueConstraints = @UniqueConstraint(columnNames = {"departmentId"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDetails implements Serializable{
	
	private static final long serialVersionUID = 3638682804059112156L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;	
	private String departmentName;	
	private String departmentAddress;	
	private String departmentCode;
}