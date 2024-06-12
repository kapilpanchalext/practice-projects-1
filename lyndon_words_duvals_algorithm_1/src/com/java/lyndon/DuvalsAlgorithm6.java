package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class DuvalsAlgorithm6 {

	public static void main(String[] args) {
		String text = "abcabcabca";
        List<String> lyndonWords = getLyndonWords(text);
        System.out.println("Lyndon words for '" + text + "':");
        for (String word : lyndonWords) {
            System.out.println(word);
        }
	}

	private static List<String> getLyndonWords(String text) {
		 List<String> result = new ArrayList<>();
	        int n = text.length();
	        int i = 0;

	        while (i < n) {
	            int j = i + 1;
	            int k = i;

	            while (j < n && text.charAt(k) <= text.charAt(j)) {
	                if (text.charAt(k) < text.charAt(j)) {
	                    k = i;
	                } else {
	                    k++;
	                }
	                j++;
	            }

	            while (i <= k) {
	                result.add(text.substring(i, i + (j - k)));
	                i += (j - k);
	            }
	        }

	        return result;	
	        }

}
