package com.java.perm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermMissingElement {
	public static void main(String[] args) {
//		List<Integer> permMissingElement = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
//		List<Integer> permMissingElement = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);
		List<Integer> permMissingElement = Arrays.asList(2, 3, 1, 5);
//		List<Integer> permMissingElement = Arrays.asList(1);
//		List<Integer> permMissingElement = Arrays.asList(1,2,3,4,5);
//		List<Integer> permMissingElement = Arrays.asList(5);
		
		if(permMissingElement.size()<=0) {
//			return 1;
		} else if(permMissingElement.size() == 1 && permMissingElement.get(0) == 1) {
			System.err.println("ELEMENT 1: " + 2);
//			return 2;
			System.exit(0);
		} else if(permMissingElement.size() == 1) {
			System.err.println("ELEMENT: " + (permMissingElement.get(0) - 1));
//			return permMissingElement.get(0) - 1;
		} else {		
			Integer sumOfPermMissingElement = permMissingElement.stream().mapToInt(Integer::intValue).sum();
			Integer maxValueOfPermMissingElement = permMissingElement.stream().mapToInt(Integer::intValue).max().getAsInt();
			System.err.println("MAX VALUE: " + maxValueOfPermMissingElement);
			List<Integer> permMissingElementSuperList = IntStream.range(1, maxValueOfPermMissingElement + 1).boxed().collect(Collectors.toList());
			System.err.println("SUPER LIST: " + permMissingElementSuperList);
			Integer sumOfSuperList = permMissingElementSuperList.stream().mapToInt(Integer::intValue).sum();
			System.err.println("permMissingElement SUM: " +  sumOfPermMissingElement);
			System.err.println("superList SUM: " + sumOfSuperList);
			
			Integer missingElement = sumOfSuperList - sumOfPermMissingElement;
			
			if(missingElement == 0) {
	//			return maxValueOfPermMissingElement+1;
			}
			
			System.err.println("MISSING ELEMENT: " + missingElement);
		}
	}
}
