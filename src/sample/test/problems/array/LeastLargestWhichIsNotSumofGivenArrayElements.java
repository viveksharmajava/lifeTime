package sample.test.problems.array;

/**
 * 
 * @author viveksharma
 * 
 * You have given a sorted array, you need to tell a smallest number which can not be represent 
 * by the sum of any subset of given array.
 * 
 * For Example : Input= {1,3,5,6} 
 *               Ans : 2 ( 2 can not be formed by adding any sub array)
 *               
 *               Input {1,2,3,4,5}
 *               output:16
 *
 */

public class LeastLargestWhichIsNotSumofGivenArrayElements {

	public static void main(String[] args) {
      
		int [] input = {1,3,5,6};
		System.out.println(leastLargeNumber(input));
		int [] input2 = {1,2,3,4,5};
		System.out.println(leastLargeNumber(input2));
	}
	
  public static  int leastLargeNumber(int [] input) {
	  int sum = 0;
	  for(int i=0;i<input.length ; i++) {
		  if(((sum+1) < input[i])) {
			  return sum+1;
		  }
		  sum = sum+input[i];
		  
	  }
	  return sum+1;
	  
  }

}
