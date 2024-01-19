package designguru.mergeintervals;
/*
 * https://www.geeksforgeeks.org/find-intersection-of-intervals-given-by-two-lists/
 * 
 *  To solve the problem mentioned above, two pointer technique can be used, as per the steps given below:
	Maintain two pointers i and j to traverse the two interval lists, arr1 and arr2 respectively.
	Now, if arr1[i] has smallest endpoint, it can only intersect with arr2[j]. Similarly, if arr2[j] has smallest endpoint, it can only intersect with arr1[i]. If intersection occurs, find the intersecting segment.
	[l, r] will be the intersecting segment if l <= r, where l = max(arr1[i][0], arr2[j][0]) and r = min(arr1[i][1], arr2[j][1]).
	Increment the i and j pointers accordingly to move ahead.
	
	Input: arr1[][] = {{0, 4}, {5, 10}, {13, 20}, {24, 25}} 
	arr2[][] = {{1, 5}, {8, 12}, {15, 24}, {25, 26}} 
	Output: {{1, 4}, {5, 5}, {8, 10}, {15, 20}, {24, 24}, {25, 25}}
	Explanation: {1, 4} lies completely within range {0, 4} and {1, 5}. Hence, {1, 4} is the desired intersection. Similarly, {24, 24} lies completely within two intervals {24, 25} and {15, 24}.
	
 */
public class IntersectOfIntervals {

	public static void main(String[] args) {
		int arr1[][] = { { 0, 4 }, { 5, 10 },
                { 13, 20 }, { 24, 25 } };

		int arr2[][] = { { 1, 5 }, { 8, 12 },
		                { 15, 24 }, { 25, 26 } };
		
		printIntervals(arr1, arr2);
	}
	
   public static void printIntervals(int [][] arr1 , int [][] arr2) {
	   
	   int i = 0, j = 0;
	   int n = arr1.length;
	   int m = arr2.length;
	   
	   while( i < n && j < m) {
		   
		   //find left bound for intersection
		   int l = Math.max(arr1[i][0], arr2[j][0]);
		   //find the right bound for intersection;
		   int r = Math.min(arr1[i][1], arr2[j][1]);
		   if(l <= r) {
			   System.out.println("Intersect "+l+","+r);
		   }
		   if(arr1[i][1]< arr2[j][1]) i++;
		   else j++;
		   
	   }
	   
	   
	   
   }

}
