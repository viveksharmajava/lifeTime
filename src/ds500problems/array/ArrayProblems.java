package ds500problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import sample.test.collection.queue.Queue;
import sample.test.top25geeks.Node;

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
		int []findMaxSum =  {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		continuousSubArrWithMaxSum(findMaxSum);
		
		int [] min = { -3, 1, -3, 4, -1, 2, 1, -5, 4};
		continuousSubArrWithMinSum(min);
		
		
		int [] p = {-6, 4, -5, 8,-10,0,8};
		System.out.println("\n  Max product sub-array="+maxProduct(p));
		
		//find distinct combination
		int[] B = { 1, 2,2, 3 };
		Arrays.sort(B);
        int k = 2;
		findCombinations(B, "", 0, B.length, k);
		
		
		//sort k sorted array
		List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
         k = 2;
         System.out.println("Sort K sorted");
        sortKSortedArray(list, k);
        System.out.println(list);
		
        System.out.println("Minimum sum subarray");
        int[] arr3 = { 10, 4, 2, 5, 6, 3, 8, 1 };
        int windowSize = 3;
 
        minimumSumSubArray(arr3, windowSize);
		//Find Triplet with given sum
        int[] arr4 = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 6;
        findTripletUsingSortedArray(arr4, sum);
        
        int  [] arr5 = {-2,0,1,1,2}; //[[-2,0,2],[-2,1,1]]
        findTripletUsingSortedArray(arr5,0);// this won't work
        System.out.println(threeSum(arr5)); // find sum with 0
        int[] arr6 = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6 };
        System.out.printf("Next least greater element of array\n%s\n",Arrays.toString(arr6));
        
        findInorderSuccessor(arr6);
        int[] inputn = { -1, -1, 0, 1, 1, 1 };
        
        System.out.print("The total number of distinct absolute values is "
                                + findDistinctCount(inputn));
        int [] max_input = { -6, 4, -5, 8, -10, 0, 8 };
        System.out.println("\nThe maximum product subarray "+maximumProductSubArray(max_input)); 
	}
	/*
	 * count distinct element in sorted array contains +ve and negative numbers
	 * https://www.techiedelight.com/count-distinct-absolute-values-sorted-array/
	   Input:  { -1, -1, 0, 1, 1, 1 }
	   Output: The total number of distinct absolute values is 2 (0 and 1)
	 
	 
	   Input:  { -2, -1, 0, 1, 2, 3 }
	   Output: The total number of distinct absolute values is 4 (0, 1, 2 and 3)
	 
	 
	   Input:  { -1, -1, -1, -1 }
	   Output: The total number of distinct absolute values is 1 (only 1)
	 */
	// Returns the total number of distinct absolute values in a given input
    public static int findDistinctCount(int[] A)
    {
    	int count = A.length;
    	int start=0 , end = A.length-1;
    	while(start < end) {
    		while( start < end && (A[start] == A[start+1])) {
    			start++;
    			count--;
    		}
    		while(end > start && (A[end] == A[end-1]) ) {
    			end--;
    			count--;
    		}
    	 if(start == end)break;
    	 int sum = A[start]+A[end];
    	 if(sum == 0) {
    		 count--;
    		 start++;
    		 end--;
    	 }
    	 else if (sum <0) start++;
    	 else if (sum > 0) end--;
    	 
    	}
    	return count;
    }
	
	/*Count distinct absolute values in a sorted array
	 * https://www.techiedelight.com/count-distinct-absolute-values-sorted-array/
	 *  Input:  { -1, -1, 0, 1, 1, 1 }
		Output: The total number of distinct absolute values is 2 (0 and 1)
		Input:  { -2, -1, 0, 1, 2, 3 }
		Output: The total number of distinct absolute values is 4 (0, 1, 2 and 3)
		Input:  { -1, -1, -1, -1 }
		Output: The total number of distinct absolute values is 1 (only 1)
	 */
	 public static void findInorderSuccessor(int [] arr) {
		 //root of the BST 
		 Node root = null;
		 //traverse from the end
		 for (int i = arr.length - 1; i >= 0; i--)
	        {
	            // insert the current element into the binary search tree
	            // and replace it with its inorder successor
	            AtomicInteger successor = new AtomicInteger(-1);
	            root = insert(root, arr[i], successor);
	            arr[i] = successor.get();
	        }
		 
		 System.out.println(Arrays.toString(arr));
	 }
	
	private static Node insert(Node root, int key, AtomicInteger successor) {
		if(root == null) return new Node(key);
		if(key < root.value) {
			successor.set(root.value);
			root.left = insert(root.left , key , successor);
		}
		if( key > root.value) {
			root.right = insert(root.right,key,successor);
		}
		return root;
	}

	//Sort the Array with Absolute value only and show real value

	 public void sortWithAbsoluteValue(int []arr) {
		// Arrays.sort(arr, Comparator.comparingInt(Math::abs));
		 Stream.of(arr).forEach(a ->  System.out.println(a));
	 }
	 
	  public  static List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> list  = new ArrayList<>();
	        for(int i = 0 ; i <= nums.length-3 ; i++){
	            int x = nums[i];
	            int start = 0, end = nums.length-1;
	            boolean found = false;
	            while(start < end){
	            	if( i == start) start++;
	                int sum = x + nums[start]+ nums[end];
	                if( sum == 0) {
	                    found = true;
	                    break;
	                }
	                else if( sum > 0)  end--;
	                else if( sum < 0)  start ++;
	            }
	            if(found){
	               List<Integer>  node = new ArrayList<>();
	                node.add(nums[i]);
	                node.add(nums[start]);
	                node.add(nums[end]);
	                found = false;
	                list.add(node);
	                
	            }
	        }
	        //remove duplicate triplet 
	        for(int i = 0 ; i < list.size()-1 ; i++) {
	        	 List<Integer>  node1 = new ArrayList<Integer>(list.get(i));
	        	 List<Integer>  node2 = new ArrayList<Integer>(list.get(i+1));
	        	 Collections.sort(node1);
	        	 Collections.sort(node2);
	        	 if(node1.equals(node2)) {
	        		 list.remove(i+1);
	        		 i--;
	        	 }
	        	 
	        }
	       return  list; 
	    }
	 /*
		URL: http://www.geeksforgeeks.org/next-greater-element/
		Next Greater Element
		Given an array, print the Next Greater Element (NGE) for every element. 
		The Next greater Element for an element x is the first greater element on
	    the right side of x in array. Elements for which no greater element exist,
	    consider next greater element as -1.
				
		Examples:
		a) For any array, rightmost element always has next greater element as -1.
		b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
		c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
		
		Element       NGE
		   4      -->   5
		   5      -->   25
		   2      -->   25
		   25     -->   -1
 */
	 
	
	public static void printNextGreaterOfEachElement(Integer [] input){
		
		Queue <Integer> queue = new Queue<Integer>();
		Integer data;
		int  element = input[0];
		for(int i=1;i<input.length ;i++){
			if(element > input[i]) queue.enqueue(input[i]);
			else{
				System.out.println(" Next greater Element for "+element +" is ="+input[i]);
				while( ( data = queue.dequeue())!= null){
					System.out.println(" Next greater Element for "+data +" is ="+input[i]);
				}
				element =input[i];
			}
		}
		System.out.println(" Next greater Element for "+element +" is ="+-1);
		while( ( data = queue.dequeue())!= null){
			System.out.println(" Next greater Element for "+data +" is ="+-1);
		}
		
		
		
	}
	/*
	 * https://www.techiedelight.com/find-triplet-given-with-given-sum/
	 * Find triplet with given sum.
	 */
	  //using sorted array
	 
	  public static void findTripletUsingSortedArray(int []input,int sum) {
		  // sort the array in ascending order
		  Arrays.parallelSort(input);
		  // check if triplet is formed by `arr[i]` and a pair from
	      // subarray `arr[i+1…arr.length)`
		  
		  for(int i =0 ; i < input.length - 3 ; i++) {
			  
			  //remaining sum
			  int k = sum - input[i];
			 // maintain two indices pointing to endpoints of the
	          // subarray `arr[i+1…n)`
              int low = i + 1;
              int high = input.length - 1;
              while(low < high) {
            	  if((input[low]+input[high]) < k) low++;
            	  else if ((input[low]+input[high]) > k) high--;
            	  else {
            		  //triplet found
            		  System.out.println("Triplet with given sum found "+"(" + input[i] + ", " +  input[low] + ", " +
            				  input[high] + ")");
            		  low++;
            		  high--;
            	  }
              }
			  
		  }
	  }
	  
	  //Find Triplet using map
	  
	  
	
	/*Find minimum sum subarray of size `k`
	 * sliding window 
	 * https://www.techiedelight.com/find-minimum-sum-subarray-given-size-k/
	 * Input:  {10, 4, 2, 5, 6, 3, 8, 1}, k = 3
	   Output: Minimum sum subarray of size 3 is (1, 3) [4,2,5]
	 */
	
	public static void minimumSumSubArray(int []input , int windowSize){
		
		int min_sum = Integer.MAX_VALUE;
		int current_sum = 0;
		int lastIndex = -1;
		for(int i = 0 ; i < input.length ; i++) {
			current_sum +=input[i];
			// if the window size is more than equal to `k`
			if(i+1 >= windowSize) {
				// update the minimum sum window
				if(min_sum > current_sum) {
				  min_sum = current_sum;
				  lastIndex = i;
				}
				// remove a leftmost element from the window
				current_sum -= input[i+1 -windowSize];
			}
		}
		
		if( lastIndex >=0) {
			System.out.println("The minimum sum sub array is ("+(lastIndex-windowSize+1)+","+lastIndex+")");
		}
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
	 * Given an array consisting of positive and negative integers, segregate them in linear time 
	 * and constant space. 
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
			int count = 0;  			// store current count of 1

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
			return max_index;
		}
	  
	  /*
	   * Problem 23: Find continuous sub array with max sum
	   * https://www.techiedelight.com/print-continuous-subarray-with-maximum-sum/
	   * kadane algorithm
	   */
	  
	   public static void continuousSubArrWithMaxSum(int [] input) {
		   
		   int max=0;//to hold max sum so far
		   int sum=0; //to calculate sum value
		   int start=0,end=0, begin = 0;
		   for(int i = 0 ; i < input.length ;i++) {
			   sum += input[i];
			   if(sum < 0) // reset the sum and begin index
			   {
				   sum = 0;
				   begin = i+1;
			   }
			   if(max < sum) {//update max, start, end
				  max = sum;
				  start = begin;
				  end = i;
			   }
			   
		   }
		   if(start != end) {
			   System.out.println("Sub Array with max sum of "+max+"\t found between input["+start+".."+end+"]\n");
		   }
		  while(start<=end) {
			  System.out.print(input[start++]+"\t");
		  }
	   }
	   
	   //Maximum sum circular sub array
	   
	   /* Problem: 25
	    * Input: { 2, 1,, -5, 4, -3, 1, -3, 4, -1}
	    * OUTput: Subarray with the largest sum is {4, -1, 2, 1} with sum 6.
	    * 
	    * Approach : Idea is to find sub-array with having  sum min then remove that sub array from  original array remaining element 
	    * will be circular sub array having max sum.
	    * 
	    * Solution : 
	    * 1. modify problem 23 solution continuousSubArrWithMaxSum to find continuousSubArrWithMinSum
	    * 2. Eliminate sub-array found in step 1 from original input array
	    * 3. remaining element will be circular  sub array with max sum.
	    * 
	    */
	   
	   public static void continuousSubArrWithMinSum(int [] input) {
		   
		   int min=0;//to hold max sum so far
		   int sum=0; //to calculate sum value
		   int start=0,end=0, begin = 0;
		   for(int i = 0 ; i < input.length ;i++) {
			   sum += input[i];
			   if(sum > 0) // reset the sum and begin index
			   {
				   sum = 0;
				   begin = i+1;
			   }
			   if(min > sum) {//update min, start, end
				  min = sum;
				  start = begin;
				  end = i;
			   }
			   
		   }
		   if(start != end) {
			   System.out.println("Sub Array with min sum of "+min+"\t found between input["+start+".."+end+"]\n");
		   }
		  int s = start;
		  while(start<=end) {
			  System.out.print(input[start++]+"\t");
		  }
		  
		  System.out.println("\n Cicular Sub-array with Max Sum is");
		  int i = 0;
		  while(i<s) {
			  System.out.print(input[i++]+"\t");
		  }
		  
		  i = end+1;
		  while(i<input.length) {
			  System.out.print(input[i++]+"\t");
		  }
	   }
	   
	   /*
	    * Problem : 30
	    * Problem statment: Find maximum product subarray in a given array
	    */
	   
	   public static int maxProduct(int []input) {
		   
		// maintain two variables to store maximum and minimum product
		// ending at current index
		   int min_ending = 0 , max_ending=0;
		
		 // to store maximum product sub-array found so far
		 int max_so_far = 0;
		 for(int i : input) {
			 int temp = max_ending;
			 max_ending = Integer.max(i, Integer.max(i*max_ending,i*min_ending));
			 min_ending = Integer.min(i , Integer.min(temp*i , i*min_ending));
			 
			 max_so_far = Integer.max(max_so_far, max_ending);
		 }
		 return max_so_far;
	   }
	   
	   /*
	    * https://www.techiedelight.com/find-distinct-combinations-of-given-length/
	    *  Find all distinct combinations of given length – I
	    *  Input:  {1, 2, 3}, k = 2
		   Output: {1, 2}, {1, 3}, {2, 3}
 
 
			Input:  {1, 2, 1}, k = 2
			Output: {1, 1}, {1, 2}
	    */
	   
	// Function to print all distinct combinations of length `k`
	    public static void findCombinations(int[] A, String out, int i, int n, int k)
	    {
	        // invalid input
	        if (k > n) {
	            return;
	        }
	 
	        // base case: combination size is `k`
	        if (k == 0) {
	            System.out.println(out);
	            return;
	        }
	 
	        // start from the next index till the last index
	        for (int j = i; j < n; j++)
	        {
	            // add current element `A[j]` to the solution and recur for next index
	            // `j+1` with one less element `k-1`
	            findCombinations(A, out + " " + (A[j]) , j + 1, n, k - 1);
	 
	            /* uncomment the following code to handle duplicates */
	           
	            while (j < n - 1 && A[j] == A[j + 1]) {
	                j++;
	            } 
	            
	        }
	    }
	    
	    public static void findCombinationsWithRepetation(int[] A, String out, int i, int n, int k)
	    {
	        
	        // base case: combination size is `k`
	        if (k == out.length()) {
	            System.out.println(out);
	            return;
	        }
	 
	        // start from the next index till the last index
	        for (int j = i; j < n; j++)
	        {
	            // add current element `A[j]` to the solution and recur for next index
	            // `j+1` with one less element `k-1`
	            findCombinations(A, out + " " + (A[j]) , j, n, k);
	 
	        }
	        
	    }

      /*
       * https://www.techiedelight.com/find-distinct-combinations-given-length-repetition-allowed/
       * Find all distinct combinations of given length with repetition allowed
       * Find minimum sum subarray of given size k
       */
	    
	    public static void findMinSumSubarray(int[] arr, int k)
	    {
	        // stores the sum of elements in the current window
	        int window_sum = 0;
	 
	        // stores the sum of minimum sum subarray found so far
	        int min_window = Integer.MAX_VALUE;
	 
	        // stores ending index of the minimum sum subarray found so far
	        int last = 0;
	 
	        for (int i = 0; i < arr.length; i++)
	        {
	            // add the current element to the window
	            window_sum += arr[i];
	 
	            // if the window size is more than equal to `k`
	            if (i + 1 >= k)
	            {
	                // update the minimum sum window
	                if (min_window > window_sum)
	                {
	                    min_window = window_sum;
	                    last = i;
	                }
	 
	                // remove a leftmost element from the window
	                window_sum -= arr[i + 1 - k];
	            }
	        }
	 
	        System.out.printf("The minimum sum subarray is (%d, %d)", last - k + 1, last);
	    }
	    
	    /*
	     * Sort K sorted array
	     * Input:
 
			arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
			k = 2
 
			Output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	     */
	 // Function to sort a k–sorted array
	    public static void sortKSortedArray(List<Integer> list, int k)
	    {
	    	PriorityQueue <Integer> pq = new PriorityQueue<Integer>(list.subList(0, k+1));
	    	int index = 0;
	    	for(int i = k+1 ; i < list.size();i++) {
	    		list.set(index++ , pq.poll());
	    		pq.add(list.get(i));
	    	}
	    	// pop all remaining elements from the min-heap and assign them to the
	        // next available array index
	    	while(!pq.isEmpty()) {
	    		list.set(index++, pq.poll());
	    	}
	    }
/*
 * https://www.techiedelight.com/find-maximum-product-subarray-given-array/
 * Maximum product sub-array problem
 * Input:  { -6, 4, -5, 8, -10, 0, 8 }
 * Output: 1600
 * Explanation: The maximum product subarray is {4, -5, 8, -10} having product 1600
 
 
 * Input:  { 40, 0, -20, -10 }
 * Output: 200
 * Explanation: The maximum product subarray is {-20, -10} having product 200
 */
	    
 public static  int maximumProductSubArray(int [] a) {
	 int max_so_far = 0;
	 int min_current= a[0] , max_current = a[0];
     for(int i=1 ;i < a.length ; i++) {
		 int temp  =max_current;
    	 max_current = Integer.max(a[i], Integer.max(max_current*a[i],min_current*a[i]));
    	 min_current = Integer.min(a[i], Integer.min(temp*a[i],min_current*a[i]));
    	 
    	 if(max_current > max_so_far) max_so_far = max_current;
	 }
	 return max_so_far;
	 
 }
	    
}//End of class
