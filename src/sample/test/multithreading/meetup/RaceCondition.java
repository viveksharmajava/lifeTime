package sample.test.multithreading.meetup;

/*
 * 
 */
public class RaceCondition {

	public static void main(String[] args) {
		Counter counter = new Counter();
		UseCounter c = new UseCounter(counter);
		AssignCounter ac = new AssignCounter(counter);
		Thread t1 = new Thread(c,"T1 Thread");
		Thread t2 = new Thread(c,"T2 Thread");
		Thread assignThread = new Thread(ac,"Assigned Thread");
	//	Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		assignThread.start();
		//t3.start();

	}

}

class Counter {
	//public static int count = 0;
	public  int count = 0;
	
	
	
 
}//end of Counter 
class UseCounter implements Runnable{
	Counter counter ;
	UseCounter(Counter counter){
		this.counter =counter;
	}
	public void increment(){
		for(int i=0;i<5;i++)
		 {
				synchronized(this) {//put synchronization to avoid race condition. Why synch.. on this it should be on Counter object rit? this is the 
					                // repeated mistake i'm keep doing isn't? I think I need to learn a lot about threading.
				counter.count++;
				System. out .println(Thread.currentThread().getName()+"\t count="+counter.count);
				  try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 }
	}	
		 
	}
	
	public void run(){
		 System. out .println(Thread.currentThread().getName()+"   started");
		increment();
			
	}
}


class AssignCounter implements Runnable{
	Counter counter ;
	AssignCounter(Counter counter){
		this.counter =counter;
	}
	public void assign( int  a){
		counter.count = a;
		  System. out .println("in assign "+Thread.currentThread().getName()+"\t count="+counter.count);
		 for(int i=0;i<5;i++)
			{
				 synchronized(this) 
				 {//put synchronization to avoid race condition
				   counter.count++;
				   System. out .println(Thread.currentThread().getName()+"\t count="+counter.count);
				   try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     }
	     }//EOf for
	  }
	
	public void run(){
		 System. out .println(Thread.currentThread().getName()+"   started");
		assign(5000);//what is the use of passing 5000 here?
		System.out.println("AssignCounter="+counter.count);
		
	}
}
