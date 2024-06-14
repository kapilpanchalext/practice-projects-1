package com.app.dashboard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.dao.AdminDashboardDao;

@Service
public class UserService {
	
	@Autowired
	private AdminDashboardDao dao;
	
	public List<UserBean> getUsers() {
		return dao.users;	
	}
	
	public List<ProductBean> getProducts(){
		return dao.products;
	}

	public List<DataProductStatBean> getProductStats() {
		return dao.dataProductStat;
	}
	
	public List<DataTransactionBean> getDataTransactions(){
		return dao.dataTransactionList;
	}
	
	public List<DataProductStatBean> getOverallStats(){
		return dao.dataOverallStatsList;
	}
}
