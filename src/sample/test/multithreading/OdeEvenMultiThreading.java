package sample.test.multithreading;

public class OdeEvenMultiThreading implements Runnable {

	 String type=null;
	 private static boolean available = false;
	 OdeEvenMultiThreading(String type){
		 System.out.println("type instantiated="+type);
		 this.type=type;
	 }
	public void run(){
		System.out.println("type exucted="+type);
		if("even".equals(type)) even();
		else odd();
	}
	
	public synchronized void even(){
		int i=2;
		while(i<=100){
			try{
			//System.out.println(" before if in even="+available);	
			if(available)
			{    
				System.out.println(i);
				i=i+2;
				available =false;
				notifyAll();
			}
			else{
				//System.out.println("waiting ="+Thread.currentThread().getName()+"\t and availability="+available);
				//wait(1000);
			}
			}catch(Exception ie){
				
			}
		}
	}
	public synchronized void odd(){
		int i=1;
		while(i<100){
			try{
				
			if(!available)
			{    
				System.out.println(i);
				available =true;
				i=i+2;
				notifyAll();
			}
			else{
				//System.out.println("waiting ="+Thread.currentThread().getName()+"\t and availability="+available);
				//wait(1000);
			}
			}catch(Exception ie){
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		 new Thread( new OdeEvenMultiThreading("even"),"Even").start();
		 new Thread( new OdeEvenMultiThreading("odd"),"Odd").start();
		/* String s ="N";
		 new Thread( new OddThread(s),"odd").start();
		 new Thread( new EvenThread(s),"even").start();*/
		
	}

}

class OddThread implements Runnable {
	String shared;
	OddThread(String s){
		shared =s;
	}
	public void run(){
		int i=1;
		while(i<100){
			try{
				
			if(!shared.equals("Y"))
			{  synchronized(shared){
				System.out.println("waiting ="+Thread.currentThread().getName() +"\t i ="+i);
				System.out.println(i);
				shared ="Y";
				i=i+2;
			}
				
			shared.notifyAll();
			}
			else{
				//System.out.println("waiting ="+Thread.currentThread().getName()+"\t and availability="+available);
				shared.wait();
			}
			}catch(Exception ie){
				
			}
		}
	
		
	}
}

class EvenThread implements Runnable {
	String shared;
	EvenThread(String s){
		shared =s;
	}
	public void run(){
		int i=2;
		while(i<=100){
			try{
			//System.out.println(" before if in even="+available);	
			if(shared.equals("Y"))
			{   synchronized(shared){ 
				System.out.println(i);
				i=i+2;
				shared ="N";
			}
			shared.notifyAll();
			}
			else{
				//System.out.println("waiting ="+Thread.currentThread().getName()+"\t and availability="+available);
				shared.wait();
			}
			}catch(Exception ie){
				
			}
		}
	
		
	}
}
