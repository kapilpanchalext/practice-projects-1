package com.java.disc;

import java.util.Arrays;

public class NumberOfDiscIntersections1 {
	public static void main(String[] args) {
//		int[] A = {1,5,2,1,4,0};
//		int[] A = {1,1,1};
		int[] A = {1,10,100,1};

		System.err.println(Arrays.toString(A));
		
		int totalNoOfPossibleIntersections = (A.length*(A.length-1))/2;
		
		System.err.println(totalNoOfPossibleIntersections);
		int doesNotIntersectCount = 0;
		
		for(int i=0; i<A.length; i++) { //A.length
			int minIndexValForNoIntersection = 2*A[i]+1 > A.length-1 ? A.length-1 : 2*A[i]+1;
			for(int j=i+1; j<A.length; j++) {
				if(A[j] > 0 && A[i] > 0 && A[minIndexValForNoIntersection] > 0) {
					if(A[minIndexValForNoIntersection] <= A[j] && !(A[minIndexValForNoIntersection] < A[j])) {
						System.err.println("A[" + minIndexValForNoIntersection + "]: " + A[minIndexValForNoIntersection] + " <= " + A[j]);
						doesNotIntersectCount++;
					}
				}
			}
			
			if(A[i] == 0) {
				int maxValue = 0;
				for(int k=0; k<A.length; k++) {
					maxValue = k+A[k];
					if(maxValue < i) {
						doesNotIntersectCount++;
					}
				}
			}
		}
		
		for(int k=0; k<A.length-1; k++) {
			if(A[k] == 0 && A[k+1] == 0) {
				doesNotIntersectCount++;
			}
		}
		
		System.err.println("DOES NOT INTERSECT COUNT: " + doesNotIntersectCount);
		int intersectionResults = 0;
		
		if(totalNoOfPossibleIntersections != doesNotIntersectCount) {
			intersectionResults = totalNoOfPossibleIntersections - doesNotIntersectCount;
		} else {
			intersectionResults = totalNoOfPossibleIntersections;
		}
		
		System.err.println(intersectionResults);
	}
}
