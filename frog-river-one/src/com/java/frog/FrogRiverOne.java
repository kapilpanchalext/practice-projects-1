package com.java.frog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrogRiverOne {
	public static void main(String[] args) {
		
//		Integer x = 5;
////		List<Integer> frogRiverOne = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
////		List<Integer> frogRiverOne = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);
////		List<Integer> frogRiverOne = Arrays.asList(1);
////		List<Integer> frogRiverOne = Arrays.asList(2);
//		
//		List<Integer> frogRiverOne = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
//		
//		System.err.println("FROG RIVER ONE: " + frogRiverOne);
//		
////		Set<Integer> frogRiverOneSet = frogRiverOne.stream().collect(Collectors.toSet());
//		Set<Integer> frogRiverOneSet = IntStream.range(1, x+1).boxed().collect(Collectors.toSet());
//		Set<Integer> resultSet = new HashSet<>();
//		
//		System.err.println("FROG RIVER ONE SET: " + frogRiverOneSet);
//		
//		Integer result = 0;
//		
//		Integer counter = 1;
//		for(int i=0; i<x; i++) {
//			for(Integer element : frogRiverOneSet) {
//				if (element == i) {
//					counter++;
//				}
//			}
//		}
//		
//		if(frogRiverOne.size() == 1 && frogRiverOne.get(0) == 1) {
//			result = 1;
//		} else if(frogRiverOne.size() == 1 && frogRiverOne.get(0) > 1) {
//			result = 0;
//		} else {
//			for (int k=0; k<frogRiverOne.size(); k++) {
//				resultSet.add(frogRiverOne.get(k));
//				System.err.println("RESULT SET: " + resultSet);
//				if(resultSet.size() == frogRiverOneSet.size()) {
//					result = k;
//					break;
//				}
//			}
//			if(resultSet.size() != x) {
//				result = -1;
//			}
//		}
//		System.err.println("RESULT SET: " + result);
		
		Integer x = 5;
//		List<Integer> frogRiverOne = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
//		List<Integer> frogRiverOne = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);
//		List<Integer> frogRiverOne = Arrays.asList(1);
		List<Integer> frogRiverOne = Arrays.asList(2);
		
//		List<Integer> frogRiverOne = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
		
		System.err.println("FROG RIVER ONE: " + frogRiverOne);
		
		Set<Integer> frogRiverOneSet = IntStream.range(1, x+1).boxed().collect(Collectors.toSet());
//		Set<Integer> resultSet = new HashSet<>();
		
		Map<Integer,Integer> resultsMap = new HashMap<>();
		
		System.err.println("FROG RIVER ONE SET: " + frogRiverOneSet);
		
		Integer result = 0;
		
		if(frogRiverOne.size() == 1 && frogRiverOne.get(0) == 1) {
			result = 0;
		} else if(frogRiverOne.size() == 1 && frogRiverOne.get(0) > 1) {
			result = -1;
		} else {
			for (int k=0; k<frogRiverOne.size(); k++) {
				resultsMap.put(frogRiverOne.get(k), frogRiverOne.get(k));
				System.err.println("RESULT SET: " + resultsMap);
				if(resultsMap.size() == frogRiverOneSet.size()) {
					result = k;
					break;
				}
			}
			if(resultsMap.size() != x) {
				result = -1;
			}
		}
		System.err.println("RESULT SET: " + result);
	}
}
