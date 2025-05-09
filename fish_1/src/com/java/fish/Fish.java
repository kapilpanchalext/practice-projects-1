package com.java.fish;

import java.util.Arrays;
import java.util.Stack;

public class Fish {

	public static void main(String[] args) {
		int[] A = {4, 3, 2, 1, 5};
		int[] B = {0, 1, 0, 0, 0};

		System.err.println(Arrays.toString(A));
		System.err.println(Arrays.toString(B));

		Stack<Integer> downstream = new Stack<>();
    int aliveCount = 0;

    for (int i = 0; i < A.length; i++) {
        int size = A[i];
        int direction = B[i];

        if (direction == 1) {
            downstream.push(size);
        } else {
            while (!downstream.isEmpty()) {
                if (downstream.peek() > size) {
                    size = -1;
                    break;
                } else {
                    downstream.pop();
                }
            }
            if (size != -1) {
                aliveCount++;
            }
        }
    }

		System.err.println(aliveCount + downstream.size());
	}
}
