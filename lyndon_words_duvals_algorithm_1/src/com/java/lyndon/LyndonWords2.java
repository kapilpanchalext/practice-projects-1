package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class LyndonWords2 {
	public static void main(String[] args) {
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
        // Generate only substrings of length 3
        for (int i = 0; i <= n - 3; i++) {
            String substring = text.substring(i, i + 3);
            if (isLyndonWord(substring)) {
                result.add(substring);
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
