package com.app.dashboard.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dashboard.bean.AffiliateStatBean;
import com.app.dashboard.bean.ChloroplethDataBean;
import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.PlotCoordinates;
import com.app.dashboard.bean.PlotDataBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.SalesByCategoryBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.bean.UserProductStatsBean;
import com.app.dashboard.dao.AdminDashboardDao;
import com.app.dashboard.pagination.Page;
import com.app.dashboard.util.PaginationUtil;

@Service
public class UserService {
	
	@Autowired
	private AdminDashboardDao dao;
	
	public List<UserBean> getUsers() {
		return dao.usersList;	
	}
	
	public UserBean getUserById(String userId) {
		UserBean user = new UserBean();
		
		for(UserBean element : dao.usersList) {
			if(element.getId().equalsIgnoreCase(userId)) {
				user = element;
			}
		}
		return user;
	}
	
	public List<ProductBean> getProducts(){
		return dao.productsList;
	}

	public List<DataProductStatBean> getProductStats() {
		return dao.dataProductStatList;
	}
	
	public List<DataTransactionBean> getDataTransactions(){
		return dao.dataTransactionList;
	}
	
	public Page<DataTransactionBean> getTransactionsPagination(int page, int size){
		List<DataTransactionBean> transactionList = getDataTransactions();
		Page<DataTransactionBean> pagedList = PaginationUtil.convertListToPage(transactionList, page, size);
		return pagedList;
	}
	
	public List<ChloroplethDataBean> getChloroplethData(){
		List<UserBean> transactionList = getUsers();
		
		// Step 1: Create a map to count occurrences of each country
        Map<String, Integer> countryCountMap = new HashMap<>();

        for (UserBean element : transactionList) {
            String country = element.getCountry();
            countryCountMap.put(country, countryCountMap.getOrDefault(country, 0) + 1);
        }

        // Step 2: Create ChloroplethDataBean list using the map
        List<ChloroplethDataBean> chloroplethDataBeanList = transactionList.stream()
                .map(country -> new ChloroplethDataBean(country.getCountry(), countryCountMap.getOrDefault(country.getCountry(), 0)))
                .collect(Collectors.toList());
        
        return chloroplethDataBeanList;
	}
	
 	public List<DataProductStatBean> getOverallStats(){
		return dao.dataOverallStatsList;
	}
	
	public List<SalesByCategoryBean> getSalesByCategory(){
		return dao.salesByCategoryList;
	}
	
