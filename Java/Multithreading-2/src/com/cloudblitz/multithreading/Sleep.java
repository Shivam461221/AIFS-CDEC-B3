package com.cloudblitz.multithreading;

public class Sleep extends Thread {
	
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("Count: "+i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Sleep t1 = new Sleep();
		
		t1.start();
	}
	
}
