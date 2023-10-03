import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
//	for(int i=0;i<A.length;i++) {			
//	System.err.println("LIST A: " + A[i]);			
//}		
//int largest = Arrays.stream(A).max().getAsInt();
//System.err.println(largest);
//
//int smallest = Arrays.stream(A).min().getAsInt();
//System.err.println(smallest);
	public static void main(String[] args) {
		Integer[] A = {1, 3, 6, 4, 1, 2};
				
		List<Integer> integerList = Arrays.asList(A);
		
		System.err.println(integerList);
		
		int largest = Collections.max(integerList);
		
		int smallest = Collections.min(integerList);
		
		Set<Integer> uniqueNumbers = integerList.stream().map(element -> {return element;}).collect(Collectors.toSet());
		
		System.err.println("UNIQUE NUMBERS: " + uniqueNumbers);
		int sumOfGivenSet = uniqueNumbers.stream().reduce(0, Integer::sum);
		
		System.err.println(sumOfGivenSet);
		
		List<Integer> fullList = IntStream.rangeClosed(smallest, largest).boxed().toList();
		System.err.println(fullList);
		
		int sumOfRange = fullList.stream().reduce(0, Integer::sum);
		System.err.println(sumOfRange);
				
		int value = sumOfRange - sumOfGivenSet;
		
		System.err.println(value);
		
		if(value < 0 ) {
			value = 1;
		} else if(value == 0 ) {
			value = largest + 1;
		}		
	}
}