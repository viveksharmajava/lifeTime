package designguru.twopointers;

import java.util.Arrays;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638f7a0a4544c65f117ba260
 * 
 */
public class TripletsSmallerSum {

	public static void main(String[] args) {
      int [ ] arr = { 5, 1, 3, 4, 7};
      System.out.println(tripletWithSmallerSum(arr,12));
	}
	
	public static int tripletWithSmallerSum(int [] arr, int target) {
		Arrays.parallelSort(arr);	
		int n = arr.length;
		int answer =0;
		for (int i = 0; i < n - 2; i++) {
			 int j = i + 1, k = n - 1;
			while( j < k) {
			   int sum = arr[i]+arr[j]+arr[k];
			   if(sum >= target) k--;
			   else {
				   answer +=(k-j);//this important , if sum from j..... k , is less than target then there will
				                // be k-j pair which will give sum < target.
				  j++;
			   }
		   }
		   
			
		}
		return answer;
	}

}
