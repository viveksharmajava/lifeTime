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

		threewayPartitioning(A, A.length - 1);
		System.out.println(Arrays.toString(A));
	}
	
	
}