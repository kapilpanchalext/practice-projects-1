package com.java.genomic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenomicRangeQuery2 {
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

		Set<Character> characterSet = new HashSet<>();

		for(int i=0; i<P.length; i++) {
			for(int j=P[i]; j<=Q[i]; j++ ) {
				characterSet.add(S.charAt(j));
				if(characterSet.size()>=4) {
					break;
				}
			}
			System.err.println(characterSet);

			if (characterSet.contains('A')) {
				result[i] = lookUpTable.get('A');
			} else if (characterSet.contains('C')) {
				result[i] = lookUpTable.get('C');
			} else if (characterSet.contains('G')) {
				result[i] = lookUpTable.get('G');
			} else {
				result[i] = lookUpTable.get('T');
			}
			characterSet = new HashSet<>();
		}
		System.err.println(Arrays.toString(result));
	}
}
