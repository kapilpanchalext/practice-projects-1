package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class DuvalsAlgorithm4 {
	public static void main(String[] args) {
		String inputString = "abcd";
		List<String> duvalOutput = duval(inputString);
		System.err.println(duvalOutput);
	}

	private static List<String> duval(String inputString) {
		int n = inputString.length();
	    int i = 0;
	    List<String> factorization = new ArrayList<>();
	    
	    while (i < n) {
	        int j = i + 1, k = i;
	        while ((j < n) && ((int)inputString.charAt(k) <= (int)inputString.charAt(j))) {
	            if ((int)inputString.charAt(k) < (int)inputString.charAt(j)) {
	                k = i;
	            } else {
	                k++;
	            }
	            j++;
	        }
	        while (i <= k) {
	            factorization.add(inputString.substring(i, j));
	            i += j - k;
	        }
	    }
	    return factorization;
	}
}
