package sample.test.multithreading.wait;

public  class WaitNotifySample {
public static void main(String [] args){
	 A ab =new B();
	 ab.x = 15;
	 A b = new B();
	 System.out.println(ab.x);
	 System.out.println(b.x);
	 Thread1 t1  = new Thread1(ab, 4000l);
	 Thread1 t2  = new Thread1(b, 5000l);
	 t2.start();
	 t1.start();
}
}



 class A{
	int x=10;
}
class B extends A{
	int x =30;
}
class Thread1 extends Thread{
	A a;
	long wait;
	Thread1(A oba,long waitingTime){
		a = oba;
		wait = waitingTime;
	}
	public void run(){
		
		synchronized(a){
			try {
				a.x= 10;
				a.wait(wait); //this is wrong implmentation according me, why wait and notify in same synchronized block
				System.out.println("I'm Thread "+Thread.currentThread().getName()+"\t and value of a"+a.x);
				a.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



