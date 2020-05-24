package ds500problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import sample.test.problems.string.LongestPalindromSubString;

public class ArrayProblems {

	public static void main(String[] args) {
		int [] input = {9, -3, 5, -2, -8, -6, 1, 4};
		input = afterSegrate(input);
		for(int i : input) {
			System.out.print(i+"\t");
		}
		findPairWithGivenSum(input,-5);
		subArrayWithZeroSum(input);
		printAllSubArrayWithZeroSum(input);
		int [] arr = {3,4,-7,3,1,3,1,-4,-2,-2};
		printAllSubArrayWithZeroSum(arr);
		int a[] = {2,0,2,1,4,3,1,0};
		largestSubArrayOfConsucutiveSequence(a);
		int []input2 = {9, -3,0, 5, -2,0, -8, -6, 1,0, 3};
		input2 = afterSegrateWithZeroes(input2);
		System.out.println("\nAfter segregate with zero\n");
		for(int i : input2) {
			System.out.print(i+"\t");
		}
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		System.out.println("THreewayPartion");
		threeWayPartition(A, A.length - 1);
		System.out.println(Arrays.toString(A));
		int [] b = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		System.out.println("Longest Sub array with sum=8 is ");
		maxLenghtSubArrayWithGivenSum(b, 8);
		
		int []c = {0,0,1 };
		System.out.println("indexOf0ToGetMax1sSubbarray="+indexOf0ToGetMax1sSubbarray(c));
	}
	
	public static void m() {
		
		char [] s =  {'a','b','c',' ','d','e' , ' ', 'f','g'}; //oputput = {'f','g', ' ', 'd','e', ' ','a','b','c'}
		
	}
	/*
	 * THreeway partition 
	 * https://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/
	 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
	 */
	
