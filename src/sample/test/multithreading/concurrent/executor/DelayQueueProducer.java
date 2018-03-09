package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.BlockingQueue;
public class DelayQueueProducer implements Runnable{

	private BlockingQueue <DelayedElement> delayQueuey;
	DelayQueueProducer( BlockingQueue  <DelayedElement> queue){
		delayQueuey = queue;
	}

	public void run(){
		
		for(int i =100 ; i <=1000;i+=100){
			DelayedElement delayElement = new DelayedElement(" Element "+i, 1000+i);
			System.out.println("producing delayed element ="+delayElement.getElementName());
			delayQueuey.offer(delayElement);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
