import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryGap {
//	List<Character> listOfZeroCounts = charBinary
//	.stream()
//	.filter(element -> element == 0)
//	.collect(Collectors.toList());
	
	/*
	 * A binary gap within a positive integer N is any maximal sequence of
	 * consecutive zeros that is surrounded by ones at both ends in the binary
	 * representation of N.
	 * 
	 * For example, number 9 has binary representation 1001 and contains a binary
	 * gap of length 2. The number 529 has binary representation 1000010001 and
	 * contains two binary gaps: one of length 4 and one of length 3. The number 20
	 * has binary representation 10100 and contains one binary gap of length 1. The
	 * number 15 has binary representation 1111 and has no binary gaps. The number
	 * 32 has binary representation 100000 and has no binary gaps.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int N); }
	 * 
	 * that, given a positive integer N, returns the length of its longest binary
	 * gap. The function should return 0 if N doesn't contain a binary gap.
	 * 
	 * For example, given N = 1041 the function should return 5, because N has
	 * binary representation 10000010001 and so its longest binary gap is of length
	 * 5. Given N = 32 the function should return 0, because N has binary
	 * representation '100000' and thus no binary gaps.
	 * 
	 * Write an efficient algorithm for the following assumptions:
	 * 
	 * N is an integer within the range [1..2,147,483,647].
	 */

	public static void main(String[] args) {
		
//		int N = 1041;
		int N = 1610612737;
		String binaryNumber = Integer.toBinaryString(N);
		System.err.println("Binary Number: " + binaryNumber);
		
		//convert binary number to a list of char		
		List<Character> charBinary = binaryNumber.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//		System.err.println(charBinary);
				
		int count = 0;
		
		List<Integer> countList = new ArrayList<>();
		
		for(char c : charBinary) {
			if(c-'0' == 0) {
				count++;
//				System.err.println("List of Zero Count: " + count);
			} else {
				countList.add(count);
				count=0;
//				System.err.println("List of Zero Count: " + count);
			}
		}
		
//		System.err.println("List of Zero Count: " + countList);
		int value = Collections.max(countList);
		System.err.println(value);
		
//		long listOfZeroCounts = charBinary
//		.stream()
//		.filter(element -> element-'0' == 0)
//		.count();		
//		System.err.println(listOfZeroCounts);
		
		AtomicInteger counter = new AtomicInteger(0);
		List<Integer> streamList = charBinary
				.stream()
				.map(element -> element-'0')
				.flatMap(i -> i==0? Stream.of(0) : Stream.of(1))
				.peek(element -> System.err.println(element))
				.reduce(new ArrayList<>(), (list, elem) -> {
					if (elem == 0) {
		                counter.incrementAndGet();
		            } else {
		                list.add(counter.get());
		                counter.set(0);
		            }
					System.err.println("LIST: " + list);
		            return list;
		        }, (list1, list2) -> {
		            list1.addAll(list2);
		            System.err.println("LIST2 :" + list2);
		            System.err.println("LIST1: " + list1);
		            return list1;
		        });
				
		System.err.println("STREAM LIST: " + streamList);
		int maxValue = Collections.max(streamList);
		System.err.println("MAX VALUE: " + maxValue);
		
		
	}
}