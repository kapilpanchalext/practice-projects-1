package com.java.prefix;

import java.util.Arrays;

public class PrefixSums1 {
	public static void main(String[] args) {
		String str = "hello";
        int[] prefixSum = new int[str.length()];

        // Initialize prefix sum array
        prefixSum[0] = str.charAt(0) == 'l' ? 1 : 0;
        for (int i = 1; i < str.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (str.charAt(i) == 'l' ? 1 : 0);
        }
        
        System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSum));

        // Check if 'e' exists in the string
        boolean exists = false;
        for (int i = 0; i < str.length(); i++) {
            if (prefixSum[i] > 0) {
                exists = true;
                break;
            }
        }

        System.out.println("Does 'e' exist in the string? " + exists);
	}
}
