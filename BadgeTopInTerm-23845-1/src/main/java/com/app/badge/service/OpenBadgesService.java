package com.app.badge.service;

import java.util.List;

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
}
