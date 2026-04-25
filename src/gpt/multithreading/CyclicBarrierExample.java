package gpt.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		CyclicBarrier  barrier = new CyclicBarrier(3,new Runnable() {
			public void run() {
				System.out.println("runnable started");
			}
		});
		Thread t1 = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() +"started!");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() +"finished!");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		});
		Thread t2 = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() +"started!");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() +"finished!");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() +"started!");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() +"finished!");
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
