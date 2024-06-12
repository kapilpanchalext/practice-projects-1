import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String someText = "HelloWorld".toLowerCase().trim();
		List<Character> someTextList = getCharacterListFromString(someText);
		List<Character> removedCharacterFromList = getUpdatedRemovedCharacterList(someTextList, 'w');
		System.err.println("SOME TEXT LIST: " + someTextList);
		System.err.println("REMOVED CHARACTER TEXT LIST: " + removedCharacterFromList);
	}

	private static List<Character> getUpdatedRemovedCharacterList(List<Character> someTextList, char c) {
		List<Character> list = new ArrayList<>(someTextList);
		List<Character> linkedList = new LinkedList<>(someTextList);
		
		list.sort(Comparator.naturalOrder());
		linkedList.sort((a, b) -> b.compareTo(a));
		linkedList.sort(Comparator.naturalOrder());
		list.containsAll(linkedList);
		
		ListIterator<Character> listIterator = list.listIterator(0);
		Integer count = 0;
		
		while(listIterator.hasNext()) {
			if(count >= 12) {
				break;
			}
			Character currentChar = listIterator.next();
			System.err.println("LIST ITERATOR: " + currentChar);
			
			
			if(currentChar.equals(c)) {
				listIterator.remove();
				listIterator.add('H');
				System.err.println("GET INDEX: " + listIterator.nextIndex());
			}

			if(listIterator.nextIndex() == 8) {
				listIterator.add('H');
			}
			
			count++;
		}
		
		return list;
	}

	private static List<Character> getCharacterListFromString(String someText) {
		List<Character> someTextList = someText.chars()
				.mapToObj((element) -> (char) element)
				.collect(Collectors.toList());
		return someTextList;
	}
}
