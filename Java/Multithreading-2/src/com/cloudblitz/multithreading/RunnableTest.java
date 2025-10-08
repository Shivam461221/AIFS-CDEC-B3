package com.cloudblitz.multithreading;

public class RunnableTest {
	
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		
		t1.setName("Thread 1 ");
		t2.setName("Thread 2 ");
		
		t1.start();
		
		t2.start();
		
	}
	
}
