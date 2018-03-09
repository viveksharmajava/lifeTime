package sample.test.problems.array;

public class OddOccurance {

	/**
	 *Find the Number Occurring Odd Number of Times
		Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.
		
		Example:
		I/P = [1, 2, 3, 2, 3, 1, 3]
		O/P = 3
	 */
	public static void main(String[] args) {
 
		int input [] = {1, 2, 3, 2, 3, 1, 3};
		int odd = getOddOccurence(input);
		System.out.println("odd="+odd);
	}
	
   public static int getOddOccurence(int []input){
	   
	   int result =0;
	   for(int i=0;i<input.length;i++){
		   result = result ^ input[i];
	   }
	   return result;
   }

}
