package com.app.badge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.badge.bean.OpenBadgeBean;
import com.app.badge.bean.OpenBadgeCriteriaBean;
import com.app.badge.dao.OpenBadgesDao;

@Service
public class OpenBadgesService {

	@Autowired
	private OpenBadgesDao dao;
	
	public List<OpenBadgeBean> getAllBadgesList () {
		return dao.getAllBadgesList();
	}
	
	public List<OpenBadgeCriteriaBean> getAllBadgesCriteriaList () {
		return dao.getAllBadgesCriteriaList();
	}
	
	public List<OpenBadgeCriteriaBean> getAllBadgesCriteriaParamList () {
		return dao.getAllBadgesCriteriaParamList();
	}
	
	public List<OpenBadgeCriteriaBean> getCriteriaDetails(String termTopper){
		List<OpenBadgeCriteriaBean> badgesCriteriaList = dao.getAllBadgesCriteriaList();
		List<OpenBadgeCriteriaBean> badgesCriteriaParamList = dao.getAllBadgesCriteriaParamList();
		
		List<OpenBadgeCriteriaBean> badgesCriteriaDetails = new ArrayList<>();
		
		for(OpenBadgeCriteriaBean element : badgesCriteriaParamList) {
			if(element.getCriteriaName().equalsIgnoreCase(termTopper)) {
				badgesCriteriaDetails.add(element);
			}
		}
		
		// Adding BadgeIds to badgesCriteriaDetails bean List
		for(OpenBadgeCriteriaBean outerElement : badgesCriteriaDetails) {
			for(OpenBadgeCriteriaBean innerElement : badgesCriteriaList) {
				if(innerElement.getCriteriaId() == outerElement.getCriteriaId()) {
					outerElement.setBadgeId(innerElement.getBadgeId());
				}
			}
		}
		
		return badgesCriteriaDetails;
	}
	
	public Map<Integer, Integer> getConsumerProgramStructureIdsMBAWX (){
		return dao.getConsumerProgramStructureIdsMBAWX();
	}
}
