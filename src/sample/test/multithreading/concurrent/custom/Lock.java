package sample.test.multithreading.concurrent.custom;

public class Lock {

	private boolean isLocked = false;
	private Thread lockingThread  = null;
	
	public synchronized void lock() throws InterruptedException
	{
		while(isLocked) {
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}
	
	public synchronized void unlock() throws InterruptedException
	{
		if(!(lockingThread == Thread.currentThread())){
			throw new IllegalMonitorStateException();
		}
		isLocked = false;
		lockingThread = null;
		notify();
	}

}
