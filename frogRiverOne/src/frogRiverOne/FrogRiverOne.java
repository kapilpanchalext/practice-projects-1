package frogRiverOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FrogRiverOne {
	public static void main(String[] args) {

		int X = 5;
		Integer[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		List<Integer> integerList = Arrays.asList(A);
		List<Integer> Y = new ArrayList<>(Collections.nCopies(integerList.size()-1, 0));

		System.err.println("IntegerList: " + integerList);

		AtomicInteger freqCounter = new AtomicInteger(1);
		
		Y.add(0);
		System.err.println("Y: " + Y);
		
		for(int i=1; i<=X; i++) {
			for(int a=0; a<integerList.size(); a++) {
				System.err.println("IntegerList: " + integerList.get(a));
				if(i == integerList.get(a)) {
					Y.set(i, freqCounter.getAndIncrement());
				}
			}
			freqCounter.set(1);
			System.err.println("Freq: " + Y);
		}
	}
}