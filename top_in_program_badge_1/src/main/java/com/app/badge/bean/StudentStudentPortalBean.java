package com.app.badge.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentStudentPortalBean {
	private String sapid;
	private String sem;
    private String program;
    private String enrollmentMonth;
    private int enrollmentYear;
    private int acadYear;
    private String acadMonth;
    private String subject;
    private String programStatus;
    private String programCleared;
    private LocalDate enrollmentDate;
    private LocalDate expectedPassoutDate;
    private LocalDate actualPassoutDate;
    private String actualPassoutMonth;
    private String actualPassoutYear;
    private int consumerProgramStructureId;
}
