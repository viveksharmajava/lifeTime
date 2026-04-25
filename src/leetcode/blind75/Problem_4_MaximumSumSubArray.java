package leetcode.blind75;
/*
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Problem_4_MaximumSumSubArray {

	public static void main(String[] args) {
           int []nums = {-2,1,-3,4,-1,2,1,-5,4};
           System.out.println(maxSubArray(nums));
	}
/*
 * nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Ans: 
 */
	
	 public static	 int maxSubArray(int[] nums) {
	        int max_sum = Integer.MIN_VALUE;
	        int max_so_far = 0;
	        for(int i = 0 ; i < nums.length; i++){
	        	max_so_far +=nums[i];
	        	if(max_so_far > max_sum) max_sum = max_so_far;
	        	
	        	if(max_so_far < 0 ) max_so_far =0;
	        }
	        
	        return max_sum;
 	    }
}
