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
public class OpenBadgeCriteriaBean implements Serializable {
	private int criteriaId;
	private int criteriaParamId;
	private int badgeId;
	private int criteriatype;
	private String criteriaName;
	private int criteriaValue; 
	private String criteriaDescription;
	private String createdBy;
	private String lastModifiedBy;
}