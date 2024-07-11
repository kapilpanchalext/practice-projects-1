package com.app.badge.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.badge.bean.OpenBadgeBean;
import com.app.badge.bean.OpenBadgeCriteriaBean;
import com.app.badge.service.OpenBadgesService;

@RestController
@RequestMapping(path = "/m")
public class OpenBadgesController {
	
	@Autowired
	private OpenBadgesService service;

//	@GetMapping(path = "/runTopInTermBadgeSchedulerMBAWX")
//	public ResponseEntity<List<OpenBadgeBean>> getAllBadgesList() {
//		
//		List<OpenBadgeBean> badgesList = service.getAllBadgesList();
//		
//		return ResponseEntity
//					.status(HttpStatus.OK)
//					.body(badgesList);
//	}
	
	@GetMapping(path = "/getAllBadges")
	public ResponseEntity<List<OpenBadgeBean>> getAllBadgesList() {
		
		List<OpenBadgeBean> badgesList = service.getAllBadgesList();
		
		return ResponseEntity
					.status(HttpStatus.OK)
					.body(badgesList);
	}
	
	@GetMapping(path = "/getAllBadgesCriteria")
	public ResponseEntity<List<OpenBadgeCriteriaBean>> getAllBadgesCriteriaList() {
		
		List<OpenBadgeCriteriaBean> badgesCriteriaList = service.getAllBadgesCriteriaList();
		
		return ResponseEntity
					.status(HttpStatus.OK)
					.body(badgesCriteriaList);
	}
	
	
}
