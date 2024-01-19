package designguru.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubarraywithOnesAfterReplacement {

	public static void main(String[] args) {
      int [] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
      int k = 3;//max replace
      System.out.println(longestSubArray(arr,k));
	}
	
	public static int   longestSubArray(int [] arr , int k) {
		ArrayList <Integer> ones = new ArrayList<>();
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] == 1)ones.add(i);
		}
		int temp1 = k, temp2 = k;
		int max = 0;
		int prev = ones.get(0);
		int current;
		for(int i = 1 ; i < ones.size(); i++) {
			current = ones.get(i);
			if((current-1 - prev) <= temp1 ) {
				 temp1 = temp1 - (current - prev-1);
					 max += current - prev;
					 prev = current;
			 }else {
				 break;
			 }
			
		}
		int left_max = max+1;
		max = 0;
		prev = ones.get(ones.size()-1);
		int right =ones.size()-2;
		for( ; right >=0; right--) {
			current = ones.get(right);
			if((prev-1 - current) <= temp2 ) {
				 temp2 = temp2 - (prev-1 - current);
				 max += prev - current;
				 prev = current;
			 }else {
				 break;
			 }
		
		}
		max = max+1;
		if(temp2 >0 && right > 0 )max += temp2;
		if(left_max < max) return max;
		else return left_max;
	}
	
	
	/*
	 *  Good solution
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

}
