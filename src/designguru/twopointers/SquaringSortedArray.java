package designguru.twopointers;

import java.util.Arrays;

/*
 * Given a sorted array, create a new array containing squares of all
 * the numbers of the input array in the sorted order.
 * Input: [-2, -1, 0, 2, 3]
	Output: [0, 1, 4, 4, 9]
 */
public class SquaringSortedArray {

	public static void main(String[] args) {
		int [] arr = {-2, -1, 0, 2, 3};
		System.out.println(Arrays.toString(sqaureArray(arr)));
	}
   
	 public static int[] sqaureArray(int [] arr) {
		 int [] square  = new int [arr.length];
		 int i= arr.length-1;
		 int start = 0, end = arr.length-1;
		 while(start < end) {
		 if( arr[start]*arr[start] > arr[end]*arr[end]) {
			 square[i] = arr[start]*arr[start];
			 i--;
			 start++;
		 }else {
			 square[i] = arr[end]*arr[end];
			 i--;
			 end--;
		 }
		 }
		return square;
	 }
}
