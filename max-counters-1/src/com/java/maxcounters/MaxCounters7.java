package com.java.maxcounters;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ParallelLoop extends RecursiveAction {
	private static final int THRESHOLD = 10;
	private Integer N;
	private Integer[] inputArray;
	private Integer[] resultsArray;
    private Integer start;
    private Integer end;
    	
	public ParallelLoop(Integer n, Integer[] inputArray, Integer[] resultsArray, Integer start, Integer end) {
		N = n;
		this.inputArray = inputArray;
		this.resultsArray = resultsArray;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) {
			Integer maxValue = 0;
			for(int i=0; i<inputArray.length; i++) {
				if(inputArray[i] <= N) {
					Integer index = inputArray[i]-1;
					resultsArray[index] += 1;
					if (resultsArray[index]>maxValue) {
						maxValue = resultsArray[index];
					}
				} else {
					Arrays.fill(resultsArray, maxValue);
				}
			}
		} else {
            System.err.println("INSIDE ELSE");
            Integer mid = (start + end) / 2;
            invokeAll(new ParallelLoop(N, inputArray, resultsArray, start, mid), new ParallelLoop(N, inputArray, resultsArray, mid, end));
		}
	}
}


public class MaxCounters7 {
	public static void main(String[] args) {
		Integer N = 5;
		Integer[] inputArray = {3,4,4,6,1,4,4};
		Integer[] resultsArray = new Integer[N];
		Arrays.fill(resultsArray, 0);
		
//		List<Integer> inputArrayList = Arrays.asList(inputArray);
//		List<Integer> resultsArrayList = new ArrayList<>();
//		resultsArrayList = Collections.nCopies(N, 0);
//
//		Integer N = 1;
//		Integer[] inputArray = {1};
//		Integer[] resultsArray = new Integer[N];
//		
//		Integer N = 1;
//		Integer[] inputArray = {1,2,1,1,2,1};
//		Integer[] resultsArray = new Integer[N];
//		
//		Integer maxValue = 0;
//		
//		for(int i=0; i<inputArray.length; i++) {
//			if(inputArray[i] <= N) {
//				Integer index = inputArray[i]-1;
//				resultsArray[index] += 1;
//				if (resultsArray[index]>maxValue) {
//					maxValue = resultsArray[index];
//				}
//			} else {
//				Arrays.fill(resultsArray, maxValue);
//			}
//		}
		ForkJoinPool pool = new ForkJoinPool();
	    pool.invoke(new ParallelLoop(N, inputArray, resultsArray, 0, inputArray.length));
		
		System.err.println("RESULTS: " + Arrays.toString(resultsArray));
	}
}
