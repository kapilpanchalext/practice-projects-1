package com.java.brackets;

import java.util.LinkedList;
import java.util.Queue;

public class Brackets1 {
	public static void main(String[] args) {
		String S = "{[()()]}";
		int result = 0;
		int[] bracketIntVal = {40, 41, 91, 93, 123, 125};
		
		Queue<Integer> openingBrackets = new LinkedList<>();
		Queue<Integer> closingBrackets = new LinkedList<>();
		
		for(int i=0; i<S.length(); i++) {
			if((int)S.charAt(i) == bracketIntVal[0] || 
					(int)S.charAt(i) == bracketIntVal[2] || 
					(int)S.charAt(i) == bracketIntVal[4]) {
				openingBrackets.add((int)S.charAt(i));
			}
			if((int)S.charAt(i) == bracketIntVal[1] || 
					(int)S.charAt(i) == bracketIntVal[3] || 
					(int)S.charAt(i) == bracketIntVal[5]) {
				closingBrackets.add((int)S.charAt(i));
			}
		}
		
		System.err.println(openingBrackets);
		System.err.println(closingBrackets);
		
		// Step - 1 Compare total size of the String
		if(openingBrackets.size() == closingBrackets.size()) {
			result = 1;
		}
		
		int parenthesisOpening = 0;
		int squareBracketsOpening = 0;
		int bracesOpening = 0;
		
		int parenthesisClosing = 0;
		int squareBracketsClosing = 0;
		int bracesClosing = 0;

		// Step - 2 Compare the size of individual brackets
		int minOfBracketSize = Math.min(openingBrackets.size(), closingBrackets.size());
		for(int i=0; i<minOfBracketSize; i++) {
			int openingVal=openingBrackets.poll();
			int closingVal=closingBrackets.poll();
			
			if(openingVal == bracketIntVal[0]) {
				parenthesisOpening++;
			} else if(openingVal == bracketIntVal[2]) {
				squareBracketsOpening++;
			} else if(openingVal == bracketIntVal[4]) {
				bracesOpening++;
			}
			
			if(closingVal == bracketIntVal[1]) {
				parenthesisClosing++;
			} else if(closingVal == bracketIntVal[3]) {
				squareBracketsClosing++;
			} else if(closingVal == bracketIntVal[5]) {
				bracesClosing++;
			}
		}
		
		System.err.println("ParenthesisOpeningSize: " + parenthesisOpening);
		System.err.println("ParenthesisClosingSize: " + parenthesisClosing);
		
		System.err.println("SquareBracketOpeningSize: " + squareBracketsOpening);
		System.err.println("SquareBracketClosingSize: " + squareBracketsClosing);
		
		System.err.println("BracesOpeningSize: " + bracesOpening);
		System.err.println("BracesClosingSize: " + bracesClosing);
		
		if(parenthesisOpening == parenthesisClosing && 
		   squareBracketsOpening == squareBracketsClosing &&
		   bracesOpening == bracesClosing) {
			result = 1;
		} else  {
			result = 0;
		}
		
		System.err.println("Result: " + result);
	}
}
