package com.app.dashboard.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyDataBean {
	private LocalDate date;
	private int totalSales;
	private int totalUnits;
}
