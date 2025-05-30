package com.java.divisors;

public class CountingDivisors1 {

	public static void main(String[] args) {
		System.out.println("Counting Divisors 1");
		
		int n = 5;
		
		int result = getCountingDivisorsResult(n);
		
		System.err.println(result);

	}

	private static int getCountingDivisorsResult(int n) {
		int result = 0;
    int i = 1;

    while (i * i < n) {
        if (n % i == 0) {
            result += 2; // i and n/i
        }
        i++;
    }

    // If n is a perfect square, add 1 for the sqrt(n)
    if (i * i == n) {
        result += 1;
    }

    return result;
	}
}
