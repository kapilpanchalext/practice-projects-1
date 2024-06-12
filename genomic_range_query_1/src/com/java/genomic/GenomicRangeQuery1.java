package com.java.genomic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery1 {
	public static void main(String[] args) {
		
		String S = "CAGCCTA";
		
		Map<Character, Integer> lookUpTable = new HashMap<>();
			lookUpTable.put('A', 1);
			lookUpTable.put('C', 2);
			lookUpTable.put('G', 3);
			lookUpTable.put('T', 4);
		
		System.err.println("SCORES LOOKUP TABLE: " + lookUpTable);
		
		int[] P = {2, 5, 0};
		int[] Q = {4, 5, 6};
		int[] result = new int[P.length];

		for(int i=0; i<P.length; i++) {
			String subString = S.substring(P[i], Q[i]+1);

			if (subString.contains("A")) {
				result[i] = lookUpTable.get('A');
			} else if (subString.contains("C")) {
				result[i] = lookUpTable.get('C');
			} else if (subString.contains("G")) {
				result[i] = lookUpTable.get('G');
			} else {
				result[i] = lookUpTable.get('T');
			}
		}
		
		System.err.println("SCORES: " + Arrays.toString(result));
	}
}
