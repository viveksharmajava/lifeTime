package sample.test.multithreading.concurrent;

public class SychnronizedSample {
public static final int  x = 2;
	public static void main(String[] args) {
  A a = new A();
  Thread1 t1 = new Thread1(a);
  Thread2 t2 = new Thread2(a);
  t1.start();
  t2.start();

}
	
}

class A{
	
	synchronized void m1(){
		System.out.println("i'm in A m1  entered method");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i'm in A m1 method");
		
	}
	
	synchronized void m2(){
		System.out.println("i'm in A m2 method");
	}
}

class Thread1 extends Thread{
	A a ;
	Thread1(A obj){
		a = obj;
	}
	public void run(){
		
		a.m1();
		
		
	}
}

class Thread2 extends Thread{
	A a ;
	Thread2(A obj){
		a = obj;
	}
	public void run(){
		
		a.m2();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}