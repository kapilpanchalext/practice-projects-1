package com.java.nesting;

import java.util.Stack;

public class Nesting {
	public static void main(String[] args) {

		final String nestingString =  "(()(())())";
//		final String nestingString =  "())";

		Stack<String> stack = new Stack<>();

		for(int i=0; i<nestingString.length(); i++) {
			if(nestingString.charAt(i) == '(') {
				stack.add("(");
			} else if(nestingString.charAt(i) == ')' && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.add(String.valueOf(nestingString.charAt(i)));
			}
		}

		if(stack.isEmpty()) {
			System.err.println("1");
		} else {
			System.err.println("0");
		}
	}
}
