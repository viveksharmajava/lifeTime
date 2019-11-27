package sample.test.multithreading.meetup;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * You have given 3 Thread t1,t2,t3
 * how will you make sure thread t3 finish after thread t2 and thread t2 finish after thread t1.
 * 
 * Solution :
 * Approach :  User  CyclicBarrier 
 */
public class FinishThreadT1T2T3oneAfterother {

	public static void main(String[] args) {
		//NOte why it is showing thread name t1 even in t2 run() method.

		Thread3 t3 = new Thread3();
		t3.setName("t3");
		CyclicBarrier waitPoint23 = new CyclicBarrier(1,t3);
		Thread2 t2 = new Thread2(waitPoint23);
		CyclicBarrier waitPoint12 = new CyclicBarrier(1,t2);
        t2.setName("t2");
		Thread1 t1 = new Thread1(waitPoint12);
		t1.setName("t1");
		//t3.start();
		//t2.start();
		t1.start();
	
		
	}
	
	 void method1() {}

}


class Thread1 extends Thread{
	CyclicBarrier waitPoint = null;
	Thread1(CyclicBarrier cb){
		this.waitPoint = cb;
		//this.start();
	}
	public void run() {
		System.out.println("Execution Thread 1 ="+Thread.currentThread().getName());

		System.out.println("Finished Thread 1 ="+Thread.currentThread().getName());
		
		try {
			waitPoint.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
}

class Thread2 extends Thread{
	CyclicBarrier waitPoint = null;
	Thread2(CyclicBarrier cb){
		this.waitPoint = cb;
		//this.start();
	}
	public void run() {
		System.out.println("Execution Thread 2 ="+Thread.currentThread().getName());
		System.out.println("Finished Thread 2="+Thread.currentThread().getName());
		
		try {
			waitPoint.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
}
class Thread3 extends Thread{
	//CyclicBarrier waitPoint = null;
	public void run() {
		System.out.println("Execution Thread3 ="+Thread.currentThread().getName());
		System.out.println("Finished Thread3 ="+Thread.currentThread().getName());
		
//		try {
//			waitPoint.await();
//		} catch (InterruptedException | BrokenBarrierException e) {
//			e.printStackTrace();
//		}
	}
	
}