	public PlotDataBean getSalesPlotCoordinates() {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			int prefixSum = 0;
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				prefixSum += element.getMonthlyData().get(i).getTotalSales(); 
				coordinates.setX(i);
				coordinates.setY(prefixSum);
				plotDataList.add(coordinates);
			}
		}
		bean.setData(plotDataList);
		return bean;
	}
	
	public PlotDataBean getUnitsPlotCoordinates() {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			int prefixSum = 0;
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				prefixSum += element.getMonthlyData().get(i).getTotalUnits();
				coordinates.setX(i);
				coordinates.setY(prefixSum);
				plotDataList.add(coordinates);
			}
		}
		bean.setData(plotDataList);
		return bean;
	}
	
	public PlotDataBean getSalesDailyPlotCoordinates(long startDate, long endDate) {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			for(int i=0;i<element.getDailyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				LocalDateTime localDateTime = element.getDailyData().get(i).getDate().atStartOfDay();
				long timeVal = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
				coordinates.setX(timeVal);
				coordinates.setY(element.getDailyData().get(i).getTotalSales());
				if(timeVal> startDate && timeVal<endDate) {
					plotDataList.add(coordinates);
				}
			}
		}
		
		bean.setData(plotDataList);
		return bean;
	}
	
	public PlotDataBean getUnitsDailyPlotCoordinates(long startDate, long endDate) {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			for(int i=0;i<element.getDailyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				LocalDateTime localDateTime = element.getDailyData().get(i).getDate().atStartOfDay();
				long timeVal = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
				coordinates.setX(timeVal);
				coordinates.setY(element.getDailyData().get(i).getTotalUnits());
				if(timeVal> startDate && timeVal<endDate) {
					plotDataList.add(coordinates);
				}
			}
		}
		
		bean.setData(plotDataList);
		return bean;
	}
	
	public PlotDataBean getSalesMonthlyPlotCoordinates() {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				coordinates.setX(i);
				coordinates.setY(element.getMonthlyData().get(i).getTotalSales());
				plotDataList.add(coordinates);
			}
		}
		
		bean.setData(plotDataList);
		return bean;
	}
	
	public PlotDataBean getUnitsMonthlyPlotCoordinates() {
		List<DataProductStatBean> overallStatsList = getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				coordinates.setX(i);
				coordinates.setY(element.getMonthlyData().get(i).getTotalUnits());
				plotDataList.add(coordinates);
			}
		}
		
		bean.setData(plotDataList);
		return bean;
	}
	
	public List<UserProductStatsBean> getAffiliateSales(){
		List<UserProductStatsBean> affiliateTransactionsList = new ArrayList<>();
		
		// Data From Dao
		List<AffiliateStatBean> affiliateSalesList = dao.affiliateSalesList;
		List<ProductBean> productsList = dao.productsList;
		List<DataTransactionBean> dataTransactionList = dao.dataTransactionList;
		
		// Data Logic
    	// Transactions Present
		HashMap<String, List<String>> userIdTransactionMap = new HashMap<>();
		Set<String> transactionsPresentInTheSystemSet = dataTransactionList.stream().map(DataTransactionBean::getId).collect(Collectors.toSet());		
		for(AffiliateStatBean outerElement : affiliateSalesList) {
			Set<String> transactionsPresent = new HashSet<>();
			for(String innerElement : outerElement.getAffiliateSales()) {
				if(transactionsPresentInTheSystemSet.contains(innerElement)) {
					transactionsPresent.add(innerElement);
				}
			}
			userIdTransactionMap.put(outerElement.getUserId(), new ArrayList<>(transactionsPresent));
		}
		
		HashMap<String, List<String>> transactionIdProductMap = new HashMap<>();
		Set<String> productId = productsList.stream().map(ProductBean::getId).collect(Collectors.toSet());
		for(DataTransactionBean outerElement : dataTransactionList) {
			Set<String> productsPresent = new HashSet<>();
			for(String innerElement : outerElement.getProducts()) {
				if(productId.contains(innerElement)) {
					productsPresent.add(innerElement);
				}
			}
			transactionIdProductMap.put(outerElement.getId(), new ArrayList<>(productsPresent));
		}
		
		HashMap<String, List<String>> mapOfUserIdAndProducts = new HashMap<>();
		for(Map.Entry<String, List<String>> entry : userIdTransactionMap.entrySet()) {
			for(int i=0; i<entry.getValue().size(); i++) {
				if (transactionIdProductMap.containsKey(entry.getValue().get(i))) {
					mapOfUserIdAndProducts.put(entry.getKey(), transactionIdProductMap.get(entry.getValue().get(i)));
				}
			}
		}
		
		int counter = 1;
		for(Map.Entry<String, List<String>> entry : mapOfUserIdAndProducts.entrySet()) {
			if(entry.getValue().size() <= 0) {
				continue;
			}
			int quantity = 1;
			for(String outerElement : entry.getValue()) {
				for(ProductBean innerElement : productsList) {
					if(outerElement.equalsIgnoreCase(innerElement.getId())) {
						UserProductStatsBean bean = UserProductStatsBean
								.builder()
								.id(counter++)
								.userId(entry.getKey())
								.productId(innerElement.getId())
								.name(innerElement.getName())
								.category(innerElement.getCategory())
								.description(innerElement.getDescription())
								.price(innerElement.getPrice())
								.quantity(quantity++)
								.build();
						affiliateTransactionsList.add(bean);
					}
				}
			}
		}
		return affiliateTransactionsList;
	}
}
