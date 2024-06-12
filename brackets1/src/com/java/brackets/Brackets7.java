package com.java.brackets;

import java.util.Stack;

public class Brackets7 {
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

	    int result = isBalanced(S) ? 1 : 0;
	    System.out.println("RESULT: " + result);
	}

	private static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
    
	    for (char ch : s.toCharArray()) {
	        if (ch == '(' || ch == '[' || ch == '{') {
	        	stack.push(ch);
	        } else if (ch == ')' || ch == ']' || ch == '}') {
	        	if (stack.isEmpty()) {
	        		return false;
	        	}
	        	char last = stack.pop();
	        	if ((ch == ')' && last != '(') || 
	        			(ch == ']' && last != '[') || 
	        			(ch == '}' && last != '{')) {
	        		return false;
	        	}
	        }
	    }
	
	    return stack.isEmpty();
	}
}
