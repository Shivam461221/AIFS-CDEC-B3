package com.cloud.list;

import java.util.LinkedList;
import java.util.List;

public class Linked {
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		
		list.add("Mango");
		list.add("Banana");
		
		list.addFirst("Apple");
		list.addLast("Watermelon");
		
		System.out.println(list);
		
		list.removeLast();
		System.out.println(list);
	}
}
