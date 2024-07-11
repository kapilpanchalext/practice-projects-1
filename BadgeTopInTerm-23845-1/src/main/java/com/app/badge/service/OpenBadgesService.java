package com.app.badge.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.badge.bean.OpenBadgeBean;
import com.app.badge.bean.OpenBadgeCriteriaBean;
import com.app.badge.bean.OpenBadgesUsersBean;
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
	
	public List<OpenBadgesUsersBean> getMasterKeyListByBadgeId(int badgeId) {
		
		List<OpenBadgesUsersBean> badgeIdCpsIdMappingList = new ArrayList<>();
		List<OpenBadgesUsersBean> badgeIdCpsIdMappingCompleteList = dao.getMasterKeyListByBadgeId();
		
		for(OpenBadgesUsersBean element : badgeIdCpsIdMappingCompleteList) {
			if(element.getBadgeId() == badgeId) {
				badgeIdCpsIdMappingList.add(element);
			}
		}
		
		return badgeIdCpsIdMappingList;
	}
	
	public List<Integer> getConsumerProgramStructure(String termTopper) {
		List<OpenBadgeCriteriaBean> getCriteriaDetails = this.getCriteriaDetails(termTopper);
		List<OpenBadgesUsersBean> badgesMappingList = new ArrayList<>();
		Set<Integer> cpsIdSet = new HashSet<>();
		for(OpenBadgeCriteriaBean element : getCriteriaDetails) {
			badgesMappingList.addAll(this.getMasterKeyListByBadgeId(element.getBadgeId()));
		}
		
		for(OpenBadgesUsersBean element : badgesMappingList) {
			cpsIdSet.add(element.getConsumerProgramStructureId());
		}
		List<Integer> cpsIdList = new ArrayList<>(cpsIdSet);
		return cpsIdList;
	}
}
