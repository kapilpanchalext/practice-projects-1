package com.java.prefix;

import java.util.ArrayList;
import java.util.List;

public class PrefixSums2 {
	public static void main(String[] args) {
		String gene = "ATCGATCGATCGATCGATCGATCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGCGATCCCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGATCGAT";

		String searchSequence1 = "CGA";
		String searchSequence2 = "TCG";
		
		int scores1 = 10;
		int scores2 = 11;

		List<List<Integer>> prefixSums = new ArrayList<>();
		
		for(int i=0; i<2; i++) {
			prefixSums.add(null);
		}

		int counter1 = scores1;
		int counter2 = scores2;
		List<Integer> newList1 = new ArrayList<>();
		List<Integer> newList2 = new ArrayList<>();
		
		for(int i=0; i<gene.length(); i++) {
			if(gene.startsWith(searchSequence1, i)) {
				counter1 += scores1;
				newList1.add(counter1);
			} else {
				newList1.add(counter1);
				
			}
			
			if(gene.startsWith(searchSequence2, i)) {
				counter2 += scores2; 
				newList2.add(counter2);
			} else {
				newList2.add(counter2);
			}
		}

		prefixSums.set(0, newList1);
		prefixSums.set(1, newList2);
		System.err.println("PREFIX SUMS: " + prefixSums);
		
		System.err.println("SCORE FOR CGA: 50-60:  " + (prefixSums.get(0).get(60) - prefixSums.get(0).get(0)));
	}
}
