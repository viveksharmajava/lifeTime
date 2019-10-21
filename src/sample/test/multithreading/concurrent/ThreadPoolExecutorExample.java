package sample.test.multithreading.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
   public static void main(String []a) throws InterruptedException{
	//RejectorExecutionHandler
	RejectedExecutionHandlerImpl rejector = new RejectedExecutionHandlerImpl();
	
	ThreadFactory tf = Executors.defaultThreadFactory();
	ThreadPoolExecutor tfe = new ThreadPoolExecutor(2, 4, 10,TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), tf , rejector);
	//start the monitoring thread
    MyMonitorThread monitor = new MyMonitorThread(tfe, 3);
    Thread monitorThread = new Thread(monitor);
    monitorThread.start();
  //submit work to the thread pool
    for(int i=0; i<10; i++){
        tfe.execute(new WorkerThread("cmd"+i));
    }
    
    Thread.sleep(30000);
    //shut down the pool
    tfe.shutdown();
    //shut down the monitor thread
    Thread.sleep(5000);
    monitor.suspend();
  }
}

class MyMonitorThread extends Thread {
	private int delay;
	private boolean run = true;
	ThreadPoolExecutor executor = null;
	MyMonitorThread(ThreadPoolExecutor ec , int d){
		this.executor = ec ;
		this.delay = d;
	}
	@Override
	public void run() {
		while(run) {
			System.out.println(String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                    this.executor.getPoolSize(),
                    this.executor.getCorePoolSize(),
                    this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(),
                    this.executor.getTaskCount(),
                    this.executor.isShutdown(),
                    this.executor.isTerminated()));
            try {
                Thread.sleep(delay*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

		}
		
	}
	
	
}
class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      System.out.println(r.toString() +" is Rejected !");		
	}
	
}
