package com.java.average;

import java.util.Arrays;

public class MinAvgTwoSlice1 {
	public static void main(String[] args) {
		
//		int[] A = new int[7];
//		
//		A[0] = 4;
//		A[1] = 2;
//	    A[2] = 2;
//	    A[3] = 5;
//	    A[4] = 1;
//	    A[5] = 5;
//	    A[6] = 8;
	    
	    //[-3, -5, -8, -4, -10]
	    
		int[] A = new int[5];
		
		A[0] = -3;
		A[1] = -5;
	    A[2] = -8;
	    A[3] = -4;
	    A[4] = -10;
	    
	    int[] prefixSum = new int[A.length];
	    double[] resultsAvg = new double[prefixSum.length-1];
	    
	    prefixSum[0] = A[0];
	    
	    for(int i=1; i<A.length; i++) {
	    	prefixSum[i] = prefixSum[i-1] + A[i];
	    }
	    
	    resultsAvg[0] = prefixSum[1] / 2;
	    
	    double minVal = Double.MAX_VALUE;
	    int indexMinVal = 0;
	    
	    for(int i = 0; i<prefixSum.length-2; i++) {
	    	resultsAvg[i+1] = (prefixSum[i+2] - prefixSum[i])/2.0;
	    	minVal = Math.min(minVal, (prefixSum[i+2] - prefixSum[i])/2.0);
	    }
	    
	    System.err.println("MINVAL: " + minVal);
	    
	    System.err.println("RESULTS AVG: " + Arrays.toString(resultsAvg));
	    
	    for(int i = 0; i<resultsAvg.length; i++) {
	    	if(resultsAvg[i] == minVal) {
	    		indexMinVal = i;
	    	}
	    }
	    System.err.println("INDEX MIN VAL: " + indexMinVal);
	}
}
