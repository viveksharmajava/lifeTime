package ds500problems.array;

import java.util.Arrays;

public class ThreeWayPartition
{
	// Linear-time partition routine to sort an array containing 0, 1 and 2
	// It similar to three-way Partitioning for Dutch national flag problem
	public static void  threewayPartitioning(int[] A, int end)
	{
		int start = 0, mid = 0;
		int pivot = 1;

		while (mid <= end)
		{
			if (A[mid] < pivot)		 // current element is 0
			{
				swap(A, start, mid);
				++start;
				++mid;
			}
			else if (A[mid] > pivot)	// current element is 2
			{
				swap(A, mid, end);
				--end;
			}
			else						// current element is 1
				++mid;
		}
	}
	
	private static void practice3WayPartioning(int[] a) {
		int start = 0, mid=0, end=a.length-1;
		int pivot= 1;
		while(mid <= end) {
			if(a[mid] < pivot) { // 0
				swap(a , start , mid);
				++start;
				++mid;
			}
			else if ( a[mid] > pivot) //2
			{
				swap(a , mid , end);
				end--;
			}
			else {
				mid++;
			}
				
		}
	}
	
	/*
	 * given an array with negative positives integers arrange all negative to the left and all the postive to the right such that even
	 * even positive appears before than odd positive.
	 */
	
	public static void custom3waypartioning(int []a) {

		int start = 0, mid=0, end=a.length-1;
		int pivot= 0;
		while(mid <= end) {
			if(a[mid] < pivot) { // negative number
				swap(a , start , mid);
				++start;
				++mid;
			}
			else if ( a[mid]%2 > pivot) //odd number
			{
				swap(a , mid , end);
				end--;
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

	// Sort an array containing 0’s, 1’s and 2’s
	public static void main (String[] args)
	{
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		int b[] ={ 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
		threewayPartitioning(A, A.length - 1);
		System.out.println(Arrays.toString(A));
	  practice3WayPartioning(b);
	  System.out.println(Arrays.toString(b));
	
	  int c[] ={ -6, 1, 2, -2, 1, 8, -5, 2, 6, 9, -7, 4 };
	  custom3waypartioning(c);
	  System.out.println(Arrays.toString(c));
		//Arrays.sorparallelSort(a);
	}
	
	
}