package com.java.math;

import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

public class FourierTransformsString {
	public static void main(String[] args) {
		String hello = "hello";
		
		int paddedLength = Integer.highestOneBit(hello.length() - 1) << 1;
	    double[] helloDouble = new double[paddedLength];
		
		for(int i=0;i < hello.length(); i++) {
			helloDouble[i] = (double) hello.charAt(i);
		}
		
		System.err.println("Hello: " + Arrays.toString(helloDouble));
		
		String world = "world";
		
		int paddedLengthWorld = Integer.highestOneBit(world.length() - 1) << 1;
	    double[] worldDouble = new double[paddedLengthWorld];
		
		for(int i=0;i < world.length(); i++) {
			worldDouble[i] = (double) world.charAt(i);
//			worldDouble[i] = i<3 ? 1.0 : 0.0;
		}
		
		System.err.println("World: " + Arrays.toString(worldDouble));

		FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	    try {           
	        Complex[] fftA = transformer.transform(helloDouble, TransformType.FORWARD);
	        Complex[] fftB = transformer.transform(worldDouble, TransformType.FORWARD);
	        System.err.println(Arrays.toString(fftA));
	        System.err.println(Arrays.toString(fftB));
	        
	        Complex[]c = new Complex[helloDouble.length];
	        
	        for(int i=0;i< helloDouble.length; i++) {
//	        	c[i] = fftA[i].add(fftB[i]).multiply(new Complex(0.4, 0));
	        	c[i] = fftA[i].add(fftB[i]);
//	        	c[i] = fftA[i].multiply(fftB[i]);
//	        	c[i] = fftA[i].add(fftB[i]).divide(Complex.ONE.add(Complex.ONE));
//	        	c[i] = fftA[i].subtract(fftB[i]);
	        }
	        
	        System.err.println("C: " + Arrays.toString(c));
	        
	        Complex[]ifftC = new Complex[helloDouble.length];
	        
	        ifftC = transformer.transform(c, TransformType.INVERSE);
	        System.err.println("IFFTC: " + Arrays.toString(ifftC));
	        
	        // Convert the real part of the complex numbers to integers using ceiling
	        int[] roundedValues = new int[ifftC.length];
	        for (int i = 0; i < ifftC.length; i++) {
	            roundedValues[i] = (int) Math.round(ifftC[i].getReal());
	        }

	        System.err.println("ROUNDED VALUES: " + Arrays.toString(roundedValues));
	        
	        // Convert the rounded values to characters and concatenate to form a string
	        StringBuilder result = new StringBuilder();
	        for (int value : roundedValues) {
	            result.append((char) value);
	        }

	        System.err.println("Result: " + result.toString());
	    } catch (IllegalArgumentException e) {
	        System.out.println(e);
	    }
	}
}
