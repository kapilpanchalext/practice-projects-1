import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String someText = "HelloWorld".toLowerCase().trim();
		
		System.err.println("SOME TEXT: " + someText);
		
		List<Character> textList = new ArrayList<>();
		
		textList = someText.chars().mapToObj((element) -> (char) element).collect(Collectors.toList());

		System.err.println("TEXT LIST: " + textList);
		
		ListIterator<Character> listIterator = textList.listIterator(2);
		Character previousValue = textList.get(0);
		while(listIterator.hasNext()) {
//			System.err.println("Previous Value: " + previousValue);
			Character nextValue = listIterator.next();
			
			System.err.println("NEXT VALUE: " + nextValue);
			if(nextValue.equals(previousValue)) {
				System.err.println("VALUES ARE SAME: " + listIterator.nextIndex());
			}
			
			
			previousValue = listIterator.previous();
			previousValue = listIterator.previous();
			
		}

	}

}
