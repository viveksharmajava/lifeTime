package sample.test.multithreading;

public class InterruptAThread {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread t = new Thread(mt,"interrupt");
		t.start();
		t.interrupt();
		MyThread2 mt2 = new MyThread2();
		Thread t2 = new Thread(mt2,"do not interrupt");
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	//System.out.println("Main finished !");
		
		
		A  a = new A();
		Mythread3 mt3 = new Mythread3(a);
		new Thread(mt3,"mt3").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mythread4 mt4 = new Mythread4(a);
		new Thread(mt4,"mt4").start();
		
	}

}

class MyThread implements Runnable{
	
	public void run() {
		
		while(true) {
			System.out.println("Hello from MyThread!");
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("I'm not done");
				return;
			}
		}
	}
}

class MyThread2 implements Runnable{
	
	public void run() {
		
		while(true) {
			System.out.println("Hello from MyThread2  !");
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("I'm not done");
				return;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Mythread3 implements Runnable{
	
     A a;
     Mythread3(A aobj){
    	 a = aobj;
     }
	public void run() {
		    a.m1();
			System.out.println(Thread.currentThread().getName() +"\t done !");
		
	}
}

class Mythread4 implements Runnable{
	 A a;
     Mythread4(A aobj){
    	 a = aobj;
     }
	public void run() {
		a.m2();
		System.out.println(a.name);
		System.out.println(Thread.currentThread().getName() +"\t done !");
	}
}

class A{
	String name ="VIvek";
	
	public synchronized void m1() {
		System.out.println("in m1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void m2() {
		System.out.println("from m2");
	}
}
