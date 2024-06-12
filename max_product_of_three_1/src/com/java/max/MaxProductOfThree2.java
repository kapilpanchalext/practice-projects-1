package com.java.max;

import java.util.Arrays;

public class MaxProductOfThree2 {

	public static void main(String[] args) {
//		int[] A = {-3, 1, 2, -2, 5, 6};
//		
//		Arrays.sort(A);
//		
//		int index = A.length-1;
//		
//		int product = A[index-2]*A[(index-1)]*A[(index)];
//		System.err.println(product);
		
//		int[] A = {-3, 1, 2, -2, 5, 6};
		int[] A = {-5, 5, -5, 4};
        Arrays.sort(A);
        int n = A.length;
        
        System.err.println(Arrays.toString(A));

        int maxProduct = Math.max(A[0] * A[1] * A[n - 1], A[n - 3] * A[n - 2] * A[n - 1]);
        System.err.println(maxProduct);

	}

}
