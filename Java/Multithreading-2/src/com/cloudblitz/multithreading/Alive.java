package com.cloudblitz.multithreading;

public class Alive extends Thread{
	
	
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
		Alive t1 = new Alive();
		
		System.out.println("Before start: "+t1.isAlive());
		
		t1.start();
		
		System.out.println("Mid : "+t1.isAlive());
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End : "+t1.isAlive());
		
		System.out.println("Main thread");
	}
}
