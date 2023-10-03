public class TimeComplexity {

	public static void main(String[] args) {

		long start =  System.nanoTime();
		System.err.println("Start Time: " + start);

		for(int i=0;i<10000;i++) {
			System.err.println(i);
		}			
		
		long end = System.nanoTime();
		System.err.println("End Time: " + end);
		System.err.println("TIME TO EXECUTE (ms): " + (end-start)/1000000.0);
	}
}