package com.java.brackets;

import java.util.Arrays;

public class Brackets3 {
	public static void main(String[] args) {
//		String S = "{[()([)]]}";
		String S = "{[()()]}";
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
			int signumStart = (int) Math.signum(scoresList[start]);
			System.err.println(signumStart);
			int totalScore = 0;
			
			if(signumStart == -1) {
				totalScore = scoresList[end] - Math.abs(scoresList[start]);
			} else {
				totalScore = scoresList[end] + scoresList[start];
			}
			
			System.err.println("TOTAL SCORE: " + totalScore);
			
			if(totalScore != 0) {
				System.arraycopy(scoresList, start, reducedList, start, ((end - start) + 1));
				break;
			}
		}
		
		System.err.println("REDUCED LIST: " + Arrays.toString(reducedList));
		
//		Calculate Prefix Sums of ReducedList Array
		int counter = 0;
		int zeroCounter = 0;
//		
//		// Calculate n for non-zero start and end values
		for(int k=0; k<reducedList.length; k++) {
			if(reducedList[k] != 0) {
				counter++;
			}
		}
		
		System.err.println("COUNTER: " + counter);
		System.err.println("ZERO COUNTER: " + zeroCounter);
		
		for(int i=0; i<reducedList.length; i++) {
			if(reducedList[i] == 0) {
				zeroCounter++;
			}
		}
		
		if(reducedList.length == zeroCounter) {
			result = 1;
		}
		
		int[] prefixSums = new int[counter];
		int count = 1;
		counter = 0;
		
		System.err.println(prefixSums.length);
		
		for(int k=0; k<reducedList.length; k++) {
			if(reducedList[k] != 0) {
				prefixSums[counter++] = reducedList[k];
			}
		}
		
		System.err.println(reducedList.length);
		System.err.println("REDUCED LIST: " + Arrays.toString(reducedList));
		System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSums));
		
		for(int i=1; i<reducedList.length; i++) {
			if(reducedList[i] != 0 && i <= prefixSums.length) {
				prefixSums[count] += prefixSums[count-1];
				count++;
			}
		}
		
		System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSums));
//		if(prefixSums.length > 0 && prefixSums[prefixSums.length - 1] == 0) {
//			result = 1;
//		}
//		
//		System.err.println(result);
	}
}
