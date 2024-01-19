package educative.concurrency;

public class InterruptExample {

	public static void main(String[] args) throws InterruptedException {
		InterruptExample.example();
	}
   public static void example() throws InterruptedException {
	   
	   Thread sleepyThread = new Thread(new Runnable() {
		   public void run() {
			   
			   System.out.println("I am too sleepy... Let me sleep for 2 mins.");
			   try {
				Thread.sleep(1*60*1000);
			} catch (InterruptedException e) {
				System.out.println("The interrupt flag is cleard : " + Thread.interrupted() + " " +
						Thread.currentThread().isInterrupted());
			}

		   }
	   });
	   
	   
	   sleepyThread.start();
	   
	   System.out.println("About to wake up the sleepy thread ..."); sleepyThread.interrupt();
	   sleepyThread.interrupt();
	   System.out.println("Woke up sleepy thread ...");
	   sleepyThread.join();
   }
}
