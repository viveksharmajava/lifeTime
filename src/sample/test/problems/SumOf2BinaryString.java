package sample.test.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOf2BinaryString {

 public static void main(String[] args) throws IOException {

	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 String s;
	 
	 while((s = in.readLine() ) !=null){
		 
		 String [] inputArr = s.split(" ");
		 
		/* System.out.println((1+1+1)/2);
		 System.out.println((1+0)%2);
		 System.out.println((0+0)%2);
*/		 add2Binaries(inputArr[0],inputArr[1]);
		 
	 }
	}
 
  static  void  add2Binaries( String a ,String b){
	 // System.out.println(" a="+a+"\t length="+a.length());
	 // System.out.println(" b="+b+"\t length="+b.length());
	  StringBuilder sb = new StringBuilder("");
	  int l1 = a.length()-1;
	  int l2 = b.length()-1;
	  int carry =0;
	  int twice=0;
	  int c=0;
	while( l1 >=0 && l2>=0){
		 //System.out.println(i);
		  int val1  = Character.getNumericValue(a.charAt(l1));
		  int val2  = Character.getNumericValue(b.charAt(l2));
		   c =(val1 +val2 +carry)%2;
		  twice = (val1 +val2+ carry)/2;
		  carry = twice;
		  sb.append(c);
		 // System.out.print(c);
		  l1--;
		  l2--;
	  }
	System.out.println("l1="+l1+"\t l2="+l2+"\t carry="+carry);
	if(l1 < 0 && l2< 0 && carry >0){
		 sb.append(carry);
		//System.out.print(carry);
	}
	else if(l1>=0){
		while( l1 >=0 ){
			  int val1  = Character.getNumericValue(a.charAt(l1));
			   c =(val1  +carry)%2;
			  twice = (val1 + carry)/2;
			  carry = twice;
			  sb.append(c);
			 // System.out.print(c);
			  l1--;
			
		  }
	}
	else if(l2>=0){
		while( l2 >=0 ){
			  int val1  = Character.getNumericValue(b.charAt(l2));
			   c =(val1  +carry)%2;
			  twice = (val1 + carry)/2;
			  carry = twice;
			  sb.append(c);
			  l2--;
			
		  }
	}
	
	if(carry > 0 && c==0){
		 sb.append(carry);
	}
	System.out.println(sb.reverse());
  }

}
