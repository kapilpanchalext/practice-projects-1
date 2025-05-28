package com.java.equileader;

import java.util.Stack;

public class EquiLeader1 {

	public static void main(String[] args) {
		System.out.println("Equi Leader - 1");

////		final int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
//		final int[] A = {4, 3, 4, 4, 4, 2};
//
//		int result = 0;
//
//		for(int i=1; i<A.length; i++) {
//			int size1 = i;
//	    int size2 = A.length-size1;
//
//	    if (A.length < size1 + size2) {
//	        throw new IllegalArgumentException("Array is too small to split into the specified sizes.");
//	    }
//
//	    int[] part1 = new int[size1];
//	    int[] part2 = new int[size2];
//
//	    System.arraycopy(A, 0, part1, 0, size1);
//	    System.arraycopy(A, size1, part2, 0, size2);
//
//	    if(part1.length == 1 || part2.length == 1) {
//	    	continue;
//	    }
//
//	    System.out.println("Part 1: " + java.util.Arrays.toString(part1));
//	    System.out.println("Part 2: " + java.util.Arrays.toString(part2));
//
//			int result1 = getLeader(part1);
//			System.err.println(result1);
//
//			int result2 = getLeader(part2);
//			System.err.println(result2);
//
//			if(result1 == result2 && result1 != -1) {
//				System.err.println("Match");
//				result++;
//			}
//		}
//		System.err.println(result);
		
		final int[] A = {4, 3, 4, 4, 4, 2};
    System.out.println("Equi Leaders Count: " + countEquiLeaders(A));
	}

	private static int getLeader(int[] A) {
    Stack<Integer> stack = new Stack<>();

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

    // Fix: only return candidate if it's a real leader
    if (count > A.length / 2) {
        return candidate;
    }

    return -1; // No leader
	}

	public static int countEquiLeaders(int[] A) {
    int size = 0, value = 0;

    // Step 1: Find candidate using stack-like logic
    for (int num : A) {
        if (size == 0) {
            size++;
            value = num;
        } else {
            if (value != num) {
                size--;
            } else {
                size++;
            }
        }
    }

    // Step 2: Verify candidate is actually a leader
    int candidate = -1, count = 0;
    for (int num : A) {
        if (num == value) count++;
    }
    if (count <= A.length / 2) return 0; // No leader
    candidate = value;

    // Step 3: Count equi leaders
    int equiLeaders = 0;
    int leftCount = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] == candidate) {
        	leftCount++;
        }

        int leftSize = i + 1;
        int rightSize = A.length - leftSize;

        if (leftCount > leftSize / 2 && (count - leftCount) > rightSize / 2) {
            equiLeaders++;
        }
    }

    return equiLeaders;
	}
	
}
