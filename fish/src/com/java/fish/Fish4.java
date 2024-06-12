package com.java.fish;

import java.util.Stack;

public class Fish4 {
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
		
//		int[] A = {0, 1};
//		int[] B = {1, 1};
		
		int[] A = {1000000000, 2000000000};
		int[] B = {1, 0};
		
//		int[] A = {0,1000000000,750123456,384567890,951234567,286789012,673456789,487901234,659012345,732345678};
//		int[] B = {1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
		
//		int[] A = {0, 286789012, 750123456, 384567890, 951234567, 1000000000, 673456789, 487901234, 659012345, 732345678};
//		int[] B = {1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
		
		int previousValue = -1;
		int previousDirection = -1;
		
		Stack<Integer> mainFishStack = new Stack<>();
		
		if(A.length > 1) {
			if((B[0] == 0) && (B[1] == 1) || (B[0] == B[1])) {
				mainFishStack.add(A[0]);
				mainFishStack.add(A[1]);
				previousDirection = B[1];
				previousValue = A[1];
			} else if((B[0] == 1) && (B[1] == 0) && A[0] > A[1]) {
				mainFishStack.add(Math.max(A[0], A[1]));
				previousDirection = B[0];
				previousValue = A[0];
			} else if((B[0] == 1) && (B[1] == 0) && A[0] < A[1]) {
				mainFishStack.add(Math.max(A[0], A[1]));
				previousDirection = B[1];
				previousValue = A[1];
			}
		
			for(int i=2; i<A.length; i++) {
				int currentDirection = B[i];
				int currentValue = A[i];
				
				if(previousDirection == 1 && currentDirection == 0 && previousValue > currentValue) {
				} else if (previousDirection == 1 && currentDirection == 0 && previousValue < currentValue) {
					if(mainFishStack.size() > 0) {
						for(int j=0; j<mainFishStack.size(); j++) {
							int topVal = mainFishStack.pop();
							if(currentValue < topVal) {
								mainFishStack.add(topVal);
							} 
						}
						mainFishStack.add(currentValue);
					}
					previousDirection = currentDirection;
				} else if (previousDirection == 0 && currentDirection == 1 && previousValue > currentValue) {
					mainFishStack.add(currentValue);
					previousDirection = currentDirection;
					previousValue = currentValue;
				} else if (previousDirection == 0 && currentDirection == 1 && previousValue < currentValue) {
					mainFishStack.add(currentValue);
					previousDirection = B[i];
					previousValue = currentValue;
				} else if (previousDirection == currentDirection) {
					mainFishStack.add(currentValue);
					previousDirection = B[i];
					previousValue = currentValue;
				}
			}
		} else {
			System.err.println("FISHES LEFT");
//			return 1;
		}
		System.err.println("STACK FISHES: " + mainFishStack);
		System.err.println("STACK FISHES SIZE: " + mainFishStack.size());
	}
}
