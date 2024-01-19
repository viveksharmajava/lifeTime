package ds500problems.number;

import java.util.Arrays;

import sample.test.collection.queue.Queue;

public class ProblemOnNumbers {

	public static void main(String[] args) {
		
		System.out.println(reverseInt(54321));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		//convertDecimalToX(4,2);
		convertDecimalToX(Integer.MAX_VALUE,2);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		//convertDecimalToX(4,2);
		convertDecimalToX(Integer.MIN_VALUE,2);
		
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE-1));
		convertDecimalToX(Integer.MAX_VALUE-1,2);
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE+1));
		convertDecimalToX(Integer.MIN_VALUE+1,2);//this is not working
	
	 //print the next greater number formed with the same digits of give  number
		nextGreaterNumberWithSameDigits(218765);
		
		System.out.println("\nGet minimum number of squaires which sum equals to given number");
		System.out.println("for given N=70 "+ getMinSquaires(70));
		
	}
	
	public static StringBuilder convertDecimalToX(int number , int base) {
		StringBuilder sb  = new StringBuilder();
		boolean isNegative = false;
		if(number < 0) {
			//handle special case when number is Integer.MIN_VALUE
			if(number == Integer.MIN_VALUE) {
				sb.append("1");
			for(int i = 1 ; i <= 31 ; i++) {
				sb.append("0");
				}
			System.out.println(sb);
			return sb;		
			}
			isNegative = true;
			number = -number;
		}
		while(number > 0) {
		 int digit = number%base;
		 number = number/base;
		 sb.insert(0, digit);
		}
		if(isNegative) {
			int len = 32- sb.length();
			for(int i = 1 ; i <= len ; i++) {
				sb.insert(0, "1");
			}
		}
		System.out.println(sb);
		return sb;
	}
	public static int reverseInt(int num) {
		boolean negativeNumber = false;
		if(num < 0) {
			negativeNumber = true;
			num = -num;
		}
		
		int  reverse_num = 0 , previous_num=0;
		while(num !=0) {
			int digit = num%10;
			reverse_num = reverse_num*10 + digit;
			//handle overflow  if (reverse_num - digit)/10 != previous_num  
			//it means number get overflow from interger range.
			if((reverse_num -digit)/10 != previous_num) {
				System.out.println("Revesed number is overflowed than Integer limit");
				return 0;
			}
			previous_num = reverse_num;
			num = num/10;
		}
	    return previous_num;
	}
  /*
   * Find next greater number with same set of digits
   * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/	
   *  
      Input:  n = "218765"
	  Output: "251678"
   */
   public static void nextGreaterNumberWithSameDigits(Integer number) {
	   
	  char [] chars = number.toString().toCharArray();
	  // (I) Start from the right most digit
      // and find the first digit that is smaller
      // than the digit next to it.
	  int i ;
	  for(i = chars.length-1 ; i >0 ; i--) {
		  if(chars[i] > chars[i-1]) break;
	  }
	// If no such digit is found, then all
      // digits are in descending order means
      // there cannot be a greater number with
      // same set of digits
      if (i == 0)
      {
          System.out.println("Not possible");
      }
      else
      {
    	  int x = chars[i-1] , min = i;
    	  // (II) Find the smallest digit on right
          // side of (i-1)'th digit that is greater
          // than number[i-1]
    	  for(int j = i+1 ; j < chars.length; j++) {
    		 if(x < chars[j] && chars[min] > chars[j]) {
    			 min = j;
    		 }
    	  }
    	  // (III) Swap the above found smallest
          // digit with number[i-1]
    	 swap(chars, i-1 , min);
    	 //(IV) sort  the digits after i-1 in ascending orders.
    	 Arrays.parallelSort(chars, i , chars.length); 
    	 System.out.print("Next number with same" +
                 " set of digits of"+number +" is ");
		for (i = 0; i < chars.length; i++)
		System.out.print(chars[i]);
      
      }
	  
   }
   // Utility function to swap two digit
  public  static void swap(char ar[], int i, int j)
   {
       char temp = ar[i];
       ar[i] = ar[j];
       ar[j] = temp;
   }
  
  //get minimum number number of squaire whose sum equals to given number n
  //https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
   public static int getMinSquaires(int n ) {
	   if(n <= 3) return n;
	   
	   //maximum squares require is n
	   // 1*1 + 1*1 ..... n
	   int resp = n;
	   for(int x = 1; x  <= n ; x++ ) {
		  int  temp =  x*x;
		  if( temp > n) break;
		  else {
			  resp = Math.min(resp, 1+ getMinSquaires(n-temp));
		  }
	   }
	  return resp;
   }
}
