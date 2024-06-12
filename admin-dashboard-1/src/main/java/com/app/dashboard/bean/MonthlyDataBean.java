package com.app.dashboard.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonthlyDataBean {
	private String month;
	private int totalSales;
	private int totalUnits;
}
