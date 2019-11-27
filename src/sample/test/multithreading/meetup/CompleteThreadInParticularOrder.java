package sample.test.multithreading.meetup;

/*
 * You have given 3 Thread t1,t2,t3
 * how will you make sure thread t1 finish after thread t2 and thread t2 finish after thread t3.
 * t3 finished
 * t2 finished
 * t1 finished
 * xs
 * Solution :
 * Approach :  User  CyclicBarrier 
 */
public class CompleteThreadInParticularOrder {

	public static void main(String[] args) {
		T3 t3 = new T3();
		t3.setName("t3");

		T2 t2  = new T2(t3);
		t2.setName("t2");
		
		T1 t1 = new T1(t2);
		t1.setName("t1");
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}

}


class T1 extends Thread{
	T2 t2 = null;
	T1(T2 t2){
		
		this.t2 = t2;
	}
	
	
	public void run() {
		System.out.println("Running thread="+Thread.currentThread().getName());


		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Finished thread="+Thread.currentThread().getName());

	
		
		
	}
}
class T2 extends Thread{
	T3 t3 = null;
	T2(T3 t){
		t3 =t;
	}
	public void run() {
		System.out.println("Running thread="+Thread.currentThread().getName());

		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Finished thread="+Thread.currentThread().getName());

	}
}
class T3 extends Thread{
	public void run() {
		System.out.println("Running thread="+Thread.currentThread().getName());
		System.out.println("Finished thread="+Thread.currentThread().getName());

	}
}
