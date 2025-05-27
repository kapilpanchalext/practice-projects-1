package com.java.stone;

import java.util.Arrays;
import java.util.Stack;

public class StoneWall1 {
	public static void main(String[] args) {
		System.out.println("Stone Wall 1!");
		
		int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
//		int[] H = {3, 2, 1};
		
//		System.out.println(Arrays.toString(H));
//		System.out.println(H[0]);
//		Stack<Integer> wallHeightStack = new Stack<>();
//		wallHeightStack.add(H[0]);
//		for(int i=1; i<H.length; i++) {
////			if(H[i-1] == H[i]) {
////				// If previous height is equal to next height then use the same height so
////				// no new additions to the wall
////				// Do Nothing
////
////			} else
//			
//			if(H[i-1] > H[i]) {
//				// If previous block is higher than next block use next block height
//				// Use New Block
//
//				wallHeightStack.add(H[i]);
//				System.out.println(H[i]);
//			} else if(H[i-1] < H[i]) {
//				// If previous block is lower than next block add to the existing height
//				// previous height
//
//				wallHeightStack.add(H[i] - H[i-1]);
////				while(!wallHeightStack.isEmpty()) {
////					
////				}
//				System.out.println(H[i] - H[i-1]);
//			}
//		}
//
//		System.out.println(wallHeightStack);
//		System.out.println("No of Walls: " + wallHeightStack.size());
		
		System.out.println("Stone Wall Solution");

    System.out.println("Heights: " + Arrays.toString(H));

    Stack<Integer> stack = new Stack<>();
    int blockCount = 0;

    for (int height : H) {
        // Remove all blocks taller than the current one
        while (!stack.isEmpty() && stack.peek() > height) {
            stack.pop();
        }

        // If the current height is already present, do nothing
        if (!stack.isEmpty() && stack.peek() == height) {
            continue;
        }

        // Otherwise, we need a new block
        stack.push(height);
        blockCount++;
    }

    System.out.println("Minimum number of blocks needed: " + blockCount);

	}
}
