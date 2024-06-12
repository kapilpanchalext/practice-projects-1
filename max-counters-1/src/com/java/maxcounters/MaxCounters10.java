package com.java.maxcounters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxCounters10 {
	public static void main(String[] args) {
//		writeToFile();
//		Integer N = 5;
//		Integer[] inputArray = new Integer[6];
//		Integer[] resultsArray = new Integer[N];
//		Arrays.fill(resultsArray, 0);
//
//		try {
//            File file = new File("dataFile.txt");
//            Scanner scanner = new Scanner(file);
//            Integer counter = 0;
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                inputArray[counter] = Integer.parseInt(line);
//                counter++;
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found: " + e.getMessage());
//        }
//
//		System.err.println(Arrays.toString(inputArray));
//		final Integer N = 5;
//		Integer[] inputArray = {3,4,4,6,1,4,4};
//		Integer[] resultsArray = new Integer[N];
//		
//		List<Integer> inputArrayList = Arrays.asList(inputArray);
//		List<Integer> resultsArrayList = new ArrayList<>();
//		resultsArrayList = Collections.nCopies(N, 0);
//
//		Integer N = 1;
//		Integer[] inputArray = {1};
//		Integer[] resultsArray = new Integer[N];
//		
		Integer N = 1;
		Integer[] inputArray = {1,2,1,1,2,1};
		Integer[] resultsArray = new Integer[N];
		
//		Integer maxValue = 0;
		Arrays.fill(resultsArray, 0);
		AtomicInteger maxVal = new AtomicInteger(0);
		
		for(int i=0; i<inputArray.length; i++) {
			if(inputArray[i] <= N) {
				Integer index = inputArray[i]-1;
				resultsArray[index] += 1;
				if (resultsArray[index]>maxVal.get()) {
					maxVal.set(resultsArray[index]);
				}
			} else {
				Arrays.fill(resultsArray, maxVal.get());
//				for(int j=0;j<resultsArray.length;j++) {
//					if(resultsArray[j] < maxVal.get()) {
//						System.err.println("Val");
//						resultsArray[j] = maxVal.get();
//					}
//				}
				
//				if(resultsArray.length > 1) {
////					resultsArray = Arrays.stream(resultsArray).filter(element -> element < N)
////							.parallel()
////							.map((element) -> {
////								element = maxVal.get();
////								return element;})
////							.toArray(Integer[]::new);
//					
//					resultsArray = Arrays.stream(resultsArray)
//						    .parallel()
//						    .map(element -> maxVal.get())
//						    .toArray(Integer[]::new);
//					
//				}
			}
		
//		for(int i=0; i<inputArray.length; i++) {
//			if(inputArray[i] <= N) {
//				Integer index = inputArray[i]-1;
//				resultsArray[index] += 1;
//				if (resultsArray[index]>maxVal.get()) {
//					maxVal.set(resultsArray[index]);
//					System.err.println("MAXVAL: " + maxVal.get());
//				}
//			} else {
//				Arrays.fill(resultsArray, maxValue);
//				for(int j=0;j<resultsArray.length;j++) {
//					if(resultsArray[j] < maxValue) {
//						resultsArray[j] = maxValue;
//					}
//				}
//				Arrays.fill(resultsArray, maxVal.get());
//				for(int j=0;j<resultsArray.length;j++) {
//					if(resultsArray[j] < maxVal.get()) {
//						resultsArray[j] = maxVal.get();
//					}
//				}
//
//				resultsArray = Arrays.stream(resultsArray).filter(element -> element < N)
//						.parallel()
//						.map((element) -> {
//							element = maxVal.get();
//							return element;})
//						.toArray(Integer[]::new);
//			}
		}
		System.err.println("RESULTS: " + Arrays.toString(resultsArray));
	}
	
	/*
	import java.util.Arrays;
	import java.util.concurrent.atomic.AtomicInteger;
	
	class Solution {
	    public int[] solution(int N, int[] A) {
	        int[] resultsArray = new int[N];
	        AtomicInteger maxVal = new AtomicInteger(0);
		    Arrays.fill(resultsArray,0);
	        for(int i=0; i<A.length; i++) {
	            if(A[i] <= N) {
					Integer index = A[i]-1;
					resultsArray[index] += 1;
					if (resultsArray[index]>maxVal.get()) {
						maxVal.set(resultsArray[index]);
					}
	            } else {
	                Arrays.fill(resultsArray, maxVal.get());
	                //     for(int j=0;j<resultsArray.length;j++) {
	                //     if(resultsArray[j] < maxVal.get()) {
	                //         System.err.println("Val");
	                //         resultsArray[j] = maxVal.get();
	                //     }
	                // }
	            }
	        }
		    return resultsArray;
	    }
	}
	*/

	private static void writeToFile() {
        String filePath = "dataFile.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i=0; i<6; i++) {
                int randomNumber = random.nextInt(6) + 1;
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
            System.out.println("Random integers saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
	}
}
