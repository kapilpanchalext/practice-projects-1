package com.app.hello.bean;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentBean implements Serializable {

	private Long id;
	private String sapid;
	private String answer;
	private Boolean attendingInPerson;
	private Boolean isSubmitted;
	private String createdBy;
	private LocalDate createdDate;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;
	
}
