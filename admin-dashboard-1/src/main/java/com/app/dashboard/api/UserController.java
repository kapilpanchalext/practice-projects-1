package com.app.dashboard.api;

import java.util.List;

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
import com.app.dashboard.bean.PlotDataBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.SalesByCategoryBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.bean.UserProductStatsBean;
import com.app.dashboard.pagination.Page;
import com.app.dashboard.service.UserService;

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
		UserBean user = service.getUserById(userId);
		
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
		List<DataProductStatBean> productStatsList = service.getProductStats();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(productStatsList);
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
		Page<DataTransactionBean> pagedList = service.getTransactionsPagination(page, size);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(pagedList);
	}
	
	@GetMapping(path = "/get-chloropleth-data")
	public ResponseEntity<List<ChloroplethDataBean>> getChloropleth(){
        List<ChloroplethDataBean> chloroplethDataBeanList = service.getChloroplethData();

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
	
	@GetMapping(path = "/get-sales-plot-overview")
	public ResponseEntity<PlotDataBean> getSalesPlotCoordinates(){
		PlotDataBean bean = service.getSalesPlotCoordinates();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-units-plot-overview")
	public ResponseEntity<PlotDataBean> getUnitsPlotCoordinates(){
		PlotDataBean bean = service.getUnitsPlotCoordinates();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-sales-plot-daily")
	public ResponseEntity<PlotDataBean> getSalesDailyPlotCoordinates(
			@RequestParam(name = "startDate") long startDate, 
			@RequestParam(name = "endDate") long endDate) {
		PlotDataBean bean = service.getSalesDailyPlotCoordinates(startDate, endDate);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-units-plot-daily")
	public ResponseEntity<PlotDataBean> getUnitsDailyPlotCoordinates(
			@RequestParam(name = "startDate") long startDate, 
			@RequestParam(name = "endDate") long endDate) {
		PlotDataBean bean = service.getUnitsDailyPlotCoordinates(startDate, endDate);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-sales-plot-monthly")
	public ResponseEntity<PlotDataBean> getSalesMonthlyPlotCoordinates() {
		PlotDataBean bean = service.getSalesMonthlyPlotCoordinates();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-units-plot-monthly")
	public ResponseEntity<PlotDataBean> getUnitsMonthlyPlotCoordinates() {
		PlotDataBean bean = service.getUnitsMonthlyPlotCoordinates();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bean);
	}
	
	@GetMapping(path = "/get-sales-by-category")
	public ResponseEntity<List<SalesByCategoryBean>> getSalesByCategory() {
		List<SalesByCategoryBean> salesByCategory = service.getSalesByCategory();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(salesByCategory);
	}
	
	@GetMapping(path = "/get-affiliate-sales")
	public ResponseEntity<List<UserProductStatsBean>> getAffiliateSales() {
		List<UserProductStatsBean> affiliateStats = service.getAffiliateSales();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(affiliateStats);
	}
}
