package sample.test.multithreading.concurrent.executor;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable {
	private BlockingQueue <DelayedElement> delayQueuey;
	DelayQueueConsumer(BlockingQueue  <DelayedElement> queue){
		delayQueuey = queue;
	}

	public void run(){
		while(true){
			try {
				DelayedElement delayElement = delayQueuey.take();
				System.out.println("Consuming delayed element ="+delayElement.getElementName());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
