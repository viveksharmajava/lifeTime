package sample.test.multithreading.concurrent;

public class TestThread extends Thread {

	public static void main(String[] args) {
		Thread t = new TestThread();
		System.out.println("Before starting thread");
		t.start();
		System.out.println("After starting thread");
		MyTestClass mt = new MyTestClass();
		
		Thread t1 = new Thread(new MyRunnable(mt),"MyRunnable" );
		Thread t2 = new Thread(new MyRunnable2(mt),"MyRunnable2" );
		t1.start();
		t2.start();
	}

}

class MyRunnable implements Runnable{
	MyTestClass mt;
	MyRunnable(MyTestClass c){
		this.mt = c;
	}
	public void run() {
		
			mt.m1();
			
		
		
	}
}
class MyRunnable2 implements Runnable{
	MyTestClass mt;
	MyRunnable2(MyTestClass c){
		this.mt = c;
	}
	public void run() {
		mt.m2();
		mt.m1();
		
	}
}
 class MyTestClass{
	 
	 synchronized void m1() {
		 System.out.println("M1 is synchronized!");
		 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
	 }
	 
	 void m2() {
		 System.out.println("M2 is not syncrhnized");
	 }
	 
 }
