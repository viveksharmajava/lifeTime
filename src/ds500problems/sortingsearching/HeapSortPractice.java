package ds500problems.sortingsearching;

import java.util.Arrays;

public class HeapSortPractice {

	public static void main(String[] args) {
		int[] A = {9, 4, 3, 8, 10, 2, 5};
		heapSort(A);
		System.out.println("Sorted Array="+Arrays.toString(A));
	}
	
	public static void heapSort(int [] arr) {
		//build heap rearrange the array
		int n = arr.length;
		for(int i = (n/2) - 1 ; i >=0 ; i--) {
			heapify(arr, i , n);
		}
		System.out.println("Sorted Array="+Arrays.toString(arr));
		//one by one extract element for the heap...
		
		for(int i = n - 1; i > 0 ; i--) {
			swap(arr,i,0);
			// Call max heapify on the reduced heap
			heapify(arr,0, i);
		}
		
	}

	private static void heapify(int[] arr, int i, int size) {
		//make root as largest element
		int largest = i;
		int left  = 2*i +1;
		int right = 2*i + 2;
		//if left child is larger than root(i)
		if(left < size && arr[left] > arr[largest]) largest = left;
		//if right child is greater 
		if(right < size && arr[right] > arr[largest]) largest = right;
		if(largest != i) {//need to swap..
			swap(arr,largest, i);
			// Recursively heapify the affected sub-tree
			heapify(arr,largest,size);
		}
		
		
	}
	private static void swap(int[] a  , int i , int j) {
		int temp = a[i];
		a[i]= a[j];
		a[j] = temp;
	}

}
