package com.java.fouriertransforms;

import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

public class FourierTransformString1 {
	public static void main(String[] args) {
		String hello = "hello";
		
		int paddedLength = Integer.highestOneBit(hello.length() - 1) << 1;
	    double[] helloDouble = new double[paddedLength];
		
		for(int i=0;i < hello.length(); i++) {
			helloDouble[i] = (double) hello.charAt(i);
		}
		
		System.err.println("Hello: " + Arrays.toString(helloDouble));
		
		FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	    try {           
	    	Complex[] fftA = transformer.transform(helloDouble, TransformType.FORWARD);

	        // Rotate frequencies
	        Complex[] rotatedFrequencies = rotate(fftA, 1); // Rotate by 2 for example

	        // Compute inverse Fourier transform
	        Complex[] ifftC = transformer.transform(rotatedFrequencies, TransformType.INVERSE);
	        System.err.println(Arrays.toString(ifftC));

	        // Convert complex values to characters
	        char[] rotatedChars = new char[hello.length()];
	        for (int i = 0; i < hello.length(); i++) {
	            rotatedChars[i] = (char) Math.round(ifftC[i].getReal());
	        }

	        // Print the rotated text
	        System.out.println("Rotated Text: " + new String(rotatedChars));
	    } catch (IllegalArgumentException e) {
	        System.out.println(e);
	    }
	}
	
	private static Complex[] rotate(Complex[] frequencies, int shift) {
        Complex[] rotated = new Complex[frequencies.length];
        for (int i = 0; i < frequencies.length; i++) {
            rotated[(i + shift) % frequencies.length] = frequencies[i];
        }
        return rotated;
    }
}
