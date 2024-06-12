package com.java.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingTable1 {
	public static void main(String[] args) {
		List<String> APPLICABLE_BADGE_ID_NGASCE = new ArrayList<>();
		List<String> APPLICABLE_BADGE_ID_NCDOE = new ArrayList<>();
		
		for (int i = 1; i <= 166; i++) {
		    APPLICABLE_BADGE_ID_NGASCE.add(String.valueOf(i));
		}
		
		Map<String, List<String>> mappedCPSIDAndBadgeIds = new HashMap<>();
		
		for (int i=1; i<164; i++) {
			mappedCPSIDAndBadgeIds.put(String.valueOf(i), APPLICABLE_BADGE_ID_NGASCE);
		}
		
		for (int i=164; i<=164; i++) {
		    APPLICABLE_BADGE_ID_NCDOE.add(String.valueOf(i));
		}
		
		// There are 166 CPSIDs for NCDOE
		for (int i=167; i<=174; i++) {
			mappedCPSIDAndBadgeIds.put(String.valueOf(i), APPLICABLE_BADGE_ID_NCDOE);
		}
	}
}
