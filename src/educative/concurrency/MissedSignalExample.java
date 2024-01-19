package educative.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalExample {

	public static void main(String[] args) throws InterruptedException {
		MissedSignalExample.example();
	}
	
	public static void example() throws InterruptedException{
		final ReentrantLock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		Thread signaller = new Thread(new Runnable() {
			public void run() {
				lock.lock();
				condition.signal();
				System.out.println("Sent Signal !");
				lock.unlock();
			}
		});
		
		Thread waiter = new Thread(new Runnable() {
			public void run() {
				lock.lock();
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Received Signal !");
				lock.unlock();
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
