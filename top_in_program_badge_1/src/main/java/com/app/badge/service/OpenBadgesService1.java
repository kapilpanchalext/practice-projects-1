package com.app.badge.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.badge.bean.OpenBadgesTopInProgramDto;
import com.app.badge.bean.StudentStudentPortalBean;
import com.app.badge.dao.OpenBadgesDAO;

@Service
public class OpenBadgesService1 {
	
	@Autowired
	private OpenBadgesDAO dao;
	
//	List<Integer> cpsIdList = Arrays.asList(111);
	List<Integer> cpsIdList = Arrays.asList(111, 151, 160);
	List<Integer> passScore = Arrays.asList(100);
	Map<Integer, Integer> cpsIdSemMap = new HashMap<>();
	Map<Integer, Integer> cpsIdDurationMap = new HashMap<>();
	Map<String, Month> monthMap = new HashMap<>();
	
	public OpenBadgesService1() {
		cpsIdSemMap.put(cpsIdList.get(0), 5);
		cpsIdSemMap.put(cpsIdList.get(1), 5);
		cpsIdSemMap.put(cpsIdList.get(2), 8);
		
		cpsIdDurationMap.put(cpsIdList.get(0), 15);
		cpsIdDurationMap.put(cpsIdList.get(1), 15);
		cpsIdDurationMap.put(cpsIdList.get(2), 24);
		
		monthMap.put("JAN", Month.JANUARY);
		monthMap.put("MAR", Month.MARCH);
		monthMap.put("APR", Month.APRIL);
		monthMap.put("JUN", Month.JUNE);
		monthMap.put("JUL", Month.JULY);
		monthMap.put("SEP", Month.SEPTEMBER);
		monthMap.put("OCT", Month.OCTOBER);
		monthMap.put("DEC", Month.DECEMBER);
	}
	
