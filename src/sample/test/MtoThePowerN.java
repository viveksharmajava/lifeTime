package sample.test;

public class MtoThePowerN {

	/**
	 * @param args write a program to calculate M
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int s= mMultiPlyN(2,24);
		System.out.println(s);
		System.out.println(Math.pow(2, 24));
		
      
	}
	
	public static  int mMultiPlyN(int m , int n){
		
	  int result = 1;
	  boolean nisOdd =false;
	  if(n%2 >0 && n/m >=2) nisOdd=true;
	  int  x = m;
	  int i=1;
	  while(n/m >=2){
		  System.out.println("in while "+i++);
		  m = m*m;
		  n= n/2;
	  }
	  System.out.println("after m and calculation m="+m+"\t n="+n);
	 while(n>0){
		 result= result * m;
		 n--;
	 }
	 if (nisOdd){
		 result = result*x;
	 }
	  return result;
	}

}
