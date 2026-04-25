package gpt.multithreading;

import java.util.concurrent.Semaphore;

public class OddEvenUsingSemaphore {

	public static void main(String[] args) {
      Semaphore s  = new Semaphore(1, true);
      int max = 100;
      Thread even = new Thread("Odd printer") {
    	 
    	  public void run() {
    		for(int i = 0 ; i <=100; i+=2) {
    			
        		 try {
        			 s.acquire();
        			 System.out.println(i);
        		 }catch(Exception e){
        			 
        		 }
        		 finally { s.release();
        		 }
    		}
    		
    	  }
      };
      
      Thread odd = new Thread("Even printer") {
     	 
    	  public void run() {
    		for(int i = 1 ; i <=100; i+=2) {
    			try {
       			 s.acquire();
       			 System.out.println(i);
       		 }catch(Exception e){
       			 
       		 }
       		 finally { s.release();
       		 }
    		}
    		
    	  }
      };
      even.start();
      odd.start();
	}

}