	public static void three_way_partition(int []a,int pivot){
		
		int start=0;
		int mid=0;
		int end= a.length-1;
		while(mid < end) {
		  if(a[mid] < pivot) {
			  swap(a , start ,mid);
			  start++;
			  mid++;
		  }
		  else if(a[mid] > a[end] ) {
			  swap(a , mid , end);
			  end--;
		  }
		  else {
			  mid++;
		  }
		}
		
	}
	
	
	/* https://www.techiedelight.com/find-largest-sub-array-formed-by-consecutive-integers/
	 *  problem 6:
	 */
	public static void largestSubArrayOfConsucutiveSequence(int [] a) {
		
		int len=1;
		int start=0,end = 0;
		for(int i=0; i<a.length ; i++) {
			int min = a[i],max=a[i];
			for(int j=i+1; j< a.length ; j++) {
				min = Math.min(min, a[j]);
				max = Math.max(max, a[j]);
				if(isConsucutive(a, i, j, min, max)) {
					if(len< (j-i+1)) {
						len = j-i+1;
						start = i ;
						end = j;
					}
				}
			}
		}
		System.out.println("The longest subArray of consucutive integer is of lenght"+len +"\t a["+start+".."+end+"]");
	}
	private static boolean isConsucutive(int [] a , int i , int j , int min , int max) {
		 
		if((max-min)!= (j-i)) return false;
		
		boolean visited[] = new boolean[j-i+1];
		for(int k=i; k<=j;k++) {
			if(visited[a[k]-min]) return false;
			else {
				visited[a[k]-min] = true;
			}
		}
	 return true;	
	}
	/*
	 * 
	 * Find if subarray with 0 sum exist or not.
	 * https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/
	 *We can easily solve this problem in linear time by using hashing, . 
	 *The idea is to use set to check if sub-array with zero sum is present in the given array or not. 
	 *We traverse the given array, and maintain sum of elements seen so far.
	 * If sum is seen before (i.e. sum exists in set), we return true as there exists at-least one sub-array with zero sum which ends at current index 
	 * else we insert the sum into the set.
	 */
	public static void subArrayWithZeroSum(int input []) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		//add 0 to handle if array first index is 0.
		set.add(0);
		int sum = 0;
		for(int i= 0 ; i < input.length; i++) {
			sum += input[i];
			if(set.contains(sum)) {
				System.out.println("sub array with zero sum exist !"); return;
			}
			set.add(sum);
		}
	}
	// Linear-time partition routine to sort an array containing 0, 1 and 2
	// It similar to three-way Partitioning for Dutch national flag problem
	public static void threeWayPartition(int[] A, int end)
	{
		int start = 0, mid = 0;

			
		int pivot = 1;

		while (mid <= end)
		{
			if (A[mid] < pivot)		 // current element is 0
			{
				swap(A, start, mid);
				++start;
				++mid;
			}
			else if (A[mid] > pivot)	// current element is 2
			{
				swap(A, mid, end);
				--end;
			}
			else						// current element is 1
				++mid;
		}
	}

	// Utility function to swap two elements A[i] and A[j] in the array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	/*
	 * Find All sub-arrays with 0 sum .
	 * https://www.techiedelight.com/find-sub-array-with-0-sum/
	 * Approach 1: using Naive method use 2 for loop to find all subarrays and its some then check if it's sum is zero if
	 * so then print indexes.
	 * 
	 * Approch 2 : Using map ( key should be sum till ith index and i should be value.
	
	 */
	public static void printAllSubArrayWithZeroSum(int input []) {
		
		printAllSubArrayWithZeroSumUsingMap(input);
		
	}
	private static void printAllSubArrayWithZeroSumUsingMap(int input []){
		HashMap<Integer,List<Integer>> map = new HashMap<>();
	    //insert 0 , -1  to consider the test case when first element of given array is 0.
		insertInMap(map,0,-1);
		int sum = 0;
		for(int i =0 ; i < input.length ; i++) {
			sum += input[i];
			if(map.containsKey(sum)) {
				List <Integer> indexes  = map.get(sum);
				for(Integer value : indexes) {
					System.out.println("Subarray with some 0 exist between input["+(value+1)+" ... "+i+"]");
				}
						
			}
			insertInMap(map, sum, i);
		}
	}
	private static void insertInMap(HashMap<Integer,List<Integer>> map , int sum , int index) {
		if(!map.containsKey(sum)) {
			map.put(sum,new ArrayList<Integer>());
		}
		
		map.get(sum).add(index);
	}
	
	/* problem : 1
	 * Find Pair with given Sum in an Array.
	 * Given an unsorted array of integers, find a pair with given  sum in it.
	 * https://www.techiedelight.com/find-pair-with-given-sum-array/
	 * 
	 * Solutions:
	 * 1. Naive approach using 2 for loop.
	 * 2. Using sorted array O(nlogn)
	 * 3. Using Hashing O(n) solution.
	 * 
	 */
	
	public static void findPairWithGivenSum(int input[], int sum) {
		
		// implementation for 3. Using Hashing O(n) solution.
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<input.length ; i++) {
			if(map.containsKey(sum-input[i])) {
				System.out.println("\nFound pair with sum="+sum +" at index="+(map.get(sum-input[i]))+"\t and "+i);
			}
			else {
				//store index of the element
				map.put(input[i], i);
			}
		}
	}
	
	/*  problem: 115 https://www.techiedelight.com/positive-and-negative-integers-segregate/
	 * https://www.techiedelight.com/positive-and-negative-integers-segregate/
	 * Given an array consisting of positive and negative integers, segregate them in linear time and constant space. 
	 * Output should print contain all negative numbers followed by all positive numbers.
	 */
	public static int [] afterSegrate(int [] input) {
		int start=0,end = input.length-1,temp=0;
		while(start < end) {
			while(input[start] < 0 ) { start ++;
				 
			}
			while( input[end] > 0 ) {
				end--;
			}
			if(start != end && start< input.length && end >0) {
				temp = input[start];
				input[start] = input[end];
				input[end] = temp;	
				start++;
				end--;
			}
				
			}
		return input;
	}
	
	/*
	 * * Given an array consisting of positive and negative and zeroes integers, segregate them in linear time and constant space. 
     * Output should print contain all negative numbers  then all zeroes followed by all positive numbers.
     * input = {9, -3,0, 5, -2,0, -8, -6, 1,0, 3}
     * output= {-3,-2,-8,-6,0,0,0,9,5,1,3}
	 */
	public static int [] afterSegrateWithZeroes(int [] input) {
		int start=0,end = input.length-1,temp=0;
		while(start < end) {
			while(input[start] < 0 ) { start ++;
				 
			}
			while( input[end] >= 0 ) {
				end--;
			}
			if(start != end && start< input.length && end >0) {
				temp = input[start];
				input[start] = input[end];
				input[end] = temp;	
				start++;
				end--;
			}
				
		}//all negative are shifted to the left side
		//now need to shift zeroes to the middle, for that first find  position for non negative first integer in array
		start=0;end = input.length-1;
		while(start < end) {
			if(input[start]<0) start++;
			else break;
		}
		
		while(start < end) {
			while(input[start]==0) { start++;
			}
			while(input[end]>0) { end--;
			}
			if(start < end && end > 0) {
				temp = input[end];
				input[end] = input[start];
				input[start] = temp;	
				end--;
				start++;
				
			}
				
			}
		return input;
	}
	
	/*
	 * Problem 5
	 * https://www.techiedelight.com/find-duplicate-element-limited-range-array/
	 * 
	 * Find duplicate element in an array
	 * INPUT : given array contains integer from 1 to  n-1   and 1 one element is repeated.
	 *   {1,2,3,4,4}
	 *   output repeated element is :4
	 */
	  public static int findDuplicateElementInArray(int [] arr) {
		  
		  int duplicate = -1;
		  for(int i = 0 ; i < arr.length ; i++) {
			  int val = arr[i] < 0 ? -arr[i] : arr[i];
			  if(arr[val-1] >=0 )  arr[val-1] = -arr[val-1];
			  else {
				  duplicate = val;
				  
			  }
		  }
		  return duplicate ;
	  }
	  
	  /*
	   * problem 7
	   * https://www.techiedelight.com/find-maximum-length-sub-array-having-given-sum/
	   *  Find max length subarray having given sum
	   *  Given an array of integers, find maximum length sub-array having given sum.
	   *  
       *  For example, consider below array
       *  
	   *  A[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 }
	   *  
	   * Sum = 8 , Sub-arrays with sum 8 are { -5, 5, 3, 5 }, {3,5}, {5,3}
	   * Max lenght sub array with sum 8 is {-5,5,3,5}
	   * 
	   * Solution : The idea is similar to find all sub array having sum 0
	   */
	  
	  public static void maxLenghtSubArrayWithGivenSum(int []arr,int s) {
		  
		  HashMap<Integer, Integer> hm = new HashMap<Integer , Integer>();
		  
		  hm.put(0,-1);
		  int sum  =0;
		  int len = 1;
		  int end_index = -1;
		  for(int i = 0 ; i< arr.length ; i++) {
			  sum += arr[i];
			// if sum is seen for first time, insert sum with its index
				// into the map
			  if(!hm.containsKey(sum)) hm.put(sum, i);
			  // update length and ending index of maximum length sub-array
				// having sum S
			 if( hm.containsKey(sum - s) && ( len < i-hm.get(sum-s))) {
				 len = i-hm.get(sum-s);
				 end_index = i;
			 }
		  }
		 if(len > 0 ) {
			 System.out.println("Longest subarray with Sum="+s+" exist between arr["+(end_index+1-len)+"..."+end_index+"]");
		 }
	  }

	  /*
	   * https://www.techiedelight.com/find-maximum-length-sub-array-equal-number-0s-1s/
	   * 
	   * Find largest subarray  contains equal 0's and 1's 
	   * 
	   * Solution :  replace all zero's 0   with -1 and then find max lenght subarray with  sum zero you can use ;
	   *  use problem 7
	   */
	  
	  /*
	   * https://www.techiedelight.com/find-index-0-replaced-get-maximum-length-sequence-of-continuous-ones/
	   * problem 12: Given a binary array find the index of 0 to be replaced with 1 to get maximum length sequence of continues 1's.
	   * INPUT: {0,0,1,0,1,1,1,0,1,1 }
	   * OUTPUT:7
	   */
	  
	  public static int indexOf0ToGetMax1sSubbarray(int []A) {
			int max_count = 0;	// stores maximum number of 1's (including 0)
			int max_index = -1;   // stores index of 0 to be replaced

			int prev_zero_index = -1;   // stores index of previous zero
			int count = 0;  			// store current count of zeros

			// consider each index i of the array
			for (int i = 0; i < A.length; i++)
			{
				// if current element is 1
				if (A[i] == 1) {
					count++;
				}
				else
				// if current element is 0
				{
					// reset count to 1 + no. of ones to the left of current 0
					count = i - prev_zero_index;

					// update prev_zero_index to current index
					prev_zero_index = i;
				}

				// update maximum count & index of 0 to be replaced if required
				if (count > max_count)
				{
					max_count = count;
					max_index = prev_zero_index;
				}
			}

			// return index of 0 to be replaced or -1 if array contains all 1's
			return max_index;}
	  
	  
}
