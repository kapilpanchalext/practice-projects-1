package com.java.cars;

import java.util.Arrays;

public class PassingCars2 {
	public static void main(String[] args) {
//		int[] A = {0, 1, 0, 1, 1};
//		int[] A = {0};
		int[] A = {1, 1, 1, 1, 0};
 		int counter = 0;
		long zeroCounter = Arrays.stream(A).filter(element -> element == 0).count();
		System.err.println(zeroCounter);
		//counter += Arrays.stream(A).filter(element -> element == 0).count();
		
		if(A.length == 1) {
			System.err.println(0);
		}
		
		if(A.length == 2) {
			if(A[0] == 0 && A[1] == 1) {
				System.err.println("1");
			} else {
				System.err.println("0");
			}
		}
		
		for(int i=0; i<A.length; i++) {
			if(A[i] == 0) {
				counter += A.length-zeroCounter-1;
				zeroCounter--;
			}
		}
		System.err.println("COUNTER: " + counter);
	}
}
