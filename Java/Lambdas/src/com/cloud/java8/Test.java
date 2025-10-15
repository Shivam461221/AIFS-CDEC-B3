package com.cloud.java8;

public class Test {

	public static void main(String[] args) {
		//Message m = new A();
		
		//m.greeting();
		
		Message m = ()->{
			System.out.println("Hello");
			System.out.println("From Message");
		};
		
		m.greeting();
		
		Sum s = (x, y)->System.out.println(x+y);
		
		s.add(10, 20);
		
		Square sq = (a)->System.out.println(a*a);
		
		sq.getSquare(3);
	}

}
