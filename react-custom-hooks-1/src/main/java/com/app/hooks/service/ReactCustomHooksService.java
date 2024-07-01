package com.app.hooks.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hooks.dao.ReactCustomHooksDao;
import com.app.hooks.model.PlacesBean;

@Service
public class ReactCustomHooksService {

	@Autowired
	private ReactCustomHooksDao dao;
	
	public List<PlacesBean> getPlacesList(){
		return dao.getPlacesList();
	}
	
	public List<PlacesBean> getPlacesSublist(){
		return dao.getPlacesList().subList(16, 18);
	}
}
