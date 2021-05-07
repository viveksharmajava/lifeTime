package sample.test.multithreading.concurrent;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ScheduledThreadPool {

	public static void main(String[] args) throws InterruptedException {
   
		ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
		System.out.println("Current Time = "+new Date());
		
		for(int i=0 ; i < 10;i++) {
			WorkerThread worker = new WorkerThread("Do heavy Duty Job "+i);
			scheduleThreadPool.schedule(worker,10, TimeUnit.SECONDS);
		}
		
		Thread.sleep(30000);
		scheduleThreadPool.shutdown();
		while(!scheduleThreadPool.isTerminated()) {
			
		}
		System.out.println("Finished all threads");
		
		
	}

}
