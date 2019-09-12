package sample.test.number;

public class FindMinNumberOf2toThePowNToGetY {

	public static void main(String[] args) {
		int powerUp = (int) Math.floor(Math.log(33) / Math.log(2));
		  System.out.println(powerUp);
		int val =  minPowAnother(33); // 2^6-2^5+2^0; but it should be 
		System.out.println(val);
		val =  minPowAnother(129);
		System.out.println(val);
		val =  minPowAnother(26);
		System.out.println(val);
		
		val =  minPowAnother (22);
		System.out.println(val);
	}
	public static int minPow(int n) {
	     //base case(0) = 0
	    if (n == 0) {
	      return 0;
	    }
	    //gets n to the power Higher than this number
	    //(basically math that does log base 2 of n)
	    int powerUp = (int) Math.ceil(Math.log(n) / Math.log(2));
	    
	    //the value associated with this 2^powerup
	    int valHigher = (int) Math.pow(2, powerUp);
        System.out.print(valHigher+"\t");
	    if (valHigher == (n * 2)) {
	      return 1;
	    } else {
	      return 1 + minPow(valHigher - n);
	    }
	  }

	public static int minPowAnother(int n) {
	     //base case(0) = 0
	    if (n == 0) {
	      return 0;
	    }
	    //gets n to the power Higher than this number
	    //(basically math that does log base 2 of n)
	    int powerUp = (int) Math.ceil(Math.log(n) / Math.log(2));
	    int powerDown = (int) Math.floor(Math.log(n) / Math.log(2));
	    
	    //the value associated with this 2^powerup
	    int valHigher = (int) Math.pow(2, powerUp);
	    int valLower = (int) Math.pow(2, powerDown);
	    if (valHigher == (n * 2)) {
		      return 1;
	    }
	    else if(n-valLower < valHigher-n) {
	    	return 1 + minPowAnother(n - valLower);
	    }else {
	    	return 1 + minPowAnother(valHigher - n);
	    }
	   
	  }
}
