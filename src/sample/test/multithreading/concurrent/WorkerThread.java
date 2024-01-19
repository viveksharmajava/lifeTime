package sample.test.multithreading.concurrent;

public class WorkerThread  implements Runnable{
	
	String cmd;
	WorkerThread(String command){
		this.cmd = command;
	}
	
	private void processCommand() {
		System.out.println(Thread.currentThread().getName()+" Processing Command ="+cmd);
//		try {
//			//Thread.sleep(2000);
//		}catch(InterruptedException e) {
//			
//		}
	}
	
	public void run() {

        System.out.println(Thread.currentThread().getName()+" Start. Command = "+cmd);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" Finished");
		
	}
}