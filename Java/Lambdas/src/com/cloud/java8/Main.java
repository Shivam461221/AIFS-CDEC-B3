package com.cloud.java8;

public class Main {
	public static void main(String[] args) {
		
		//Runnable r = new MyRunnable();
		
//		Runnable r = ()->{
//			for (int i = 0; i < 10; i++) {
//				System.out.println("Child thread");
//			}
//		};
//		
//		Thread t1 = new Thread(r);
		
//		Thread t1 = new Thread(new Runnable() {
//			public void run() {
//				for (int i = 0; i < 10; i++) {
//					System.out.println("Child thread");
//				}
//			}
//		});
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<10;i++) {
				System.out.println("Child thread");
			}
		});
		
		t1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
