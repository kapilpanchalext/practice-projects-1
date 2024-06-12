package com.java.lyndon;

public class DuvalsAlgorithm5 {
	public static void main(String[] args) {
		String w = "abcdabcdab";
        lyndonFactorization(w);
	}

	private static void lyndonFactorization(String w) {
		int k = 0;
        int n = w.length();

        while (k < n) {
            int i = k + 1;
            int j = k + 2;

            while (true) {
                if (j == n + 1 || w.charAt(j - 1) < w.charAt(i - 1)) {
                    while (k < i) {
                        System.out.println(w.substring(k, k + j - i));
                        k += j - i;
                    }
                    break;
                } else {
                    if (w.charAt(j - 1) > w.charAt(i - 1)) {
                        i = k + 1;
                    } else {
                        i++;
                    }
                    j++;
                }
            }
        }
	}
}
