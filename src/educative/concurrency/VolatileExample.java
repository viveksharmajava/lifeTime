package educative.concurrency;

public class VolatileExample {
	static volatile int count = 0;
	public static void main(String[] args) {
	 //Volatile does imply thread safety
	  int threadsCount = 10;
	  Thread [] threads = new Thread[threadsCount];
	  for(int i = 0 ; i < threadsCount; i++) {
		  threads[i] = new Thread(new Runnable() {
			  public void run() {
				  for(int j = 1 ; j <=1000; j++) {
					  count++;
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
	  
	  System.out.println("The count ="+count);
	}

}
