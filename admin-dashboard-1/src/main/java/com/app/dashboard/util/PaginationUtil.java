package com.app.dashboard.util;

import java.util.List;

import com.app.dashboard.pagination.Page;
import com.app.dashboard.pagination.PageImpl;

public class PaginationUtil {
	
	public static <T> Page<T> convertListToPage(List<T> list, int pageNumber, int pageSize){
		int startItem = pageNumber * pageSize;
		List<T> pagedList;
		
		if(list.size() < startItem) {
			pagedList = List.of();
		} else {
			int toIndex = Math.min(startItem + pageSize, list.size());
			pagedList = list.subList(startItem, toIndex);
		}
		return new PageImpl<>(pagedList, pageNumber, pageSize, list.size());
	}
}
