package com.java.brackets;

import java.util.Arrays;

public class Brackets6 {
	public static void main(String[] args) {
//		String S = "{[()([)]]}";
//		String S = "{[()()]}";
//		String S = "([)()]";
//		String S = "[()()]]";
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
		
		boolean flag = false;
		
		// Consecutive comparisons - Prohibited Brackets
		for(int i=0; i<bracketAlphabet.length-1; i++) {
			char nextAlphabet = bracketAlphabet[i+1];
			if(bracketAlphabet[i] == 'A' && (nextAlphabet == 'E' || nextAlphabet == 'F')) {
				result = 0;
				flag = true;
				break;
			} else if(bracketAlphabet[i] == 'B' && (nextAlphabet == 'D' || nextAlphabet == 'F')) {
				result = 0;
				flag = true;
				break;
			} else if(bracketAlphabet[i] == 'C' && (nextAlphabet == 'D' || nextAlphabet == 'E')) {
				result = 0;
				flag = true;
				break;
			} else {
				result = 1;
				flag = false;
			}
		}
		
		System.err.println("RESULT1: " + result);
		System.err.println("FLAG: " + flag);
		
		int parenthesisCounter = 0;
		int squareBracketCounter = 0;
		int curlyBracketCounter = 0;
		
		for(int i=0; i<bracketAlphabet.length; i++) {
			if(bracketAlphabet[i] == 'A') {
				parenthesisCounter++;
			}
			
			if(bracketAlphabet[i] == 'B') {
				squareBracketCounter++;
			}
			
			if(bracketAlphabet[i] == 'C') {
				curlyBracketCounter++;
			}
			
			if(bracketAlphabet[i] == 'D') {
				parenthesisCounter--;
			}
			
			if(bracketAlphabet[i] == 'E') {
				squareBracketCounter--;
			}
			
			if(bracketAlphabet[i] == 'F') {
				curlyBracketCounter--;
			}
			
			System.err.println("Parenthesis Counter: " + parenthesisCounter);
			System.err.println("Square Bracket Counter: " + squareBracketCounter);
			System.err.println("Curly Bracket Counter: " + curlyBracketCounter);
			
			if(parenthesisCounter < 0 || squareBracketCounter < 0 || curlyBracketCounter < 0) {
				System.err.println("INSIDE IF");
				result = 0;
				break;
			} else if(parenthesisCounter > 0 || squareBracketCounter > 0 || curlyBracketCounter > 0) {
				result = 0;
			} else if(flag == false) {
				result = 1;
			}
		}
		
		if(flag) {
			result = 0;
		}
		
		System.err.println("RESULT2: " + result);
	}
}
