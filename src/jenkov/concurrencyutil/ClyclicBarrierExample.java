package jenkov.concurrencyutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ClyclicBarrierExample {

	public static void main(String[] args) {

		Runnable action1 = new Runnable() {
			public void run() {
				System.out.println("Action 1 executed !");
			}
		};
		Runnable action2 = new Runnable() {
			public void run() {
				System.out.println("Action 2 executed !");
			}
		};
		CyclicBarrier cb1 = new CyclicBarrier(2, action1);
		CyclicBarrier cb2 = new CyclicBarrier(2, action2);
		CyclicBarrierRunnable cr1 = new CyclicBarrierRunnable(cb1,cb2);
		CyclicBarrierRunnable cr2 = new CyclicBarrierRunnable(cb1,cb2);
		
		new Thread(cr1, "Thread 1").start();
		new Thread(cr2, "Thread 2").start();
		
	}

}
class CyclicBarrierRunnable implements Runnable{

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(
            CyclicBarrier barrier1,
            CyclicBarrier barrier2) {

        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }
    public void run() {
    	try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() +" waiting at barrier 1");
	    	barrier1.await();
	    	Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() +" waiting at barrier 2");
	    	barrier2.await();
	    	System.out.println(Thread.currentThread().getName() +" done !");
	    	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
