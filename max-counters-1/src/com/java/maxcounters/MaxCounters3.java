package com.java.maxcounters;

import java.util.Arrays;

public class MaxCounters3 {
	public static void main(String[] args) {
		Integer N = 5;
		Integer[] inputArray = {3,4,4,6,1,4,4};
		Integer[] resultsArray = new Integer[N];

//		Integer N = 1;
//		Integer[] inputArray = {1};
//		Integer[] resultsArray = new Integer[N];
		
//		Integer N = 1;
//		Integer[] inputArray = {1,2,1,1,2,1};
//		Integer[] resultsArray = new Integer[N];
		
//		for(int i=0; i<N; i++) {
//			resultsArray[i] = 0;
//		}
		
		Arrays.fill(resultsArray, 0);

		Integer maxValue = 0;
		
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] <= N) {
				Integer index = inputArray[i]-1;
//				System.err.println("INDEX: " + index);
				resultsArray[index] = resultsArray[index] + 1;
				if (resultsArray[index] + 1>maxValue) {
					maxValue = resultsArray[index];
				}
//				System.err.println("RESULTS ARRAY INDEX: " + resultsArray[index]);
			} else {
//				Integer prevValue = Integer.MIN_VALUE;
//
//				for (int k=0;k<resultsArray.length;k++) {
//					if(resultsArray[k]>prevValue) {
//						prevValue = resultsArray[k];
//					}
//				}

				System.err.println("MAX VALUE: " + maxValue);

//				for(int j=0; j<N; j++) {
//					resultsArray[j] = maxValue;
//				}
				
				Arrays.fill(resultsArray, maxValue);
				
			}
		}

		for(Integer element : resultsArray) {
			System.err.println("RESULTS: " + element);
		}
		
	}
}

//import java.util.Arrays;
//class Solution {
//    public int[] solution(int N, int[] A) {
//        int[] resultsArray = new int[N];
//
//        Arrays.fill(resultsArray,0);
//        Integer maxValue = 0;
//        for(int i=0; i<A.length; i++) {
//            if(A[i] <= N) {
//                Integer index = A[i]-1;
//                resultsArray[index] = resultsArray[index] + 1;
//                if (resultsArray[index] + 1>maxValue) {
//				    maxValue = resultsArray[index];
//                }
//            } else {
//                // for(int j=0; j<N; j++) {
//				// 	resultsArray[j] = maxValue;
//				// }
//                Arrays.fill(resultsArray, maxValue);
//            }
//        }
//
//       return resultsArray;
//    }
//}