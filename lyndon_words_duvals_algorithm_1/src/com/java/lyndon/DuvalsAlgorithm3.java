package com.java.lyndon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuvalsAlgorithm3 {
	public static void main(String[] args) {
	    int n=2;
	    char S[]={'0', '1', '2', '3', '4'};
	    int k = S.length;
	    Arrays.sort(S); 
	 
	    // To store the indices 
	    // of the characters 
	    List<Integer> w = new ArrayList<Integer>(); 
	    w.add(-1);
	    // Loop till w is not empty     
	    while(w.size() > 0) {
	 
	      // Incrementing the last character
	      Integer value = w.get(w.size()-1); // get value
	      value = value + 1; // increment value
	      w.set(w.size()-1, value); // replace value
	      int m = w.size();
	      if(m == n) {
	        String str="";
	        for(int i = 0; i < w.size(); i++) {
	          value = w.get(i);
	          str += S[value];
	        }
	        System.out.println(str);
	      }
	 
	      // Repeating w to get a 
	      // n-length string
	      while(w.size() < n) {
	        value = w.size() - m;
	        value = w.get(value);
	        w.add(value);
	      }
	 
	      // Removing the last character 
	      // as long it is equal to 
	      // the largest character in S
	      while(w.size() > 0 && w.get(w.size() - 1) == k - 1) {
	        w.remove(w.size()-1);
	      }
	    }
	}
}
