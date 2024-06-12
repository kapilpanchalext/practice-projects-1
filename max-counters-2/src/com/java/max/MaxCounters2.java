package com.java.max;

import java.util.Arrays;

public class MaxCounters2 {
	public static void main(String[] args) {
		int N = 5;
		int[] A = new int []{3, 4, 4, 6, 1, 4, 4};
		int[] results = new int[N];
		int highestValue = 0;
		int resetIndex = 0;

		System.err.println("A: " + Arrays.toString(A));

		//Initialize the Array to all Zeros
		for(int i=0; i<N; i++) {
			results[i] = 0;
		}

		//Find the last highest reset
		for(int i=A.length-1; i>=0; i--) {
			if(A[i] > N) {
				System.err.println("INDEX2: " + (i));
				resetIndex = i;
				break;
			}
		}

		System.err.println("RESET INDEX: " + resetIndex);

		for(int i=0; i<resetIndex; i++) {
			if(A[i] <= N) {
				int index = A[i]-1;
				results[index]++;
				if (results[index]>highestValue) {
					highestValue = results[index];
				}
			}
		}

		Arrays.fill(results, highestValue);

		for(int i=resetIndex; i<A.length; i++) {
			if(A[i] <= N) {
				int index = A[i]-1;
				results[index]++;
				if (results[index]>highestValue) {
					highestValue = results[index];
				}
			}
		}

		System.err.println("HIGHEST VALUE: " + highestValue);
		System.err.println("RESULTS: " + Arrays.toString(results));
	}
}
