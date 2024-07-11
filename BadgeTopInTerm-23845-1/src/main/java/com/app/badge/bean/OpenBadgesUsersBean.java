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
public class OpenBadgesUsersBean implements Serializable {
	private int userId;
	private int badgeId;
	private String sapid;
	private int consumerProgramStructureId;
	private String firstname;
	private String lastname;
	private String emailId;
	private int emailstop;
	private String createdBy;
	private String lastModifiedBy;
}