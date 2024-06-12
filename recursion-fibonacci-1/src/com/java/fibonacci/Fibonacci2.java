package com.java.fibonacci;

public class Fibonacci2 {

	public static void main(String[] args) {
		int n = 10;
		int results = fibonacci(n);
		System.err.println("FIBONACCI LAST TERM:" + results);
		results = 0;
		for(int i=0; i<n; i++) {
			results+=fibonacci(i);
		}
		System.err.println("SUMMED: " + results);
	}
	
	private static int fibonacci(int n) {
		if (n<1) {
			return 0;
		}
		if (n<2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
