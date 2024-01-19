package ds500problems.dp;

import java.util.Arrays;

public class PartitionProblem {

	public static void main(String[] args) {
        int [] arr = {3, 1, 1, 2, 2, 1};
        System.out.println("Array can be devided into 2 subset with equalt sum "+partition(arr));
		// Input: a set of integers
        int[] S = { 7, 3, 2, 1, 5, 4, 8 };
 
        if (partition3(S)) {
            System.out.println("Set can be partitioned");
        }
        else {
            System.out.println("Set cannot be partitioned");
        }
	}

/*
 * Problem statement: 
 *    Given a set of positive integers,
 *    find if it can be divided into two subsets with equal sum.
 *    Consider S = {3, 1, 1, 2, 2, 1}
		 
		We can partition S into two partitions, each having a sum of 5.
		 
		S1 = {1, 1, 1, 2}
		S2 = {2, 3}
		 
		Note that this solution is not unique. Here’s another solution.
		 
		S1 = {3, 1, 1}
		S2 = {2, 2, 1}
 *    Solution: 
 *     calculate total sum of given array if sum is odd then
 *     it can not be divided into 2 parts.
 *     If sum is even then find the sub-set elements of given array which
 *     sum is total_sum/2.
 *     We can use modified knapsack solution here:
 *     1. calculate  the sum including  current element. and recur the solution
 *        for remaining element.
 *     2. calculate  the sum excluding  current element. and recur the solution
 *        for remaining element.
 *     Finally:return true if we get the sub-set which sum is total_sum/2 from including
 *             or excluding the elements. else return the false.
 *    
 */
	//return true if there exist subarray arr[0..n] of sum sum
	private static boolean subSetSum(int arr[], int n , int sum) {
		// return true if the sum becomes 0 (subset found)
		if(sum == 0) return true;
		//base case: no item left or sum become negative
		if( n < 0 || sum < 0) return false;
		//case 1 include current item in subset to find sum and recur for remaining.
		boolean include = subSetSum(arr , n-1 , sum-arr[n]);
		if(include) return true;
		//case 2 exclude current item  in subset to find given sum and recur for remaining.
		boolean exclude = subSetSum(arr, n-1,sum);
		
	   return  exclude;
	}
	
  public  static boolean partition(int [] arr)	{
	  
	  int sum = Arrays.stream(arr).sum();
	  // return true if the sum is even and the array can be divided into
      // two subarrays with equal sum
      return (sum & 1) == 0 && subSetSum(arr , arr.length-1 , sum/2);
	  
  }
  
  /*
   * https://www.techiedelight.com/3-partition-problem/
   * 3–Partition Problem
   * determine if given array can be divided into 3 subset of equal sum 
   * S = { 7, 3, 2, 1, 5, 4, 8 }

	 We can partition S into 3 partition of equal sum
		
		S1 = { 7, 3 }S2 = { 5, 4, 1 }S3 = { 8, 2 }
   */
  public static boolean partition3(int [] arr) {
		int sum = Arrays.stream(arr).sum();
		
		return (sum%3 ==0) && subSetSum( arr , arr.length-1,sum/3,sum/3,sum/3);
				
  }

private static boolean subSetSum(int [] arr, int n, int a, int b, int c) {
	//return true if subsets are found
	if( a == 0 && b == 0 & c == 0) return true;
	//base case: no item left
	if( n < 0) return false;
	boolean A = false;
	// Case 1. The current item becomes part of the first subset
	if( a - arr[n] >=0) {
		A = subSetSum(arr, n-1, a-arr[n],b ,c);
	}
	boolean B = false;
	// Case 2. The current item becomes part of the second subset
	if(!A &&  b - arr[n] >=0) {
		B = subSetSum(arr, n-1, a,b-arr[n] ,c);
	}
	boolean C = false;
	// Case 3. The current item becomes part of the third subset
	if(!A && !B &&  c - arr[n] >=0) {
		C = subSetSum(arr, n-1, a,b ,c-arr[n]);
	}
	// return true if we get a solution
    return A || B || C;
}
  
}

