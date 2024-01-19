package educative.concurrency;

public class DeadlockDemonstration {

	public static void main(String[] args) throws InterruptedException {
		Deadlock deadlock = new Deadlock();
		deadlock.runTest();
	}

}

class Deadlock{
	
	private int counter=0;
	private Object lock1 = new  Object();
	private Object lock2 = new  Object();
	
	Runnable increment = new Runnable() {
		
		@Override
		public void run() {
		  try {
			for(int i = 1; i < 100 ;i++) {
				incrementCounter();
			}
		  }catch(InterruptedException e) {
			  
		  }
		}

		
	};
Runnable decrement = new Runnable() {
		
		@Override
		public void run() {
		  try {
			for(int i = 1; i < 100 ;i++) {
				decrementCounter();
			}
		  }catch(InterruptedException e) {
			  
		  }
		}
	};
	private void incrementCounter() throws InterruptedException {
		
		synchronized(lock1) {
			System.out.println(Thread.currentThread().getName() +"\t Acquired lock1");
			Thread.sleep(1000);
			synchronized(lock2) {
				counter++;
			}	
		}
		
		
	}
	private void decrementCounter()  throws InterruptedException{
		synchronized(lock2) {
			System.out.println(Thread.currentThread().getName() +"\t Acquired lock2");
			Thread.sleep(1000);
			synchronized(lock1) {
				counter--;
			}	
		}
		
	}
	
	public void runTest() throws InterruptedException {
		Thread t1 = new Thread(increment);
		t1.start();
		Thread.sleep(1000);
		Thread t2 = new  Thread(decrement);
		t2.start();
		
		t1.join();
		t2.join();
	}
}
