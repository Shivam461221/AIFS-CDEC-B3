package com.cloudblitz.multithreading;

public class Test {
	
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		
		MyThread t2 = new MyThread();
		
		MyThread t3 = new MyThread();
		
		t1.setName("Thread 1 ");
		
		t2.setName("Thread 2 ");
		
		t3.setName("Thread 3 ");
		
		t1.start();  //internally calls its run method
		
		t2.start();
		
		t3.start();
	}
}
