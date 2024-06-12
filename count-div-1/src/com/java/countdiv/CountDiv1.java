package com.java.countdiv;

public class CountDiv1 {
	public static void main(String[] args) {
//		int A = 0;
//		int B = 0;
//		int K = 11;
		
//		int A = 0;
//		int B = 2000000000;
//		int K = 2;
		
		int A = 6;
		int B = 11;
		int K = 2;
		
//		int A = 35;
//		int B = 175;
//		int K = 31;

		int index = 0;
		int result = 0;

//		for(int i=A; i<=B; i++) {
//			System.err.println("i: " + i);
//			if(i%K == 0 && i != 0) {
//				index = i;
//				break;
//			}
//		}
		
		for(int i=0; i<=B; i+=K) {
			System.err.println("i: " + i);
//			if(i%K == 0 && i != 0) {
//				index = i;
//				break;
//			}
			
			if(i>=A) {
				index=i;
				result = 1;
				break;
			}
		}

		System.err.println("INDEX: " + index);
		System.err.println((B-(index)));
		result += (int) Math.ceil((B-(index))/(K)); 

		if(A == 0 && B == 0) {
			result = 1;
		}
		
		System.err.println("INDEX: " + index);
		System.err.println("RESULT: " + result);
	}
}
