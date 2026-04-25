package gpt.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore s = new Semaphore(2,true);//false faireness
       for(int i = 0; i < 5 ; i++) {
    	   new Worker(s).start();
       }
	}
	

}
class Worker extends Thread {
    Semaphore semaphore;

    Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " waiting");

            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() + " acquired permit");

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " releasing permit");

            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
