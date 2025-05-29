package com.java.maxprofit;

import java.util.Arrays;

public class MaxProfit1 {

	public static void main(String[] args) {
		int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
		
		int[] diffArray = new int[A.length];
		diffArray[0] = 0;
		for(int i=0; i<A.length-1; i++) {
			diffArray[i+1] = A[i+1] - A[i];
		}
		
		System.err.println(Arrays.toString(diffArray));
		
		int maxEnding = diffArray[0];
		int maxSlice = diffArray[0];
		
		for (int i = 1; i < diffArray.length; i++) {
			System.err.print("MaxEnding: " + diffArray[i] + " : " + (maxEnding + diffArray[i]) + " = ");
      maxEnding = Math.max(diffArray[i], maxEnding + diffArray[i]);
      System.err.println(maxEnding);
      maxSlice = Math.max(maxSlice, maxEnding);
      System.err.println("MaxSlice: " + maxSlice);
		}

		System.err.println(maxSlice);
	}

}
