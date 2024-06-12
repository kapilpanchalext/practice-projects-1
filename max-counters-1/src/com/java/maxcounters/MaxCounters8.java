package com.java.maxcounters;

import java.util.Arrays;

public class MaxCounters8 {

	public static void main(String[] args) {
//		Integer N = 5;
//		Integer[] inputArray = {3,4,4,6,1,4,4};
//		Integer[] resultsArray = new Integer[N];
		
		Integer N = 1;
		Integer[] inputArray = {1,2,1,1,2,1};
		Integer[] resultsArray = new Integer[N];
		
		Arrays.fill(resultsArray, 0);
		
		Integer maxValue = 0;
		
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] <= N) {
				Integer index = inputArray[i]-1;
				resultsArray[index] += 1;
				if (resultsArray[index]>maxValue) {
					maxValue = resultsArray[index];
				}
			} else {
				Arrays.fill(resultsArray, maxValue);
			}
		}
		
		System.err.println("RESULTS ARRAY: " + Arrays.toString(resultsArray));
	}
}
