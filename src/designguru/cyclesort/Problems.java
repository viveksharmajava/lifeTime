package designguru.cyclesort;

import java.util.Arrays;
import java.util.HashMap;

public class Problems {

	public static void main(String[] args) {

		 int [] arr = {3, 2, 0, 3, 4};
		 //findMisingOrDupliacte(arr);
		 int [] arr2 = {4, 0, 3, 1};
		 //findMisingOrDupliacte(arr2);
		 
		 int [] arr4 = {2,2};
		 findMisingOrDupliacte1ToN(arr4);
		 
		 int [] arr5 = {1, 3, 3};
		 findMisingOrDupliacte1ToN(arr5);
		 
		 int [] arr6 = {2, 3, 1, 8, 2, 3, 5, 1};
		 findMisingOrDupliacte1ToN(arr6);
		 System.out.println("\n printTwoElements\n ");
		 printTwoElements(arr6);
		 int []arr7 = {-3, 1, 5, 4, 2};
		 System.out.println("\n printTwoElements\n ");
		 System.out.println("\n"+ Arrays.toString(arr7));
		
		 printTwoElements(arr7);
		 int [] arr3 = {2, 3, 1, 8, 2, 3, 5, 1};
		// findAllMisings(arr3);
		 
		 
		 int [] array = {-3, 1, 5, 4, 2};
		 System.out.println("first missingPositiveNumber \n");
		 System.out.println(firstMissingPositive(array));
		 //System.out.println("\n firstMissingPositive3 \n ");
		 
		// good solution
		 System.out.println(firstMissingPositive3(array));
		 
		 int [] array2 = {33, 37, 5};
		 
		 System.out.println(firstMissingPositive3(array2));
		 
		 int [] array3 = {3, -1, 4, 5, 5};
		 
		 System.out.println("\n firstKMissingPositive \n ");
		 firstKMissingPositive(array3,3);
	}
	
	/*
	 * Problem: Find the Missing Number Or Find Duplicate number
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6393ab5cd8a93f4bff961bc7
	 * https://stephenjoel2k.medium.com/cyclic-sort-programming-pattern-16eb16ac9c4b
	 */
	
