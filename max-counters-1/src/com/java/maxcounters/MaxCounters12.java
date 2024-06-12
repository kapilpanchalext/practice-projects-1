package com.java.maxcounters;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxCounters12 {
	public static void main(String[] args) {
//		final Integer N = 5;
//		Integer[] inputArray = {3,4,4,6,1,4,4};
//		Integer[] inputArray = {6,7,8,6,9,10,4};
//		Integer[] resultsArray = new Integer[N];
//
//		List<Integer> inputArrayList = Arrays.asList(inputArray);
//		List<Integer> resultsArrayList = new ArrayList<>();
//		resultsArrayList = Collections.nCopies(N, 0);
//
//		Integer N = 1;
//		Integer[] inputArray = {1};
//		Integer[] resultsArray = new Integer[N];
//		
//		Integer N = 1;
//		Integer[] inputArray = {1,2,1,1,2,1};
//		Integer[] resultsArray = new Integer[N];
		
		Integer N = 1;
		Integer[] inputArray = {2,1,2,2,1};
		Integer[] resultsArray = new Integer[N];
		
		Arrays.fill(resultsArray, 0);
		AtomicInteger maxVal = new AtomicInteger(0);
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] <= N) {
				Integer index = inputArray[i]-1;
				resultsArray[index] += 1;
				
				if (resultsArray[index] > maxVal.get()) {
					maxVal.set(resultsArray[index]);
				}
			}
			else {
				Arrays.fill(resultsArray, maxVal.get());
			}
		}
		System.err.println("RESULTS3: " + Arrays.toString(resultsArray));
	}
}
