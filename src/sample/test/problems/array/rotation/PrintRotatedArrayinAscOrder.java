package sample.test.problems.array.rotation;

import sample.test.searchingAndSorting.MergeSort;

/**
 * Given a list of numbers, you are supposed to do the following..
1. Print the first element
2. Move the second to the end.
Print 3rd
Move 4th element to the last

Keep doing this until the list is not empty.

Given these operations what should be the initial ordering such that the elements are printed in sorted order

Input: 1 3 5 6 7 2 4
Output: 1 6 2 5 3 7 4
 * 
 */
public class PrintRotatedArrayinAscOrder {

	public static void main(String[] args) {
		int []array= {53,30,3,8,6,10}; 
		printRotated(array);
	}

	
 static void printRotated(int [ ]input) {
	//first sort the input
	int [] sorted = MergeSort.mergeSort(input,0,input.length-1);
	int [] output = new int[sorted.length];
	for(int i=0, j=0; i < sorted.length ; i+=2) {
		output[i] = sorted[j++];
	}
	
	for(int i=0;i<output.length ; i++) {
		System.out.print(output[i]+" ");
	}
			
	 
 }
}