	 public static void findMisingOrDupliacte(int [] arr) {
		 int pos= 0;
		 while(pos < arr.length) {
			 if( arr[pos] < arr.length && arr[pos] != arr[arr[pos]]) {
				 swap(arr, pos, arr[pos]);
			 }
			 else {
				 pos++;
			 }
		 }
		 System.out.println(" Array after sort "+Arrays.toString(arr)+"\n");
		 for(int i=0; i < arr.length ; i++) {
			 if(arr[i] != i) {
				 System.out.println("The missing number  is "+i);
				 System.out.println("The duplicate number ="+arr[i]);
			 }
			 
		 }
	 }
	 /*
	  *  1 ... N , not 0 .. N
	  */
	 public static void findMisingOrDupliacte1ToN(int [] arr) {
		 int pos= 0;
		 int ans [] = new int[2];
		 while(pos < arr.length) {
			 if( arr[pos] < arr.length && arr[pos] != arr[arr[pos]-1]) {
				 swap(arr, pos, arr[pos]-1);
			 }
			 else {
				 pos++;
			 }
		 }
		 System.out.println(" Array after sort "+Arrays.toString(arr)+"\n");
		 for(int i=0; i < arr.length ; i++) {
			 if(arr[i] != i+1) {
				 System.out.println("The missing number  is "+(i+1));
				 //System.out.println("The repeating number ="+arr[i]);
				 //ans[0] = arr[i];
				 ans[1] = i+1;
				 break;
			 }
			 
		 }
	 }
	 private static void swap(int [] arr , int i, int j) {
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 /*
	  *  Problem: Find all Missing Numbers (easy)
	  *  We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
		
		Example 1:
		
		Input: [2, 3, 1, 8, 2, 3, 5, 1]
		Output: 4, 6, 7
		Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
	  */
	 public static void findAllMisings(int [] arr) {
		 int pos= 0;
		 while(pos < arr.length) {
			 if( arr[pos] < arr.length && arr[pos] != arr[arr[pos]]) {
				 swap(arr, pos, arr[pos]);
			 }
			 else {
				 pos++;
			 }
		 }
		 System.out.println(" Array after sort "+Arrays.toString(arr)+"\n");
		 for(int i=0; i < arr.length ; i++) {
			 if(arr[i] != i) {
				 System.out.println("The missing number  is "+i);
				 System.out.println("The duplicate number ="+arr[i]);
			 }
			 
		 }
	 }
	 
	 /*  Problem : Find the missing and repeating number
	  *  most  accurate  solution 
	  *  Method 2 (Use elements as Index and mark the visited places)
	  *  https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ 
	  */
	 public static void printTwoElements(int [] arr) {
		 System.out.println("The repeating is ");
		 for(int i = 0 ; i < arr.length ; i++) {
			 int abs = Math.abs(arr[i]);
			 if(arr[abs-1] > 0) arr[abs-1] = -arr[abs-1];
			 else {
				 System.out.print("\t "+ abs);
			 }
		 }
		 System.out.println("\n The missing is ");
		 for(int i=0; i < arr.length ; i++) {
			 if(arr[i] > 0)System.out.print("\t "+(i+1));
		 }
	 }
   /*
    * Problem : Missing Positive Number 
    * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63948c59c549a12fb2181118
    * Given an unsorted array containing numbers, find the smallest missing positive number in it.

	Note: Positive numbers start from '1'.
	
	Example 1:
	
	Input: [-3, 1, 5, 4, 2]
	Output: 3
	Explanation: The smallest missing positive number is '3'
	Example 2:
	
	Input: [3, -2, 0, 1, 2]
	Output: 4
	
	Solution: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
			The idea is to use array elements as an index. 
			To mark the presence of an element x, change the value at the index x to negative. 
			But this approach doesn’t work if there are non-positive (-ve and 0) numbers. 
			So segregate positive from negative numbers as the first step and 
			then apply the approach.
    * 
    */
	
	  public static int firstMissingPositive(int[] nums) {
		  int n = nums.length;
		  //1. mark number < 0 and > n  to n+1
		  for( int i = 0 ; i < n ; i++) {
			  if( nums[i] <=0 || nums[i] > n)nums[i] = n+1;
		  }
		  
		  //all elements in the array are positive and in the range 1... n+1
		  // 2. mark each cell appearing, by converting the index for that number to negative
		  for( int i = 0 ; i < n ; i++) {
			  int num = Math.abs(nums[i]);
			  if( num > n) continue;
			  num = num -1;
			  if(nums[num] > 0 ) {
				  nums[num] = -1*nums[num];
			  }
		  }
		 // 3 traverse the array and find first non-negative number 
		  
		  for( int i = 0 ; i < n ; i++) {
			  if(nums[i] > 0) return i+1;
		  }
		  
		  // 4. if no positve number found which means all numbers are in 1.. n
		  return n+1;
		  
	  }
	  
	  /*
	   * check below solution
	   * https://www.geeksforgeeks.org/find-first-k-natural-numbers-missing-given-array/
	   *    1. We can use hashmap to search in O(1) time.
			2. Use a dictionary to store values in the array. 
			3. We run a loop from 1 to n+k and check whether they are in hashmap.
			4. If they are not present print the number. 
			5. if all k elements are found break the loop. 
			
			Time Complexity : o(n+k)
			Space complexity : O(n)
	   */
	  public static void firstKMissingPositive(int[] nums, int k) {
		  
		// Creating a hashmap
	     HashMap<Integer, Integer> d = new HashMap<>();
	     for(int i = 0 ; i < nums.length; i++) {
	    	if(nums[i] > 0) d.put(nums[i],nums[i]);
	     }
	     int cnt = 1;
	     int f = 0;
	     for(int i = 0 ; i < (nums.length+k); i++ ) {
	    	 if(!d.containsKey(cnt)) {
	    		 f++;
	    		 System.out.println(cnt);
	    		 if(f == k) break;
	    	 }
	    	 cnt++;
	     }
	        
	  }
	  
	  // leetcode solution 
		public static int firstMissingPositive3(int[] nums) {
		    int n = nums.length;
		    
		    // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
		    // (we can ignore those because if all number are > n then we'll simply return 1)
		    for (int i = 0; i < n; i++) {
		        if (nums[i] <= 0 || nums[i] > n) {
		            nums[i] = n + 1;
		        }
		    }
		    // note: all number in the array are now positive, and on the range 1..n+1
		    
		    // 2. mark each cell appearing in the array, by converting the index for that number to negative
		    for (int i = 0; i < n; i++) {
		        int num = Math.abs(nums[i]);
		        if (num > n) {
		            continue;
		        }
		        num--; // -1 for zero index based array (so the number 1 will be at pos 0)
		        if (nums[num] > 0) { // prevents double negative operations
		            nums[num] = -1 * nums[num];
		        }
		    }
		    
		    // 3. find the first cell which isn't negative (doesn't appear in the array)
		    for (int i = 0; i < n; i++) {
		        if (nums[i] >= 0) {
		            return i + 1;
		        }
		    }
		    
		    // 4. no positive numbers were found, which means the array contains all numbers 1..n
		    return n + 1;
		} 
		
}
