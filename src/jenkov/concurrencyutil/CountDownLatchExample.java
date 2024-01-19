package jenkov.concurrencyutil;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Decrementer dec = new Decrementer(latch);
	    Waiter w = new Waiter(latch);
	    new Thread(w).start();
	    new Thread(dec).start();
	}

}

class Waiter implements Runnable {
	CountDownLatch latch = null;
	Waiter(CountDownLatch latch ){
		this.latch = latch;
		
	}
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Waiter released !");
	}
}

class Decrementer implements Runnable{
	
  CountDownLatch latch = null;
Decrementer(CountDownLatch latch ){
	this.latch = latch;
	
}
public void run() {
	try {
		latch.countDown();
        System.out.println("\n Decrementer called  countDown 1 \n  ");
		Thread.sleep(1000);
		latch.countDown();
		System.out.println("\n Decrementer called  countDown 2 \n  ");
		Thread.sleep(1000);
		latch.countDown();
		System.out.println("\n Decrementer called  countDown 3 \n  ");
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}