package ds500problems.sortingsearching;

import java.net.URL;
import java.security.CodeSource;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Class klass = MergeSort.class;
		URL jar = klass.getResource('/' + klass.getName().replace('.', '/') + ".class");
		System.out.println(" jar localtion "+jar);
		
		int []array4= {1,2,0,3,-3,-2,-1,0};
		System.out.println("Before sort Array ="+Arrays.toString(array4));
		sort(array4);
		System.out.println("Merge sort Array ="+Arrays.toString(array4));
	}
	
	public static void sort(int [] arr) {
		mergeSort(arr, 0, arr.length-1);
	}
	
	private static void mergeSort(int [] arr , int l , int r) {
		//base case
		if( l >= r) return ;
		
		int mid = (l + r)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		merge(arr,l,mid,r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		 
		//find the size of 2 sub-arrays to be merged
		int n1 = mid - l +1;
		int n2 = r-mid;
		int L1 [] = new int [n1];
		int L2[] = new int [n2];
		//copy into sub-array
		for(int i = 0; i < n1; i++) {
			L1[i] = arr[l+i];
		}
		for(int i = 0; i < n2; i++) {
			L2[i] = arr[mid +i + 1];
		}
		int k = l;
		int i = 0, j = 0;
		while( i < n1 && j < n2) {
			if(L1[i] < L2[j]) arr[k++] = L1[i++];
			else arr[k++] = L2[j++];
		}
		while( i < n1 ) arr[k++] = L1[i++];
			
		while( j < n2) arr[k++] = L2[j++];
		
	}

}
