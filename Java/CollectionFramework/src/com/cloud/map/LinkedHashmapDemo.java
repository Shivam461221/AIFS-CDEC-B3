package com.cloud.map;

import java.util.LinkedHashMap;

public class LinkedHashmapDemo {
	public static void main(String[] args) {
		
		LinkedHashMap<String, Integer> students = new LinkedHashMap<>();
		
		students.put("Sagar", 85);
		students.put("Swaleha", 96);
		students.put("Aditi", 80);
		
		System.out.println(students);
		
	}
}
