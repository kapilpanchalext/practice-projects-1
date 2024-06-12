package com.java.tower;

public class TowerOfHanoi2 {
	public static void main(String[] args) {
		solveTower(3, 'A', 'B', 'C');
	}

	private static void solveTower(int n , char fromPeg, char toPeg, char auxPeg) {
		// baseCase
		// When zero discs then return;
		if(n == 0) {
			return;
		}
		
		//recursive case
		solveTower(n-1, fromPeg, auxPeg, toPeg);
		System.err.println("The Disc no " + n + " to be moved from peg " + fromPeg + " to Peg " + toPeg);
		solveTower(n-1, auxPeg, fromPeg, toPeg);
	}
}
