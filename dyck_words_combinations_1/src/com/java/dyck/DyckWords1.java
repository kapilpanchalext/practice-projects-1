package com.java.dyck;

import java.util.ArrayList;
import java.util.List;

public class DyckWords1 {

	public static void main(String[] args) {
		List<String> dyckWords = generateDyckWords(1);
        for (String dyckWord : dyckWords) {
            System.out.println(dyckWord);
        }
	}
	public static List<String> generateDyckWords(int length) {
        List<String> dyckWords = new ArrayList<>();
        generateDyckWordsRecursive(length, length, "", dyckWords);
        return dyckWords;
    }

    private static void generateDyckWordsRecursive(int open, int close, String current, List<String> dyckWords) {
        if (open == 0 && close == 0) {
            dyckWords.add(current);
            return;
        }

        if (open > 0) {
            generateDyckWordsRecursive(open - 1, close, current + "A", dyckWords);
            generateDyckWordsRecursive(open - 1, close, current + "C", dyckWords);
            generateDyckWordsRecursive(open - 1, close, current + "E", dyckWords);
        }

        if (close > open) {
            generateDyckWordsRecursive(open, close - 1, current + "B", dyckWords);
            generateDyckWordsRecursive(open, close - 1, current + "D", dyckWords);
        }
    }
}
