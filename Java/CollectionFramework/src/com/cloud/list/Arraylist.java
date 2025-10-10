package com.cloud.list;

import java.util.ArrayList;

public class Arraylist {
	
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<>();
		
		fruits.add("Mango");
		
		fruits.add("Banana");
		
		fruits.add("Pineapple");
		
		fruits.add("Apple");
		
		System.out.println(fruits);
		
		ArrayList<String> fruits2 = new ArrayList<>(fruits);
		
		System.out.println(fruits2);
		
		System.out.println(fruits.isEmpty());
		
		System.out.println(fruits.subList(0, 2));
		
		int index = fruits.indexOf("Mango");
		
		System.out.println(index);
		
		System.out.println(fruits.get(fruits.size()-1));
		
		
	}
}
