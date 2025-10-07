package com.cloudblitz.wrapper;

public class ObjectAndString {
	public static void main(String[] args) {
		
		Integer x = 10;
		
		
		//Object to String
		String s = x.toString();
		
		//String to Object
		Integer y = Integer.valueOf(s);
		
		
		//Auto-boxing - primitive to object type conversion automatically
		Integer z = x;
		
		//Auto-unboxing- Object to primitive type conversion automatically
		int d = z;
	}
}
