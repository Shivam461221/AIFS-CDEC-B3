package com.cloudblitz.multithreading;

import java.io.Serializable;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " count: "+i);
			
			try {
				Thread.sleep(500);
			}
			catch(InterruptedException e) {
				
			}
		}
	}
	
}
