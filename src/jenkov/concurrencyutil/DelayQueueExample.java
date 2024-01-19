package jenkov.concurrencyutil;

import java.util.concurrent.DelayQueue;

public class DelayQueueExample {

	public static void main(String[] args) {
      
	DelayQueue < DelayElement> queue = new DelayQueue < DelayElement>();
	DelayQueueProducer  producer  = new DelayQueueProducer(queue);
	DelayQueueConsumer consumer = new DelayQueueConsumer(queue);
	Thread producerT= 	new Thread(producer);
	Thread consumerT = new Thread(consumer);
	producerT.start();
	consumerT.start();
	if(!producerT.isAlive()) {
		 System.out.println("Producer finished!");
	 }
	
	}

}
