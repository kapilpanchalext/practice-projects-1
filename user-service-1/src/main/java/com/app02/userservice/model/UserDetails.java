package com.app02.userservice.model;

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

@Entity(name = "UserService")
@Table(name = "userservice",
		schema = "appServiceSch", 
		uniqueConstraints = @UniqueConstraint(columnNames = {"userId"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetails implements Serializable{

	private static final long serialVersionUID = -595082312256629860L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;	
	private String firstName;	
	private String lastName;	
	private String email;	
	private Long departmentId;	
}
