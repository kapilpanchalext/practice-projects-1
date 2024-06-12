package com.java.triangle;

public class Triangle1 {
	public static void main(String[] args) {
		int[] A = {-3, 1, 2, -2, 5, 6};
		
		int result = 0;
		for(int i=0; i<A.length-2; i++) {
			for(int j=i+1; j<A.length-1; j++) {
				for(int k=j+1; k<A.length; k++) {
					if(A[i]+A[j]>A[k] && A[j]+A[k]>A[i] && A[k]+A[i]>A[j]) {
						result = 1;
					}
				}
			}
		}

		System.err.println(result);
	}
}
