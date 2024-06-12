package com.java.triangle;

import java.util.Arrays;

public class Triangle3 {
	public static void main(String[] args) {
		int[] A = {-3, 1, 2, -2, 5, 6};
		
        Arrays.sort(A);
        int result = 0;
        
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                result = 1;
            }
        }
        
        System.err.println("RESULT: " + result);
	}
}
