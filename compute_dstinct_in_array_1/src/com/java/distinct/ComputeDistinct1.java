package com.java.distinct;

import java.util.Arrays;

public class ComputeDistinct1 {
	public static void main(String[] args) {
		
		int[] A = {14, 7, 3, 12, 9, 11, 6, 2, 2};
		
		System.err.println("A: " + Arrays.toString(A));
		int[] B = Arrays.stream(A).distinct().toArray();
		System.err.println("B: " + Arrays.toString(B));
	}
}
