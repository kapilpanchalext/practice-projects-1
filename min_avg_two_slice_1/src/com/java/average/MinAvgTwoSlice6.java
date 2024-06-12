package com.java.average;

public class MinAvgTwoSlice6 {
	public static void main(String[] args) {
		int[] A = new int[]{-3, -5, -8, -4, -10};
		int N = A.length;
        int[] prefixSum = new int[N];
        int[] minAvgIndex = new int[N];
        
        prefixSum[0] = A[0];
        minAvgIndex[0] = 0;
        
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            if ((double) prefixSum[i] / (i + 1) < (double) prefixSum[minAvgIndex[i - 1]] / (minAvgIndex[i - 1] + 1)) {
                minAvgIndex[i] = i;
            } else {
                minAvgIndex[i] = minAvgIndex[i - 1];
            }
        }
        
        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;
        
        for (int i = 0; i < N - 1; i++) {
            double avg = (double) (prefixSum[i + 1] - prefixSum[minAvgIndex[i]]) / (i + 1 - minAvgIndex[i]);
            if (avg < minAvg) {
                minAvg = avg;
                minIndex = minAvgIndex[i];
            }
        }
        System.err.println("MINAVG: " + minAvg);
        System.err.println("MIN INDEX: " + minIndex);
	}
}
