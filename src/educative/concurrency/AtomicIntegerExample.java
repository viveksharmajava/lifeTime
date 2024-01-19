package educative.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	static volatile int valatilecount = 0;
	 static AtomicInteger atomic = new AtomicInteger();
	public static void main(String[] args) {

		 //Volatile does imply thread safety
		
		  int threadsCount = 10;
		  Thread [] threads = new Thread[threadsCount];
		  for(int i = 0 ; i < threadsCount; i++) {
			  threads[i] = new Thread(new Runnable() {
				  public void run() {
					  for(int j = 1 ; j <=1000; j++) {
						  valatilecount++;
					  }
				  }
			  });
		  }
		  
		  for(int i = 0 ; i < threadsCount; i++) {
			  threads[i].start();
		  }
		  for(int i = 0 ; i < threadsCount; i++) {
			  try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		  
		  System.out.println("The Volatile count ="+valatilecount);
		
	  
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//Atomic are thread safe
		  for(int i = 0 ; i < threadsCount; i++) {
			  threads[i] = new Thread(new Runnable() {
				  public void run() {
					  for(int j = 1 ; j <=1000; j++) {
						  atomic.incrementAndGet();
					  }
				  }
			  });
		  }
		  
		  for(int i = 0 ; i < threadsCount; i++) {
			  threads[i].start();
		  }
		  for(int i = 0 ; i < threadsCount; i++) {
			  try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		  System.out.println("The Atomic count ="+atomic.get());
			
		   //Primitive an Atomic are different
		  AtomicInteger atomicFive = new AtomicInteger(5);
		  AtomicInteger atomicAlsoFive = new AtomicInteger(5);
		  System.out.println(atomicFive==atomicAlsoFive);
		  System.out.println(atomicFive.hashCode());
		  System.out.println(atomicAlsoFive.hashCode());
		  
		  Integer a = 5;
		  Integer b = 5;
		  
	}

}
