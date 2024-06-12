package com.java.brackets;

import java.util.Arrays;

public class Brackets5 {
	public static void main(String[] args) {
//		String S = "{[()([)]]}";
//		String S = "{[()()]}";
//		String S = "([)()]";
//		String S = ")(";
//		String S = "[()}";
//		String S = "())(()";
		String S = "({{({}[]{})}}[]{})";
//		String S = "{([][][])]";
//		String S = "{{{{";
		
		int result = 0;
		if(S.length() == 0) {
			result = 1;
//			return result;
		}
		
		int[] asciiList = new int[S.length()];
		int[] scoresList = new int[S.length()];
		char[] bracketAlphabet = new char[S.length()];
		
		for(int i=0; i<S.length(); i++) {
			asciiList[i] = (int) S.charAt(i);
		}
		
		for(int i=0; i<S.length(); i++) {
			if(asciiList[i] == 40) {
				bracketAlphabet[i] = 'A';
				scoresList[i] = -1;
			}
			
			if(asciiList[i] == 41) {
				bracketAlphabet[i] = 'D';
				scoresList[i] = 1;
			}
			
			if(asciiList[i] == 91) {
				bracketAlphabet[i] = 'B';
				scoresList[i] = -2;
			}
			
			if(asciiList[i] == 93) {
				bracketAlphabet[i] = 'E';
				scoresList[i] = 2;
			}
			
			if(asciiList[i] == 123) {
				bracketAlphabet[i] = 'C';
				scoresList[i] = -3;
			}
			
			if(asciiList[i] == 125) {
				bracketAlphabet[i] = 'F';
				scoresList[i] = 3;
			}
		}
		
		System.err.println(Arrays.toString(bracketAlphabet));
		
		// Consecutive comparisons - Negative Scores not permissible
		// Compute Prefix Sums
		int counter = 0;
		// Calculate n for non-zero start and end values
		
		for(int k=0; k<scoresList.length; k++) {
			if(scoresList[k] != 0) {
				counter++;
			}
		}
		
		int[] prefixSums = new int[counter];
		int count = 1;
		
		System.err.println(prefixSums.length);
		counter = 0;
		
		for(int k=0; k<scoresList.length; k++) {
			if(scoresList[k] != 0) {
				prefixSums[counter++] = scoresList[k];
			}
		}
		
		for(int i=1; i<scoresList.length; i++) {
			if(scoresList[i] != 0 && i <= prefixSums.length) {
				prefixSums[count] += prefixSums[count-1];
				count++;
			}
		}
		
		System.err.println("PREFIX SUMS: " + Arrays.toString(prefixSums));
		
		for(int i=0; i<prefixSums.length; i++) {
			if(prefixSums[i] > 0) {
				result = 0;
				break;
//				return result;
			}
		}
		
		System.err.println("PREFIX SUMS RESULT: " + result);
		
		// Consecutive comparisons - Prohibited Brackets
		for(int i=0; i<bracketAlphabet.length-1; i++) {
			char nextAlphabet = bracketAlphabet[i+1];
			if(bracketAlphabet[i] == 'A' && (nextAlphabet == 'E' || nextAlphabet == 'F')) {
				result = 0;
				break;
			} else if(bracketAlphabet[i] == 'B' && (nextAlphabet == 'D' || nextAlphabet == 'F')) {
				result = 0;
				break;
			} else if(bracketAlphabet[i] == 'C' && (nextAlphabet == 'D' || nextAlphabet == 'E')) {
				result = 0;
				break;
			} else {
				result = 1;
			}
		}
		System.err.println("RESULT1: " + result);
		
		// Asymmetric Brackets
		int[] reversedBrackets = new int[scoresList.length];
		
		for(int i=0; i<scoresList.length; i++) {
			reversedBrackets[i] = scoresList[scoresList.length - i - 1];
		}
		
		System.err.println("SCORES LIST: " + Arrays.toString(scoresList));
		System.err.println("REVERSED BRACKET LIST: " + Arrays.toString(reversedBrackets));
		boolean asymmetric = false;
		
		for(int i=0; i<scoresList.length; i++) {
			if(scoresList[i] != reversedBrackets[i]) {
				asymmetric = true;
			}
		}
		
		if(asymmetric == true && prefixSums[prefixSums.length-1] == 0) {
			result = 1;
//			return result;
		}
		
		// Symmetric Brackets
		for(int j = 0; j<scoresList.length; j++) {
			int start = j;
			int end = scoresList.length - 1 - j;
			int totalScore = scoresList[end] + scoresList[start];
			if(totalScore != 0) {
				result = 0;
			}
		}
		
		if(bracketAlphabet[bracketAlphabet.length-1] == 'A' || 
		   bracketAlphabet[bracketAlphabet.length-1] == 'B' || 
		   bracketAlphabet[bracketAlphabet.length-1] == 'C') {
			result = 0;
		}
		
		if(bracketAlphabet[0] == 'D' || 
		   bracketAlphabet[0] == 'E' || 
		   bracketAlphabet[0] == 'F') {
			result = 0;
		}
		
		System.err.println(result);
	}
}
