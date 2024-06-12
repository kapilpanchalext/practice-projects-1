package com.java.maxcounters;

import java.util.Arrays;

public class MaxCounters11 {
	public static void main(String[] args) {
		final Integer N = 5;
		Integer[] inputArray = {3, 4, 4, 6, 1, 4, 4};
		Integer[] resultsArray = new Integer[N];
		
		Integer[] subArray = Arrays.copyOf(inputArray, 3);
		System.err.println(Arrays.toString(subArray));
	}
}
