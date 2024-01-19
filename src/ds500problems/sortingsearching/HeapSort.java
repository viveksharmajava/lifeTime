package ds500problems.sortingsearching;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] A = { 6, 4, 7, 1, 9, -2 };
		sort(A);
		System.out.println("Sorted Array="+Arrays.toString(A));
	}
	public static void sort(int [] A) {
		int n = A.length;
		int i = (n-2)/2;
		
		while(i >=0 ) {
			heapify(A ,i-- ,n);
		}
		while(n > 0) {
			A[n-1] = pop(A,n);
			n--;
		}
	}
	private static void swap(int[] a  , int i , int j) {
		int temp = a[i];
		a[i]= a[j];
		a[j] = temp;
	}
	private static void heapify(int [] a , int i,int size) {
		int left  = 2*i +1;
		int right = 2*i +2;
		int largest = i;
		if(left < size && a[left]  > a[largest])largest = left;
		if(right < size && a[right]  > a[largest])largest = right;
		
		if(largest != i) {
			swap(a , largest ,i);
			heapify(a , largest,size);
		}
	}
	
	private static int pop( int []a , int n) {
		int top = a[0];
		a[0] = a[n-1];
		heapify(a , 0,n-1);
		return top;	
	}

}
