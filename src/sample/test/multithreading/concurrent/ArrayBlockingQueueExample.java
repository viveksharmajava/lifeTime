package sample.test.multithreading.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample  {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		 ArrayBlockingQueue <String> blockingArray = new ArrayBlockingQueue<String>(16,true);//set fairness true grant thread access in FIFO	
		Producer produce = new Producer(blockingArray);
		
		new Thread(produce).start();
		Consumer consumer = new Consumer(blockingArray,"Consumer1");
		consumer.start();
		Consumer consumer2 = new Consumer(blockingArray,"Consumer 2");
	consumer2.start();
		
		

	}
	
}

class Producer implements Runnable{
	
	//ArrayBlockingQueue<String> produce;
	BlockingQueue<String> produce;//to make it generic so that other concrete implementation may also use same producer and consumer for example
	Producer(BlockingQueue produce){
		this.produce = produce;
	}
	public void run(){
		
		try{
			
			for(int i =0 ;i<100;i++)
			{
				//System.out.println("producer inserting"+"produced"+i);
				produce.put(""+i);
			}
			produce.put("EndProducing");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
class Consumer extends Thread{
//	ArrayBlockingQueue<String> produce;
	BlockingQueue<String> consume;//to make it generic so that other concrete implementation may also use same producer and consumer for example
	Consumer(BlockingQueue consume,String name){
		super(name);
		this.consume = consume;
		
	}
	public void run(){
		  try{
			String received=null;
			System.out.println(" consume.size()  ="+consume.size());
		  //  while(! "EndProducing".equals(produce.poll(1000,TimeUnit.MILLISECONDS))  ){
			 while(! "EndProducing".equals(received=consume.take())  ){
		    	System.out.println("Received="+received+"\t by thread"+this.getName());
		    }
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}

