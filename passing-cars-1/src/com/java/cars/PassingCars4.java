package com.java.cars;

public class PassingCars4 {

	public static void main(String[] args) {
		int eastCars = 0;
	    int passingPairs = 0;
	    int[] A = {0, 1, 0, 1, 1};
	    for (int car : A) {
	        if (car == 0) {
	            eastCars++;
	        } else {
	            passingPairs += eastCars;
	        }
	        
	        if (passingPairs > 1000000000) {
//	            return -1; // Return -1 if passingPairs exceeds 1,000,000,000
	        }
	    }
	    System.err.println(passingPairs);
	}

}
