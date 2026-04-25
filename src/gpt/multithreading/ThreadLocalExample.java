package gpt.multithreading;

public class ThreadLocalExample {

	public static void main(String[] args) {
     ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
     Thread t1 = new Thread("Thread-1") {
     public void run() {
    		 threadLocal.set(100);
    		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 System.out.println(Thread.currentThread()+"\t value ="+threadLocal.get());
    	 }
     };
     Thread t2 = new Thread("Thread-2") {
         public void run() {
        		 threadLocal.set(200);
        		 try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		 System.out.println(Thread.currentThread()+"\t value ="+threadLocal.get());
        	 }
         };
     
        t2.start();
        t1.start();
	}

}
