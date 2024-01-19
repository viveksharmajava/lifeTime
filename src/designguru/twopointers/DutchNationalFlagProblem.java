package designguru.twopointers;

import java.util.Arrays;

/*
 * Given an array containing 0s, 1s and 2s, sort the array in-place. 
 * You should treat numbers of the array as objects,
 * hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638f9b3e239cfbfb10ee82f3
 */
public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		int b[] ={ 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		System.out.println("Before="+Arrays.toString(A));
		threeWayPartition(A);
		System.out.println("After="+Arrays.toString(b));
		System.out.println("Before="+Arrays.toString(b));
		threeWayPartition(b);
		System.out.println("After="+Arrays.toString(b));
	}
   public static void threeWayPartition(int [] arr) {
	   int pivot = 1;
	   int mid = 0, start = 0, end =arr.length-1;
	   while(mid <= end) {
		   if(arr[mid] > pivot) {//elements is greater than 1 
			   swap(arr, mid,end) ;
			  end--;
		   }
		   else if ( arr[mid] < pivot) {
			    swap(arr, start,mid) ;
			    start++;
			    mid++;
		   }
		   else {
			   mid++;
		   }
	   }
   }
	// Utility function to swap two elements A[i] and A[j] in the array
		public static void swap(int[] A, int i, int j) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
   
}
