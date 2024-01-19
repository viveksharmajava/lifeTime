package ds500problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ArrayProblems2 {

	public static void main(String[] args) {
		int n = 5;
        int[] out = new int[n];
 
        // print all combinations of numbers from 1 to `n` having sum `n`
        printCombinations(1, n, out, 0);
        int[] arr = { 4, 3, 6, 5, 2, 4,7 };
       // findMissingAndDuplicate(arr);
        int[] price = { 2, 4, 7, 5, 4, 3, 5 };
        findMaxProfit(price);
        findMaxProfit(new int[] {10, 6, 8, 4, 2});
        findMaxProfit(new int [] {8, 7, 6, 4});
        
        int[] nums = { 2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9 };
        
        // find the frequency of each array element and store it in a map
        HashMap<Integer, Integer> freq = new HashMap<>();
        findFrequency(nums, 0, nums.length - 1, freq);
 
        System.out.println(freq);
        
        //isInterleaving("AB","CD","ACDB");
       // isInterleaving("ABC","DEF","ADEBCF");
       // isInterleaving("CD","ABC","ACBCD");
        isInterleaving("ABC","ACD","ACDABC");
        int[] arrr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6 };
        replace(arrr);
        
        //find max sum subarray problem
        int[] numsmax = { 2, -4, 1, 9, -6, 7, -3 };
        
        System.out.println("The maximum sum of the subarray is " +
                maximumSumSubarray(numsmax, 0, numsmax.length-1));
    
	}
