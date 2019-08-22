package sample.test.problems.array;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/*
 *Given an array, find the largest element in it.
	Example:
	Input : arr[] = {10, 20, 4}
	Output : 20
	
	
	Note : The motive of this program to compare time complexity among sorted and unsorted array.

 */



public class FindLargestElement {

	public static void main(String[] args) {
		
     int [] a  = new int[1000000];
     Random r = new Random();
     for(int i=0; i<1000000;i++) {
    	 a[i] = r.nextInt(1000000)+i;
    	 //System.out.println(a[i]);
     }
     findMaxInUnsortedArray(a);
     findMaxInSortedArray(a);
	}
	
	static void findMaxInUnsortedArray(int [] input) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date start = new Date();
		System.out.println(start.getTime()); //2016/11/16 12:08:43
		int max = input[0];
		for(int i=1;i<input.length; i++) {
			if(input[i]>max) max = input[i];
		}
		System.out.println("max = "+max);
		Date end = new Date();
		System.out.println(end.getTime()); //2016/11/16 12:08:43
		System.out.println(end.getTime()-start.getTime()); //2016/11/16 12:08:43
	}
	static void findMaxInSortedArray(int [] input) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date start = new Date();
		System.out.println(start.getTime()); //2016/11/16 12:08:43
		Arrays.parallelSort(input);
		int max = input[input.length-1];
		
		System.out.println("max = "+max);
		Date end = new Date();
		System.out.println(end.getTime()); //2016/11/16 12:08:43
		System.out.println(end.getTime()-start.getTime()); //2016/11/16 12:08:43
	}

}
