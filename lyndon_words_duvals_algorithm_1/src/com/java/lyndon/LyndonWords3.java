package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class LyndonWords3 {
	public static void main(String[] args) {
		 // String text = "abcabcabca";
        String text = "abcd";
        List<String> lyndonWords = getLyndonWords(text);
        System.out.println("Lyndon words for '" + text + "':");
        for (String word : lyndonWords) {
            System.out.println(word);
        }
	}

	private static List<String> getLyndonWords(String text) {
		List<String> result = new ArrayList<>();
        int n = text.length();
        // Generate all combinations of 3 characters
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    String substring = "" + text.charAt(i) + text.charAt(j) + text.charAt(k);
                    if (isLyndonWord(substring)) {
                        result.add(substring);
                    }
                }
            }
        }
        return result;
	}
	
	private static boolean isLyndonWord(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.compareTo(s.substring(i) + s.substring(0, i)) > 0) {
                return false;
            }
        }
        return true;
    }
}
