package sample.test.multithreading;

public abstract class SimpleThreads {

	
	static void threadMessage(String message){
		
		String threadName =Thread.currentThread().getName();
		System.out.println("thread name="+threadName+"        message="+message);
	}
	
	private static class MessageLoop implements Runnable
	{
		
		public void run(){
			String importantInfo[] = {
	                "Mares eat oats",
	                "Does eat oats",
	                "Little lambs eat ivy",
	                "A kid will eat ivy too"
	            };
			
		try{
			
			for(int i=0;i<importantInfo.length;i++){
				Thread.sleep(4000);
				threadMessage(importantInfo[i]);
			}
			
		}catch(InterruptedException ie){
			System.out.println("I wasn't done !!!!!!!!!!!");
		}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop(),"MessageLoop");
        t.start();
        long patience = 1000 * 1*6;
        threadMessage("Waiting for MessageLoop thread to finish");
        while(t.isAlive()){
        	//System.out.println("Still waiting :)");
        	//t.join(1000);
        	if((System.currentTimeMillis()-startTime)>patience && t.isAlive()){
        		threadMessage("Tired of waiting!");
        		t.interrupt();
        		
        		
        	}
        }

        threadMessage("Finally!");
	}

}
