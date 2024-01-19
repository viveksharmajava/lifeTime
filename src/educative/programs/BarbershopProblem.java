package educative.programs;

import java.util.HashSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Problem Statement#
  A similar problem appears in Silberschatz and Galvin's OS book,
  and variations of this problem exist in the wild.
  A barbershop consists of a waiting room with n chairs,
  and a barber chair for giving haircuts. If there are no 
  customers to be served, the barber goes to sleep. 
  If a customer enters the barbershop and all chairs are occupied,
  then the customer leaves the shop. If the barber is busy, 
  but chairs are available, then the customer sits in one of the free chairs. If the barber is asleep, the customer wakes up the barber. Write a program to coordinate the interaction between the barber and the customers.
 */
public class BarbershopProblem {

	final int WAITING_CHAIRS = 3;
	int waitingCustomers =0 ;
	ReentrantLock lock = new ReentrantLock();
	
	Semaphore waitingForCustomerToEnter = new Semaphore(0);
	Semaphore waitingForBarberTobeReady = new Semaphore(0);
	
	Semaphore waitingForBarberTocutThehair = new Semaphore(0);
	Semaphore waitForCustomerToLeave = new Semaphore(0);
	int hairCutsGiven = 0;
	
	void customerWalkin() throws InterruptedException{
		lock.lock();
		if(waitingCustomers == WAITING_CHAIRS) {
			System.out.println("Customer walks out as no free chair available !!");
		    lock.unlock();
			return;
		}
		//let barber know that customer arrivers
		waitingForCustomerToEnter.release();
		
	    // lets wait for barber to become available to come and greet you for style.
		waitingForBarberTobeReady.acquire();
		
		// Wait for haircut to complete
		waitingForBarberTocutThehair.acquire();
		// Leave the barber chair and let barber thread know chair is vaca
		waitForCustomerToLeave.release();
		lock.lock();
		waitingCustomers--;
		lock.unlock();
	}
	
	void barber() throws InterruptedException{
		
		while(true) {
			//wait for customer to enter
			waitingForCustomerToEnter.acquire();
			
			//tell customer that barber is ready..
			waitingForBarberTobeReady.release();
			hairCutsGiven++;
			
			System.out.println("barber cutting hair !....");
			System.out.println("Hair cut give to "+hairCutsGiven+" customers");
			Thread.sleep(50);
			//let the customer know haircut is done
			
			waitingForBarberTocutThehair.release();
			
			//wait for customer to leaver the 
			waitForCustomerToLeave.acquire() ;
			
		}
	}
	
	public static void main(String [] args)throws InterruptedException {
		runTest() ;
	}
	public static void runTest() throws InterruptedException {
		HashSet<Thread> set = new HashSet<Thread>();
		final BarbershopProblem barberShopProblem = new BarbershopProblem();
		Thread barberThread = new Thread(new Runnable() {
		public void run() {
		try {
		barberShopProblem.barber();
		} catch (InterruptedException ie) {
		}
		}
		});
		barberThread.start();
		
		for(int i =0 ; i < 10 ; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
				try {
				barberShopProblem.customerWalkin();
				} catch (InterruptedException ie) {
				}
				}
				});
				set.add(t);
		}
		for(Thread t : set) {
			t.start();
		}
		for(Thread t : set) {
			t.join();
		}
		set.clear();
		Thread.sleep(800);
	}
}


