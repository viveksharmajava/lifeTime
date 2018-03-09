package sample.test.multithreading.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 LinkedBlockingQueue <String> linkedQueue= new  LinkedBlockingQueue<String>();
		 Producer produce = new Producer(linkedQueue);
			
			new Thread(produce).start();
			Consumer consumer = new Consumer(linkedQueue,"COnsumer1");
			consumer.start();
			Consumer consumer2 = new Consumer(linkedQueue,"Consumer 2");
		consumer2.start();
			

	}

}
