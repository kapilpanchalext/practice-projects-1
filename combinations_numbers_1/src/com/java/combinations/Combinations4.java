package com.java.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations4 {
	public static void main(String[] args) {
		List<Integer> resultList = new ArrayList<>();
		int n = 5;
		int counter = 0;
		int varCounter = 5;
		for(int i=0; i<10; i++) {
			resultList.add(counter);
			if(i>(i+varCounter)) {
				counter++;
			}
			varCounter--;
		}
		System.err.println(resultList);
	}
}
