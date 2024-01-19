package designguru.slidingwindow;

import java.util.Arrays;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/636b1d083b22faa3e89b2478
 * Given an array of positive integers and a number ‘S,’ 
 * find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to 'S'. 
 * Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7
Output: 1 
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 */
public class SmallestSubarrayWithaGreaterSum {

	public static void main(String[] args) {
    int [] arr = {2, 1, 5, 2, 3, 2};
    int  target = 7;
    smallestSubarrayWithgreaterSum(arr ,target);
	}
public static void smallestSubarrayWithgreaterSum(int [] arr , int target) {
		
		if (arr == null) return;
		int sum = 0;
		int start = 0;
		int end = -1;
		
		for(int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
			if( sum >= target) {
				
				int k = start;
				int temp_sum = sum;
				while( k < i &&  temp_sum >= target) {
					temp_sum -= arr[k];
					if(temp_sum == target) break;
					k++;
				}
				if( temp_sum >= target) {
					start = k;
					end  = i;
				}
			}
			
		}
		if(end != -1) {
			System.out.println("Subaray "+Arrays.toString(Arrays.copyOfRange(arr, start, end)));
		}else {
			System.out.println("Subarray with larger or equal sum of "+target+" does not exist");
		}
		
   }
}
