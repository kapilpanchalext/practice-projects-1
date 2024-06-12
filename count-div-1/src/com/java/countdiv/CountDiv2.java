package com.java.countdiv;

public class CountDiv2 {
	public static void main(String[] args) {
//		int A = 6;
//		int B = 11;
//		int K = 2;
		
//		int A = 0;
//		int B = 0;
//		int K = 11; // return 1
		
//		int A = 1;
//		int B = 1;
//		int K = 11; // return 0
		
//		int A = 0;
//		int B = 14;
//		int K = 2; // return 8
		
//		int A = 10;
//		int B = 10;
//		int K = 7; // return 0
		
//		int A = 10;
//		int B = 10;
//		int K = 20; // return 0
		
		int A = 11;
		int B = 14;
		int K = 2; // return 0
		
		int result1 = B/K;
		int result2 = A/K;
		
		System.err.println((A%K));
		
		System.err.println("RESULT 1: " + result1);
		System.err.println("RESULT 2: " + result2);
		
		int finalResult = result1 - result2;
		
		if (A == 0 && B == 0) {
			finalResult++;
		}
		else if(A == B && ((A%K) == 0 || (B%K) == 0)) {
			System.err.println("INSIDE ELSE IF 1");
			finalResult++;			
		}
		else if (result1 == 0 && result2 == 0) {
			System.err.println("INSIDE ELSE IF2");
			finalResult = 0;
		}
		else if(A == B && A != K) {
			finalResult = 0;
		}
		else if(A%K != 0) {
			finalResult += 0;
		}
		else {
			System.err.println("ELSE");
			finalResult++;
		}
		
		System.err.println("FINAL RESULT: " + finalResult);
	}
}
