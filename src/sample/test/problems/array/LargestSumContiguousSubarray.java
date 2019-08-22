package sample.test.problems.array;

import java.util.Arrays;

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
		int sum = 0;
		sum = maxSum( input);
		System.out.println("max sum="+sum);
		int [] maxsumSubArr ;
		maxsumSubArr = subArrayWithMaxSum(input);
		print(maxsumSubArr);
		int []input1 ={-1,-2,-3};
		sum = maxSum( input1);
		System.out.println("max sum="+sum);
		maxsumSubArr = subArrayWithMaxSum(input1);
		print(maxsumSubArr);
		int []input2 ={3,4,6,-44,3,-15,-1,11};
		sum = maxSum( input2);
		System.out.println("max sum="+sum);
		maxsumSubArr = subArrayWithMaxSum(input2);
		print(maxsumSubArr);
	}
	
	private static void print(int [] input) {
		System.out.print("[");
		for(int i=0 ; i<input.length; i++) {
		  System.out.print(input[i]+",");
		}
		System.out.print("]");
		System.out.println();
	}
	public static int  maxSum(int [] input){
		int tempSum =0;
		int sum = Integer.MIN_VALUE;
		for(int i=0;i < input.length;i++){
			tempSum += input[i];
			if(sum <tempSum ) sum = tempSum;
			if (tempSum < 0) {
				tempSum = 0 ;
			}
			
			
		 }
		
		return sum;
	}
	public static int [] subArrayWithMaxSum(int [] input){
		int tempSum =0;
		int k=0 , m =0, n =0;
		int sum = Integer.MIN_VALUE;
		for(int i=0;i < input.length;i++){
			tempSum += input[i];
			if(sum <tempSum ) {
				sum = tempSum;
				k = m;
				n = i;
			}
			if (tempSum < 0) {
				//k = m ;
				m = i+1;
				tempSum = 0 ;
			}
		 }
		
		return Arrays.copyOfRange(input, k, n+1);
	}


}
