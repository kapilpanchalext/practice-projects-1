package com.java.bitwise;

public class BitwiseOperator1 {
	public static void main(String[] args) {
		
		int num = 3;
		int shifted = num << 1;
		
		System.err.println("NUM: " + Integer.toBinaryString(num));
		System.err.println("SHIFTED: " + Integer.toBinaryString(shifted));
		
		for(int i=0; i<10; i++) {
			System.err.println("SHIFTED: " + Integer.toBinaryString(num << i) + " : " + (num << i));
		}
		
		// BITWISE AND
		int a = 5;  // Binary: 101
		int b = 3;  // Binary: 011
		System.err.println("A: " + Integer.toBinaryString(a));
		System.err.println("B: " + Integer.toBinaryString(b));
		int result = a & b;  // Binary: 001 (Decimal: 1)
		System.err.println("A&B: " + Integer.toBinaryString(result));
		System.out.println(result);  // Output: 1
		
		// USE CASE: Checking If a Bit Is Set 
		int number = 6;  // Binary: 110
		int mask = 2;    // Binary: 010 (decimal 2, corresponding to the second bit)
		int result1 = number & mask;
		if (result1 != 0) {
		    System.out.println("The second bit is set.");
		} else {
		    System.out.println("The second bit is not set.");
		}
		
		// BITWISE AND
		int a2 = 5;  // Binary: 101
		int b2 = 3;  // Binary: 011
		System.err.println("A: " + Integer.toBinaryString(a2));
		System.err.println("B: " + Integer.toBinaryString(b2));
		int result2 = a2 | b2;  // Binary: 001 (Decimal: 1)
		System.err.println("A|B: " + Integer.toBinaryString(result2));
		System.out.println(result2);  // Output: 1
		
		// USE CASE: Combining Flags
		int readPermission = 1;    // Binary: 001
		int writePermission = 2;   // Binary: 010
		int executePermission = 4; // Binary: 100

		// Combine read and execute permissions
		int permissions = readPermission | executePermission; // Binary: 101 (Decimal: 5)
		System.err.println("PERMISSIONS: " + permissions);
		
		// BITWISE XOR
		int a3 = 5;  // Binary: 101
		int b3 = 3;  // Binary: 011
		int result3 = a3 ^ b3;  // Binary: 110 (Decimal: 6)
		System.out.println(result3);  // Output: 6
		
		//USE CASE: Toggling Bits
		int number3 = 10;  // Binary: 1010

		// Toggle the second bit (from the right)
		int mask3 = 1 << 1;  // Binary: 0010
		int result4 = number3 ^ mask3;  // Toggle the second bit
		System.out.println(Integer.toBinaryString(result4));  // Output: 1000
		
		// BITWISE NOT
		int a5 = 5;  // Binary: 0000 0101
		int result5 = ~a5;  // Binary: 1111 1010 (Decimal: -6)
		System.out.println(result5);  // Output: -6
		
		int number6 = 10;  // Binary: 0000 1010

		// Flip all bits
		int result6 = ~number6;  // Binary: 1111 0101 (Decimal: -11)
		System.out.println(Integer.toBinaryString(result6));
		
		
		int[] numbers = {2, 3, 4, 5, 6};
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int pair = (1 << i) | (1 << j);
                System.out.println(numbers[i] + "-" + numbers[j]);
//                System.err.println("PAIR: " + pair);
            }
        }
	}
}