// print all 1-n having sum n
//https://www.techiedelight.com/print-all-combination-numbers-from-1-to-n/
 /*
  * For n = 5, the following combinations are possible:
 
	{ 5 }
	{ 1, 4 }
	{ 2, 3 }
	{ 1, 1, 3 }
	{ 1, 2, 2 }
	{ 1, 1, 1, 2 }
	{ 1, 1, 1, 1, 1 }
  */
	
	// Recursive function to print all combinations of numbers from `i` to `n`
    // having sum `n`. The `index` denotes the next free slot in the output array `out`
	public static void printCombinations(int i , int n , int [] out , int index) {
		if(n == 0 ) {
			System.out.println(Arrays.stream(out).limit(index).boxed().collect(Collectors.toList()));
		}
		// start from the previous element in the combination till `n`
		for(int j = i ; j <= n ; j++) {
			out[index] = j;
			printCombinations(j, n-j, out, index+1);
		}
		
	}
  // int[] price = { 2, 4, 7, 5, 4, 3, 5 };
  //Find maximum profit earned from at most two stock transactions
  //https://www.techiedelight.com/find-maximum-profit-earned-from-at-most-two-stock-transactions/
	// solution isnpired from https://www.youtube.com/watch?v=JaosdXkUWTs
	public static void findMaxProfit(int [] prices) {
		int local_min = Integer.MAX_VALUE;
		int local_max = Integer.MIN_VALUE;
		int first_profit = Integer.MIN_VALUE;
		int second_profit= Integer.MIN_VALUE;
		int i = 0;
		while(i < prices.length) {
			if(local_min == Integer.MAX_VALUE) {//find min
				while((i+1 < prices.length) && prices[i] > prices[i+1]) {
					i++;
				}
				if(i < prices.length) {
					local_min = prices[i];
					//i++;//increase it to find the max after min index
				}
				
			}
			 if((i+1 < prices.length) && local_max == Integer.MIN_VALUE) {//find min
				while((i+1 < prices.length) && prices[i] < prices[i+1]) {
					i++;
				}
				if(i < prices.length) {
					local_max = prices[i];
				}
			}
			
			//int profit = local_max - local_min;
			if(local_max != Integer.MIN_VALUE && local_max > local_min && first_profit == Integer.MIN_VALUE) {
				first_profit = local_max - local_min;
				local_min = Integer.MAX_VALUE;
				local_max = Integer.MIN_VALUE;
				
			}
			else  if(local_max != Integer.MIN_VALUE && local_max > local_min && second_profit == Integer.MIN_VALUE) {
				second_profit = local_max - local_min;
				local_min = Integer.MAX_VALUE;
				local_max = Integer.MIN_VALUE;
				
			}
			else if( second_profit != Integer.MIN_VALUE &&  first_profit != Integer.MIN_VALUE) {
				
				if(first_profit < local_max - local_min) {
					first_profit= local_max - local_min;
					local_min = Integer.MAX_VALUE;
					local_max = Integer.MIN_VALUE;
					
				}
				else if (second_profit < local_max - local_min) {
					second_profit = local_max - local_min;
					local_min = Integer.MAX_VALUE;
					local_max = Integer.MIN_VALUE;
					
				}
			}
			i++;
		}
		
		int maxProfit = 0;
		if(first_profit != Integer.MIN_VALUE)
		 {
			System.out.println("first profit"+first_profit);
			maxProfit += first_profit;
		 }
		if(second_profit != Integer.MIN_VALUE)
		 {
			System.out.println("second profit "+second_profit);
			maxProfit += second_profit;
		 }
		System.out.println("Max profit "+maxProfit);
	}
	
	//Find the frequency of each element in a sorted array containing duplicates
	//https://www.techiedelight.com/find-frequency-element-sorted-array-containing-duplicates/
	public static void findFrequency( int a[] , int left , int right , HashMap<Integer, Integer> freq) {
		if(left > right ) return;
		if(a[left] == a[right]) {
			Integer count = freq.get(a[left]);
			count = count == null? 0 : count;
			freq.put(a[left],count+right-left+1);
			return;
		}
		int mid = (left+right)/2;
		findFrequency(a , left, mid,freq);
		findFrequency(a , mid+1 , right,freq);
	}
	//https://www.techiedelight.com/check-string-interleaving-two-given-strings/
	/*
	 * Given three strings, return true if the third string is interleaving the first and second strings, i.e., it is formed from all characters of the first and second string, and the order of characters is preserved.

		For example,
		
		ACDB is interleaving of AB and CD
		 
		ADEBCF is interleaving of ABC and DEF
		 
		ACBCD is interleaving of ABC and CD
		 
		ACDABC is interleaving of ABC and ACD
		Practice this problem
	 */
	public static boolean isInterleaving(String s1, String s2 , String s3) {
	     if(s3.length() != (s1.length()+s2.length())) return false;
		 int len = s3.length();
		 int l1 = s1.length();
		 int l2 = s2.length();
	     int  m=0, n=0;
	     for(int i  =0 ; i <  len ; i++) {
	    	 if(m < l1 && n < l2  && s1.charAt(m) == s2.charAt(n)) {
	    		 //check from where to pick the character
	    		 // we can iteratively  check next match, we should pick only the which has next match
	    	      int temp1 = m;
	    	      int temp2 = n;
	    	      int temp3 = i;
	    	      boolean b1 =false;
	    	      boolean b2= false;
	    	      while( (temp1 < l1 && (b1 = s1.charAt(temp1) == s3.charAt(temp3)))
	    	    		  &&
	    	    		  (temp2 < l2 && (b2 = s2.charAt(temp2) == s3.charAt(temp3)))
	    	    		  
	    	    		  ){
	    	    	  temp1++;temp2++; temp3++;
	    	      }
	    	      if(b1)m++;
	    	      if(b2) n++;
	    	 }
	    	 else if(m < s1.length() &&s3.charAt(i) == s1.charAt(m)) {
	    		 m++;
	    	 }
	    	 else if(n < s2.length() &&s3.charAt(i) == s2.charAt(n)) {
	    		 n++;
	    	 }
	    	 else {
	    		 System.out.println(s3+" isInterleaving "+false);
	    		    
	    		 return false;
	    	 }
	     }
	     System.out.println(s3+" isInterleaving "+true);
	     return true;
	}
	
	/* https://www.techiedelight.com/replace-every-element-array-least-greater-element-right/
	 * Replace every array element 
	 * with the least greater element on its right
	 * Input:  { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6 }
 	   Output: { 32, -1, 94, 35, 65, 80, 90, 94, -1, -1 }

	 */
	public static void replace(int [] nums) {
		Node root = null;
		System.out.println("before = "+Arrays.toString(nums));
		for(int i = nums.length-1; i >=0 ; i--) {
			AtomicInteger successor = new AtomicInteger(-1);
			root = insert(root, nums[i] ,successor);
			nums[i]= successor.get();
		}
		System.out.println("after = "+Arrays.toString(nums));
	} 
	private static Node insert(Node root ,int key, AtomicInteger successor) {
		if (root == null) return new Node(key);
		if( key < root.data) {
			successor.set(root.data);
			root.left = insert(root.left, key, successor);
		}
		else {
			root.right= insert(root.right,key,successor);
		}
		return root;
	}
//find maximum sum subarray
//https://www.techiedelight.com/maximum-sum-subarray-using-divide-conquer/
	public static int maximumSumSubarray(int [] input , int left ,int right) {
		
		if(right == left) return input[left];
		int mid = (left + right)/2;
		int leftMax = Integer.MIN_VALUE;
		int sum=0;
		// Find maximum subarray sum for the left subarray,
        // including the middle element
        
		for(int i = mid ; i >= left; i--) {
			sum+=input[i];
			if(sum > leftMax) leftMax = sum;
		}
		// Find maximum subarray sum for the right subarray,
        // excluding the middle element
        int rightMax = Integer.MIN_VALUE;
        sum = 0;//reset
        for(int i = mid+1; i <=right ; i++) {
        	sum += input[i];
        	if(sum > rightMax) {
        		rightMax = sum;
        	}
        }
        // Recursively find the maximum subarray sum for the left
        // and right subarray, and take maximum
        int leftRightMax  = Integer.max(maximumSumSubarray(input ,  left , mid),maximumSumSubarray(input ,  mid+1 , right));
		
	   return Integer.max(leftRightMax, leftMax+rightMax);
	}

}
//TreeNode
class Node {
	int data;
	Node left,right;
	Node(int key){
		this.data = key;
	}
}
