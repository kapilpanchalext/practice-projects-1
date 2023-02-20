package com.app05.main.model;

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

@Entity(name = "MainService")
@Table(name = "mainservice",
		schema = "appServiceSch",
		uniqueConstraints = @UniqueConstraint(columnNames = {"mainId"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainData implements Serializable{

	private static final long serialVersionUID = -6369531188576376534L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mainId;
	private Long userId;
	private Long departmentId;
}