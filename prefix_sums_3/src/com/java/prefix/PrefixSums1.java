package com.java.prefix;

import java.util.ArrayList;
import java.util.List;

public class PrefixSums1 {
	public static void main(String[] args) {
		String gene = "ATCGATCGATCGATCGATCGATCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGAT";

		String searchSequence1 = "CGA";
		String searchSequence2 = "TCG";
		
		int scores1 = 10;
		int scores2 = 11;

		List<List<Integer>> prefixSums = new ArrayList<>();

		int counter = scores2;

		for(int i=0; i<gene.length(); i++) {
			List<Integer> newList = new ArrayList<>();
			if(gene.startsWith(searchSequence1, i)) {
//				counter++;
				counter += scores1; 
//				prefixSums.add().add(counter);
				newList.add(counter);
			} else {
//				prefixSums.add(counter);
				newList.add(counter);
			}
			
			if(gene.startsWith(searchSequence2, i)) {
//				counter++;
				counter += scores2; 
//				prefixSums.add().add(counter);
				newList.add(counter);
			} else {
//				prefixSums.add(counter);
				newList.add(counter);
			}
			prefixSums.add(newList);
		}

		System.err.println("PREFIX SUMS: " + prefixSums);
//		boolean results = gene.contains(searchSequence);
//		System.err.println("RESULTS: " + results);
		
//		System.err.println("NUMBER OF TIMES THE SEARCH STRING OCCURS IN THE GENE STRING: " + (prefixSums.get(0).get(60) - prefixSums.get(0).get(50)));
	}
}
