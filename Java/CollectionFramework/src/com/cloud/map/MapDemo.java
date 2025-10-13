package com.cloud.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	//HashMap, LinkedeHashMap, TreeMap
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> list = new HashMap<>();
		
		list.put(101, "Sagar");
		list.put(111, "Swaleha");
		list.put(112, "Aditi");
		list.put(115, "Yash");
		list.put(117,  "Sagar");
		
		System.out.println(list);
		
		list.remove(111);
		System.out.println(list);
		
		System.out.println(list.get(117));
		
		System.out.println(list.size());
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.containsKey(111));
		
		System.out.println(list.containsValue("Sagar"));
		
		for(Map.Entry<Integer, String> entry : list.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		System.out.println("------------------------------------");
		
		for(Integer key: list.keySet()) {
			System.out.println(key +" : "+list.get(key));
		}
		
		System.out.println("------------------------------------");
		
		list.forEach((key, value)->System.out.println(key+" : "+value));
		
		
		
	
	}
}
