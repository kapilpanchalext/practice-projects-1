package com.java.maximumslice;

import java.util.Arrays;

public class MaximumSliceProblem1 {

	public static void main(String[] args) {
		System.out.println("Maximum Slice Problem!");
		
//		int[] A = {5, -7, 3, 5, -2, 4, -1};
		int[] A = {3, 2, -6, 4, 0};
		
		System.out.println(Arrays.toString(A));
		
		int maxEnding = A[0];
		int maxSlice = A[0];
		
		for (int i = 1; i < A.length; i++) {

			System.err.print("MaxEnding: " + A[i] + " : " + (maxEnding + A[i]) + " = ");
      maxEnding = Math.max(A[i], maxEnding + A[i]);
      System.err.println(maxEnding);
      maxSlice = Math.max(maxSlice, maxEnding);
      System.err.println("MaxSlice: " + maxSlice);
		}

		System.err.println(maxSlice);
	}
}
