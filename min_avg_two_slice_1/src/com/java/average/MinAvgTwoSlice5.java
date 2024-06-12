package com.java.average;

public class MinAvgTwoSlice5 {
	public static void main(String[] args) {
		
		int[] A = new int[]{-3, -5, -8, -4, -10};
		int[] prefixSum = new int[A.length];
		prefixSum[0] = A[0];

		// Calculate the prefix sum array
		for(int i = 1; i < A.length; i++) {
		    prefixSum[i] = prefixSum[i - 1] + A[i];
		}

		double minAvg = Double.MAX_VALUE;
		int minIndex = 0;

		// Calculate the minimum average
		for(int i = 0; i < A.length - 1; i++) {
		    double avg1 = (double)(prefixSum[i] - A[i]) / (i + 1);
		    double avg2 = (double)(prefixSum[A.length - 1] - prefixSum[i]) / (A.length - i - 1);
		    
		    System.err.println("AVG1: " + avg1);
		    System.err.println("AVG2: " + avg2);
		    
		    double currAvg = Math.min(avg1, avg2);

		    if(currAvg < minAvg) {
		        minAvg = currAvg;
		        minIndex = i;
		    }
		}

		System.out.println("MINVAL: " + minAvg);
		System.out.println("INDEXMINVAL: " + minIndex);
	}
}
