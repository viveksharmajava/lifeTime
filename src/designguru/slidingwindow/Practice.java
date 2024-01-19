package designguru.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

	public static void main(String[] args) {
	  
		int a = 3; //00000011
		
		int b = 8;//00001000
		int d = 48;
		int c  = d|b;//1011
		System.out.println(d&b);
		
		
		
		int [] arr = {2, 1, 5, 1, 3, 2};
	   int k=3 ;
	   System.out.println(maxSumSubarraySizeK(arr,k));
	   System.out.println("smallest_Subarray_With_a_GreaterSum");
	  int [] arr1 = {3, 4, 1, 1, 6};
	  System.out.println(smallest_Subarray_With_a_GreaterSum(arr1,8));
	  System.out.println("\n longestSameLetter \n ");
	  String s = "aabccbb";
	  System.out.println(longestSameLetter(s,2));
	  System.out.println("\n longestSubSeg \n ");
	 int [] oneZero =  {1, 0, 0, 1, 0, 1, 0, 1, 0, 1};
	 System.out.println(longestSubSeg(oneZero,2));
	 int[] nums = { 3, 4, -7, 1, 3, 3, 1, -4 };
     int target = 7;
     System.out.println("\nfindSubarrays\n");
     findSubarrays(nums, target);
	}
	
	public static int maxSumSubarraySizeK(int [] arr , int k) {
		if (k > arr.length || k < 1)  return Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0 ; i < k; i ++) {
			sum = sum + arr[i];
		}
		
		int max_so_far = sum;
		for(int i = k ; i < arr.length; i ++) {
			sum = sum + arr[i] - arr[i-k];
			if(sum > max_so_far) max_so_far = sum;
		}
		return max_so_far;
	}
	
	public static int smallest_Subarray_With_a_GreaterSum(int [] arr , int x) {
		int sum = 0;
		int s = 0;
		int min_len = Integer.MAX_VALUE;
		for(int i = 0 ; i < arr.length; i ++) {
			sum = sum + arr[i];
			if(sum >= x ) {
				//int len = i-s +1;
				while ( (sum - arr[s]) >= x && s <=i) {
				 	sum = sum -arr[s];
					s++;
				}
				int len = i-s +1;
				if(len < min_len) min_len = len;
			}
		}
		
		return min_len;
	}
	/*Longest Substring with Same Letters after Replacement (hard)
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6385d4b24a29c96532f7bb19
	 * Input: String="aabccbb", k=2  
	   Output: 5  
	 * Input: String="abbcb", k=1  
	   Output: 4
	   
	 */
	public static int longestSameLetter(String str , int k ) {
		String subStr = null;
		
		HashMap <Character,ArrayList<Integer>> hm = new HashMap<>();
		for(int i = 0 ; i < str.length(); i ++) {
		  Character  c = str.charAt(i);
		  if(hm.containsKey(c)) {
			  hm.get(c).add(i);
		  }else {
			 ArrayList <Integer> indexed =   new ArrayList<Integer>();
			 indexed.add(i);
			 hm.put(c ,indexed );
		  }
		}
		
		Character max_char ;
		int max = -1;
		for(Character c : hm.keySet()) {
			 ArrayList <Integer> indexList = hm.get(c);
			 int temp = k;
			 int prev = indexList.get(0);
			 int start = prev;
			// int  s = -1 , e = -1;
			 for(int m = 1 ; m < indexList.size(); m++) {
				 int current = indexList.get(m);
				 if((current-1 - prev) <= temp ) {
					 temp = temp - (current-1 - prev);
					 prev = current;
					 if( (current+1 - start) > max ) {
						 max = current+1 - start;
						// s = start ; e = current;
					 }
				 }else {
					 break;
				 }
			 }
		}
		return max;
	}
	/*
	 * Longest subsegment of ‘1’s formed by changing at most k ‘0’s
	 * Input : a[] = {1, 0, 0, 1, 1, 0, 1}, 
          k = 1.
		Output : 4
	 */
	// check solution below 
	//https://www.geeksforgeeks.org/longest-subsegment-1s-formed-changing-k-0s/
	public static int   longestSubSeg(int [] arr , int k) {
		int n = arr.length;
		int l = 0;
		int count0=0;
		int max_len =0;
		for(int i = 0 ; i< n; i++) {
			if(arr[i] == 0) count0++;
			
			while(count0 > k) {
				if(arr[l] == 0)count0--;
				
				l++;
			}
			max_len = Math.max(max_len, (i-l+1));
		}
		return max_len;
	}
	
	/*
	    Number of subarrays having sum exactly equal to k
	    Given an unsorted array of integers, find the number of subarrays having a sum exactly equal to a given number k.
		Examples: 
		Input : arr[] = {10, 2, -2, -20, 10}, k = -10
		Output : 3
		Explanation: Subarrays: arr[0…3], arr[1…4], arr[3..4] have a sum exactly equal to -10.
		Input : arr[] = {9, 4, 20, 3, 10, 5}, k = 33
		Output : 2
		Explanation: Subarrays : arr[0…2], arr[2…4] have a sum exactly equal to 33.
    */
	
	 public static void findSubarrays(int [] arr , int sum) {
         // create a map for storing the end index of all subarrays with
	     // the sum of elements so far
		 HashMap < Integer , ArrayList<Integer>> map = new HashMap <> ();
		 //handle the case when the sub-array with given sum start at 0th index.
		 insert(map, 0,-1);
		 
		 int sum_so_far = 0;
		 for(int i = 0; i < arr.length; i++) {
			// sum of elements so far
			 sum_so_far +=arr[i];
			// check if there exists at least one subarray with the given sum
			 if(map.containsKey(sum_so_far -sum)) {
				 ArrayList <Integer> sub_array = map.get(sum_so_far -sum);
				 for( Integer index : sub_array) {
					 printSubarray(arr , index+1 , i);
				 }
			 }
			 // insert (target so far, current i) pair into the map
			 insert(map, sum_so_far, i);
		 }
		 
		 
	 }
	 
	 private static  void insert( HashMap < Integer , ArrayList<Integer>> map  , int sum , int ind) {
		 map.putIfAbsent(sum, new ArrayList<Integer>());
		 map.get(sum).add(ind);
	 }
	 // Utility function to print subarray `nums[i, j]`
	    public static void printSubarray(int[] nums, int i, int j)
	    {
	        System.out.println(IntStream.range(i, j + 1)
	                                    .mapToObj(k -> nums[k])
	                                    .collect(Collectors.toList()));
	    }

}
