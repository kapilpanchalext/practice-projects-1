package com.java.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations2 {
	public static void main(String[] args) {
		List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> initialList = new ArrayList<>(Collections.nCopies(5, 0));
        resultList.add(initialList);

        System.out.println("RESULTS NEW: " + resultList);

        for (int i = 1; i <= 5; i++) {
            List<Integer> newList = new ArrayList<>(resultList.get(0));
            resultList.add(newList.subList(0, i));
        }
        
        resultList.remove(0);

        System.out.println("RESULTS SET: " + resultList);
	}
}
