package educative.programs;

import java.util.Random;
import java.util.concurrent.Semaphore;
//below thread is doing stuck thread.. 

public class DinningPhilospherProblem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		runTest();
	}

	public static void runTest() throws InterruptedException {
		final DiningPhilosophers dp = new DiningPhilosophers();
		
		Thread t0 = new Thread(new Runnable () {
			public void run() {
				DiningPhilosophers.startPhilosper(dp, 0);
			}
		});
		
		Thread t1 = new Thread(new Runnable () {
			public void run() {
				DiningPhilosophers.startPhilosper(dp, 1);
			}
		});
		
		Thread t2 = new Thread(new Runnable () {
			public void run() {
				DiningPhilosophers.startPhilosper(dp, 2);
			}
		});
		
		Thread t3 = new Thread(new Runnable () {
			public void run() {
				DiningPhilosophers.startPhilosper(dp, 3);
			}
		});
		
		Thread t4 = new Thread(new Runnable () {
			public void run() {
				DiningPhilosophers.startPhilosper(dp, 4);
			}
		});
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t0.join();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	}
}
class DiningPhilosophers {
private static Random random = new Random(System.currentTimeMillis());
private Semaphore [] forks = new Semaphore[5];
private Semaphore  maxDiners = new Semaphore(4);//allow only 4 Philosper to pick fork.

public DiningPhilosophers() {
	forks[0] = new Semaphore(1);
	forks[1] = new Semaphore(1);
	forks[2] = new Semaphore(1);
	forks[3] = new Semaphore(1);
	forks[4] = new Semaphore(1);
  }

public void lifeCycleOfPhilosper(int id) throws InterruptedException {
	while(true) {
		contemplate(id);
		eat(id);
	}
}

private void eat(int id) throws InterruptedException {
	maxDiners.acquire();
	forks[id].acquire();
	System.out.println("Philosper id "+id+" is eating !");
	forks[(id+4)%5].acquire();
	maxDiners.release();
}

private void contemplate(int id) throws InterruptedException {
	Thread.sleep(random.nextInt(50));
}

static void startPhilosper(DiningPhilosophers dp , int id) {
	try {
		dp.lifeCycleOfPhilosper(id);
	}catch(InterruptedException e) {
		
	}
}
}
