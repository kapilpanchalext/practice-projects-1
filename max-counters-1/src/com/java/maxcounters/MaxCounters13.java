package com.java.maxcounters;

import java.util.Arrays;
import java.util.Random;

public class MaxCounters13 {
	public static void main(String[] args) {
		int N = 1000;
//		int[] inputArray = {3,4,4,6,1,4,4};
		int[] resultsArray = new int[N];

		int[] inputArray = generateRandomIntArray(100000);
//		System.err.println(Arrays.toString(inputArray));
//		Integer N = 1;
//		Integer[] inputArray = {1,2,1,1,2,1};
//		Integer[] resultsArray = new Integer[N];
//		
//		Integer N = 1;
//		Integer[] inputArray = {2,1,1,2,1};
//		Integer[] resultsArray = new Integer[N];
//		
//		Integer N = 1;
//		Integer[] inputArray = {2,1,2,2,1};
//		Integer[] resultsArray = new Integer[N];
//
//		Arrays.fill(resultsArray, 0);

		int maxValue = 0;
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] <= N) {
				int index = inputArray[i]-1;
				resultsArray[index]++;
				if (resultsArray[index]>maxValue) {
					maxValue = resultsArray[index];
				}
			} else {
				Arrays.fill(resultsArray, maxValue);
			}
		}
		

		System.err.println("RESULTS ARRAY: " + Arrays.toString(resultsArray));
	}

	private static int[] generateRandomIntArray(int size) {
		 int[] array = new int[size];
	        Random random = new Random();
	        for (int i = 0; i < size; i++) {
	        	array[i] = random.nextInt(1000)+1;
	        }
	        return array;
		
//		 int[] array = new int[size];
//	        Random random = new Random();
//	        double mean = 1.5; // Mean value for the distribution
//	        double stdDev = 1.0; // Standard deviation for the distribution
//	        for (int i = 0; i < size; i++) {
//	            int value = (int) (random.nextGaussian() * stdDev + mean);
//	            if (value < 1) {
//	                value = 1; // Ensure the value is at least 1
//	            } else if (value > 10) {
//	                value = 10; // Ensure the value is at most 10
//	            }
//	            array[i] = value;
//	        }
//	        return array;
	}
}
