package com.java.merge;

import java.util.Arrays;
import java.util.List;

public class MergeSortIterative1 {
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(14, 7, 3, 12, 9, 11, 6, 2);
		System.err.println(A);
		
		int counter = A.size();
		int previousCounter = 0;
		
		while(counter > 0) {
			counter = counter/2;
			mergeSort(A.subList(0, counter), A.subList(counter, (counter+counter)));
			previousCounter = counter;
		}
	}

	private static void mergeSort(List<Integer> a1, List<Integer> a2) {
		System.err.println("A1: " + a1);
		System.err.println("A2: " + a2);
	}
}
