package designguru.knapsack;

import java.util.concurrent.atomic.AtomicInteger;

public class CountOfSubsetSum {

	public static void main(String[] args) {
      int [] arr = {1, 1, 2, 3};
      int  S=4;
      AtomicInteger count = new AtomicInteger(0);
     int c=  count_subsetsum(arr,S,arr.length-1,count);
      System.out.println("count ="+count+" count c  ="+c);
      c=  count_subsetsum2(arr,S,arr.length-1);
      System.out.println("count c  ="+c);
       
      int [] targetSum =  {1, 1, 2, 3};
      S=1;
      count = new AtomicInteger(0);
      
      System.out.println("targetSum ="+targetSum(targetSum, (S+7)/2, targetSum.length-1));
      
      int [] target2 = {1, 2, 7, 1} ;
      S = 9;
      
      System.out.println("targetSum ="+targetSum(target2, (S+11)/2, target2.length-1));
      
      
	}
	public static int count_subsetsum(int []arr , int W,int n, AtomicInteger count) {
		if( W == 0 ) {
			count.set(count.get()+1);
			return 1;
		}
		if( n < 0) return 0;
		if( arr[n] <= W) {
		 return count_subsetsum(arr, W-arr[n],n-1,count) + 
				 count_subsetsum(arr, W,n-1,count);
		}else {
			return count_subsetsum(arr, W,n-1,count);
		}
	}
	
	public static int count_subsetsum2(int []arr , int W,int n) {
		if( W == 0 ) {
			return 1;
		}
		if( n < 0) return 0;
		if( arr[n] <= W) {
		 return count_subsetsum2(arr, W-arr[n],n-1) + 
				 count_subsetsum2(arr, W,n-1);
		}else {
			return count_subsetsum2(arr, W,n-1);
		}
	}
	/*
	 *  S1(Sum)-S1(Sum) = difference
	 *  S1(Sum)+ S2(Sum) = Sum of array elements.. arr(sum)
	 *  2(S1(sum) = diff+ arr(Sum)
	 *  S1(Sum) = ( diff+ arr(Sum)/2
	 *  
	 *  So we should find out sub set which sum is ( diff+ arr(Sum)/2
	 *  
	 *  Example: 1, 1, 2, 3}, diff = 1 ,array sum = 7 
	 *  find Sub sets S1 which has sum (1+7)/2 = 4
	 *  so final solution will be count subset with sum S
	 *  
	 *  
	 */
	public static int targetSum(int []arr , int W,int n) {
		if( W == 0 ) {
			return 1;
		}
		if( n < 0) return 0;
		if( arr[n] <= W) {
		 return targetSum(arr, W-arr[n],n-1) + 
				 targetSum(arr, W,n-1);
		}else {
			return targetSum(arr, W,n-1);
		}
	}
	
}
