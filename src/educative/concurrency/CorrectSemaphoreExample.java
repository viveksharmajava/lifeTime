package educative.concurrency;

import java.util.concurrent.Semaphore;

public class CorrectSemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		CorrectSemaphoreExample.example();
	}
public static  void example()throws InterruptedException{
		
		Semaphore semaphore = new Semaphore(1);
		Thread badThread = new Thread(new Runnable() {
			public void run() {
				
					try {
						System.out.println("Bad thread!");
						semaphore.acquire();
						try{
							throw new RuntimeException("Exception happened at runtime");
						}catch(Exception e) {
							System.out.println("Exception caught");
						}
						finally{
							System.out.println("bad thread releasing semaphore");
							semaphore.release();
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
			}
		});
		badThread.start();
		// Wait for the bad thread to go belly-up
		Thread.sleep(5000);
		Thread goodThread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						System.out.println("Good thread waiting patiently");
						semaphore.acquire();
						System.out.println("Good thread executiong");
						
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
