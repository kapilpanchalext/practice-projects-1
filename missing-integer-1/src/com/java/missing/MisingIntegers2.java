package com.java.missing;

import java.util.Arrays;

public class MisingIntegers2 {
	public static void main(String[] args) {
//		int[] A = {1, 3, 6, 4, 1, 2};
		int[] A = {1, 2, 3, 4};
//		int[] A = {-1, -3};
//		int[] A = {-1, -3, -2};
//		
//		int[] A = new int[99];
//		int factor = 1;
//		for (int i = 1; i < 101; i++) {
//		    if(i == 45) {
//		    	factor = 2;
//		    	continue;
//		    }
//		    A[i-factor] = i;
//		}
		
//		int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
//		int[] A = {1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 34, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 12, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
//		int[] A = {-2, -1, 1, 2, 5, 4, 6, 7, 8};
//		int[] A = {5, 4, 6, 2};
//		int[] A = {-1000000, 1000000};
		
		System.err.println(Arrays.toString(A));
		int[] distinct = Arrays.stream(A).filter(a -> a > 0).distinct().sorted().toArray();
		System.err.println(Arrays.toString(distinct));
		
//		int prevElement = 0;
//		int result = Integer.MIN_VALUE;
//		
//		System.err.println(Arrays.toString(distinct));
//		
//		for(Integer element : distinct) {
//			if((element - prevElement) != 1) {
//				result = (element + prevElement)/2;
//			}
//			prevElement = element;
//		}
//		System.err.println("RESULT1: " + result);
//		if(result == 0) {
//			result = distinct[distinct.length-1] + 1;
//		} else if(distinct[0] != 1 && distinct[0] != 0) {
//			result = 1;
//		}
//		
//		if(result == Integer.MIN_VALUE) {
//			result = distinct[distinct.length-1];
//		}
//		
//		if(distinct[distinct.length-1] == -1) {
//			result = 1;
//		}
//		
//		if(result < -1000000 || result > 1000000) {
//			result = 1;
//		}
//				
//		System.err.println("RESULT2: " + result);
		
		int smallestPositive = 1;

        for (int i = 0; i < distinct.length; i++) {
            if (distinct[i] == smallestPositive) {
                smallestPositive++;
            } else {
                System.err.println(smallestPositive);
            }
        }

        System.err.println(smallestPositive);
    }
}
