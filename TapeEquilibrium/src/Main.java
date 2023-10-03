import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
	
		int[] A = { 3, 1, 2, 4, 3 };
		
		int leftSum = 0;
	    int[] difference = new int[A.length-1];
		int totalSum = Arrays.stream(A).sum();

		int n = A.length;
		
		for(int i = 0 ; i <  n-1; i++) {
	        leftSum += A[i];
	        int rightSum = totalSum - leftSum;
	        difference[i] = Math.abs(leftSum - rightSum);
		}
		int minValue = Arrays.stream(difference).min().getAsInt();
	}
}


/*
 * public static void main(String[] args) {
		//SUPER LOOP
		
		int subLoop1 = 0;
		int subLoop2 = 0;
		
		int[] A = { 3, 1, 2, 4, 3 };
		int[] difference = new int[A.length-1];
		
		int leftSum = 0;
	    int minValue1 = Integer.MAX_VALUE;
		
		int totalSum = Arrays.stream(A).sum();
		System.err.println("TOTAL SUM: " + totalSum);
		System.err.println("MIN VALUE: " + minValue1);
		int n = A.length;
		
		for(int i = 1 ; i < n; i++) {
			
//			for(int j = 0; j < i; j++) {
//				subLoop1 += A[j];				
//			}
//			
//			for(int k = n-1; k > i-1; k--) {
//				subLoop2 += A[k];				
//			}
//			
//			difference[i-1] = Math.abs(subLoop1 - subLoop2);
//			subLoop1 = 0;
//			subLoop2 = 0;
	        leftSum += A[i];
	        int rightSum = totalSum - leftSum;
	        int currentDifference = Math.abs(leftSum - rightSum);
	        minValue1 = Math.min(minValue1, currentDifference);
		}
		
//		int minValue = Arrays.stream(difference).min().getAsInt();
		System.err.println("MIN VALUE: " + minValue1);
	}
}

 * 
 * 
 * */

/*
public class Main {

	public static void main(String[] args) {
		//SUPER LOOP
		
		int subLoop1 = 0;
		int subLoop2 = 0;
		
		int[] A = { 3, 1, 2, 4, 3 };
		int[] difference = new int[A.length-1];
		
		int n = A.length;
		
//		System.err.println("N: " + n);
		
		for(int i = 1 ; i < n; i++) {
			
//			System.err.println("    Ai [" + i + "] ");
			
			for(int j = 0; j < i; j++) {
//				System.err.println("Aj [" + j + "] ");
				subLoop1 += A[j];				
			}
//			System.err.println("SUBLOOP 1 SUM: " + subLoop1);
//			System.err.println();
			
			for(int k = n-1; k > i-1; k--) {
//				System.err.println("Ak [" + k + "] ");
				subLoop2 += A[k];				
			}
			
			difference[i-1] = Math.abs(subLoop1 - subLoop2);
//			System.err.println("SUBLOOP 2 SUM: " + subLoop2);
			subLoop1 = 0;
			subLoop2 = 0;		 
		}
//		for(int l=0;l<difference.length;l++) {
//			System.err.println("Difference: " + difference[l]);
//		}
		
		int minValue = Arrays.stream(difference).min().getAsInt();
		System.err.println("MIN VALUE: " + minValue);
	}
}*/

