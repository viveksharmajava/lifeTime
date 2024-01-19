package jenkov.concurrencyutil;

import java.util.concurrent.Semaphore;

public class SemaphoneExample {

	public static void main(String[] args) {
		Semaphore binarySemaphore = new Semaphore(1);
		try {
		    binarySemaphore.acquire();
		   if(0 ==  binarySemaphore.availablePermits()) {
			   System.out.println("TRUE");
		   }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		} finally {
		    binarySemaphore.release();
		    if(1 ==  binarySemaphore.availablePermits()) {
				   System.out.println("TRUE");
			   }
		}
	}

}
