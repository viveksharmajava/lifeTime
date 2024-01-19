package designguru.twopointers;

import java.util.Arrays;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638e33feac0cc8a9358a25ac
 * Move all the unique elements at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.

	Example 1:
	
	Input: [2, 3, 3, 3, 6, 9, 9]
	Output: 4
	Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 */
public class RemoveDuplicate {
   public static void main(String [] arg) {
	   int [] arr = {2, 3, 3, 3, 6, 9, 9};
	   System.out.println(removeDuplicate(arr));
	   int [] arr2 = { 2, 2, 2, 11};
	   System.out.println(removeDuplicate(arr2));
   }
   public static  int removeDuplicate(int [] input) {
	   int  i =0 , j = 0;
	   while(j < input.length) {
		   if(input[i] == input[j])j++;
		   else {
			   input[++i]=input[j];
			   j++;
		   }
	   }
	  System.out.println(Arrays.toString(Arrays.copyOf(input, ++i)));
	   return i;
   }
}
