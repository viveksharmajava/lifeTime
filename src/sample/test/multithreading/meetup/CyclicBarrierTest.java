package sample.test.multithreading.meetup;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrier waitPoint = new CyclicBarrier(4, new MixedDoubleTennisGame());
		new Player(waitPoint ,"Vivek");
		new Player(waitPoint ,"Preeti");
		new Player(waitPoint ,"Sharma");
		new Player(waitPoint ,"Agrawal");
	}

}

//The run() method in this thread should be called only when
//four players are ready to start the game

class MixedDoubleTennisGame extends Thread{
	public void run(){
		System. out .println("All four players ready, game starts \n Love all...");
	}
}

class Player extends Thread{
	
	String name;
	CyclicBarrier waitPoint;
	Player(CyclicBarrier waitPoint , String name){
		this.name  = name;
		this.waitPoint = waitPoint;
		this.start();
	}
	public void run(){
		System.out.println("Player "+name+"\t is ready");
		try {
			waitPoint.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}