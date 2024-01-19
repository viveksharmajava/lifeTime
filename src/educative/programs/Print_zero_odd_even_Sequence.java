package educative.programs;

import java.util.concurrent.Semaphore;

/*
 * Problem Statement# educative pdf 239
 * 010203
 Suppose we are given a number n based on which a program creates 
 the series 010203...0n. There are three threads t1, t2 and t3 which print a specific type of number 
 from the series.
  t1 only prints zeros,
  t2 prints odd numbers
  t3 prints even numbers from the series.
 
 The code for the class is given as follows:
 */
public class Print_zero_odd_even_Sequence {

	public static void main(String[] args) {
		Semaphore zero = new Semaphore(1);
		Semaphore odd = new Semaphore(0);
		Semaphore even= new Semaphore(0);
		int n = 20;
		PrintNumberSeries service = new PrintNumberSeries(n, zero,odd, even);
		NumberSeriesThread t = new NumberSeriesThread(service,"zero");
		NumberSeriesThread t1 = new NumberSeriesThread(service,"odd");
		NumberSeriesThread t2 = new NumberSeriesThread(service,"even");
		t.start();
		t1.start();
		t2.start();
		
	}

}


class NumberSeriesThread extends Thread{
	PrintNumberSeries service;
	String method;
	NumberSeriesThread(PrintNumberSeries service , String method){
		this.service = service;
		this.method = method;
	}
	public  void run(){
		if(method.equals("zero")) service.printZero();
		else if(method.equals("odd")) service.printOdd();
		else if (method.equals("even")) service.printEven();
	}
}

class PrintNumberSeries{
	int n;
	Semaphore zero, odd ,even;
	PrintNumberSeries(int num , Semaphore zero , Semaphore odd , Semaphore even){
		this.n  = num;
		this.even = even;
		this.odd = odd;
		this.zero = zero;
	}
	
	public void printZero() {
		for(int i = 1 ; i <= n ; i++) {
			try {
				zero.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(0);
			if(i%2==0) even.release();
			else odd.release();
		}
	}
	public void printOdd() {
		for(int i = 1 ; i <= n ; i+=2) {
			try {
				odd.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i);
			zero.release();
		}
	}
	public void printEven() {
		for(int i = 2 ; i <= n ; i +=2) {
			try {
				even.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i);
			zero.release();
		}
	}
	
}
