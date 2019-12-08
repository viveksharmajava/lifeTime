package sample.test.multithreading;

// write a program to print 1-20 seque . using 3 threads.
public class PrintNumbers {

	
	public static void main(String[] args) {
	
//		 new Thread( new MuttiThreading("T1",1),"T1").start();
//		 new Thread( new MuttiThreading("T2",2),"T2").start();
//		 new Thread( new MuttiThreading("T3",3),"T3").start();
		
		 Print p = new Print("A");
		 new Thread(new PrintSequence(1,20 , p)).start();
		 new Thread(new PrintSequence2(2,20 , p)).start();
		 new Thread(new PrintSequence3(3,20 , p)).start();
		 
		 // where there are 3 classses PS1,2,3 it can be achieved using 1 class only just need to set A,B,C carefully?
	}

	
}
class Print {
	private String value;
	public void print(int i) {
		System.out.print(i+" ");
	}
	
	Print(String s){
		value = s;
	}
	
	public void setValue(String s) {
		value = s;
	}
	public String getValue() {
		return value;
	}
}

class PrintSequence implements Runnable{
	Print shared ;
	int seq;
	int upto;
	PrintSequence(int sequence, int up , Print p){
	  this.seq = sequence;
	  this.upto = up;
	  this.shared = p;
	}
	public void run() {

		int i=seq;
		while(i<= this.upto){
			try{
				
			if(shared.getValue().equals("A"))
			{  synchronized(shared){
				shared.print(i);
				shared.setValue("B");
				i=i+3;
			}
			shared.notifyAll();
			}
			else{
				wait();
			}
			}catch(Exception ie){
				
			}
		}
	}
}

class PrintSequence2 implements Runnable{
	Print shared ;
	int seq;
	int upto;
	PrintSequence2(int sequence, int up , Print p){
	  this.seq = sequence;
	  this.upto = up;
	  this.shared = p;
	}
	public void run() {

		int i=seq;
		while(i<= this.upto){
			try{
				
			 if(shared.getValue().equals("B"))
			{  synchronized(shared){
				shared.print(i);
				shared.setValue("C");
				i=i+3;
			}
			shared.notifyAll();
			}
			else{
				wait();
			}
			}catch(Exception ie){
				
			}
		}
	}
}


class PrintSequence3 implements Runnable{
	Print shared ;
	int seq;
	int upto;
	PrintSequence3(int sequence, int up , Print p){
	  this.seq = sequence;
	  this.upto = up;
	  this.shared = p;
	}
	public void run() {

		int i=seq;
		while(i<= this.upto){
			try{
		  if(shared.getValue().equals("C"))
			{  synchronized(shared){
				shared.print(i);
				shared.setValue("A");
				i=i+3;
			}
			shared.notifyAll();
			}
			
			else{
				wait();
			}
			}catch(Exception ie){
				
			}
		}
	}
}
//This is not a correct way of implementation
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