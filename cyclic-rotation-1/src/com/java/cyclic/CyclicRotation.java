package com.java.cyclic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CyclicRotation {
	public static void main(String[] args) {
		Integer K = 11;
	
//		List<Integer> cyclicRotation = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
//		List<Integer> cyclicRotation = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);
		List<Integer> cyclicRotation = Arrays.asList(3, 8, 9, 7, 6);
//		List<Integer> cyclicRotation = Arrays.asList();
		List<Integer> cyclicRotatedIndices = IntStream.range(0, cyclicRotation.size()).boxed().collect(Collectors.toList());
		Integer[] resultArray = new Integer[cyclicRotation.size()];
		
		if(K >= cyclicRotation.size() && cyclicRotation.size()>0) {
			K = K%cyclicRotation.size();
		}
		
		if(cyclicRotation.size() <= 0) {
			for(int k=0; k<cyclicRotation.size(); k++) {
			    resultArray[k] = cyclicRotation.get(cyclicRotatedIndices.get(k));
		    }
//            return resultArray;
		}
		
		if(cyclicRotation.size() == 1) {
			resultArray[0] = cyclicRotation.get(0);
		}
		
		System.err.println("CYCLIC ROTATION: " + cyclicRotation);
		System.err.println("CYCLIC ROTATED INDICES: " + cyclicRotatedIndices);
		
		Integer rotationCounter = 0;
		
		for(int i=K; i<cyclicRotation.size();i++) {
			cyclicRotatedIndices.set(i, rotationCounter++);
			
		}
		for(int j=0;j<K;j++) {
			cyclicRotatedIndices.set(j, rotationCounter++);
		}
		System.err.println("ROTATION COUNTER: " + rotationCounter);
		System.err.println("CYCLIC ROTATED INDICES: " + cyclicRotatedIndices);
		
		for(int k=0; k<cyclicRotation.size(); k++) {
			resultArray[k] = cyclicRotation.get(cyclicRotatedIndices.get(k));
		}
		
		for(int l=0; l<resultArray.length; l++) {
			System.err.println("RESULT ARRAY: " + resultArray[l]);
		}
	}
}
