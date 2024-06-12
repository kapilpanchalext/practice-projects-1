package com.java.genomic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery3 {
	public static void main(String[] args) {
		String S = "CAGCCTA";
        Map<Character, Integer> lookUpTable = new HashMap<>();
        lookUpTable.put('A', 1);
        lookUpTable.put('C', 2);
        lookUpTable.put('G', 3);
        lookUpTable.put('T', 4);

        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] result = new int[P.length];

        Arrays.parallelSetAll(result, i -> {
            String subString = S.substring(P[i], Q[i] + 1);
            if (subString.contains("A")) {
                return lookUpTable.get('A');
            } else if (subString.contains("C")) {
                return lookUpTable.get('C');
            } else if (subString.contains("G")) {
                return lookUpTable.get('G');
            } else {
                return lookUpTable.get('T');
            }
        });

        System.err.println("RESULT: " + Arrays.toString(result));
	}
}
