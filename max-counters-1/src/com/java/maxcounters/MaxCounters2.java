package com.java.maxcounters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxCounters2 {

	public static void main(String[] args) {
		Integer N = 5;
//		List<Integer> maxCounters = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
		List<Integer> maxCounters = Arrays.asList(3, 4, 4, 6, 1, 4, 4);
//		List<Integer> maxCounters = Arrays.asList(2, 3, 1, 5);
//		List<Integer> maxCounters = Arrays.asList(1);
//		List<Integer> maxCounters = Arrays.asList(1,2,3,4,5);
//		List<Integer> maxCounters = Arrays.asList(5);
//		List<Integer> maxCounters = Arrays.asList(999999999);
//		List<Integer> maxCounters = Arrays.asList(2, 1, 1, 2, 1);
		int[] resultArray = new int[N];

		List<Integer> resultList = new ArrayList<>(Collections.nCopies(N, 0));
		System.err.println("RESULT LIST: " + resultList);

		Integer maxCounterValue = 0;
		
		if(N == 0) {
//			return maxofMaxCounters;
			int max = maxCounters.stream().mapToInt(Integer::intValue).max().getAsInt();
			resultArray[0] = max;
		} else {
			for(int i=0; i<maxCounters.size(); i++) {
				for(int j=0; j<resultList.size(); j++) {
					if(maxCounters.get(i) == j) {
						resultList.set(j-1, resultList.get(j-1) + 1);
						System.err.println(resultList);
					} else if(maxCounters.get(i) == 1 && N == 1) {
						resultList.set(j, resultList.get(j) + 1);
					}
					
					if(maxCounters.get(i) > N) {
						resultList = new ArrayList<>(Collections.nCopies(N, maxCounterValue));
						break;
					}
				}
				maxCounterValue = resultList.stream().mapToInt(Integer::intValue).max().getAsInt();
			}
		}
		
//		System.err.println("FINAL RESULTS LIST: " + resultList);
		
//		resultArray = resultList.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
	}
}
