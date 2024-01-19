package educative.concurrency;

import java.util.concurrent.Semaphore;

public class IncorrectSemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		IncorrectSemaphoreExample.example();
	}

	public static  void example()throws InterruptedException{
		
		Semaphore semaphore = new Semaphore(1);
		Thread badThread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						System.out.println("Bad thread!");
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					throw new RuntimeException("Exception happened at runtime");
					 // The following line to signal the semaphore is never reached
					//semaphore.release();
					
				}
			}
		});
		badThread.start();
		// Wait for the bad thread to go belly-up
		Thread.sleep(1000);
		Thread goodThread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						System.out.println("Good thread waiting patiently");
						semaphore.acquire();
						System.out.println("It will never execute");
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		goodThread.start();
		badThread.join();
		goodThread.join();
		System.out.println("System Existing !");
		
	}
}
