package com.app.badge.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenBadgeBean implements Serializable {
	private int badgeId;
	private String badgeName;
	private String badgeDescription;
	private String issuername;
	private String issuerurl;
	private String issuercontact;
	private String expiredate;
	private String expireperiod;
	private int courseid;
	private String message;
	private String messagesubject;
	private String attachment;
	private int notification;
	private int status;
	private String version;
	private String imageauthorname;
	private String imageauthoremail;
	private String imageauthorurl;
	private String imagecaption;
	private String createdBy;
	private String lastModifiedBy;
	private int totalBadges ;
	private int issuedCount ;
	private int notIssuedCount ;
	private int claimedCount ;
	private int notClaimedCount ;
	private int revokedCount ;
}
