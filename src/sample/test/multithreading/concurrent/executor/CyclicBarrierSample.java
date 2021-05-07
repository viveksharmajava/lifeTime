package sample.test.multithreading.concurrent.executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {

	public static void main(String[] args) {
     
		CyclicBarrier barrier = new CyclicBarrier(2,new Thread() {
			public void run() {
				System.out.println("All thread finished its task!!");
			}
		});
		Service1 s1 = new Service1(barrier);
		Service1 s2 = new Service1(barrier);
		new Thread(s1).start();
		new Thread(s2).start();
		
	
	}
	

}


class Service1 implements Runnable{
	CyclicBarrier barrier;
	Service1(CyclicBarrier b){
		this.barrier = b;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+"started its work");
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
