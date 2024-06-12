package com.java.fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 50;
		int results = fibonacci(n);
		System.err.println("FIBONACCI LAST TERM:" + results);
		results = 0;
		for(int i=0; i<n; i++) {
			results+=fibonacci(i);
		}
		System.err.println("SUMMED: " + results);
	}

//	private static int fibonacci(int number) {
//		int result = 0;
//		int prevResult = 1;
//		int summedResults = 0;
//		for(int i=0; i<number-1; i++) {
//			result += prevResult;
//			prevResult = result-prevResult;
//			summedResults+=result;
//			System.err.println("RESULTS: " + result);
//		}
//		return summedResults;
//	}
	
	private static int fibonacci(int n) {
		if (n<1) {
			return 0;
		}
		if (n<2) {
			return 1;
		}

//		int result = 0;
//		result = fibonacci(n-1) + fibonacci(n-2);
//		System.err.println(result);
//		summedResult += result;
//		return result;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
