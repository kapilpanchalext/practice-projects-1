package com.java.leader;

import java.util.Stack;

public class Leader1 {

	public static void main(String[] args) {
		final int[] A = {3, 4, 3, 2, 3, -1, 3, 3};

		Stack<Integer> stack = new Stack<>();
		int result = 0;
    // Phase 1: Push/pop to find a candidate
    for (int num : A) {
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
//        return candidate;
    	for(int i=0; i<A.length; i++) {
    		if(A[i] == candidate) {
//    			return i;
    			result = i;
    		}
    	}
        result = candidate;
        System.err.println(result);
    }

//    return -1; // No leader
    result = -1;
    
    System.err.println(result);
	}

}
