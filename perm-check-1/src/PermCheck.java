import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermCheck {

	public static void main(String[] args) {
//		List<Integer> permOriginal = Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new));
		List<Integer> permOriginal = Arrays.asList(1, 3, 1, 4, 2, 3, 5, 4);
//		List<Integer> permOriginal = Arrays.asList(2, 3, 1, 5);
//		List<Integer> permOriginal = Arrays.asList(1);
//		List<Integer> permOriginal = Arrays.asList(1,2,3,4,5);
//		List<Integer> permOriginal = Arrays.asList(5);
//		List<Integer> permOriginal = Arrays.asList(999999999);
		
		System.err.println("PERM CHECK: " + permOriginal);
		List<Integer> permCheck = permOriginal.stream().distinct().collect(Collectors.toList());
		System.err.println("permCheck After: " + permCheck);
		
		if (permOriginal.size() != permCheck.size()) {
//			return 0;
		}
		
		if(permCheck.size()<=0) {
//			return 0;
		} else if(permCheck.size() == 1 && permCheck.get(0) == 1) {
			System.err.println("ELEMENT 1: " + 1);
//			return 1;
			System.exit(0);
		} else if(permCheck.size() == 1) {
			System.err.println("ELEMENT: " + (0));
//			return 0;
		} else {		
			Integer sumOfPermMissingElement = permCheck.stream().mapToInt(Integer::intValue).sum();
			Integer maxValueOfPermMissingElement = permCheck.stream().mapToInt(Integer::intValue).max().getAsInt();
			System.err.println("MAX VALUE: " + maxValueOfPermMissingElement);
//			List<Integer> permMissingElementSuperList = IntStream.range(1, maxValueOfPermMissingElement + 1).boxed().collect(Collectors.toList());
//			System.err.println("SUPER LIST: " + permMissingElementSuperList);
//			Integer sumOfSuperList = permMissingElementSuperList.stream().mapToInt(Integer::intValue).sum();
			Integer sumOfSuperList = maxValueOfPermMissingElement*(maxValueOfPermMissingElement+1)/2;
			
			System.err.println("permMissingElement SUM: " +  sumOfPermMissingElement);
			System.err.println("superList SUM: " + sumOfSuperList);
			
			Integer missingElement = sumOfSuperList - sumOfPermMissingElement;
			
			if(missingElement == 0) {
//				return 1;
				System.err.println("RETURN 1: " + 1);
			} else {
//				return 0;
				System.err.println("RETURN 1: " + 0);
			}
			
			
		}
	}
}
