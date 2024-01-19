package jenkov.concurrencyutil;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	public static void main(String[] args) {

		SynchronousQueue <Integer> queue = new SynchronousQueue();
		
		new Thread("I'm producer") {
			public void run() {
				int i =1;
				while(true) {
					try {
						//System.out.println("Before adding to queue"+i);
						queue.put(i);
						System.out.println(" queue size ="+queue.size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					i++;
					if( i == 11) break;
					
				}
			}
		}.start();
		new Thread("I'm Consumer") {
			public void run() {
				while(true) {
					
					try {
						System.out.println("After retrieving from  queue ="+queue.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}

}
