package enumdemo;

public class EnumDemo {
	    
	public static void main(String[] args) {
		double x = 1.0;
        double y = 2.0;
        
        for (Operation op : Operation.values())
            System.err.println(x + " " + op + " " + y + " = " + op.eval(x, y));
	}
}