package cyclic_rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CyclicRotation {
/*
//	public static void main(String[] args) {
////		Integer[] A = {3, 8, 9, 7, 6};
////		Integer[] A = {0, 0, 0};
////		Integer[] A = {1, 2, 3, 4};
//		Integer[] A = {-1,-1000};
////		int K = 3;
////		int K = 0;
////		int K = 4;		
//		int K = 1;
//		
//		List<Integer> integerList = Arrays.asList(A);
//		System.err.println(integerList);
//		
//		List<Integer> newIndexList = new ArrayList<>();
//		
////		if(K < A.length) {
//			for(int i=0; i<A.length; i++) {
//				if((i+K) > A.length) {
//					int val = ((i+K) - A.length)-1;
//					newIndexList.add(val);
//					System.err.println("IF IF (i+k): " + val);
//				} else {
//					int val = ((i+K)-1);
//					newIndexList.add(val);
//					System.err.println("ELSE IF (i+k): " + val);
//				}
//			}
////		} else {
////			for(int i=1; i<=A.length; i++) {
////				if((i+K) > A.length) {
////					System.err.println("ELSE IF (i+k): " + ((i+K)- A.length-1));
////					newIndexList.add((i+K) - A.length-1);
////				} else {
////					System.err.println("ELSE ELSE (i+k)" + ((i+K)- A.length-1));
////					newIndexList.add(i+K-1);
////				}			
////			}		
////		}
//		
//		System.err.println("NEW INDEX LIST: " + newIndexList);
//		
////		if(K == 0) {
////			for(int k=0;k<A.length;k++) {
////				System.err.println("ROLLED LIST: " + A[k]);
////			}
////		} else {
////		
////		int[] rolledList = new int[A.length];
////		
////		for(int j=0; j<A.length; j++) {
////			rolledList[j] = A[newIndexList.get(j)];
////		}
////		
////		for(int k=0;k<rolledList.length;k++) {
////			System.err.println("ROLLED LIST: " + rolledList[k]);
////		}
////		}
//		
//	}*/
	
	/*
	public static void main(String[] args) {
		
	Integer[] A = {3, 8, 9, 7, 6};
//	Integer[] A = {0, 0, 0};
//	Integer[] A = {1, 2, 3, 4};
//	Integer[] A = {-1,-1000};
	int K = 3;
//	int K = 0;
//	int K = 4;		
//	int K = 1;
	
	
	Integer[] array = new Integer[A.length];
	Arrays.setAll(array, (i -> ((i + 1)-1)));
	List<Integer> integerList = Arrays.asList(array);
	
	List<Integer> newIntegerList = new ArrayList<Integer>(Collections.nCopies(A.length, 0));
	System.err.println("NEW LIST: " + newIntegerList);
		for(int i=0;i<K;i++) {
			
			newIntegerList.set(newIntegerList.get(0), A.length-1);

			
			for(int j=1; j<A.length;j++) {
//				System.err.println(newIntegerList.get(j));
//				newIntegerList.set(newIntegerList.get(j), newIntegerList.get(j));
			}
			
			System.err.println("NEW INDICES LIST: " + newIntegerList);
		}		
	}*/
	
	public static void main(String[] args) {
		
//	Integer[] A = {3, 8, 9, 7, 6};
//	Integer[] A = {0, 0, 0};
	Integer[] A = {1, 2, 3, 4};
//	Integer[] A = {-1,-1000};
//	int K = 3;
//	int K = 0;
	int K = 4;		
//	int K = 1;
	
	
	Integer[] array = new Integer[A.length];
	Arrays.setAll(array, (i -> ((i + 1)-1)));
	List<Integer> integerList = Arrays.asList(array);
	
	List<Integer> newIntegerList = new ArrayList<Integer>(Collections.nCopies(A.length, 0));
	
	
//		System.err.println(integerList);
		for(int i=0;i<K;i++) {		
			for(int j=1 ;j<integerList.size();j++) {
				newIntegerList.set(j, integerList.get(j-1));
			}
			
			newIntegerList.set(0, integerList.get(integerList.size()-1));
			
			for(int k=0; k<integerList.size(); k++) {
				integerList.set(k, newIntegerList.get(k));
			}
			
//			System.err.println("INT LIST: " + integerList);
		}
		
		int[] response = new int[integerList.size()];
		
		for(int x=0;x<integerList.size(); x++) {
			response[x] = A[integerList.get(x)];
			System.err.println(response[x]);
		}
	}
}