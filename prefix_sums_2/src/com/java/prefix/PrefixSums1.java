package com.java.prefix;

import java.util.ArrayList;
import java.util.List;

public class PrefixSums1 {
	public static void main(String[] args) {

		String gene = "ATCGATCGATCGATCGATCGATCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGAT";

		String searchSequence = "CGATCCCG";

		List<Integer> prefixSums = new ArrayList<>();

		int counter = 0;

		for(int i=0; i<gene.length(); i++) {
			if(gene.startsWith(searchSequence, i)) {
				counter++;
				prefixSums.add(counter);
			} else {
				prefixSums.add(counter);
			}
		}
//		System.err.println("PREFIX SUMS: " + prefixSums);
//		boolean results = gene.contains(searchSequence);
//		System.err.println("RESULTS: " + results);
		
		System.err.println("NUMBER OF TIMES THE SEARCH STRING OCCURS IN THE GENE STRING: " + (prefixSums.get(prefixSums.size()-1) - prefixSums.get(0)));
		
	}
}
