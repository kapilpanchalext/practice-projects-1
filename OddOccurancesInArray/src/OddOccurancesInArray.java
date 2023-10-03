import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OddOccurancesInArray {

//	public static void main(String[] args) {
//
//		Integer[] A = {9,3,9,3,9,7,9};
//		List<Integer> oddList = Arrays.asList(A);
//		Set<Integer> uniqueElementSet = oddList.stream().collect(Collectors.toSet());
//		
//		AtomicInteger counter = new AtomicInteger();
//		AtomicInteger value = new AtomicInteger();
//
//		uniqueElementSet.stream().map(element -> {
//			for(int i=0;i<oddList.size();i++) {
//				if(element == oddList.get(i)) {
//					counter.getAndIncrement();
//				}
//			}
//			if(counter.get()%2 != 0) {
//				value.set(element);
//			}
//			counter.set(0);
//			return element;
//		}).collect(Collectors.toList());
//		
//		System.err.println(value.get());
//	}
	
//	// you can also use imports, for example:
//	// import java.util.*;
//	import java.util.Arrays;
//	import java.util.List;
//	import java.util.Set;
//	import java.util.concurrent.atomic.AtomicInteger;
//	import java.util.stream.Collectors;
//	// you can write to stdout for debugging purposes, e.g.
//	// System.out.println("this is a debug message");
//

	public static void main(String[] args) {
	        // Integer[] A = {9,3,9,3,9,7,9};
		
		long startEmpty =  System.nanoTime();
//		int iVal = 0;
//		long ival1 = 0;
//		String someString = "This is some string that needs to be evaluated";
		long endEmpty = System.nanoTime();
		System.err.println("TIME TO EXECUTE (microseconds): " + (endEmpty-startEmpty)/1000.0);

		
		long start =  System.nanoTime();
//		System.err.println("Start Time: " + start);
		
		int[] A = {9,3,9,3,9,7,9};
		
        Integer[] integerArray = Arrays.stream(A)
                .boxed()
                .toArray(Integer[]::new);
        
		List<Integer> oddList = Arrays. asList(integerArray);
		Set<Integer> uniqueElementSet = oddList.stream().collect(Collectors.toSet());
		
		AtomicInteger counter = new AtomicInteger();
		AtomicInteger value = new AtomicInteger();

		uniqueElementSet.stream().map(element -> {
			for(int i=0; i<oddList.size(); i++) {
				if(element == oddList.get(i)) {
					counter.getAndIncrement();
				}
			}
			if(counter.get()%2 != 0) {
				value.set(element);
			}
			counter.set(0);
			return element;
		}).collect(Collectors.toList());
		
		System.err.println(value);
		long end = System.nanoTime();
//		System.err.println("End Time: " + end);
		System.err.println("TIME TO EXECUTE (ms): " + (end-start)/1000000.0);
		
		
		long start1 =  System.nanoTime();
		
		Integer[] integerArray1 = Arrays.stream(A)
	            .boxed()
	            .toArray(Integer[]::new);
	    
		List<Integer> oddList1 = Arrays. asList(integerArray1);
		Set<Integer> uniqueElementSet1 = oddList.stream().collect(Collectors.toSet());
		AtomicInteger value1 = new AtomicInteger();
	
		uniqueElementSet1.stream().map(element -> {
		Map<Integer, Long> countMap = oddList1.stream()
	               .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
	
//	    System.err.println("Count Map: " + countMap);
        
        for(Map.Entry<Integer, Long> entry: countMap.entrySet()) {
    		if(entry.getValue()%2 != 0) {
    			value1.set(entry.getKey());
    		}
        }
        
		return element;
	}).collect(Collectors.toList());
	
	System.err.println(value);
		
		long end1 = System.nanoTime();
		System.err.println("TIME TO EXECUTE1 (ms): " + (end1-start1)/1000000.0);
		
		
		long start2 =  System.nanoTime();
//		System.err.println("Start Time1: " + start1);
		int value2 = 0;
		
	    Integer[] integerArray2 = Arrays.stream(A)
	            .boxed()
	            .toArray(Integer[]::new);
	    
	    Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer number : integerArray2) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

//        System.err.println("Count Map: " + countMap);
      for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
  		if(entry.getValue()%2 != 0) {
  			value2 = entry.getKey();
  		}
      }
      System.err.println(value2);		
		
		long end2 = System.nanoTime();
//		System.err.println("End Time1: " + end1);
		System.err.println("TIME TO EXECUTE2 (ms): " + (end2-start2)/1000000.0);
//	        return value.get();
		}
	
//	public static void main(String[] args) {
//        // Integer[] A = {9,3,9,3,9,7,9};
//	
//	int[] A = {9,3,9,3,9,7,9};
//	
//    Integer[] integerArray = Arrays.stream(A)
//            .boxed()
//            .toArray(Integer[]::new);
//    
//	List<Integer> oddList = Arrays. asList(integerArray);
//	Set<Integer> uniqueElementSet = oddList.stream().collect(Collectors.toSet());
//	
//	AtomicInteger counter = new AtomicInteger();
//	AtomicInteger value = new AtomicInteger();
//
//	uniqueElementSet.stream().map(element -> {
//		
//		int frequencyValue = Collections.frequency(oddList, element);
//		if(frequencyValue%2 != 0) {
//			value.set(element);
//		}
//		return element;
//	}).collect(Collectors.toList());
//	
//	System.err.println(value);
////        return value.get();
//	}
//	
//	public static void main(String[] args) {
//        // Integer[] A = {9,3,9,3,9,7,9};
//	
//		int[] A = {9,3,9,3,9,7,9};
//		
//	    Integer[] integerArray = Arrays.stream(A)
//	            .boxed()
//	            .toArray(Integer[]::new);
//	    
//		List<Integer> oddList = Arrays. asList(integerArray);
//		Set<Integer> uniqueElementSet = oddList.stream().collect(Collectors.toSet());
//		AtomicInteger value = new AtomicInteger();
//	
//		uniqueElementSet.stream().map(element -> {
//		Map<Integer, Long> countMap = oddList.stream()
//	               .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//	
//	    System.err.println("Count Map: " + countMap);
//        
//        for(Map.Entry<Integer, Long> entry: countMap.entrySet()) {
//    		if(entry.getValue()%2 != 0) {
//    			value.set(entry.getKey());
//    		}
//        }
//        
//		return element;
//	}).collect(Collectors.toList());
//	
//	System.err.println(value);
////        return value.get();
//	}
	
//	public static void main(String[] args) {
//      // Integer[] A = {9,3,9,3,9,7,9};
//	
//		int[] A = {9,3,9,3,9,7,9};
//		int value = 0;
//		
//	    Integer[] integerArray = Arrays.stream(A)
//	            .boxed()
//	            .toArray(Integer[]::new);
//	    
//	    Map<Integer, Integer> countMap = new HashMap<>();
//        for (Integer number : integerArray) {
//            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
//        }
//
//        System.err.println("Count Map: " + countMap);
//      for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
//  		if(entry.getValue()%2 != 0) {
//  			value = entry.getKey();
//  		}
//      }
//	System.err.println(value);
////      return value.get();
//	}
}