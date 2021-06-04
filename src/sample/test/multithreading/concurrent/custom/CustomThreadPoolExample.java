package sample.test.multithreading.concurrent.custom;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExample {

	public static void main(String[] args) {
      CustomThreadPool pool = new CustomThreadPool(2);
      for(int i = 1 ; i <=5 ;i++) {
    	  Task task = new Task("Task "+i);
    	  System.out.println("Task created "+task.getName());
    	  pool.execute(task);
      }
      pool.shutdown();//this won't work efficiently 
	}

}

class CustomThreadPool{
	
	//pool size
	private int poolSize;
	//FIFO ordering
	LinkedBlockingQueue<Runnable> queue;
	
	//internal pool 
	WorkerThreads [] workers;
	CustomThreadPool(int poolSize){
		this.poolSize = poolSize;
		queue = new LinkedBlockingQueue<Runnable>();
		workers = new WorkerThreads[this.poolSize];
		for(int i = 0 ; i < poolSize ; i++) {
			workers[i] = new WorkerThreads();
			workers[i].start();
		}
	}
	
	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}
	 public void shutdown() {
	        System.out.println("Shutting down thread pool");
	        for (int i = 0; i < poolSize; i++) {
	            workers[i] = null;
	        }
  }
	private class WorkerThreads extends Thread {

		@Override
		public void run() {
		
		Runnable task;
		while(true) {
			synchronized (queue) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				task = queue.poll();
				
			}
			try {
			task.run();
			}catch(RuntimeException e) {
				System.out.println("Thread pool is interrupted due to an issue"+e.getMessage());
			}
		}

		}

	}
}

 class Task implements Runnable {
    private String name;
 
    public Task(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


