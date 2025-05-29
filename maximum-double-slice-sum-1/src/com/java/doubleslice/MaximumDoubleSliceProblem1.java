package com.java.doubleslice;

public class MaximumDoubleSliceProblem1 {

	public static void main(String[] args) {
		System.out.println("Maximum Double Slice Problem!");
		
//		int[] A = {5, -7, 3, 5, -2, 4, -1};
			int[] A = {5, -7, 3, 5, -2, 4, -1};
//		System.out.println(Arrays.toString(A));
//		
//		int forwardSum = getForwardSum(A, A.length);
//		System.out.println(forwardSum);
//		
//		int backwardSum = getBackwardSum(A, A.length);
//		System.out.println(backwardSum);
//		
//		int resultSum = getCombinedResults(A);
//		System.out.println(resultSum);
		
		int N = A.length;

    // Arrays to hold max sum subarrays ending before and starting after each index
    int[] maxEndingHere = new int[N];
    int[] maxStartingHere = new int[N];

    // Forward Kadane: max sum ending at i (excluding A[i])
    for (int i = 1; i < N - 1; i++) {
        maxEndingHere[i] = Math.max(0, maxEndingHere[i - 1] + A[i]);
    }

    // Backward Kadane: max sum starting at i (excluding A[i])
    for (int i = N - 2; i > 0; i--) {
        maxStartingHere[i] = Math.max(0, maxStartingHere[i + 1] + A[i]);
    }

    // Compute the maximum double slice sum
    int maxDoubleSliceSum = 0;
    for (int Y = 1; Y < N - 1; Y++) {
        int sum = maxEndingHere[Y - 1] + maxStartingHere[Y + 1];
        maxDoubleSliceSum = Math.max(maxDoubleSliceSum, sum);
    }
    System.out.println(maxDoubleSliceSum);
	}

	private static int getCombinedResults(int[] A) {
		int maxEnding = 0;
		for(int i=1; i<A.length-1; i++) {
			int forwardSum = getForwardSum(A, A.length);
			int backwardSum = getBackwardSum(A, A.length);
			
			maxEnding = Math.max(maxEnding, forwardSum + backwardSum);
		}
		return maxEnding;
	}

	private static int getBackwardSum(int[] A, int length) {
		int[] maxEnding = new int[length];
		int sum = 0;
		
		for(int i=1; i<length-1; i++) {
			maxEnding[i] = Math.max(0, maxEnding[i + 1] + A[i]);
		}
		
		for(int element : maxEnding) {
			sum += element;
		}
		return sum;
	}

	private static int getForwardSum(int[] A, int length) {
		int[] maxEnding = new int[length];
		int sum = 0;
		
		for(int i=1; i<length-1; i++) {
			maxEnding[i] = Math.max(0, maxEnding[i - 1] + A[i]);
		}
		
		for(int element : maxEnding) {
			sum += element;
		}
		return sum;
	}

}
