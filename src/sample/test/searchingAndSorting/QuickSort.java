package sample.test.searchingAndSorting;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
 
	// Java implementation of quicksort algorithm
		public static void main(String[] args)
		{
			int a[] = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };

			quickSort(a, 0, a.length - 1);
			
			// print the sorted array
			System.out.println(Arrays.toString(a));
			
			System.out.println("iterativeQuickSort\n");
			int b[] = { 9, -3, 5, 2, 6, 8, -6, 1, 3 };
			iterativeQuickSort(b);
			System.out.println(Arrays.toString(b));
		}
	public static void quickSort(int a[], int start , int end) {
		//base case 
		if(start >= end) return;
		
		int pivotIndex = partition(a , start ,end);
		 quickSort(a, start, pivotIndex-1);
		 quickSort(a, pivotIndex, end);
	}
	//partition using Lumoto partition scheme
	private static int partition(int a[], int start ,int end) {
		//pick right most element as pivot from the array
		int pivot = a[end];
		// elements less than pivot will be pushed to the left of pIndex
		// elements more than pivot will be pushed to the right of pIndex
		// equal elements can go either way
		int pIndex =start;
	    //each time when we find element less that to pivot 
		// move that element to left of the pivot
		for(int i = start ; i < end; i++)
		{
			if(a[i] <= pivot) {
				swap(a, i , pIndex);
				pIndex++;
			}
		}
		// swap pIndex with Pivot
		swap(a, end, pIndex);
		 return pIndex;
	}
	
	/*Iterative quick sort
	 *  Souce : https://www.techiedelight.com/iterative-implementation-of-quicksort/
	 */

	 public static void iterativeQuickSort(int a[]) {
		 //create stack of Pair class
		 Stack < Pair> stack = new Stack();
		 stack.push(new Pair(0,a.length-1));
		 while(!stack.isEmpty()) {
			 System.out.println("stack size="+stack.size());
			 int start = stack.peek().getX();
			 int end = stack.peek().getY();
			 stack.pop();
			 int pivot = partition(a, start, end);
			 if(pivot-1 > start) stack.push(new Pair(start,pivot-1));
			 if(pivot+1 < end) stack.push(new Pair(pivot+1,end));
			 
		 }
		 
	 }
	
	public static void swap(int []array,int i , int j){
		 
		 int temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
	 }
}
//Simple pair class in Java
	 class Pair {
	 	private final int x;
	 	private final int y;

	 	Pair(int x, int y) {
	 		this.x = x;
	 		this.y = y;
	 	}

	 	public int getX() { return x; }
	 	public int getY() { return y; }
	 }
