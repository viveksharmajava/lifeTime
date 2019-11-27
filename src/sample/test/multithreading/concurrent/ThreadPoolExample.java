package sample.test.multithreading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i= 0 ; i<10; i++) {
		 
			Thread worker = new WorkerThread(" "+i);
			worker.setName("worker-"+i);
			executor.execute(worker);
		}
		
		executor.shutdown();
		while(!executor.isTerminated()) {
			System.out.println("Waiting for termination !");
		}
		
		System.out.println("All threads completed");

	}

}


