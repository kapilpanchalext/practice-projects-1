package com.java.average;

import java.util.Arrays;

public class MinAvgTwoSlice2 {
	public static void main(String[] args) {
		
		int[] A = new int[5];
		
		A[0] = -3;
		A[1] = -5;
	    A[2] = -8;
	    A[3] = -4;
	    A[4] = -10;
	    
	    int[] prefixSum = new int[A.length];
//	    int lengthOfArray = 0;
//	    
//	    for(int i=2; i<=A.length; i++) {
//	    	lengthOfArray += A.length - i + 1;
//	    }
//	    
//	    System.err.println("LENGTH OF ARRAY: " + lengthOfArray);
//	    
//	    double[] resultsAvg = new double[lengthOfArray];
	    
	    prefixSum[0] = A[0];
	    
	    for(int i=1; i<A.length; i++) {
	    	prefixSum[i] = prefixSum[i-1] + A[i];
	    }
	    
	    System.err.println("PREFIX SUM: " + Arrays.toString(prefixSum));
	    
//	    int counter = 0;
	    double denominator = 2.0;
	    double minVal = Double.MAX_VALUE;
	    int indexMinVal = 0;
	    
	    for(int i=0; i<A.length-1; i++) {
	    	denominator = 2.0;
	    	for(int j=i+1; j<A.length; j++) {
	    		double firstTerm = prefixSum[j];
	    		double secondTerm = i == 0 ? 0 : prefixSum[i-1];
	    		double val = (firstTerm	- secondTerm)/(denominator++);
	    		System.err.println("VAL: " + val);
//	    		resultsAvg[counter++] = val;
	    		
	    		minVal = Math.min(minVal, val);
	    		if(minVal == val) {
	    			indexMinVal = i;
	    		}
	    	}
	    }
	    
	    System.err.println("MINVAL: " + minVal);
	    System.err.println("INDEXMINVAL: " + indexMinVal);
	    
//	    resultsAvg[0] = prefixSum[1] / 2;
	    

	    
	}
}
