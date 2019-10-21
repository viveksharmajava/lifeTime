package sample.test.multithreading.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample {
	public static void main(String[] args) {
     
		MyCallable call1 = new MyCallable(1000);
		MyCallable call2 = new MyCallable(2000);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		FutureTask <String> ft1 = new FutureTask<String>(call1);
		FutureTask <String> ft2 = new FutureTask<String>(call2);
		
		executor.execute(ft1);
		executor.execute(ft2);
		
		while(true) {
			try {
				if(ft1.isDone() && ft2.isDone()) {
					System.out.println("Done !");
					executor.shutdown();
					return;
				}
				
				if(!ft1.isDone()) {
					System.out.println("Ft1 ouput"+ft1.get());
				}
				
				System.out.println("Waiting for f2 to complete");
				String s = ft2.get(200l, TimeUnit.MILLISECONDS);
				if(s != null) {
					System.out.println("Ft2 output ="+s);
				}
				
			}catch(InterruptedException | ExecutionException | TimeoutException e) {
				
			}
			
		}	
		}
		
	

}
