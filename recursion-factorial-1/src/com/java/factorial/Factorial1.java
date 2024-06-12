package com.java.factorial;

public class Factorial1 {
	public static void main(String[] args) {
		
		int n = 5;
		int factorial = factorial(n);
		System.err.println("FACTORIAL: " + factorial);

	}

	private static int factorial(int n) {
		//Terminating condition
		if(n<2) {
			return 1;
		}
		
//		int result = n * factorial(n-1);
		
		return n * factorial(n-1);
	}
}
