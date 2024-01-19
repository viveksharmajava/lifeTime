package educative.programs;
/* #233
 * Printing Foo Bar n Times
 * Problem Statement#
Suppose there are two threads t1 and t2. t1 prints Foo and t2 prints Bar. 
You are required to write a program which takes a user input n.
 Then the two threads print Foo and Bar alternately n number of times.
 The code for the class is as follows:
 */
public class PrintFooBarnTimes {

	public static void main(String[] args) {
		FooBarPrinter p = new FooBarPrinter();
		FooBarThread foo = new FooBarThread(p,"Foo",30);
		FooBarThread bar = new FooBarThread(p,"Bar",30);
		foo.start();
		bar.start();
	}

}

class FooBarThread extends Thread{
	FooBarPrinter printer;
	String method;
	int  num;
	FooBarThread(FooBarPrinter p, String m,int n){
		this.printer = p;
		this.method = m;
	    this.num = n;
	}
	public void run() {
		if(this.method.equalsIgnoreCase("Foo")) {
			try {
				while(num > 0) {
					printer.printFoo();
					num--;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				while(num > 0) {
					printer.printBar();
					num--;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class FooBarPrinter{
	volatile int flag = 1;
	public void printFoo() throws InterruptedException {
		synchronized(this) {
			if(flag == -1) {
				wait();
			}
			System.out.print("Foo");
			flag = -1;
			notifyAll();
		}
	}
	public void printBar() throws InterruptedException {
		synchronized(this) {
			if(flag == 1) {
				wait();
			}
			System.out.print("Bar");
			flag = 1;
			notifyAll();
		}
	}
}