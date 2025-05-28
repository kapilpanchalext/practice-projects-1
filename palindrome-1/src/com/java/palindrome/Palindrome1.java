package com.java.palindrome;

public class Palindrome1 {

	public static void main(String[] args) {
		final String palindrome = "MALAYALAM";
//		final String palindrome = "AAAAAA";
		
		char[] palindromeCharArray = palindrome.toCharArray();
		
//		// split the palindrome to half
//		
//		int centerVal = palindromeCharArray.length/2;
//		System.err.println(centerVal);
//		
//		// Split the char array to 2 and reverse the second array
//		
//		char[] palindrome1 = new char[centerVal];
//		char[] palindrome2 = new char[centerVal];
//		
//		int counter = palindromeCharArray.length - 1;
//		
//		for(int i=0; i<centerVal; i++) {
//			palindrome1[i] = palindromeCharArray[i];
//			palindrome2[i] = palindromeCharArray[counter--];
//		}
//		
//		System.err.println(Arrays.toString(palindrome1));
//		System.err.println(Arrays.toString(palindrome2));
		boolean isPalindrome = true;
//		for(int i=0;i<centerVal; i++) {
//			if(palindrome1[i] != palindrome2[i]) {
//				isPalindrome = false;
//			}
//		}
//		System.err.println("Is Palindrome: " + isPalindrome);
		
		

    for (int i = 0; i < palindrome.length() / 2; i++) {
        if (palindrome.charAt(i) != palindrome.charAt(palindrome.length() - 1 - i)) {
            isPalindrome = false;
            break;
        }
    }

    System.out.println("Is Palindrome: " + isPalindrome);
	}

}
