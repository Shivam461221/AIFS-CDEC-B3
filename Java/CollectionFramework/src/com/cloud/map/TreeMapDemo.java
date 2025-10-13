package com.cloud.map;

import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<Integer, String> list = new TreeMap<>();
		
		list.put(101, "Sagar");
		list.put(111, "Swaleha");
		list.put(112, "Aditi");
		list.put(115, "Yash");
		list.put(117,  "Sagar");
		
		System.out.println(list);
	}
}
