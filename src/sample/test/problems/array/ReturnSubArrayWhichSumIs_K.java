package sample.test.problems.array;

/**
 * 
 * @author viveksharma
 * you have given unsorted array which may have positive and negative numbers
 * 
 *  Problem 1 : Return 1 if there is a continues sub array with sum K else 0.
 *  Problem 2: Return number of sub arrays which sum is K.
 *
 */
public class ReturnSubArrayWhichSumIs_K {

	public static void main(String[] args) {
		
		int [] input = { 2,-1,4,6,10 ,12 };
		//System.out.println(findSubArrayWhichSomeIs_K(input , 5));
        System.out.println(findSubArrayWhichSomeIs_K(input , 22));
	}
	
	public static int findSubArrayWhichSomeIs_K(int [] input,int k) {
		
		int start = 0;
		int sum = 0;
		int count=0;
		int [] sumOfAi = new int [input.length];
		for(int i = 0 ; i < input.length ; i++ ) {
		  sum = sum + input[i];
		  if(sum == k) { // you may return 1 here for problem 1 just need to modify 
			  count++;
			  start = i+1;
			  sum = 0;
		  }
		  else if (sum > k) {
			  sumOfAi[i] = sum;
			  sum = sum - input[start];
			 for(int j = start+1 ; j <= i ; j++ ) {
				 sumOfAi[j] = sumOfAi[j]-input[start];
				 if(sumOfAi[j] == k) count++;
				 
			 }
			  start = start+1;
		  }
		  sumOfAi[i] = sum;
		  
		}
		return count;
	}

}
