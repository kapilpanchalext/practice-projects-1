package com.java.bean;

import java.time.LocalDate;

/** THIS IS THE BEAN FOR exam.student**/
public class StudentStudentPortalBean {
	
	public StudentStudentPortalBean() {
		
	}
	
	private String sapid;
	private String sem;
    private String program;
    private String enrollmentMonth;
    private Integer enrollmentYear;
    private Integer acadYear;
    private String acadMonth;
    private String programStatus;
    private String programCleared;
    private String programStructure; 
    private LocalDate enrollmentDate;
    private LocalDate expectedPassoutDate;
    private LocalDate actualPassoutDate;
    private String actualPassoutMonth;
    private String actualPassoutYear;
    
	public String getSapid() {
		return sapid;
	}
	public void setSapid(String sapid) {
		this.sapid = sapid;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getEnrollmentMonth() {
		return enrollmentMonth;
	}
	public void setEnrollmentMonth(String enrollmentMonth) {
		this.enrollmentMonth = enrollmentMonth;
	}
	public Integer getEnrollmentYear() {
		return enrollmentYear;
	}
	public void setEnrollmentYear(Integer enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}
	public Integer getAcadYear() {
		return acadYear;
	}
	public void setAcadYear(Integer acadYear) {
		this.acadYear = acadYear;
	}
	public String getAcadMonth() {
		return acadMonth;
	}
	public void setAcadMonth(String acadMonth) {
		this.acadMonth = acadMonth;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	public String getProgramCleared() {
		return programCleared;
	}
	public void setProgramCleared(String programCleared) {
		this.programCleared = programCleared;
	}
	public String getProgramStructure() {
		return programStructure;
	}
	public void setProgramStructure(String programStructure) {
		this.programStructure = programStructure;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public LocalDate getExpectedPassoutDate() {
		return expectedPassoutDate;
	}
	public void setExpectedPassoutDate(LocalDate expectedPassoutDate) {
		this.expectedPassoutDate = expectedPassoutDate;
	}
	public LocalDate getActualPassoutDate() {
		return actualPassoutDate;
	}
	public void setActualPassoutDate(LocalDate actualPassoutDate) {
		this.actualPassoutDate = actualPassoutDate;
	}
	public String getActualPassoutMonth() {
		return actualPassoutMonth;
	}
	public void setActualPassoutMonth(String actualPassoutMonth) {
		this.actualPassoutMonth = actualPassoutMonth;
	}
	public String getActualPassoutYear() {
		return actualPassoutYear;
	}
	public void setActualPassoutYear(String actualPassoutYear) {
		this.actualPassoutYear = actualPassoutYear;
	}
	@Override
	public String toString() {
		return "StudentStudentPortalBean [sapid=" + sapid + ", sem=" + sem + ", program=" + program
				+ ", enrollmentMonth=" + enrollmentMonth + ", enrollmentYear=" + enrollmentYear + ", acadYear="
				+ acadYear + ", acadMonth=" + acadMonth + ", programStatus=" + programStatus + ", programCleared="
				+ programCleared + ", programStructure=" + programStructure + ", enrollmentDate=" + enrollmentDate
				+ ", expectedPassoutDate=" + expectedPassoutDate + ", actualPassoutDate=" + actualPassoutDate
				+ ", actualPassoutMonth=" + actualPassoutMonth + ", actualPassoutYear=" + actualPassoutYear + "]";
	}
}
