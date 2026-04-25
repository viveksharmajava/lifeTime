package leetcode.blind75;

public class Problem_5_MaxProductSubArray {

	public static void main(String[] args) {
         
		System.out.println(maxProductSubArray(new int[]{2,3,-2,4}));
	}
	/*https://leetcode.com/problems/maximum-product-subarray/description/
	 *Input: nums = [2,3,-2,4]
		Output: 6
		Explanation: [2,3] has the largest product 6.
	 * Ans: 
	 */
		
		 public static	 int maxProductSubArray(int[] A) {
			  // base case
	        if (A.length == 0) {
	            return 0;
	        }
	 
	        // maintain two variables to store the maximum and minimum product
	        // ending at the current index
	        int max_ending = A[0], min_ending = A[0];
	 
	        // to store the maximum product subarray found so far
	        int max_so_far = A[0];
	 
	        // traverse the given array
	        for (int i = 1; i < A.length; i++)
	        {
	            int temp = max_ending;
	 
	            // update the maximum product ending at the current index
	            max_ending = Integer.max(A[i], Integer.max(A[i] * max_ending,
	                                                A[i] * min_ending));
	 
	            // update the minimum product ending at the current index
	            min_ending = Integer.min(A[i], Integer.min(A[i] * temp,
	                                                A[i] * min_ending));
	 
	            max_so_far = Integer.max(max_so_far, max_ending);
	        }
	 
	        // return maximum product
	        return max_so_far;
	        
		 }
		}
