package sample.test.multithreading;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {

		TimerTask tk = new MyTimerTask();
		
		//Running timer task as daemon thread.
		Timer timer = new Timer(true);
		
		timer.scheduleAtFixedRate(tk, 0, 5*10000);
		
		System.out.println(" Timer task started");
		try {
			Thread.sleep(100000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		timer.cancel();
		System.out.println("Timer Cancelled ");
	}

}
