package com.java.tower;

import java.util.LinkedList;
import java.util.Queue;

public class TowerOfHanoi {
	public static void main(String[] args) {
		
		Queue<Integer> towerA = new LinkedList<>();
		Queue<Integer> towerB = new LinkedList<>();
		Queue<Integer> towerC = new LinkedList<>();
		
		towerA.add(2);
		towerA.add(1);
		towerA.add(3);
		
		System.err.println("TOWER A: " + towerA);
		
		towerC.add(towerA.poll());		
//		towerC.add(towerA.poll());
//		towerB.add(towerA.poll());
//		towerA.add(towerC.poll());
//		towerA.add(towerC.poll());
//		towerC.add(towerB.poll());
//		towerC.add(towerA.poll());
//		
//		towerB.add(towerA.poll());
//		
//		towerA.add(towerC.poll());
//		towerB.add(towerC.poll());
//		towerB.add(towerA.poll());
		
		System.err.println("TOWER A: " + towerA);
		System.err.println("TOWER B: " + towerB);
		System.err.println("TOWER C: " + towerC);
	}
}
