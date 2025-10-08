package com.cloudblitz.multithreading;

public class Priority extends Thread{
	
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName()+" Count: "+i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//Max_Priority - 10
	//Norm-Priority - 5
	//Min_Priority - 1
	
	public static void main(String[] args) {
		Priority t1 = new Priority();
		Priority t2 = new Priority();
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}
