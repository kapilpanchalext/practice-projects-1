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
public class DataProductStatBean {
	private String id;
    private String productId;
    private int totalCustomers;
    private int yearlySalesTotal;
    private int yearlyTotalSoldUnits;
    private int year;
    private List<MonthlyDataBean> monthlyData;
    private List<DailyDataBean> dailyData;
}
