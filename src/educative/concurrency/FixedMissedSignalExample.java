package educative.concurrency;

import java.util.concurrent.Semaphore;

public class FixedMissedSignalExample {

	public static void main(String[] args) throws InterruptedException {
		FixedMissedSignalExample.example();
	}
	public static void example() throws InterruptedException{
		Semaphore semaphore = new Semaphore(1);
		
		Thread signaller = new Thread(new Runnable() {
			public void run() {
				semaphore.release();
				System.out.println("Sent Signal !");
			}
		});
		
		Thread waiter = new Thread(new Runnable() {
			public void run() {
				
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Received Signal !");
				semaphore.release();
			}
		});
		signaller.start();
		Thread.sleep(1000);
		waiter.start();
		signaller.join();
		waiter.join();
		System.out.println("Program existing");
	}

}

