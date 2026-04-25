package leetcode.blind75;
/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/1178547400/
 */
public class Problem_6_arr_MinInRotatedSortedArray {

	public static void main(String[] args) {
     
	}
	
/*
 * [4,5,6,7,8,9,10,11,0,1,2]	
 */
 public static  int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if(nums[l] <= nums[r]) return nums[l];//array is not rotated.
        while(l <= r){
        	int mid = (l+r)/2;
        	if(mid >0 &&   nums[mid-1] > nums[mid]) return nums[mid];
           if( nums[mid] > nums[r]) l = mid+1; //left half is sorted...
        	else r = mid-1;
        }
        return -1;
    }
 
}
