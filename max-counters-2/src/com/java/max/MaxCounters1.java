package com.java.max;

import java.util.Arrays;

public class MaxCounters1 {
	public static void main(String[] args) {

		int N = 5;
		int[] A = new int []{3, 4, 4, 6, 1, 4, 4};
		int[] results = new int[N];

		System.err.println("A: " + Arrays.toString(A));

		//Initialize the Array to all Zeros
		for(int i=0; i<N; i++) {
			results[i] = 0;
		}

//		int highestValue = 0;
//		for (int element : A) {
//			if(element > N) {
//				Arrays.fill(results, highestValue);
//			} else {
//				results[element-1] += 1;
//				highestValue = Math.max(highestValue, results[element - 1]);
//			}
//		}
		
//		int highestValue = 0;
//		for (int element : A) {
//			if(element > N) {
////				for(int i=0; i<N; i++) {
////					results[i] = highestValue;
////				}
//				Arrays.fill(results, highestValue);
//			} else {
//				results[element-1] += 1;
//				highestValue = Math.max(highestValue, results[element - 1]);
//			}
//		}
		
		int highestValue = 0;
		int maxResetValue = 0; 
		for (int element : A) {
		    if (element > N) {
		        maxResetValue = highestValue; // Update the max reset value
		    } else {
		        int index = element - 1;
		        if (results[index] < maxResetValue) {
		            results[index] = maxResetValue + 1; // Increment the counter only if necessary
		        } else {
		            results[index]++; // Increment the counter
		        }
		        highestValue = Math.max(highestValue, results[index]);
		    }
		}

		// Update any remaining counters after processing all elements
		for (int i = 0; i < N; i++) {
		    results[i] = Math.max(results[i], maxResetValue);
		}
		
		System.err.println("RESULTS: " + Arrays.toString(results));
	}
}
