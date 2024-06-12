package com.java.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Combinations3 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        // Fill the stack with the specified pattern
        stack.push(0);
        stack.push(0);
        stack.push(0);
        stack.push(0);
        stack.push(0);

        // Use a single for loop to empty the stack and fill the queue
        for (int i = 0; i < 5; i++) {
            if (stack.isEmpty()) {
                break;
            }

            // Remove an element from the stack and add it to the queue
            int element = stack.pop();
            queue.offer(element);

            // Increment the element and add it back to the stack
            element++;
            if (!stack.isEmpty()) {
                stack.push(element);
            }

            // Remove an element from the queue and add it to the stack
            if (!queue.isEmpty()) {
                stack.push(queue.poll());
            }

            // Add the popped element to the list of lists
            if (resultList.size() <= element) {
                resultList.add(new ArrayList<>());
            }
            resultList.get(element).add(element);
        }

        // Print the final contents of the stack
        System.out.println("Final Stack: " + stack);

        // Print the contents of the list of lists
        System.out.println("Result List: " + resultList);
	}

}
