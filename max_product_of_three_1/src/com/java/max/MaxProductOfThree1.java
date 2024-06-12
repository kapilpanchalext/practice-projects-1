package com.java.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProductOfThree1 {
	public static void main(String[] args) {
		
		int[] A = {-3, 1, 2, -2, 5, 6};
		
		List<Integer> resultsList = new ArrayList<>();
		int counter = 0;
		for(int i=0; i<A.length-2; i++) {
			for(int j=i+1; j<A.length-1; j++) {
				for(int k=j+1; k<A.length; k++) {
					System.err.println(i + ":" + j + ":" + k);
					counter++;
					resultsList.add(A[i]*A[j]*A[k]);
					
				}
			}
		}
		System.err.println(counter);
		System.err.println(resultsList);
		System.err.println(Collections.max(resultsList));
	}
}
