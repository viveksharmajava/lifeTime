package ds500problems.sortingsearching;

import java.util.Arrays;

public class All_Sorting_Alogrithms {

	public static void main(String[] args) {
               int []array= {53,30,3,8,6,10,2};
		
		 insertionSort(array);
		System.out.println("Insertion Sort Array ="+Arrays.toString(array));
		int []array2= {53,30,3,8,6,10,2};
		selectionSort(array2);
		System.out.println("Selection sort Array ="+Arrays.toString(array2));
		
		int []array3= {53,30,3,8,6,10,2};
		bubbleSort(array3);
		System.out.println("Bubble sort Array ="+Arrays.toString(array3));
		int []array4= {53,30,3,8,6,10,2};
		System.out.println("Before sort Array ="+Arrays.toString(array4));
		mergeSort(array4);
		System.out.println("Merge sort Array ="+Arrays.toString(array4));
		
		
		int [] array5= {53,30,3,8,6,10,2};
		quickSort(array5,0,6);
		System.out.println("Quick sort Array ="+Arrays.toString(array5));
	}

	public static void insertionSort(int [] arr) {
		
		int key ;
		for(int j = 1; j < arr.length ; j++) {
			
			key = arr[j];
			int i=j-1;
			while(i >=0  && arr[i] >= key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		
		}
		//return arr;
	}
	
	/*
	 * Complexity: O(n^2)
	 * Advantage : 
	 * The biggest advantage of using a selection sort is that
	 * it does a maximum of n swaps (memory write). 
	 * insertion sort use O(n^2) 
	 */
	
	public static void  selectionSort(int [] arr) {
		
		//run the n-1 times where n is the lenght
		for(int i = 0; i < arr.length-1; i++) {
			int min = i;
			//find the minimum elements in the unsorted array  i...n-1
			//and swap the element with  arr[i]
			for(int j = i+1; j < arr.length; j++) {
				
				//if arr[j] is the minimum then udpate it with min...
				if(arr[j] < arr[min]) min = j;
			}
			swap(arr,i,min);
		}
	  // return arr;
	}

	 public static void bubbleSort(int [] arr) {

			//run the n-1 times where n is the lenght
			for(int k = 0; k < arr.length-1; k++) {
				
				//last k items are already sorted so the inner look can
				//avoid looking at the last k 
				for(int i = 0; i <  arr.length -1 -k ; i++) {
					
					if(arr[i] > arr[i+1]) swap(arr,i+1,i);
				}
				
			}
		  // return arr;
	 }
	 
	 /*
	  *  Algorithm: quick sort 
	  *  https://www.techiedelight.com/quick-sort-using-hoares-partitioning-scheme/
	  * 
	  */
	 
	 public static void quickSort(int [] arr ,int low , int high) {
		 if(low >= high) return;
		 // re-arrange elements based on 
		 int pivot = partition(arr , low ,high);
		 quickSort(arr,low, pivot);
		 quickSort(arr,low+1, pivot);
		 
	 }
	 private static int partition(int[] arr, int low, int high) {
		 int pivot = arr[low];
		 int i = low-1;
		 int j = high + 1;
		 while(true) {
			 do {
				 i++;
			 }while(arr[i] < pivot);
			 
			 do {
				 j--;
			 }while(arr[j] > pivot);
			if(i >= j)  return j; // I did not understand this code..
			swap(arr,i,j);
		 }
		 
		 
	}

	public static void mergeSort(int [] arr) {
		 mergeSort(arr,0, arr.length-1);
	 }
	 
	 private static void  mergeSort(int [] arr, int p , int r) {
		 if( p < r) {
			 int q = p + (r-p)/2;
			 mergeSort(arr,p,q);
			 mergeSort(arr,q+1,r);
			 merge(arr,p,q,r);
			 
		 }
	 }
	private static void merge(int[] arr, int p, int q, int r) {
		
		int l1 = q-p+1;
		int l2 = r-q;
		int [] L1 = new int [l1];
		int [] L2 = new int [l2];
		for(int i =0 ; i < l1 ; i++) {
			L1[i] = arr[p+i];
		}
		for(int i =0 ; i < l2 ; i++) {
			L2[i] = arr[q+1+i];
		}
		
		int i =0; 
		int j = 0;
		int k = p;
		while(i <  l1 && j < l2) {
			if(L1[i] < L2[j]) {
				arr[k] = L1[i] ;
				i++;
			}else {
				arr[k] = L2[j] ;
				j++;
			}
			k++;
		}
		if(  i < l1) {
			while(i < l1) {
				arr[k] = L1[i] ;
				i++;
				k++;
			}
		}
		else if(  j < l2) {
			while(j < l2) {
				arr[k] = L2[j] ;
				j++;
				k++;
			}
		}
		
		
	}

	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
	}
}
