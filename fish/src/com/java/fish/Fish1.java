package com.java.fish;

import java.util.Stack;

public class Fish1 {
	public static void main(String[] args) {
//		int[] A = {4, 3, 2, 1, 5};
//		int[] B = {0, 1, 0, 0, 0};
		
//		int[] A = {4, 3, 2, 1, 1};
//		int[] B = {1, 0, 0, 0, 0};
		
//		int[] A = {4};
//		int[] B = {1};
		
//		int[] A = {4, 3};
//		int[] B = {0, 1};
		
//		int[] A = {4, 3};
//		int[] B = {1, 0};
		
//		long[] A = {0, 1};
//		byte[] B = {1, 1};
		
//		long[] A = {1000000000, 2000000000};
//		byte[] B = {1, 0};
		
		long[] A = {0,1000000000,750123456,384567890,951234567,286789012,673456789,487901234,659012345,732345678};
		byte[] B = {1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
		
//		long[] A = {0, 286789012, 750123456, 384567890, 951234567, 1000000000, 673456789, 487901234, 659012345,	732345678};
//		byte[] B = {1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
		
		byte previousDirection = -1;
		long previousValue = -1L;
		
		Stack<Long> mainFishStack = new Stack<>();
		
		if(A.length > 1) {
			if((A[0] > A[1]) && (B[0] == 1) && (B[1] == 0)) {
				mainFishStack.add(A[0]);
				previousDirection = B[0];
				previousValue = A[0];
			} else if((A[0] < A[1]) && (B[0] == 1) && (B[1] == 0)) {
				mainFishStack.add(A[1]);
				previousDirection = B[1];
				previousValue = A[1];
			} else {
				mainFishStack.add(A[0]);
				mainFishStack.add(A[1]);
				previousDirection = B[1];
				previousValue = A[1];
			}
		
			for(int i=2; i<A.length; i++) {
				byte currentDirection = B[i];
				long currentValue = A[i];
				
				if(currentDirection == previousDirection) {
					mainFishStack.add(A[i]);
				} else if(currentDirection == 0 && previousDirection == 1) {
					if(currentValue > previousValue) {
						long topVal = 0L;
						if(mainFishStack.size() > 0) {
							for(int j=0; j<mainFishStack.size(); j++) {
								topVal = mainFishStack.pop();
								if(currentValue < topVal) {
									mainFishStack.add(topVal);
								}
							}
						}
						previousDirection = B[i];
						previousValue = currentValue;
					} else {
						previousValue = Math.max(previousValue, currentValue);
					}
				} else if(currentDirection == 1 && previousDirection == 0) {
//					if(currentValue > previousValue) {
						mainFishStack.add(A[i]);
//					} 
//					else {
//						mainFishStack.add(A[i]);
						previousDirection = B[i];
//					}
				}
				
//				if(currentValue > previousValue && currentDirection == previousDirection) {
//					previousValue = Math.max(previousValue, currentValue);
//				} else {
//					previousValue = currentValue;
//				}
//				
//				if(currentValue > previousValue && currentDirection == previousDirection) {
//					previousValue = Math.max(previousValue, currentValue);
//				} else if(currentValue < previousValue && currentDirection == previousDirection) {
//					previousValue = currentValue;
//				} else if(currentDirection == 1 && previousDirection == 0) {
//					previousValue = Math.max(previousValue, currentValue);
//				} else if(currentDirection == 0 && previousDirection == 1) {
//					previousValue = currentValue;
//				}
			}
			
			System.err.println("FISHES LEFT NUMBERS: " + mainFishStack.size());
			System.err.println("FISHES LEFT: " + mainFishStack);
		} else {
			System.err.println("FISHES LEFT");
//			return 1;
		}
	}
}
