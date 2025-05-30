package com.java.primality;

public class PrimalityTest1 {

	public static void main(String[] args) {
		System.out.println("Primality Test 1:");
		
		int n = 4;
		
		boolean result = checkNumberPrimality(n);
		
		System.out.println(result);
	}

	private static boolean checkNumberPrimality(int n) {
		int i = 2;
		
		while(i * i <= n) {
			if(n % i == 0) {
				return false;
			}
			i++;
		}
		
		return true;
	}

}
