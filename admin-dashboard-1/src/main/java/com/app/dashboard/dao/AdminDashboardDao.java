package com.app.dashboard.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.app.dashboard.bean.AffiliateStatBean;
import com.app.dashboard.bean.DataProductStatBean;
import com.app.dashboard.bean.DataTransactionBean;
import com.app.dashboard.bean.ProductBean;
import com.app.dashboard.bean.SalesByCategoryBean;
import com.app.dashboard.bean.UserBean;
import com.app.dashboard.reader.DataAffiliateStatReader;
import com.app.dashboard.reader.DataOverallStatReader;
import com.app.dashboard.reader.DataProductStatReader;
import com.app.dashboard.reader.DataTransactionReader;
import com.app.dashboard.reader.ProductReader;
import com.app.dashboard.reader.SalesByCategoryReader;
import com.app.dashboard.reader.UserReader;

@Repository
public class AdminDashboardDao {
	public List<UserBean> usersList = new ArrayList<>();
	public List<ProductBean> productsList = new ArrayList<>();
	public List<DataProductStatBean> dataProductStatList = new ArrayList<>();
	public List<DataTransactionBean> dataTransactionList = new ArrayList<>();
	public List<DataProductStatBean> dataOverallStatsList = new ArrayList<>();
	public List<SalesByCategoryBean> salesByCategoryList = new ArrayList<>();
	public List<AffiliateStatBean> affiliateSalesList = new ArrayList<>();

	private AdminDashboardDao() {
		UserReader userReader = new UserReader();
		usersList = userReader.readInputsFromFile("datafile\\users.txt");

		ProductReader productReader = new ProductReader();
		productsList = productReader.readInputsFromFile("datafile\\product.txt");

		DataProductStatReader dataProductStatReader = new DataProductStatReader();
		dataProductStatList = dataProductStatReader.readInputsFromFile("datafile\\dataproductstat.txt");

		DataTransactionReader dataTransactionReader = new DataTransactionReader();
		dataTransactionList = dataTransactionReader.readInputsFromFile("datafile\\dataTransactions.txt");

		DataOverallStatReader dataOverallStatReader = new DataOverallStatReader();
		dataOverallStatsList = dataOverallStatReader.readInputsFromFile("datafile\\dataOverallStats.txt");

		SalesByCategoryReader salesByCategory = new SalesByCategoryReader();
		salesByCategoryList = salesByCategory.readInputsFromFile("datafile\\salesByCategory.txt");
		
		DataAffiliateStatReader affiliateSalesCategory = new DataAffiliateStatReader();
		affiliateSalesList = affiliateSalesCategory.readInputsFromFile("datafile\\affiliateStats.txt");
	}
}
