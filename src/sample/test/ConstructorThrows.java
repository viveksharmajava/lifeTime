package sample.test;

import java.io.FileNotFoundException;

public class ConstructorThrows {

	ConstructorThrows()  {
		
	}
	public static void main(String[] args) throws Throwable {
		
		System.out.println(1+2+"vivek"+1+2+3);
		ConstructorThrows ct  = new ConstructorThrows();
		ct.finalize();
		//ct.m2();
	}
   void m1() throws FileNotFoundException,NullPointerException{
	 
 }
   void m2() {
	   try{
		   throw new NullPointerException(); 
	   }
	   finally{
		   System.out.println(" hello in finally");
	   }
		 
   }
}

class BBBB extends ConstructorThrows{
	 BBBB()  throws Exception {
		super();
	}
	
	void m1() throws RuntimeException{
		
	}
	
	
}