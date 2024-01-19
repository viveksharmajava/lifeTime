package educative.concurrency;

public class BadSynchronization {

	public static void main(String[] args) {
		// BadSynchronization # 1 
		Object o = new Object();
		 // Attempting to call wait() on the object
		 // outside of a synchronized block.
		try {
			o.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	// BadSynchronization example 2
    // when calling notify on the object which is not synchronized locked.
		Object object = new Object();
		Object lock = new Object();
		synchronized(object) {
			object.notify();
			lock.notify();
		}
	
	}

}
