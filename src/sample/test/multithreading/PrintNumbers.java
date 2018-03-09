package sample.test.multithreading;

// write a program to print 1-20 seque . using 3 threads.
public class PrintNumbers {

	
	public static void main(String[] args) {
	
		 new Thread( new MuttiThreading("T1",1),"T1").start();
		 new Thread( new MuttiThreading("T2",2),"T2").start();
		 new Thread( new MuttiThreading("T3",3),"T3").start();
	}

	
}



class  MuttiThreading implements Runnable{
	 String threadName=null;
	 private static boolean t1Available = true;
	 private static boolean t2Available = false;
	 private static boolean t3Available = false;
	 private  int i =1;
	public void run()
	 {
		/*if("T1".equalsIgnoreCase(Thread.currentThread().getName())){
			t1();
		}
		else if("T2".equalsIgnoreCase(Thread.currentThread().getName())){
			t2();
		}
		else if("T3".equalsIgnoreCase(Thread.currentThread().getName())){
			t3();
		}*/
		t1();
	 }
	
	MuttiThreading(String name,int start){
		 this.threadName=name;
		 this.i= start;
	 }
	
	private synchronized  void t1(){
		while(i <= 20){
			try{
			if(t1Available ||t2Available ||t3Available)
			{    
				System.out.println(Thread.currentThread().getName()+"\t printing="+i);
				i= i+3;
				if (t1Available){ t1Available=false; t2Available=true;}
				else if (t2Available) {t2Available =false ; t3Available=true;}
				else{
					t3Available =false;
					t1Available=true;
				}
				
				wait(500);
			}
				
			else{
				wait(500);
			}
			}catch(InterruptedException ie){
				
			}
		}
	}
	private void t2(){
		while(i<=20){
			try{
			if(t2Available)
			{    
				System.out.println(i);
				i++;
				t2Available =false;
				t3Available = true;
				notifyAll();
			}
			else{
				wait();
			}
			}catch(Exception ie){
				
			}
		}
	}
	private void t3(){
		while(i<=20){
			try{
			//System.out.println(" before t1 if ");	
			if(t3Available)
			{    
				System.out.println(i);
			    i++;
				t3Available =false;
				t1Available = true;
				notifyAll();
			}
			else{
				//System.out.println("waiting ="+Thread.currentThread().getName()+"\t and availability="+available);
				wait();
			}
			}catch(Exception ie){
				
			}
		}
	}
}