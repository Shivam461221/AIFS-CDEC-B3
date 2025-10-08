package com.cloudblitz.multithreading;

public class join extends Thread{
	
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Count: "+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		join t1 = new join();
		
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread");
	}
}
