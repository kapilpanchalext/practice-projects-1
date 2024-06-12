package com.java.triangle;

import java.util.Arrays;

public class Triangle4 {

	public static void main(String[] args) {
		int[] A = {-3, 1, 2, -2, 5, 6, Integer.MAX_VALUE, Integer.MAX_VALUE};
		int result = 0;
        Arrays.sort(A);
        
        for (int i = 0; i < A.length - 2; i++) {
            long a = A[i];
            long b = A[i + 1];
            long c = A[i + 2];
            if (a + b > c) {
                result = 1;
            }
        }
        System.err.println("RESULT: " + result);
	}
}
