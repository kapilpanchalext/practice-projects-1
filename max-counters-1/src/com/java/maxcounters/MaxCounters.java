package com.java.maxcounters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxCounters {
	public static void main(String[] args) {

		Integer N = 1;
//		List<Integer> maxCounters = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
//		List<Integer> maxCounters = Arrays.asList(3, 4, 4, 6, 1, 4, 4);
//		List<Integer> maxCounters = Arrays.asList(2, 3, 1, 5);
//		List<Integer> maxCounters = Arrays.asList(1);
//		List<Integer> maxCounters = Arrays.asList(1,2,3,4,5);
//		List<Integer> maxCounters = Arrays.asList(5);
//		List<Integer> maxCounters = Arrays.asList(999999999);
		List<Integer> maxCounters = Arrays.asList(2, 1, 1, 2, 1);
		int[] resultArray = new int[N];

		List<Integer> resultList = Collections.nCopies(N, 0).stream().collect(Collectors.toList());
		System.err.println("RESULT LIST: " + resultList);

		Integer maxCounterValue = 0 ;
		System.err.println("N: " + N + " : " + maxCounters.size());
		
		if(N == maxCounters.get(0)) {
			resultList.set(N-1, 1);
		} else {
			System.err.println("MAX COUNTERS N == maxCounters: " + resultList);
			
			for(int i=0; i<maxCounters.size(); i++) {
				if(N == 1) {
					for(int j=0; j<maxCounters.size(); j++) {
						maxCounterValue = resultList.stream().mapToInt(Integer::intValue).max().getAsInt();
						System.err.println("$$MAX COUNTER VALUE: " + maxCounterValue);
						if(j == maxCounters.get(i)) {
							System.err.println("##MAX COUNTERS: " + maxCounters.get(i));
							resultList.set(j-1, resultList.get(j-1) + 1);
							System.err.println(resultList);
						}
					}
					
				} else {
					for(int j=0; j<resultList.size(); j++) {
						if(j == maxCounters.get(i)) {
							System.err.println("##MAX COUNTERS: " + maxCounters.get(i));
							resultList.set(j-1, resultList.get(j-1) + 1);
							System.err.println(resultList);
							
						}
						maxCounterValue = resultList.stream().mapToInt(Integer::intValue).max().getAsInt();
//						maxCounterValue = 2;
						System.err.println("MAX COUNTER VALUE: " + maxCounterValue);
						if(maxCounters.get(i) > N) {
							System.err.println("EXCEEDED: " + maxCounters.get(i));
							resultList = Collections.nCopies(N, maxCounterValue).stream().collect(Collectors.toList());
							System.err.println("RESULT LIST: " + resultList);
							break;
						}
					}
				}

			}
		}
				
		resultArray = resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
		
//		resultList.toArray(resultArray);
//		
//		for(int i=0;i<resultArray.length;i++) {
//			System.err.println("RESULT ARRAY: " + resultArray[i]);
//		}
	}
}
