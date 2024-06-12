package com.java.disc;

import java.util.Arrays;

public class NumberOfDiscIntersections4 {
	public static void main(String[] args) {

		int[] A = {1, 5, 2, 1, 4, 0};
		int n = A.length;
        long[] lower = new long[n];
        long[] upper = new long[n];

        for (int i = 0; i < n; i++) {
            lower[i] = (long) i - A[i];
            upper[i] = (long) i + A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersectionCount = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && upper[i] >= lower[j]) {
                intersectionCount += j;
                intersectionCount -= i;
                j++;
            }
        }

        if (intersectionCount > 10000000) {
//            return -1;
        }
        System.err.println(intersectionCount);
	}
}
