package sample.test.multithreading.concurrent.executor;
import java.util.Random;

public class ProducerConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Drop drop = new Drop();
		
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();

	}

}

class Drop{
	
	private String message;
	private boolean empty=true;
	
	public synchronized  String take(){
		while(empty){
			
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("I was interuppted");
			}
		}
		//toggle status
		empty=true;
		//notify producer that status has changed.
		notifyAll();
		return message;
	}
	
	public synchronized  void put(String message){
		while(!empty){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("I was interuppted");
			}
			
			//toggle message 
			empty=false;
			this.message= message;
			notifyAll();//notify consumer that status has changed.
		}
	}
}

class Producer implements Runnable{
	
	private Drop drop;
	Producer(Drop drop){
		this.drop=drop;
	}
	
	public void run(){
		
		String []someMessages ={"vivek","and","Preeti","got","married"};
		Random random = new Random();
		for(int i =0;i<someMessages.length ;i++){
			drop.put(someMessages[i]);
			try{
				Thread.sleep(random.nextInt(100));
			}catch(InterruptedException e){
				System.out.println("producer interrupted");
			}
		}
		drop.put("DONE");
		
	}

}
class Consumer implements Runnable{
	
	private Drop drop;
	
	Consumer(Drop drop){
		this.drop = drop;
	}
	Random random = new Random();
	public void run(){
		while(!"DONE".equals(drop.take())){
			System.out.println(" Consumer consumer="+drop.take());
			try{
				Thread.sleep(random.nextInt(100));
			}catch(InterruptedException e){
				System.out.println("consumer interrupted");
			}
		}
	}
}
