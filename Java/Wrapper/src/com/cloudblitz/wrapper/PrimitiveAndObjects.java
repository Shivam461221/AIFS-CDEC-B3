package com.cloudblitz.wrapper;

public class PrimitiveAndObjects {
	
	public static void main(String[] args) {
		int x = 10;
		
		
		//Primitive to Object (boxing)
		Integer y = Integer.valueOf(x);
		
		
		//Object to primitive (Unboxing)
		int z = y.intValue();
		
		
		double a = 10.0;
		
		Double b = Double.valueOf(a);
		
		double c = b.doubleValue();
	}
}
