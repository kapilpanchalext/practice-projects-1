import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		System.err.println("Hello World");
		
		List<String> firstList = new ArrayList<String>();
		List<String> secondList = new ArrayList<String>();
		List<String> thirdList = new ArrayList<String>();
		List<String> fourthList = new ArrayList<String>();
		
				
		firstList.add("123");
		firstList.add("456");
		firstList.add("789");
		firstList.add("012");
		firstList.add("345");
		
		secondList.add("123");
		secondList.add("456");
		secondList.add("789");
		secondList.add("012");
		secondList.add("345");
		
		thirdList.add("123");
		thirdList.add("456");
		thirdList.add("189");
		thirdList.add("012");
		thirdList.add("345");
		
		
		fourthList.add("123");
		fourthList.add("456");
		fourthList.add("789");
	
		System.err.println("First List"+ firstList);
		System.err.println("Second List"+ secondList);
		System.err.println("Third List"+ thirdList);
		System.err.println("Fourth List"+ fourthList);
		
		boolean allValuesExist1 = firstList.stream()
			    .allMatch(firstStudent -> secondList.stream()
			        .anyMatch(secondStudent -> secondStudent.equals(firstStudent)));
		
		System.err.println("ALL VALUES EXIST 1-2: " + allValuesExist1);
		
		boolean allValuesExist2 = thirdList.stream()
			    .allMatch(thirdStudent -> fourthList.stream()
			        .anyMatch(fourthStudent -> fourthStudent.equals(thirdStudent)));
		
		System.err.println("ALL VALUES EXIST 3-4: " + allValuesExist2);
		
		// Find and collect extra values in studentsList
		List<String> extraValues1 = fourthList.stream()
		    .filter(fourthStudent -> !thirdList.contains(fourthStudent))
		    .collect(Collectors.toList());
		
		System.err.println("EXTRA VALUES1: " + extraValues1);
		
		// Find and collect extra values in studentsList
		List<String> extraValues2 = thirdList.stream()
		    .filter(thirdStudent -> !fourthList.contains(thirdStudent))
		    .collect(Collectors.toList());
		
		System.err.println("EXTRA VALUES2: " + extraValues2);
		
		// Find and collect extra values in studentsList
		List<String> extraValues3 = firstList.stream()
		    .filter(firstStudent -> !secondList.contains(firstStudent))
		    .collect(Collectors.toList());
		
		System.err.println("EXTRA VALUES3: " + extraValues3);
		
		
	}

}
