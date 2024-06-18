package com.app.dashboard.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.SalesByCategoryBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.reader.DataOverallStatReader;
import com.app.dashboard.reader.DataProductStatReader;
import com.app.dashboard.reader.DataTransactionReader;
import com.app.dashboard.reader.ProductReader;
import com.app.dashboard.reader.SalesByCategoryReader;
import com.app.dashboard.reader.UserReader;

@Repository
public class AdminDashboardDao {
	public List<UserBean> users = new ArrayList<>();
	public List<ProductBean> products = new ArrayList<>();
	public List<DataProductStatBean> dataProductStat = new ArrayList<>();
	public List<DataTransactionBean> dataTransactionList = new ArrayList<>();
	public List<DataProductStatBean> dataOverallStatsList = new ArrayList<>();
	public List<SalesByCategoryBean> salesByCategoryList = new ArrayList<>();

	private AdminDashboardDao() {
		UserReader userReader = new UserReader();
		users = userReader.readInputsFromFile("datafile\\users.txt");

		ProductReader productReader = new ProductReader();
		products = productReader.readInputsFromFile("datafile\\product.txt");

		DataProductStatReader dataProductStatReader = new DataProductStatReader();
		dataProductStat = dataProductStatReader.readInputsFromFile("datafile\\dataproductstat.txt");

		DataTransactionReader dataTransactionReader = new DataTransactionReader();
		dataTransactionList = dataTransactionReader.readInputsFromFile("datafile\\dataTransactions.txt");

		DataOverallStatReader dataOverallStatReader = new DataOverallStatReader();
		dataOverallStatsList = dataOverallStatReader.readInputsFromFile("datafile\\dataOverallStats.txt");

		SalesByCategoryReader salesByCategory = new SalesByCategoryReader();
		salesByCategoryList = salesByCategory.readInputsFromFile("datafile\\salesByCategory.txt");
	}
}
