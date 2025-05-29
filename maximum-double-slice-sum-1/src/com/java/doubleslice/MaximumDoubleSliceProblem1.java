package com.java.doubleslice;

import java.util.Arrays;

public class MaximumDoubleSliceProblem1 {

	public static void main(String[] args) {
		System.out.println("Maximum Double Slice Problem!");
		
		int[] A = {5, -7, 3, 5, -2, 4, -1};
		
		System.out.println(Arrays.toString(A));
		
		int forwardSum = getForwardSum(A, A.length);
		System.out.println(forwardSum);
		
		int backwardSum = getBackwardSum(A, A.length);
		System.out.println(backwardSum);
		
		int resultSum = getCombinedResults(A);
		System.out.println(resultSum);

	}

	private static int getCombinedResults(int[] A) {
		int maxEnding = 0;
		for(int i=1; i<A.length-1; i++) {
			int forwardSum = getForwardSum(A, A.length);
			int backwardSum = getBackwardSum(A, A.length);
			
			maxEnding = Math.max(maxEnding, forwardSum + backwardSum);
		}
		return maxEnding;
	}

	private static int getBackwardSum(int[] A, int length) {
		int[] maxEnding = new int[length];
		int sum = 0;
		
		for(int i=1; i<length-1; i++) {
			maxEnding[i] = Math.max(0, maxEnding[i + 1] + A[i]);
		}
		
		for(int element : maxEnding) {
			sum += element;
		}
		return sum;
	}

	private static int getForwardSum(int[] A, int length) {
		int[] maxEnding = new int[length];
		int sum = 0;
		
		for(int i=1; i<length-1; i++) {
			maxEnding[i] = Math.max(0, maxEnding[i - 1] + A[i]);
		}
		
		for(int element : maxEnding) {
			sum += element;
		}
		return sum;
	}

}
