package educative.threads;

import java.util.Random;

public class DemoThreadUnsafe {
 
	static Random random = new Random(System.currentTimeMillis());
	public static void main(String[] args) {
		
		ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				
				for(int i = 0 ; i < 100; i++) {
					badCounter.increment();
					DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				
				for(int i = 0 ; i < 100; i++) {
					badCounter.decrement();
					DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
				}
			}
		};
		
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		badCounter.printFinalCounterValue();
	}
	
	static void sleepRandomlyForLessThan10Secs() {
		try {
			Thread.sleep(random.nextInt(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class ThreadUnsafeCounter { 
	int counter =  0;
    public void increment() {
    	counter++;
    }
    public void decrement() {
    	counter--;
    }
    
    public void printFinalCounterValue() {
    	System.out.println("Final value="+counter);
    }

}
