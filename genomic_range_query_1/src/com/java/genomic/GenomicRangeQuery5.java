package com.java.genomic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenomicRangeQuery5 {
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
						
			Pattern pattern = Pattern.compile("[ACGT]");
			Matcher matcher = pattern.matcher(subString);
			while (matcher.find()) {
			    String matchedCharacter = matcher.group();
			    if (matchedCharacter.equalsIgnoreCase("A")) {
					result[i] = lookUpTable.get('A');
				} else if (matchedCharacter.equalsIgnoreCase("C")) {
					result[i] = lookUpTable.get('C');
				} else if (matchedCharacter.equalsIgnoreCase("G")) {
					result[i] = lookUpTable.get('G');
				} else {
					result[i] = lookUpTable.get('T');
				}
			}
		}
		
		System.err.println("SCORES: " + Arrays.toString(result));

	}
}
