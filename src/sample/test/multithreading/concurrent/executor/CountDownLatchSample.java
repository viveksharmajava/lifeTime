package sample.test.multithreading.concurrent.executor;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(4);
		Application app1 = new Application(latch);
		Application app2 = new Application(latch);
		Application app3 = new Application(latch);
		Application app4 = new Application(latch);
		new Thread(app1).start();
		new Thread(app2).start();
		new Thread(app3).start();
		new Thread(app4).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All Application up and running !!");
	}

}

class Application implements Runnable{
	CountDownLatch countDown ;
	Application(CountDownLatch latch){
		this.countDown = latch;
	}
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+" started!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.countDown.countDown();
	}
}
