package com.java.triangle;

import java.util.Arrays;

public class Triangle2 {
	public static void main(String[] args) {
		int[] A = {-3, 1, 2, -2, 5, 6};
		
		int result = 0;
		
	    Arrays.sort(A);

	    for (int i = 0; i < A.length - 2; i++) {
	        int k = i + 2;
	        for (int j = i + 1; j < A.length - 1; j++) {
	            while (k < A.length && A[i] + A[j] > A[k]) {
	                k++;
	            }
	            
	            if (k > j + 1) {
	            	result = 1;
	            }
	        }
	    }
		System.err.println(result);
	}
}
	

