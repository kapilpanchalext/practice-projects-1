package com.java.string;

import java.util.Collections;

public class StringUtilsJava {
	public static void main(String[] args) {
		String.join(",", Collections.nCopies(3, "?"));
		
		System.err.println(String.join(",", Collections.nCopies(3, "?")));
		System.err.println(Collections.nCopies(3, "?"));

	}
}
