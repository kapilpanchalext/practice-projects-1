package com.java.brackets;

import java.util.Arrays;

public class Brackets2 {
	public static void main(String[] args) {
		String S = "{[()([)]]}";
//		String S = "{[()()]}";
//		String S = "([)()]";
		
		int result = 0;
		int[] asciiList = new int[S.length()];
		int[] scoresList = new int[S.length()];
		
		for(int i=0; i<S.length(); i++) {
			asciiList[i] = (int) S.charAt(i);
		}
		
		for(int i=0; i<S.length(); i++) {
			if(asciiList[i] == 40) {
				scoresList[i] = -1;
			}
			if(asciiList[i] == 41) {
				scoresList[i] = 1;
			}
			if(asciiList[i] == 91) {
				scoresList[i] = -2;
			}
			if(asciiList[i] == 93) {
				scoresList[i] = 2;
			}
			if(asciiList[i] == 123) {
				scoresList[i] = -3;
			}
			if(asciiList[i] == 125) {
				scoresList[i] = 3;
			}
		}
		
		int[] reducedList = new int[scoresList.length];
		
		System.err.println("SCORES LIST: " + Arrays.toString(scoresList));
		
		for(int j=0; j<scoresList.length; j++) {
			int start = j;
			int end = scoresList.length - 1 - j;
			int totalScore = scoresList[end]+scoresList[start];
			System.err.println((end-start));
			if(totalScore != 0) {
				System.arraycopy(scoresList, start, reducedList, start, ((end - start) + 1));
				break;
			}
		}
		
		System.err.println("REDUCED LIST: " + Arrays.toString(reducedList));
		
//		for(int j=0; j<scoresList.length; j++) {
//			int start = j;
//			int end = scoresList.length-1-j;
//			System.err.println("START: " + start);
//			System.err.println("END: " + end);
//			
//			if(scoresList[j] + scoresList[end] != 0) {
//				System.arraycopy(scoresList, start, reducedList, start, (scoresList.length-j));
//				System.err.println("BEFORE BREAK: " + j);
//				break;
//			} 
//		}
//		
//		System.err.println("SCORES LIST: " + Arrays.toString(scoresList));
//		
//		// Calculate Prefix Sums of ReducedList Array
//		int counter = 0;
//		
//		// Calculate n for non-zero start and end values
//		for(int k=0; k<reducedList.length; k++) {
//			if(reducedList[k] != 0) {
//				counter++;
//			}
//		}
//		
//		int zeroCounter = 0;
//		
//		for(int i=0; i<reducedList.length; i++) {
//			if(reducedList[i] == 0) {
//				zeroCounter++;
//			}
//		}
//		
//		if(reducedList.length == zeroCounter) {
//			result = 1;
//		}
//		
//		int[] prefixSums = new int[counter];
//		int count = 1;
//		counter = 0;
//		
//		for(int k=0; k<reducedList.length; k++) {
//			if(reducedList[k] != 0) {
//				prefixSums[counter++] = reducedList[k];
//			}
//		}
//		
//		System.err.println(reducedList.length);
//		System.err.println("REDUCED LIST: " + Arrays.toString(reducedList));
//		
//		for(int i=0; i<reducedList.length; i++) {
//			if(reducedList[i] != 0 && i <= prefixSums.length) {
//				prefixSums[count] += prefixSums[count-1];
//				count++;
//			}
//		}
//		
//		System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSums));
//		if(prefixSums.length > 0 && prefixSums[prefixSums.length - 1] == 0) {
//			result = 1;
//		}
//		
//		System.err.println(result);
	}
}
