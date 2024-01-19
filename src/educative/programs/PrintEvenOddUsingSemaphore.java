package educative.programs;

import java.util.concurrent.Semaphore;

public class PrintEvenOddUsingSemaphore {

	public static void main(String[] args) {
		Semaphore even = new Semaphore(0);// we want to start with 1 so even initial limit is 0
		Semaphore odd = new Semaphore(1);
		SharedPrinter printer = new SharedPrinter(even,odd)	;
		Even t1 = new Even(printer,40);
		Odd t2 = new Odd(printer,40);
		new Thread(t1, "EVEN").start();
		new Thread(t2, "Odd").start();
		
	}

}

class Even implements Runnable {
	
	SharedPrinter printer ;
	int max;
	Even(SharedPrinter p , int m){
		this.printer  = p;
		this.max  = m;
		
	}
	@Override
	public void run() {
		int num = 2;
		while(num <= max) {
			printer.printEven(num);
			num +=2;
		}
	}
	
}
class Odd implements Runnable {
	SharedPrinter printer ;
	int max;
	Odd(SharedPrinter p , int m){
		this.printer  = p;
		this.max  = m;
		
	}
	@Override
	public void run() {
		int num = 1;
		while(num <= max) {
			printer.printOdd(num);
			num +=2;
		}
		
	}
}

class SharedPrinter{
	 Semaphore   even;
	 Semaphore   odd;
	 SharedPrinter( Semaphore e , Semaphore o){
		 this.even = e;
		 this.odd = o;
	 }
	 
	 public void printEven(int num) {
		 try {
			this.even.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" printing "+num);
		this.odd.release();
	 }
	 public void printOdd(int num) {
		 try {
			this.odd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" printing "+num);
		this.even.release();
	 }
}

