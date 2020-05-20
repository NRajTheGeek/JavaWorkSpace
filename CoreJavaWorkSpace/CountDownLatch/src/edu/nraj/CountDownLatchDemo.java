package edu.nraj;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);
		
		Worker thread1 = new Worker(100, latch, "Thread 1");
		Worker thread2 = new Worker(200, latch, "Thread 2");
		Worker thread3 = new Worker(300, latch, "Thread 3");
		Worker thread4 = new Worker(400, latch, "Thread 4");
		Worker thread5 = new Worker(500, latch, "Thread 5");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		latch.await();
		System.out.println("Main Thread Finished");
	}

}

class Worker extends Thread {
	
	private int delay;
	private CountDownLatch latch;

	public Worker(int delay, CountDownLatch latch, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			this.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
