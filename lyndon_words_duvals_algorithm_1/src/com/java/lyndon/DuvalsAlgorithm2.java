package com.java.lyndon;

import java.util.ArrayList;
import java.util.List;

public class DuvalsAlgorithm2 {
	public static void main(String[] args) {
		 char[] alphabet = {'1', '2', '3', '4'};
	        int maxLength = 4;
	        List<String> lyndonWords = duvalLyndonWords(alphabet, maxLength);
	        for (String word : lyndonWords) {
	            System.out.println(word);
	        }
	}

	private static List<String> duvalLyndonWords(char[] alphabet, int maxLength) {
		int alphabetSize = alphabet.length;
        List<String> lyndonWords = new ArrayList<>();
        List<Integer> word = new ArrayList<>();
        word.add(1);

        while (word.size() <= maxLength) {
            lyndonWords.add(convertToWord(word, alphabet));
            word = nextLyndonWord(word, alphabetSize, maxLength);
        }

        return lyndonWords;
	}

	private static List<Integer> nextLyndonWord(List<Integer> word, int n, int maxLength) {
		 int m = word.size();
	        int i = m - 1;
	        while (i >= 0 && word.get(i) == n) {
	            i--;
	        }
	        if (i < 0) {
	            return new ArrayList<>();
	        }
	        List<Integer> newWord = new ArrayList<>(word.subList(0, i));
	        newWord.add(word.get(i) + 1);
	        while (newWord.size() < maxLength) {
	            newWord.add(1);
	        }
	        return newWord;
	}

	private static String convertToWord(List<Integer> word, char[] alphabet) {
		StringBuilder sb = new StringBuilder();
        for (int i : word) {
            sb.append(alphabet[i - 1]);
        }
        return sb.toString();
	}
}
