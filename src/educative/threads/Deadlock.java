package educative.threads;

public class Deadlock {

	private Object lock1 = new Object(); 
	private Object lock2 = new Object();
	private int count = 0;
	Runnable incrementer = new Runnable() {
		
		@Override
		public void run() {
			for(int i= 0; i < 100; i++) {
				try {
					incementCounter();
					System.out.println("Incremented "+count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		
	};
	private void incementCounter() throws InterruptedException {
		synchronized(lock1){
			System.out.println("Acquired Lock 1");
			Thread.sleep(100);
			synchronized(lock2) {
				count++;
			}
			
			
		}
	}
	
Runnable decrementer = new Runnable() {
		
		@Override
		public void run() {
			for(int i= 0; i < 100; i++) {
				try {
					decrementCounter();
					System.out.println("Decrementing "+count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

		
	};
	private void decrementCounter() throws InterruptedException {
		synchronized(lock2){
			System.out.println("Acquired Lock 2");
			Thread.sleep(100);
			synchronized(lock1) {
				count--;
			}
			
			
		}
	}	
	
	public void runTest()  throws InterruptedException  {
		Thread t1  = new Thread(incrementer);
		Thread t2  = new Thread(decrementer);
		t1.start();
		Thread.sleep(1000);//make sure t1 get a chance to acquire lock1
		t2.start();
	
	}
	public static void main(String[] args) throws InterruptedException {
          Deadlock d = new Deadlock();
          d.runTest();
	}
	
	

}
