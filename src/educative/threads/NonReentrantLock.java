package educative.threads;

public class NonReentrantLock {

	public static void main(String[] args)  throws Exception{
		NonReentrantLock nreLock = new NonReentrantLock();
		//first lock would be success
		nreLock.lock();
		System.out.println("Acquired first lock");
		nreLock.lock();
		System.out.println("trying to acquire lock second time");
	}
	boolean isLocked;
	NonReentrantLock(){
		isLocked =false;
	}
	public synchronized void lock() throws InterruptedException {
		while(isLocked) wait();
		isLocked = true;
	}
	
}
