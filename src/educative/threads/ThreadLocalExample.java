package educative.threads;

public class ThreadLocalExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyRunnable local  = new MyRunnable();
		Thread t1 = new Thread(local);
		Thread t2 = new Thread(local);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}

class MyRunnable implements Runnable {
 ThreadLocal <Integer> threadLocal = new ThreadLocal<>();
	@Override
	public void run() {
		
		int  i=  (int) (Math.random() * 100D) ;
		 threadLocal.set(i);
          System.out.println(Thread.currentThread().getName()+" configure threadlocal ="+i);
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	        }

	        System.out.println(Thread.currentThread().getName()+" reading threadlocal ="+threadLocal.get());
	}
	
}