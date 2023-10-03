package frog_jmp;

public class FrogJmp {

	public static void main(String[] args) {

		long start = System.nanoTime();
		
		int X = 10;
		int Y = 85;
		int D = 30;
		
		int answer = ((Y-X)/D);		
		
		int modAns = (Y-X) % D;		
		
		int value = 0;
		
		if(modAns == 0) {
			value = answer;
		} else {
			value = answer+1;
		}
		
		long end = System.nanoTime();
		
		System.err.println("ANSWER: " + value);
		
		System.err.println("TIME TO EXECUTE (us): " + (end-start)/1000.0);
	}
}