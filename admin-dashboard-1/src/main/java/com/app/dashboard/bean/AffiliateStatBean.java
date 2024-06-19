package com.app.dashboard.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AffiliateStatBean {
	private String affiliateId;
	private String userId;
	private List<String> affiliateSales;
}
