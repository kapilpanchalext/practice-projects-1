import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//public class Main {
//	private static int missingValue;
//	
//
////	public int getValue() {
////		return value;
////	}
////
////
////	public void setValue(int value) {
////		this.value = value;
////	}
//
//
//	public static void main(String[] args) {	
//		
//		/*
//		List<Integer> aList = Arrays.stream(A)
//                .boxed()
//                .sorted()
//                .filter(e -> {
//                	if(e < 3) {
//                		value = e;
//                		return true;
//                	} else {
//                		return false; 
//                	}               	
//                })
//                .peek(e-> System.err.println(value))
//                .collect(Collectors.toList());
//		
//		System.err.println("ALIST: " + aList);
//		System.err.println("VALUE: " + value);
//		*/
//		
//		int [] A = {2,3,1,5};
//		
//		List<Integer> aList = Arrays.stream(A)
//                .boxed()
//                .sorted()
//                .collect(Collectors.toList());
//		
//		if(aList.size() <= 0) {
////			return 1;
//		}
//		
//		if(aList.size() == 1) {
////			return aList.get(0)+1;
//		}
//		
//		System.err.println("ALIST: " + aList);
//		
//		List<Integer> resultsList = aList.stream().filter(e -> {
//			
//			int currentIndex = aList.indexOf(e);
//			int prevIndex = 0;
//			
//			if (currentIndex > 0) {
//				prevIndex = currentIndex-1;
//			}
//			
//			int currentValue = e;
//			int prevValue = aList.get(prevIndex);
//			
//			if((currentValue - prevValue) > 1) {
//				System.err.println("VALUE IS: " + (currentValue - prevValue));
//				missingValue = ((currentValue - prevValue)/2 + prevValue);				
//			}
//			
//			if (missingValue == 0) {
//				missingValue = aList.get(0) - 1;
//			}
//			
//			return true;
//			}).collect(Collectors.toList());
//		System.err.println("MISSING VALUE: " + missingValue);
//	}
//
//}


public class Main {
	private static int missingValue;

	public static void main(String[] args) {	
		
		int [] A = {5,3,1,2};
		
		int n = A.length;
		
		int sum = ((n+1)*(n+2))/2;
		
		if(n <= 0) {
			missingValue = 1;
		}
		
		if(n == 1) {
			if(A[0] != 1) {
				missingValue = 1;
			}
			missingValue = A[0]+1;
		}
		
		System.err.println("SUM: " + sum);
		
		for(int element : A) {
			sum = sum - element;	
		
			if (sum == 0) {
				missingValue = element + 1;
			}
		}
		missingValue = sum;
		
		System.err.println("MISSING VALUE: " + missingValue);
	}
}
