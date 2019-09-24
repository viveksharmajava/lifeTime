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
		 Printer s = new Printer("N");
		 new Thread( new OddThread(s),"odd").start();
		 new Thread( new EvenThread(s),"even").start();
		
	}

}

class Printer {
	private String value;
	public void print(int i) {
		System.out.print(i+" ");
	}
	
	Printer(String s){
		value = s;
	}
	
	public void setValue(String s) {
		value = s;
	}
	public String getValue() {
		return value;
	}
}
class OddThread implements Runnable {
	Printer shared;
	OddThread(Printer s){
		shared =s;
	}
	public void run(){
		int i=1;
		while(i<100){
			try{
				
			//if(!shared.getValue().equals("Y"))  This is giving correct result  without it threads are running forever 
				//even though results are correct. see the below example.
			//{  
				synchronized(shared){
				System.out.println(i);
				shared.setValue("Y");
				i=i+2;
				shared.notifyAll();
				shared.wait(); // remove this if you want to use if #96
			}
				
			// uncomment below 109-113 if you want to use if #96
			//}  
			//else{
//				synchronized(shared){
//					shared.wait();
//				}
			//}
			}catch(Exception ie){
				
			}
		}
	
		
	}
}

class EvenThread implements Runnable {
	Printer shared;
	EvenThread(Printer s){
		shared =s;
	}
	public void run(){
		int i=2;
		while(i<=100){
			try{
			//if(shared.getValue().equals("Y"))
			//{   
				synchronized(shared){ 
				System.out.println(i);
				i=i+2;
				shared.setValue("N");
				shared.notifyAll();
				shared.wait();
			}
			
//			}
//			else{
//				synchronized(shared){ 
//					shared.wait();
//			}
			}catch(Exception ie){
				
			}
		}
	}
}
