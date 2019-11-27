package sample.test.multithreading.concurrent.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {

	public static void main(String[] args) {

		 BlockingQueue <DelayedElement> queue = new DelayQueue<DelayedElement>();
		 
		 Thread producer  = new Thread(new DelayQueueProducer(queue));
		 Thread consumer  = new Thread(new DelayQueueConsumer(queue));
		 producer.start();
		 consumer.start();
		 if(!producer.isAlive()) {
			 System.out.println("Producer finished!");
		 }
		 
		 
	}

}
