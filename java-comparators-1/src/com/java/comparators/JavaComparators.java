package com.java.comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaComparators {
	public static void main(String[] args) {
		
//		List<Integer> listA = Arrays.asList(1,2,3,4,5,6,7,6,5,4,3,2,1,0);
		List<Integer> listA = new ArrayList<>();
//		List<Integer> listB = Arrays.asList(0,106,107,101,105,102,102,103,104,106,105,103,101,104);
		List<Integer> listB = Arrays.asList(100,152,139,142,250,800,9000,1,142,120,131,75,45,79);
		
		Random random = new Random();

        for (int i = 0; i <14; i++) {
        	listA.add(random.nextInt(100)); // Adjust the bound as needed
        }
		
		
		System.err.println("LIST A: "+ listA);
		System.err.println("LIST B: " + listB);
//		System.out.println("Original listB: " + listB);
//		listB.sort(Comparator.comparingInt(listA::indexOf));
//        
//      System.out.println("Sorted listB based on template listA: " + listB);
        // Create a set of elements present in listB for faster lookup

        // Sort listA based on the index in listB or use a default index if not present
//        listB.sort(Comparator.comparingInt(a -> {
//            int index = listA.indexOf(a);
//            System.err.println("INDEX: " + index);
//            if (index == -1) {
//                // If the element is not in listB, check for nearby values
//                int indexPlusOne = listA.indexOf(a + 100);
//                int indexMinusOne = listA.indexOf(a - 100);
//
//                if (indexPlusOne != -1) {
//                    return indexPlusOne;
//                } else if (indexMinusOne != -1) {
//                    return indexMinusOne;
//                } else {
//                    // Use a default index if not present in listB or nearby
//                    return Integer.MAX_VALUE;
//                }
//            }
//            return index;
//        }));
//
//        System.err.println("Rearranged listB: " + listB);
		
	        // ensure, that sizes are equal
	        assert (listA.size() == listB.size());

	        // sort for better mapping
	        List<Integer> listAValues = listA.stream().sorted().collect(Collectors.toList());
	        List<Integer> listBValues = listB.stream().sorted().collect(Collectors.toList());
	        
	        System.err.println("SORTED LIST A: " + listAValues);
	        System.err.println("SORTED LIST B: " + listBValues);

	        // map to ensure, that template completes
	        Map<Integer, Integer> template = new HashMap<>();
	        Set<Integer> processedB = new HashSet<>();
	        for (int i = 0; i < listAValues.size(); i++) {
	            Integer key = listAValues.get(i);
	            Integer value = listBValues.get(i);
	            if (template.containsKey(key)) {
//	            	System.err.println("INSIDE IF");
	                assert(template.get(key).equals(value));
	            } else {
//	            	System.err.println("INSIDE ELSE");
	                assert(!processedB.contains(value));
	                template.put(key, value);
	                processedB.add(value);
	            }
	        }
	        System.err.println("TEMPLATE: " + template);
	        System.err.println("PROCESSED B: " + processedB);

	        // rearrange
	        List<Integer> rearrangedListB = listA
	                .stream()
	                .map(template::get)
//	                .peek(s-> System.err.println(s))
	                .collect(Collectors.toList());
	        System.err.println("Rearranged listB: " + rearrangedListB);

		
	}
}
