package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class DuvalsAlgorithm1 {
	public static void main(String[] args) {
		 String s = "abacabacaba";
	        List<String> factorization = duval(s);
	        System.out.println("Lyndon factorization of " + s + ":");
	        for (String factor : factorization) {
	            System.out.println(factor);
	        }

	}

	private static List<String> duval(String s) {
	 int n = s.length();
        int i = 0;
        List<String> factorization = new ArrayList<>();
        while (i < n) {
            int j = i + 1, k = i;
            while (j < n && s.charAt(k) <= s.charAt(j)) {
                if (s.charAt(k) < s.charAt(j))
                    k = i;
                else
                    k++;
                j++;
            }
            while (i <= k) {
                factorization.add(s.substring(i, j - k + i));
                i += j - k;
            }
        }
        return factorization;
	}
}
