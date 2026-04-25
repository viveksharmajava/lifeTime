package gpt.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
      ExecutorService executor = Executors.newFixedThreadPool(2);
      executor.submit(new MyTask());
      executor.submit(new MyTask());
      executor.submit(new MyTask());
      System.out.println("isDone!"+executor.isTerminated());
      executor.shutdown();
      //Use(Collable + Future )
      ExecutorService service = Executors.newSingleThreadExecutor();
      Future <Integer> res =  service.submit(new MyCallable());
      System.out.println("Doing something else!");
      Integer result =res.get();//blocks
      System.out.println("result ="+result);
      service.shutdown();
      
      
      
      //1) Submit n tasks and process results in submission order
      
      ExecutorService executors = Executors.newFixedThreadPool(3);

      List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

      // submit n tasks
      for (int i = 1; i <= 5; i++) {
          Future<Integer> future = executors.submit(new MyCallable());
          futures.add(future);
      }

      // process each result
      for (Future<Integer> future : futures) {
          try {
              Integer ans = future.get();   // blocks until this task is done
              System.out.println("Result = " + ans);
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              System.out.println("Main thread interrupted");
          } catch (ExecutionException e) {
              System.out.println("Task failed: " + e.getCause());
          }
      }

      executors.shutdown();
      
      //drabacks
      /*
       * Limitation
         If task 1 is slow, task 2 and task 3 results will not be processed until task 1 finishes, 
          because you are reading futures in the same order you submitted them.
       */
      
      
 //1) Submit n tasks and Process results as soon as tasks finish
      
      executors = Executors.newFixedThreadPool(3);

      futures = new ArrayList<Future<Integer>>();
     CompletionService <Integer> completionService = new ExecutorCompletionService(executors);
      // submit n tasks
      for (int i = 1; i <= 5; i++) {
    	  completionService.submit(new MyCallable());
      }

      // process each result
      for (int i = 1; i <= 5; i++) {
          try {
            Future <Integer> future =  completionService.take(); // blocks until this task is done
            
            System.out.println("Result = " + future.get());
          } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              System.out.println("Main thread interrupted");
          } catch (ExecutionException e) {
              System.out.println("Task failed: " + e.getCause());
          }
      }

      executors.shutdown();
      
      
 
	}

}

class MyTask implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName() +"\t MyTask execution finished!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class MyCallable implements Callable<Integer>{
	public Integer call() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10+10;
	}
}
