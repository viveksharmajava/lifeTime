package educative.programs;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {

	public static void main(String[] args) throws InterruptedException {
		runTest();
	}

	public static void runTest() throws InterruptedException {
		UberSeatingProblem   uberSeatingProblem= new UberSeatingProblem();
		Set<Thread> allThreads = new HashSet<Thread>();
		for (int i = 0; i < 10; i++) {
		Thread thread = new Thread(new Runnable() {
		public void run() {
		try {
		uberSeatingProblem.seatDemocrat();
		} catch (InterruptedException ie) {
		System.out.println("We have a problem");
		} catch (BrokenBarrierException bbe) {
		System.out.println("We have a problem");
		}
		
	   }
		
	  });
	 thread.setName("Democrat_" + (i + 1));
	 allThreads.add(thread);
	 Thread.sleep(50);
	}	
	
	//set republician 
		for (int i = 0; i < 14; i++) {
			Thread thread = new Thread(new Runnable() {
			public void run() {
			try {
			uberSeatingProblem.seatReplucian();
			} catch (InterruptedException ie) {
			System.out.println("We have a problem");
			} catch (BrokenBarrierException bbe) {
			System.out.println("We have a problem");
			}
			
		   }
			
		  });
		 thread.setName("Republican_" + (i + 1));
		 allThreads.add(thread);
		 Thread.sleep(50);
		}
		for(Thread t : allThreads) {
			t.start();
		}
		for(Thread t : allThreads) {
			t.join();
		}
		
	 }	
	
	
	//Thread code start here
	
	private int republicans = 0;
	private int democrates =  0;
	
	private Semaphore demWaiting =  new Semaphore(0);
	private Semaphore repWaiting =  new Semaphore(0);
	
	
	CyclicBarrier barrier = new CyclicBarrier(4);
	ReentrantLock lock = new ReentrantLock();
	
	void drive() {
		System.out.println("Uber ride on   its way........ with ride leader ="+Thread.currentThread().getName());
		System.out.flush();
	}
	
	void seatDemocrat() throws InterruptedException, BrokenBarrierException  {
		
		boolean rideLeader = false;
		lock.lock();
		democrates++;
		if(democrates == 4) {
			demWaiting.release(3);
			democrates -=4;
			rideLeader = true;
			
		}
		else if(democrates == 2 && republicans == 2 ) {
			demWaiting.release(1);
			repWaiting.release(2);
			democrates -=2;
			republicans -=2;
			rideLeader = true;
		}else {
			lock.unlock();
			demWaiting.acquire();
		}
	    seated();
	    barrier.await();
	    
	    if(rideLeader) {
	    	drive();
	    	lock.unlock();
	    }
	}
void seatReplucian() throws InterruptedException, BrokenBarrierException  {
		
		boolean rideLeader = false;
		lock.lock();
		republicans++;
		if(republicans == 4) {
			repWaiting.release(3);
			republicans -=4;
			rideLeader = true;
			
		}
		else if(democrates == 2 && republicans == 2 ) {
			repWaiting.release(1);
			demWaiting.release(2);
			democrates -=2;
			republicans -=2;
			rideLeader = true;
		}else {
			lock.unlock();
			repWaiting.acquire();
		}
	    seated();
	    barrier.await();
	    
	    if(rideLeader) {
	    	drive();
	    	lock.unlock();
	    }
	}

	private void seated() {
		System.out.println("Thread "+Thread.currentThread().getName()+" is seated !");
		System.out.flush();
	}
	
}
