package com.java.average;

public class MinAvgTwoSlice7 {
	public static void main(String[] args) {
		int[] A = new int[]{-3, -5, -8, -4, -10};
		int N = A.length;
		int minAvgIdx = 0;
        double minAvgVal = (A[0] + A[1]) / 2.0;

        for (int i = 0; i < A.length - 2; i++) {
            // check average of 2-element slice
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minAvgVal) {
                minAvgVal = avg2;
                minAvgIdx = i;
            }

            // check average of 3-element slice
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
            if (avg3 < minAvgVal) {
                minAvgVal = avg3;
                minAvgIdx = i;
            }
        }

        // check the average of the last 2-element slice
        double avg2 = (A[A.length - 2] + A[A.length - 1]) / 2.0;
        if (avg2 < minAvgVal) {
            minAvgIdx = A.length - 2;
        }

        System.err.println("MIN AVG IDX: " + minAvgIdx);
	}
}
