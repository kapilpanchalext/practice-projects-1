package com.java.genomic;

import java.util.Arrays;

public class GenomicRangeQuery6 {
	public static void main(String[] args) {
		String S = "CAGCCTA";

        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int[] result = solution(S, P, Q);
        System.out.println("SCORES: " + Arrays.toString(result));
	}

	private static int[] solution(String S, int[] P, int[] Q) {
		int[][] prefixSums = calculatePrefixSums(S);
		System.err.println("PREFIX SUMS: " + Arrays.deepToString(prefixSums));
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i] + 1;

            if (prefixSums[0][endIndex] - prefixSums[0][startIndex] > 0) {
                result[i] = 1;
            } else if (prefixSums[1][endIndex] - prefixSums[1][startIndex] > 0) {
                result[i] = 2;
            } else if (prefixSums[2][endIndex] - prefixSums[2][startIndex] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
	}

	private static int[][] calculatePrefixSums(String S) {
		int[][] prefixSums = new int[4][S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            char nucleotide = S.charAt(i);

            for (int j = 0; j < 4; j++) {
                prefixSums[j][i + 1] = prefixSums[j][i];
            }

            switch (nucleotide) {
                case 'A':
                    prefixSums[0][i + 1]++;
                    break;
                case 'C':
                    prefixSums[1][i + 1]++;
                    break;
                case 'G':
                    prefixSums[2][i + 1]++;
                    break;
                case 'T':
                    prefixSums[3][i + 1]++;
                    break;
            }
        }

        return prefixSums;
	}
}
