package com.java.average;

import java.util.Arrays;

public class MinAvgTwoSlice4 {
	public static void main(String[] args) {
//		int[] A = new int[]{4, 2, 2, 5, 1, 5, 8};
		int[] A = new int[]{-3, -5, -8, -4, -10};
		int n = A.length;
		
		System.err.println("A: " + Arrays.toString(A));

		// Calculate prefix sum array
		int[] prefixSum = new int[n];
		prefixSum[0] = A[0];
		for (int i = 1; i < n; i++) {
		    prefixSum[i] = prefixSum[i - 1] + A[i];
		}

		System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSum));
		
		// Calculate minimum prefix sum from the left for each index
		int[] minPrefixSum = new int[n-1];
		minPrefixSum[0] = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;
		
		minPrefixSum[0] = 0;
		for (int i = 1; i < n-1; i++) {
			System.err.println("PREFIXSUM: " + prefixSum[i-1]);
		    minSum = Math.min(minSum, prefixSum[i-1]);
		    minPrefixSum[i] = minSum;
		}
		
		
		System.err.println("MIN PREFIX SUM: " + Arrays.toString(minPrefixSum));
 
		double minVal = Double.MAX_VALUE;
		int indexMinVal = 0;
		double denominator = 2.0;

//		for (int j = 1; j < n; j++) {
//		    double val = (prefixSum[j] - minPrefixSum[j - 1]) / denominator++;
//		    System.err.println("VAL: " + val);
//		    if (val < minVal) {
//		        minVal = val;
//		        indexMinVal = j - 1;
//		    }
//		}
		
		for(int j=1; j<prefixSum.length; j++) {
			for(int i=j; i<prefixSum.length; i++) {
				double val = (prefixSum[i] - minPrefixSum[j-1])/(j + 0.0);
				System.err.println(val);
			}
		}

		System.err.println("MINVAL: " + minVal);
		System.err.println("INDEXMINVAL: " + indexMinVal);
	}
}
