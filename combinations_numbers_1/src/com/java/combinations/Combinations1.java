package com.java.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations1 {
	/** Time Complexity O(n^2) **/
	public static void main(String[] args) {
		List<List<Integer>> resultList = generateIndices(5, 0);
		System.err.println("RESULTS NEW: " + resultList);
	}

	private static List<List<Integer>> generateIndices(int size, int counter) {
	    List<List<Integer>> resultList = new ArrayList<>();
	    
	    // Base case
	    if (size == 0) {
	        return resultList;
	    }
	    
	    // Recursive case
	    resultList.add(Collections.nCopies(size, counter));
	    resultList.addAll(generateIndices(size - 1, counter + 1));
	    
	    return resultList;
	}
	
//	private static List<List<Integer>> generateIndices(int size, int counter) {
//	    List<List<Integer>> resultList = new ArrayList<>();
//	    
//	    // Base case
//	    if (size == 0) {
//	        return resultList;
//	    }
//	    
//	    // Recursive case
//	    List<Integer> newList = new ArrayList<>();
//	    newList.add(counter);
//	    resultList.add(newList);
//	    resultList.addAll(generateIndices(size - 1, counter + 1));
//	    
//	    return resultList;
//	}
}
