package com.cloudblitz.wrapper;

public class PrimitiveAndString {
	
	
	public static void main(String[] args) {
		
		int x = 123;
		
		
		//Primitive to string
		String s = Integer.toString(x);
		
		//string to primitive
		int y = Integer.parseInt(s);
		
		//--------------------------------
		
		double a = 12.2;
		
		String b = Double.toString(a);
		
		double c = Double.parseDouble(b);
		
	}
}
