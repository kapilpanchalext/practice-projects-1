package com.app.dashboard.api;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dashboard.bean.ChloroplethDataBean;
import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.PlotCoordinates;
import com.app.dashboard.bean.PlotDataBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.pagination.Page;
import com.app.dashboard.service.UserService;
import com.app.dashboard.util.PaginationUtil;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService service;
    
	@GetMapping(path = "/get-users")
	public ResponseEntity<List<UserBean>> getUsers(){
		List<UserBean> users = service.getUsers();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(users);
	}
	
	@GetMapping(path = "/get-users-by-id")
	public ResponseEntity<UserBean> getUsersById(@RequestParam(name = "userId") String userId){
		List<UserBean> users = service.getUsers();
		
		UserBean user = new UserBean();
		
		for(UserBean element : users) {
			if(element.getId().equalsIgnoreCase(userId)) {
				user = element;
			}
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(user);
	}
	
	@GetMapping(path = "/get-products")
	public ResponseEntity<List<ProductBean>> getProducts(){
		List<ProductBean> products = service.getProducts();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(products);
	}
	
	@GetMapping(path = "/get-products-stats")
	public ResponseEntity<List<DataProductStatBean>> getProductStats(){
		List<DataProductStatBean> productStats = service.getProductStats();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(productStats);
	}
	
	@GetMapping(path = "/get-transactions")
	public ResponseEntity<List<DataTransactionBean>> getTransactions(){
		List<DataTransactionBean> transactionList = service.getDataTransactions();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(transactionList);
	}
	
	@GetMapping(path = "/get-transactions-pagination")
	public ResponseEntity<Page<DataTransactionBean>> getTransactionsPagination(
			@RequestParam(value = "page", defaultValue = "0") int page,
	        @RequestParam(value = "size", defaultValue = "25") int size){
		
		List<DataTransactionBean> transactionList = service.getDataTransactions();
		
		Page<DataTransactionBean> pagedList = PaginationUtil.convertListToPage(transactionList, page, size);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(pagedList);
	}
	
	@GetMapping(path = "/get-chloropleth-data")
	public ResponseEntity<List<ChloroplethDataBean>> getChloropleth(){
		List<UserBean> transactionList = service.getUsers();
		
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

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(chloroplethDataBeanList);
	}
	
	@GetMapping(path = "/get-sales")
	public ResponseEntity<List<DataProductStatBean>> getOverallStats(){
		List<DataProductStatBean> overallStatsList = service.getOverallStats();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(overallStatsList);
	}
	
	@GetMapping(path = "/get-sales-plot-monthly")
	public ResponseEntity<PlotDataBean> getSalesPlotCoordinates(){
		List<DataProductStatBean> overallStatsList = service.getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			int prefixSum = 0;
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				prefixSum += element.getMonthlyData().get(i).getTotalSales(); 
				coordinates.setXString(element.getMonthlyData().get(i).getMonth());
				coordinates.setY(prefixSum);
				plotDataList.add(coordinates);
			}
		}
		bean.setData(plotDataList);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-units-plot-monthly")
	public ResponseEntity<PlotDataBean> getUnitsPlotCoordinates(){
		List<DataProductStatBean> overallStatsList = service.getOverallStats();
		List<PlotCoordinates> plotDataList = new ArrayList<>();
		PlotDataBean bean = new PlotDataBean();
		
		for(DataProductStatBean element : overallStatsList) {
			int prefixSum = 0;
			for(int i=0;i<element.getMonthlyData().size(); i++) {
				PlotCoordinates coordinates = new PlotCoordinates();
				prefixSum += element.getMonthlyData().get(i).getTotalUnits(); 
				coordinates.setXString(element.getMonthlyData().get(i).getMonth());
				coordinates.setY(prefixSum);
				plotDataList.add(coordinates);
			}
		}
		bean.setData(plotDataList);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-sales-plot-daily")
	public ResponseEntity<PlotDataBean> getSalesDailyPlotCoordinates(
			@RequestParam(name = "startDate") long startDate, 
			@RequestParam(name = "endDate") long endDate) {
		List<DataProductStatBean> overallStatsList = service.getOverallStats();
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
		System.err.println(plotDataList.size());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-units-plot-daily")
	public ResponseEntity<PlotDataBean> getUnitsDailyPlotCoordinates(
			@RequestParam(name = "startDate") long startDate, 
			@RequestParam(name = "endDate") long endDate) {
		List<DataProductStatBean> overallStatsList = service.getOverallStats();
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
		System.err.println(plotDataList.size());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
}
