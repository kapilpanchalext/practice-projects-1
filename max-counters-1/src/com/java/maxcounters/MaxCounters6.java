package com.java.maxcounters;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ParallelForLoop extends RecursiveAction {
	private static final int THRESHOLD = 10; // Adjust the threshold as needed
    private int[] array;
    private int start;
    private int end;
    
    public ParallelForLoop(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) {
            System.err.println("INSIDE IF");
            for (int i = start; i < end; i++) {
                array[i] = array[i] + 2;
                System.out.println("Thread: " + Thread.currentThread().getName() +
                        ", Index: " + i + ", Value: " + array[i]);

            }
        } else {
            System.err.println("INSIDE ELSE");
            int mid = (start + end) / 2;
            System.err.println("MID: " + mid);
            
            System.out.println("Thread: " + Thread.currentThread().getName() +
                    ", Splitting task into two subtasks: [" + start + " - " + mid + "] and [" + mid + " - " + end + "]");
            
            invokeAll(new ParallelForLoop(array, start, mid), new ParallelForLoop(array, mid, end));
        }
		
	}
}

public class MaxCounters6 {
	public static void main(String[] args) {
		int[] array = new int[1000];
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelForLoop(array, 0, array.length));
        System.err.println(Arrays.toString(array));
	}
}
