package com.cloud.list;

import java.util.Stack;

public class StackDemo {
	
	public static void main(String[] args) {
		
		Stack<String> list = new Stack<>();
		//LIFO - Last In First Out
		
		list.push("Shivam");
		list.push("Swaleha");
		list.push("Sagar");
		list.push("Aditi");
		
		System.out.println(list);
		
		System.out.println(list.peek());
		list.pop();
		System.out.println(list);
		
		System.out.println(list.peek());
		
		
	}
}
