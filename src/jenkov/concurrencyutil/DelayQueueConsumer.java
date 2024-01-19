package jenkov.concurrencyutil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;


public class DelayQueueConsumer implements Runnable {
	private BlockingQueue <DelayElement> delayQueuey;
	DelayQueueConsumer(BlockingQueue  <DelayElement> queue){
		delayQueuey = queue;
	}

	public void run(){
		long currenttime = System.currentTimeMillis();
		while(true){
			try {
				DelayElement delayElement = delayQueuey.take();
				System.out.println("Consuming delayed element ="+delayElement.name +"at "+( (System.currentTimeMillis()-currenttime))/1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
	}
}
