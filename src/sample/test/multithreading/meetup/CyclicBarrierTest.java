package sample.test.multithreading.meetup;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Problem : why getNumberWaiting is returning always 0 ? it should return number of parties waiting at barrier
public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrier waitPoint = new CyclicBarrier(4, new MixedDoubleTennisGame());
		Player p1 = new Player(waitPoint ,"Vivek");
		Player p2 = new Player(waitPoint ,"Preeti");
		Player p3 = new Player(waitPoint ,"Sharma");
		Player p4 = new Player(waitPoint ,"Agrawal");
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
	    
	}

}

//The run() method in this thread should be called only when
//four players are ready to start the game

class MixedDoubleTennisGame extends Thread{
	public void run(){
		System. out .println("All four players ready, game starts \n Score Love all...");
	}
}

class Player extends Thread{
	
	String name;
	CyclicBarrier waitPoint;
	Player(CyclicBarrier waitPoint , String name){
		this.name  = name;
		this.waitPoint = waitPoint;
		//this.start();
	}
	public void run(){
		try {
			waitPoint.await();
			System.out.println("Player "+name+"\t is ready and waiting for "+waitPoint.getNumberWaiting()+"\t to get ready !");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}