package com.app.badge.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.badge.bean.OpenBadgeBean;
import com.app.badge.bean.OpenBadgeCriteriaBean;
import com.app.badge.reader.BadgeCriteriaParamReader;
import com.app.badge.reader.BadgeCriteriaReader;
import com.app.badge.reader.BadgesReader;

@Repository
public class OpenBadgesDao {
	
	List<OpenBadgeBean> badgesList = new ArrayList<>();
	List<OpenBadgeCriteriaBean> badgesCriteriaList = new ArrayList<>();
	List<OpenBadgeCriteriaBean> badgesCriteriaParamList = new ArrayList<>();
	
	public OpenBadgesDao() {
		BadgesReader badgesReader = new BadgesReader();
		badgesList = badgesReader.readInputsFromFile("dataFile\\DataFile_Badges_V1.txt");
		
		BadgeCriteriaReader badgeCriteriaReader = new BadgeCriteriaReader();
		badgesCriteriaList = badgeCriteriaReader.readInputsFromFile("dataFile\\DataFile_Criteria_V1.txt");
	
		BadgeCriteriaParamReader badgeCriteriaParamReader = new BadgeCriteriaParamReader();
		badgesCriteriaParamList = badgeCriteriaParamReader.readInputsFromFile("dataFile\\DataFile_Criteria_Param_V1.txt");
	}

	public List<OpenBadgeBean> getAllBadgesList () {
		return badgesList;
	}
	
	public List<OpenBadgeCriteriaBean> getAllBadgesCriteriaList () {
		return badgesCriteriaList;
	}
	
	public List<OpenBadgeCriteriaBean> getAllBadgesCriteriaParamList () {
		return badgesCriteriaParamList;
	}
}
