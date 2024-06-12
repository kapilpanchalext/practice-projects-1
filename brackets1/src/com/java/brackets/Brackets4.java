package com.java.brackets;

import java.util.Arrays;

public class Brackets4 {
	public static void main(String[] args) {
//		String S = "{[()([)]]}";
		String S = "{[()()]}";
//		String S = "([)()]";
//		String S = ")(";
//		String S = "[()}";
//		String S = "())(()";
//		String S = "({{({}[]{})}}[]{})";
//		String S = "{([][][])]";
		
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
				bracketAlphabet[i] ='A';
				scoresList[i] = -1;
			}
			if(asciiList[i] == 41) {
				bracketAlphabet[i] ='D';
				scoresList[i] = 1;
			}
			if(asciiList[i] == 91) {
				bracketAlphabet[i] ='B';
				scoresList[i] = -2;
			}
			if(asciiList[i] == 93) {
				bracketAlphabet[i] ='E';
				scoresList[i] = 2;
			}
			if(asciiList[i] == 123) {
				bracketAlphabet[i] ='C';
				scoresList[i] = -3;
			}
			if(asciiList[i] == 125) {
				bracketAlphabet[i] ='F';
				scoresList[i] = 3;
			}
		}
		
		System.err.println(Arrays.toString(bracketAlphabet));
		
		// Consecutive comparisons
		for(int i = 0; i<bracketAlphabet.length-1; i++) {
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
		
//		boolean flag = true;
//		for(int i = 0; i<bracketAlphabet.length; i+=2) {
//			char nextAlphabet = bracketAlphabet[i+1];
//			System.err.println(nextAlphabet);
//			
//			if(bracketAlphabet[i] == 'A' && nextAlphabet == 'D') {
//				flag = false;
//			}
//			
//			if(bracketAlphabet[i] == 'D' && nextAlphabet == 'A') {
//				flag = true;
//				break;
//			}
//			
//			if(bracketAlphabet[i] == 'B' && nextAlphabet == 'E') {
//				flag = false;
//			}
//			
//			if(bracketAlphabet[i] == 'E' && nextAlphabet == 'B') {
//				flag = true;
//				break;
//			}
//			
//			if(bracketAlphabet[i] == 'C' && nextAlphabet == 'F') {
//				flag = false;
//			}
//			
//			if(bracketAlphabet[i] == 'F' && nextAlphabet == 'C') {
//				flag = true;
//				break;
//			}
//		}
//		
//		if(flag) {
//			System.err.println("FLAG TRUE: " + flag);
//			result = 0;
////			return result;
//		}
//		
//		System.err.println("RESULT2: " + result);
//		
//		int[] scoresListReversed = new int[scoresList.length];
//		
//		// compare first and last elements
//		for (int i = 0; i < scoresList.length / 2; i++) {
//            if (scoresList[i] != scoresList[scoresList.length - i - 1]) {
//            	result = 0;
////            	return result;
//            }
//        }
//		
//		System.err.println("RESULT3: " + result);
//		
//		// Compute whether the brackets are symmetrically arranged or asymmetrically arranged
//		for (int i = 0; i < scoresList.length; i++) {
//            scoresListReversed[i] = scoresList[scoresList.length - i - 1];
//        }
//		
//		System.err.println("SCORES LIST: " + Arrays.toString(scoresList));
//		System.err.println("SCORES LIST REVERSED: " + Arrays.toString(scoresListReversed));
//		
//		// Compute the scores list and scores list reversed to find whether they are symmetric
//		boolean symmetric = false;
//		for(int i=0; i<scoresList.length; i++) {
//			if(Math.abs(scoresList[i]) == Math.abs(scoresListReversed[i])) {
//				symmetric = true;
//			} else {
//				symmetric = false;
//				break;
//			}
//		}
//		
//		System.err.println("SYMMETRIC: "+ symmetric);
//		if(symmetric == true) {
			// Symmetric Brackets
			for(int j = 0; j<scoresList.length; j++) {
				int start = j;
				int end = scoresList.length - 1 - j;
				int totalScore = scoresList[end] + scoresList[start];
				if(totalScore != 0) {
					result = 0;
				}
			}
//		}
		
		if(bracketAlphabet[bracketAlphabet.length-1] == 'A' || 
		   bracketAlphabet[bracketAlphabet.length-1] == 'B' || 
		   bracketAlphabet[bracketAlphabet.length-1] == 'C') {
			result = 0;
		}
		
		System.err.println(result);
	}
}
