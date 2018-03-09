package sample.test.problems.array;

public class LargestSumContiguousSubarray {

	/**
	 * @param args  Kadane’s Algorithm
	 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 
		Input:
		The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
		 The first line of each test case contains a single integer N denoting the size of array. 
		 The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
		 
		Output:
		Print the maximum sum of the contiguous sub-array in a separate line for each test case.
		 
		Constraints:
		1 ≤ T ≤ 40
		1 ≤ N ≤ 100
		-100 ≤ A[i] <= 100
		 
		Example:
		Input
		2
		3
		1 2 3
		4
		-1 -2 -3 -4
		
		Output
		6
		-1
	 */
	public static void main(String[] args) {
       // int []input ={-1 ,-2 ,-3, -4};
		int []input ={1,-2,3};
		int sum = subArray( input);
		System.out.println("max sum="+sum);
		
		int []input2 ={3,4,6,-4,3,-15,-1,18};
		 sum = subArray( input2);
		System.out.println("max sum="+sum);
	}
	
	public static int  subArray(int [] input){
		
		//int [] result  = new int [2] ;
		int tempSum;
		int sum = tempSum=0;
		for(int i=0;i < input.length;i++){
		
			//if (tempSum <(tempSum + input[i])) {
			if ((tempSum + input[i])<=0) {
				tempSum = 0 ;
			}
			else{
				tempSum =tempSum + input[i];
			}
			if(sum <tempSum ) sum = tempSum;
		 }
		
		return sum;
	}

}
