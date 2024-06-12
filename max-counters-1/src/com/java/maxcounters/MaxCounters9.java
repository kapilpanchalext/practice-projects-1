package com.java.maxcounters;

import java.util.Arrays;

public class MaxCounters9 {
	public static void main(String[] args) {
		
		Integer N = 5;
		Integer[] inputArray = {3,4,4,6,1,4,4};
		Integer[] resultsArray = new Integer[N];
		Arrays.fill(resultsArray, 0);

		Integer max = Arrays.stream(inputArray).mapToInt(Integer::intValue).max().getAsInt();
		System.err.println("MAX VALUE: " + max);
	}
}
