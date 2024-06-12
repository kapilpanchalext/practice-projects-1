package com.java.math;

import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;



public class MathLibrary {
	public static void main(String[] args) {
		double [] a = new double[4];
	    a[0] = 4.0;
	    a[1] = 1.0;
	    a[2] = 0.0;
	    a[3] = 0.0;
	    
	    double [] b = new double[4];
	    b[0] = 3.0;
	    b[1] = 7.0;
	    b[2] = 0.0;
	    b[3] = 0.0;

	    
	    
	    FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	    try {           
	        Complex[] fftA = transformer.transform(a, TransformType.FORWARD);
	        Complex[] fftB = transformer.transform(b, TransformType.FORWARD);

	        System.err.println(Arrays.toString(fftA));
	        System.err.println(Arrays.toString(fftB));
	        
	        Complex[] c = new Complex[4];
	        
	        for(int i=0;i<fftA.length; i++) {
	        	c[i] = fftA[i].multiply(fftB[i]);
	        }
	        
	        System.err.println(Arrays.toString(c));
	        
	        Complex[]ifftC = new Complex[4];
	        
	        ifftC = transformer.transform(c, TransformType.INVERSE);
	        System.err.println("IFFTC: " + Arrays.toString(ifftC));
	        
	        double ans = 0.0;
	        int factor = 100;
	        
	        for (Complex element : ifftC) {
	        	ans += element.getReal()*factor;
	        	factor = factor/10;
	        }

	        System.err.println("ANSWER: " + ans);
	    } catch (IllegalArgumentException e) {
	        System.out.println(e);
	    }
	}
}
