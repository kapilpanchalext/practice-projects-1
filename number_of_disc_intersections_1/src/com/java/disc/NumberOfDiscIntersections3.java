package com.java.disc;

import java.util.Arrays;

public class NumberOfDiscIntersections3 {
	public static void main(String[] args) {
		int[] A = {1,5,2,1,4,0};
//		int[] A = {1,5,1,1,4,0};
//		int[] A = {0,0,0,0,0,0};
//		int[] A = {1,1,1};
//		int[] A = {1,10,100,1};
//		int[] A = {1, 2147483647, 0};
		
		int totalNoOfPossibleIntersections = (A.length*(A.length-1))/2;
		long[] lowerValues = new long[A.length];
		long[] higherValues = new long[A.length];
		
		for(int i=0; i<A.length; i++) {
			lowerValues[i] = (long)i-A[i];
			higherValues[i] = (long)i+A[i];
		}
		
		int doesNotIntersectCount = 0;
		int intersectionResults = 0;
		for(int i=0; i<A.length-1; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(higherValues[i]<lowerValues[j]) {
					doesNotIntersectCount++;
				}
			}
		}
		if(totalNoOfPossibleIntersections > doesNotIntersectCount) {
			intersectionResults = totalNoOfPossibleIntersections - doesNotIntersectCount;
		} else if(totalNoOfPossibleIntersections < doesNotIntersectCount) {
			intersectionResults = 0;
		} else {
			intersectionResults = totalNoOfPossibleIntersections;
		}
		
		if(intersectionResults > 10000000) {
			intersectionResults = -1;
		}
		System.err.println(intersectionResults);
	}
}
