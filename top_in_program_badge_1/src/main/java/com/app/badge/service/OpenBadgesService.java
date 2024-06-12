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
public class OpenBadgesService {

	@Autowired
	private OpenBadgesDAO dao;
	
	List<Integer> cpsIdList = Arrays.asList(111, 151, 160);
	List<Integer> passScore = Arrays.asList(100);
	Map<Integer, Integer> cpsIdSemMap = new HashMap<>();
	Map<Integer, Integer> cpsIdDurationMap = new HashMap<>();
	Map<String, Month> monthMap = new HashMap<>();
		
	public OpenBadgesService() {
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
		
		Month month = monthMap.get(passoutMonth.toUpperCase());
		LocalDate actualPassoutDate = LocalDate.of(passoutYear, month, 1);
		System.err.println("ACTUAL PASSOUTDATE: " + actualPassoutDate);
		
//		// Master List - Get all sapIds for the CPSID for MBA-WX the master list
		List<StudentStudentPortalBean> masterListSapids = dao.getMasterListForAllSapIdsForTopInProgramMBAWx(cpsIdList, passoutMonth, passoutYear);
//		System.err.println("MASTER LIST: " + masterListSapids.size());
//		
//		// In-eligible Students scheduleIds - From the Exam Schedule Table get all the scheduleIds
//		// Who have scored 100, this means that those students have re-attempted and hence
//		// in-eligible for top in program badge - this is the list that will be filtered from the master
//		// list the data is scheduleIds
//		List<Integer> scheduleIdList = dao.getScheduleIdsForIneligibleStudents(passScore);
//		System.err.println("SCHEDULEIDLIST: " + scheduleIdList.size());
//		
//		// Filtered SapIds - 1st Pass removed students with 100 marks re-attempt exam
//		// from Mba_passFail table get sapIds whose schedule ids are found in the 
//		// scheduleIdList from above - This is a list of all sapids whose
//		// max_score is 100
//		List<String> ineligibleSapIdsList = dao.getIneligibleSapIds(scheduleIdList);
//		System.err.println("INELIGIBLE SAPID LIST: " + ineligibleSapIdsList.size());
//				
//		/** 1st - Pass Filter **/
//		// There are 2 lists masterList and ineligibleList, filter out the ineligible ids from
//		// the masterlist and create a new list
//		List<StudentStudentPortalBean> firstPassFilter = new ArrayList<>();
//		for(StudentStudentPortalBean element : masterListSapids) {
//			if(!ineligibleSapIdsList.contains(element.getSapid())) {
//				firstPassFilter.add(element);
//			}
//		}
//		
//		System.err.println("FIRSTPASS FILTER LIST: " + firstPassFilter.size());
		
		/** 2nd - Pass Filter **/
		// From the Registration Table there are 2 pieces of information that can 
		// be retrieved, Actual passout date and semester of respective programs
		// e.g. 111, 151 have 5 semester, whereas 160 has 8 semesters
			
		List<String> sapIds = dao.getSapIdsForPassoutStudentsExamRegistration(cpsIdSemMap, passoutMonth, passoutYear);
		System.err.println("SAPIDS: " + sapIds.size());
		
		// In-eligible Students scheduleIds - From the Exam Schedule Table get all the scheduleIds
		// Who have scored 100, this means that those students have re-attempted and hence
		// in-eligible for top in program badge - this is the list that will be filtered from the master
		// list the data is scheduleIds
		List<Integer> scheduleIdList = dao.getScheduleIdsForIneligibleStudents(passScore);
		System.err.println("SCHEDULEIDLIST: " + scheduleIdList.size());
		
		// Filtered SapIds - 1st Pass removed students with 100 marks re-attempt exam
		// from Mba_passFail table get sapIds whose schedule ids are found in the 
		// scheduleIdList from above - This is a list of all sapids whose
		// max_score is 100
		List<String> ineligibleSapIdsList = dao.getIneligibleSapIds(scheduleIdList);
		System.err.println("INELEGIBLE SAPID LIST: " + ineligibleSapIdsList.size());
		
		/** 1st - Pass Filter **/
		// There are 2 lists masterList and ineligibleList, filter out the ineligible ids from
		// the masterlist and create a new list
		List<String> firstPassFilter = new ArrayList<>();
		for(String element : sapIds) {
			if(!ineligibleSapIdsList.contains(element)) {
				firstPassFilter.add(element);
			}
		}
		
		System.err.println("FIRSTPASS FILTER LIST: " + firstPassFilter.size());
		System.err.println("MASTERLISTSAPIDS: " + masterListSapids.size());
		
		/** 2nd - Pass Filter **/
		List<StudentStudentPortalBean> secondPassFilter = new ArrayList<>();
		for(StudentStudentPortalBean element : masterListSapids) {
			
			Month month1 = monthMap.get(element.getEnrollmentMonth().toUpperCase());
			LocalDate enrollmentDate = LocalDate.of(element.getEnrollmentYear(), month1, 1);
						
			element.setEnrollmentDate(enrollmentDate);
			element.setExpectedPassoutDate(enrollmentDate.plusMonths(cpsIdDurationMap.get(element.getConsumerProgramStructureId())));
			
			LocalDate startDate = element.getExpectedPassoutDate().minus(1, ChronoUnit.MONTHS);
		    LocalDate endDate = element.getExpectedPassoutDate().plus(1, ChronoUnit.MONTHS);
		    
			if(element.getProgramCleared().equalsIgnoreCase("Y") && 
				firstPassFilter.contains(element.getSapid()) && 
				actualPassoutDate.isAfter(startDate) && actualPassoutDate.isBefore(endDate)) {
				secondPassFilter.add(element);
			}
		}
		
		System.err.println("SECOND PASS FILTER: " + secondPassFilter.size());
		
		// Get the totalMarks and outOfMarks from MBA_PassFail Table
		List<OpenBadgesTopInProgramDto> studentMarks = dao.finalSapIdsWithMarks(secondPassFilter);
		
		// Get The Ranking of the Student
		setRankTopInProgram(studentMarks);
		
		List<OpenBadgesTopInProgramDto> finalListOfSapIdsToBeAwardedBadge = new ArrayList<>();
		
		for(OpenBadgesTopInProgramDto element : studentMarks) {
			if (element.getRank() <= 10 && element.getRank() > 0) {
				finalListOfSapIdsToBeAwardedBadge.add(element);
			}
		}
		
		System.err.println("FINAL LIST: " + finalListOfSapIdsToBeAwardedBadge.size());
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
