package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.Semaphore;

public class SemaphoreSample {

	public static void main(String[] args) {
      Pool p = new Pool();
      for(int i=0; i < 20 ; i++) {
    	  new Thread(new UseResource(p,1000*(i+1)),"UseResourece "+i).start();
      }
    //Test Binary Semaphore
  	CounterUsingMutex c = new CounterUsingMutex();
  	for(int i = 1 ; i < 6 ; i++) {
  		
  		new Thread(new BinarySemaphoreThread(c),"Thread "+i).start();
  	}
  	System.out.println("counter "+c.getCount());
	System.out.println("counter hasQueuedThreads "+c.hasQueuedThreads());
	}
	
	
	
}
class UseResource implements Runnable{
	Pool pool;
	int wait = 0;
	UseResource(Pool pool,int w){
		this.pool = pool;
		this.wait = w;
	}
	public void run() {
		try {
			String item = pool.getItem();
			System.out.println(Thread.currentThread().getName()+"\t has acquired resource "+item);
			Thread.sleep(wait);
			pool.putItem(item);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class Pool {
	   private static final int MAX_AVAILABLE = 10;
	   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	   // Not a particularly efficient data structure; just for demo

	   protected String[] items = new  String[MAX_AVAILABLE];   //... whatever kinds of items being managed
	   protected boolean[] used = new boolean[MAX_AVAILABLE];
	   Pool() {
		   for(int i = 1 ; i <= 10 ; i++) {
			   items[i-1] = "Resource "+i;
		   }
	   }
	   public String getItem() throws InterruptedException {
	     available.acquire();
	     return getNextAvailableItem();
	   }

	   public void putItem(String x) {
	     if (markAsUnused(x))
	       available.release();
	   }

	  
	    synchronized String getNextAvailableItem() {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (!used[i]) {
	          used[i] = true;
	          return items[i];
	       }
	     }
	     return null; // not reached
	   }

	    synchronized boolean markAsUnused(String item) {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (item == items[i]) {
	          if (used[i]) {
	            used[i] = false;
	            return true;
	          } else
	            return false;
	       }
	     }
	     return false;
	   }

	 }


class BinarySemaphoreThread implements Runnable{
	CounterUsingMutex counter;
	BinarySemaphoreThread(CounterUsingMutex c){
		this.counter = c;
	}
	public void run() {
		try {
			counter.increase();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class CounterUsingMutex {

    private Semaphore mutex;
    private int count;

    CounterUsingMutex() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increase() throws InterruptedException {
        mutex.acquire();
        this.count = this.count + 1;
        Thread.sleep(1000);
        mutex.release();

    }

    int getCount() {
        return this.count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}