	public void callTopInProgramBadgeForAllStudentMBAWX(String passoutMonth, int passoutYear) {
		System.err.println("INSIDE CALL TOP IN PROGRAM BADGE FOR ALL STUDENTS MBAWX");
		Month month = monthMap.get(passoutMonth.toUpperCase());
		LocalDate actualPassoutDate = LocalDate.of(passoutYear, month, 1);
		System.err.println("ACTUAL PASSOUTDATE: " + actualPassoutDate);
		
		/** Step 1 - Get Students List from Exam Registration Table Where Semester is 5 or 8, CPSID, Passout Year/Month**/
		List<String> sapIdsMasterList = dao.getSapIdsForPassoutStudentsExamRegistration(cpsIdSemMap, passoutMonth, passoutYear);
		System.err.println("REGISTRATION TABLE SAPIDS - SEMESTER 5&8 FILTER: " + sapIdsMasterList.size());
		
		/** Step 2 - 1st Pass Filter **/
		/** From the above list check in Exam.Students Table whether the programCleared status is 'Y' **/
		List<String> sapIdsProgramClearedIsYesList = dao.getFromExamStudentsTableSapIdsWhereProgramClearedIsYes(sapIdsMasterList, cpsIdSemMap, passoutMonth, passoutYear);
		System.err.println("FIRST PASS  FILTER - PROGRAM CLEARED STATUS IS TRUE: " + sapIdsProgramClearedIsYesList.size());
		
		/** Step 3 - 2nd Pass Filter **/
		/** From the above filtered list get the schedule_ids from **/
		// In-eligible Students scheduleIds - From the Exam Schedule Table get all the scheduleIds
		// Who have scored 100, this means that those students have re-attempted and hence
		// in-eligible for top in program badge - this is the list that will be filtered from the master
		// list the data in scheduleIds
		List<Integer> scheduleIdList = dao.getScheduleIdsForIneligibleStudents(passScore);
		System.err.println("SCHEDULEID LIST 100 MARKS FILTER: " + scheduleIdList.size());
		
		// Filtered SapIds - 1st Pass removed students with 100 marks re-attempt exam
		// from Mba_passFail table get sapIds whose schedule ids are found in the 
		// scheduleIdList from above - This is a list of all sapids whose
		// max_score is 100
		List<String> ineligibleSapIdsList = dao.getIneligibleSapIds(scheduleIdList);
		System.err.println("SECOND PASS - INELEGIBLE SAPID LIST 100 MARKS FILTER: " + ineligibleSapIdsList.size());
		
		/** Step 4 - 2rd Pass Filter **/
		/** Filter out the students who has topped the program in the second attempt  **/
		// There are 2 lists masterList and ineligibleList, filter out the ineligible ids from
		// the masterlist and create a new list
		List<String> thirdPassFilter = new ArrayList<>();
		for(String element : sapIdsProgramClearedIsYesList) {
			if(!ineligibleSapIdsList.contains(element)) {
				thirdPassFilter.add(element);
			}
		}
		
		List<StudentStudentPortalBean> thirdPassFilterStudentBean = dao.getDataFromExamStudentsList(thirdPassFilter);
		
		System.err.println("THIRDPASS FILTER LIST: " + thirdPassFilter.size());
		System.err.println("THIRDPASS FILTER STUDENT BEAN: " + thirdPassFilterStudentBean.size());
		System.err.println("THIRDPASS FILTER STUDENT BEAN: " + thirdPassFilterStudentBean);
		
		/** Step 5 - 3rd Pass Filter **/
		/** Step 5 - Compare the Expected passout date within +1 Month of the Actual PassoutDate **/
		List<StudentStudentPortalBean> fourthPassFilter = new ArrayList<>();
		for(StudentStudentPortalBean element : thirdPassFilterStudentBean) {
			
			Month month1 = monthMap.get(element.getEnrollmentMonth().toUpperCase());
			LocalDate enrollmentDate = LocalDate.of(element.getEnrollmentYear(), month1, 1);
						
			element.setEnrollmentDate(enrollmentDate);
			element.setExpectedPassoutDate(enrollmentDate.plusMonths(cpsIdDurationMap.get(element.getConsumerProgramStructureId())));
			
			LocalDate startDate = element.getExpectedPassoutDate().minus(1, ChronoUnit.DAYS);
		    LocalDate endDate = element.getExpectedPassoutDate().plus(1, ChronoUnit.MONTHS);
		    
			if(actualPassoutDate.isAfter(startDate) && actualPassoutDate.isBefore(endDate)) {
				fourthPassFilter.add(element);
			}
		}
		
		System.err.println("FOURTH PASS FILTER: " + fourthPassFilter.size());
		
		/** Step 6 - 4th Pass Filter **/
		/** Step 6 - Get ranking of students and then filter out the first 10 top ranks **/
		
		// Get the totalMarks and outOfMarks from MBA_PassFail Table
		List<OpenBadgesTopInProgramDto> studentMarks = dao.finalSapIdsWithMarks(fourthPassFilter);
		
		System.err.println("STUDENT MARKS: " + studentMarks.size());
		
		// Get The Ranking of the Student
		setRankTopInProgram(studentMarks);
		
		List<OpenBadgesTopInProgramDto> finalListOfSapIdsToBeAwardedBadge = new ArrayList<>();
		
		for(OpenBadgesTopInProgramDto element : studentMarks) {
			if (element.getRank() <= 10 && element.getRank() > 0) {
				finalListOfSapIdsToBeAwardedBadge.add(element);
			}
		}
		
		System.err.println("FINAL LIST SIZE: " + finalListOfSapIdsToBeAwardedBadge.size());
		System.err.println("FINAL LIST: " + finalListOfSapIdsToBeAwardedBadge);
 	}

	public void setRankTopInProgram(List<OpenBadgesTopInProgramDto> list) {
		 Integer prev_val = null;
		 int rank = 0;
		 list =list.stream()
		 .sorted(Comparator.comparing(OpenBadgesTopInProgramDto::getTotalMarks).reversed())
		 .collect(Collectors.toList()); 	
		 
		 for(OpenBadgesTopInProgramDto bean : list) {
			 if(prev_val == bean.getTotalMarks()) {
				 bean.setRank(rank);
			 } else {
				 rank  = rank + 1; 
				 prev_val = bean.getTotalMarks();
				 bean.setRank(rank);
			 }
		 }
	}
}
