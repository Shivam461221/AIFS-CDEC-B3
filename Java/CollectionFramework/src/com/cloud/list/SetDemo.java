package com.cloud.list;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> list = new HashSet<>();

		list.add("Mango");
		list.add("Banana");
		list.add("Apple");
		list.add("Watermelon");
		list.add("Watermelon");
		list.add("Watermelon");
		
		//list.remove("Mango");
		
		

		System.out.println(list);

		Set<String> list2 = new LinkedHashSet<>();

		list2.add("Mango");
		list2.add("Banana");
		list2.add("Apple");
		list2.add("Watermelon");
		list2.add("Watermelon");
		list2.add("Watermelon");
		list2.add("Papaya");
		
		System.out.println(list2.containsAll(list));

		System.out.println(list2);
		
		Set<String> list3 = new TreeSet<>();

		list3.add("Mango");
		list3.add("Banana");
		list3.add("Apple");
		list3.add("Watermelon");
		list3.add("Watermelon");
		list3.add("Watermelon");

		System.out.println(list3);
	}
}
