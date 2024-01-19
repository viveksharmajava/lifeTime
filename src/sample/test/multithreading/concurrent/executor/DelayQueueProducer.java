package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.BlockingQueue;
public class DelayQueueProducer implements Runnable{

	private BlockingQueue <DelayedElement> delayQueuey;
	DelayQueueProducer( BlockingQueue  <DelayedElement> queue){
		delayQueuey = queue;
	}

	public void run(){
		
		for(int i =1 ; i <=10;i++){
			DelayedElement delayElement = new DelayedElement(" Element "+i, 1000*i);
			System.out.println("producing delayed element ="+delayElement.getElementName());
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
