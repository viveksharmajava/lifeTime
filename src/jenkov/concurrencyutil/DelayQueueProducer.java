package jenkov.concurrencyutil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueProducer implements Runnable{

	private BlockingQueue <DelayElement> delayQueuey;
	DelayQueueProducer( BlockingQueue  <DelayElement> queue){
		delayQueuey = queue;
	}

	public void run(){
		
		for(int i =1 ; i <=10;i++){
			DelayElement delayElement = new DelayElement(" Element "+i, 1000l*i);
			System.out.println("producing delayed element ="+delayElement.name);
			try {
				delayQueuey.put(delayElement);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

}
