package com.app.dashboard.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.dashboard.bean.DailyDataBean;
import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.MonthlyDataBean;

public class DataOverallStatReader {
	public List<DataProductStatBean> readInputsFromFile(String fileName) {
	List<DataProductStatBean> dataProductStatList = new ArrayList<>();

	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		String line;
		DataProductStatBean dataProductStatBean = null;
		List<MonthlyDataBean> monthlyDataList = null;
		List<DailyDataBean> dailyDataList = null;

		while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("_id:")) {
                if (dataProductStatBean != null) {
                    dataProductStatBean.setMonthlyData(monthlyDataList);
                    dataProductStatBean.setDailyData(dailyDataList);
                    dataProductStatList.add(dataProductStatBean);
                }
                dataProductStatBean = new DataProductStatBean();
                monthlyDataList = new ArrayList<>();
                dailyDataList = new ArrayList<>();
                dataProductStatBean.setId(line.split(":")[1].trim().replaceAll("[\",]", ""));
            } else if (line.startsWith("totalCustomers:")) {
                if (dataProductStatBean != null) {
                    int val = Integer.parseInt(line.split(":")[1].trim().replaceAll("[\",]", ""));
                    dataProductStatBean.setTotalCustomers(val);
                } else {
                    System.err.println("Skipping totalCustomers as dataProductStatBean is not initialized.");
                }
            } else if (line.startsWith("yearlySalesTotal:")) {
                if (dataProductStatBean != null) {
                    dataProductStatBean.setYearlySalesTotal(Integer.parseInt(line.split(":")[1].trim().replaceAll("[\",]", "")));
                }
            } else if (line.startsWith("yearlyTotalSoldUnits:")) {
                if (dataProductStatBean != null) {
                    dataProductStatBean.setYearlyTotalSoldUnits(Integer.parseInt(line.split(":")[1].trim().replaceAll("[\",]", "")));
                }
            } else if (line.startsWith("monthlyData:")) {
                if (monthlyDataList != null) {
                    while ((line = br.readLine()) != null && !line.trim().startsWith("]")) {
                        MonthlyDataBean monthlyData = parseMonthlyData(line.trim());
                        if (monthlyData != null) {
                            monthlyDataList.add(monthlyData);
                        }
                    }
                }
            } else if (line.startsWith("dailyData:")) {
                if (dailyDataList != null) {
                    while ((line = br.readLine()) != null && !line.trim().startsWith("]")) {
                        DailyDataBean dailyData = parseDailyData(line.trim());
                        if (dailyData != null) {
                            dailyDataList.add(dailyData);
                        }
                    }
                }
            }
        }

	        if (dataProductStatBean != null) {
	            dataProductStatBean.setMonthlyData(monthlyDataList);
	            dataProductStatBean.setDailyData(dailyDataList);
	            dataProductStatList.add(dataProductStatBean);
	        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataProductStatList;
	}

	private DailyDataBean parseDailyData(String data) {
		data = data.trim().replaceAll("[{}\"]", "");
        String[] keyValuePairs = data.split(",");
        DailyDataBean dailyData = new DailyDataBean();

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                switch (key) {
                    case "date":
                        dailyData.setDate(LocalDate.parse(value));
                        break;
                    case "totalSales":
                        dailyData.setTotalSales(Integer.parseInt(value));
                        break;
                    case "totalUnits":
                        dailyData.setTotalUnits(Integer.parseInt(value));
                        break;
                }
            }
        }
        return dailyData;
    }

    private MonthlyDataBean parseMonthlyData(String data) {
    	data = data.trim().replaceAll("[{}\"]", "");
    	String[] keyValuePairs = data.split(",");
    	MonthlyDataBean monthlyData = new MonthlyDataBean();
    	
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().toLowerCase();
                String value = keyValue[1].trim();
                switch (key) {
                    case "month":
                        monthlyData.setMonth(value);
                        break;
                    case "totalsales":
                        monthlyData.setTotalSales(Integer.parseInt(value));
                        break;
                    case "totalunits":
                        monthlyData.setTotalUnits(Integer.parseInt(value));
                        break;
                    case "_id":
                        monthlyData.setId(value);
                        break;
                }
            }
        }
        return monthlyData;
    }
}
