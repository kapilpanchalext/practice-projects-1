package com.java.cars;

public class PassingCars {

	public static void main(String[] args) {
//		int[] A = {0, 1, 0, 1, 1};
		int[] A = {1, 1, 1, 1, 0};
		int counter = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == 1) {
				continue;
			}
			for(int j=i; j<A.length; j++) {
				if(A[j] == 0) {
					continue;
				}
				if(A[i] == 0 && A[j] == 1) {
					counter++;
				}
			}
		}
		System.err.println("COUNTER: " + counter);
	}
}
