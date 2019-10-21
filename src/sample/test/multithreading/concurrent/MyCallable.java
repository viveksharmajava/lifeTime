package sample.test.multithreading.concurrent;

import java.util.concurrent.Callable;

public class MyCallable  implements Callable{

	private long waitTime;
	MyCallable(long waitingTime){
		this.waitTime = waitingTime;
	}
	
	@Override
	public Object call() throws Exception {
		
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}

}
