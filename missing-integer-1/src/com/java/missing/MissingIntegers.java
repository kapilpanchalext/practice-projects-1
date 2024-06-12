package com.java.missing;

import java.util.Arrays;

public class MissingIntegers {
	public static void main(String[] args) {
		
		int[] A = {1,3,6,4,1,2};
		
		System.err.println(Arrays.toString(A));

		int[] distinct = Arrays.stream(A).distinct().toArray();
		
		System.err.println(Arrays.toString(distinct));
		
		int max = Arrays.stream(distinct).max().getAsInt();
		int min = Arrays.stream(distinct).min().getAsInt();
		
		System.err.println(max);
		System.err.println(min);
		
		int actualSum = Arrays.stream(distinct).sum();
		System.err.println("Actual Sum: " + actualSum);

		int expectedSum = 0;
		int missingElement = 0;
		
		if(max > 0) {
			expectedSum = (max*(max+1))/2;
			missingElement = expectedSum-actualSum;
		} else {
			expectedSum = -(Math.abs(min)*(Math.abs(min)+1))/2;
			missingElement = expectedSum-actualSum;
		}
		
		System.err.println(expectedSum);
		System.err.println("Missing Element: " + missingElement);
	}
}
