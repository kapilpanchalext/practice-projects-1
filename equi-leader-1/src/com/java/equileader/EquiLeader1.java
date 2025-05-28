package com.java.equileader;

import java.util.Stack;

public class EquiLeader1 {

	public static void main(String[] args) {
		System.out.println("Equi Leader - 1");

		final int[] A = {3, 4, 3, 2, 3, -1, 3, 3};

		int result = getLeader(A);
		System.err.println(result);
	}

	private static int getLeader(int[] A) {
		Stack<Integer> stack = new Stack<>();
    // Phase 1: Push/pop to find a candidate
    for(int num : A) {
        if (stack.isEmpty()) {
            stack.push(num);
        } else {
            if (stack.peek() != num) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
    }

    // Phase 2: Verify candidate
    int candidate = -1;
    if (!stack.isEmpty()) {
        candidate = stack.peek();
    }

    int count = 0;
    for (int num : A) {
        if (num == candidate) {
            count++;
        }
    }

    if (count > A.length / 2) {
        return candidate;
    }

    return candidate; // No leader
	}

}
