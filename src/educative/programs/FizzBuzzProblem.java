package educative.programs;

/*
 * educative pdf  #253
 * Fizz Buzz Problem
 * FizzBuzz is a common interview problem in which a program prints a number series from 1 to n such that for every number that is a multiple of 3 it prints "fizz", for every number that is a multiple of 5 it prints "buzz" and for every number that is a multiple of both 3 and 5 it prints "fizzbuzz". We will be creating a multi-threaded solution for this problem.
Suppose we have four threads t1, t2, t3 and t4. Thread t1 checks if the number is divisible by 3 and prints fizz. Thread t2 checks if the number is divisible by 5 and prints buzz. Thread t3 checks if the number is divisible by both 3 and 5 and prints fizzbuzz. Thread t4 prints numbers that are not divisible by 3 or 5. The workflow of the program is shown below:

 * 
 */
public class FizzBuzzProblem {

	public static void main(String[] args) {
      MultithreadedFizzBuzz fb = new MultithreadedFizzBuzz(20);
      FizzBuzzThread t1 = new FizzBuzzThread(fb, "Fizz");
      FizzBuzzThread t2 = new FizzBuzzThread(fb, "Buzz");
      FizzBuzzThread t3 = new FizzBuzzThread(fb, "FizzBuzz");
      FizzBuzzThread t4 = new FizzBuzzThread(fb, "number");
      t1.start();
      t2.start();
      t3.start();
      t4.start();
	}

}


class MultithreadedFizzBuzz {
	private int n;
	private int num = 1;
	MultithreadedFizzBuzz(int n){
		this.n = n;
	}
	public synchronized void fizz() throws InterruptedException {
		while(num <= n) {
		if(num%3 == 0  && num%5 !=0) {
			 System.out.println("Fizz");
			 num++;
			 notifyAll();
		 }else {
			 wait();
		 }
		}
	}
	
	public synchronized void buzz() throws InterruptedException {
		while(num <= n) {
		if(num%5 == 0  && num%3 !=0) {
			 System.out.println("buzz");
			 num++;
			 notifyAll();
		 }else {
			 wait();
		 }
	  }
	}
	public synchronized void fizzbuzz() throws InterruptedException {
		while(num <= n) {
		 if(num%3 == 0  && num% 5 ==0) {
			 System.out.println("FizzBuzz");
			 num++;
			 notifyAll();
		 }else {
			 wait();
		 }
	   } 
	}
	public synchronized void number() throws InterruptedException {
		while(num <= n) { 
		if(num%3 !=0 && num %5 !=0) {
			 System.out.println(num);
			 num++;
			 notifyAll();
		 }else {
			 wait();
		 }
		}
	}
	
}

class FizzBuzzThread extends Thread{
	MultithreadedFizzBuzz  fizzbuzz = null;
	private String method;
	FizzBuzzThread(MultithreadedFizzBuzz fb,String method){
		fizzbuzz = fb;
		this.method = method;
	}
	public void run() {
		try {
			if ("Fizz".equals(method)) 
				 {
				fizzbuzz.fizz();
				 }
		   else if ("Buzz".equals(method)) 
				 {
			   fizzbuzz.buzz();
				 }
		   else if ("FizzBuzz".equals(method)) 
				 {
			   fizzbuzz.fizzbuzz();
				 }
			 else  
				 {
				 fizzbuzz.number();
				 }
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}