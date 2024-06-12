package com.java.garbage;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollection {
	public static void main(String[] args) throws InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		long availableBytes = runtime.freeMemory();
		System.err.println("Available Memory At Start: " + (availableBytes/1024) + " k");
		
		List<Customer> customers = new ArrayList<>();
		
		for(int i=0; i<1000000; i++) {
			customers.add(new Customer("John"));
		}
		
		availableBytes = runtime.freeMemory();
		System.err.println("Available Memory When Customers Created: " + (availableBytes/1024) + " k");
		
		customers = new ArrayList<>();
		
		availableBytes = runtime.freeMemory();
		System.err.println("Available Memory When Customers No Longer Referenced: " + (availableBytes/1024) + " k");

		Thread.sleep(1000);
		availableBytes = runtime.freeMemory();
		System.err.println("Available Memory 1 Second Later: " + (availableBytes/1024) + " k");
		
		System.gc();
		availableBytes = runtime.freeMemory();
		System.err.println("Available Memory After GC Command: " + (availableBytes/1024) + " k");

		
	}
}
