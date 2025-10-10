package com.cloud.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		System.out.println(list);
		
		list.add(12);
		list.add(13);
		list.add(22);
		list.add(10);
		System.out.println(list);
		
		list.remove(0);
		
		System.out.println(list);
		
		System.out.println(list.get(0));
		
		list.set(0, 33);
		
		//Collections.sort(list);  //Sorting in Ascending
		
		//Collections.sort(list, Collections.reverseOrder());  //in descending
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		for(Integer i: list) {
			System.out.println(i);
		}
		
		for(int i= 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
