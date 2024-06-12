package com.app.dashboard.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.reader.DataProductStatReader;
import com.app.dashboard.reader.ProductReader;
import com.app.dashboard.reader.UserReader;

@Repository
public class AdminDashboardDao {
	public List<UserBean> users = new ArrayList<>();
	public List<ProductBean> products = new ArrayList<>();
	public List<DataProductStatBean> dataProductStat = new ArrayList<>();

	private AdminDashboardDao() {
		UserReader userReader = new UserReader();
		users = userReader.readInputsFromFile("datafile\\users.txt");
		
		ProductReader productReader = new ProductReader();
		products = productReader.readInputsFromFile("datafile\\product.txt");
		
		DataProductStatReader dataProductStatReader = new DataProductStatReader();
		dataProductStat = dataProductStatReader.readInputsFromFile("datafile\\dataproductstat.txt");
	}
}
