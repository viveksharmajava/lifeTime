package sample.test.number;

public class printFactorialUpto200 {

	public static void main(String[] args) {
		for(int i = 100; i>=2 ; i--) {
			factorialOfN(i);
		}
			
	}
	
	public static void factorialOfN(int n) {
		
		StringBuffer fact = new StringBuffer("1");
		StringBuffer sb2 = new StringBuffer();
		int a ;
		int multi;
		int carry = 0 ;
		int r;
		for(int x = 2 ; x<=n ; x++)
		 {
			sb2 = new StringBuffer();
			char [] arr = (new String(fact)).toCharArray();
			for(int i = arr.length-1 ; i>=0 ; i--) {
				  a = Character.getNumericValue(arr[i]);
				  multi = a*x+carry;
				  r = returnMode(multi);
				  carry = returnCarry(multi);
				  sb2.insert(0, r);
			}
			if(carry != 0) sb2.insert(0, carry);
			fact = new StringBuffer(sb2);
			carry = 0;
		}
		System.out.println(""+fact +"\t length ="+fact.length());
		
	}
	
	private static int returnCarry(Integer num) {
		
		int  c = num/10;
		return c;	
		      
	}
	
	private static int returnMode(Integer num) {

		
		int  c = 0;
		String s = num.toString();
		c = Character.getNumericValue(s.charAt(s.length()-1));
	return c;	
		      
		
	}
}
