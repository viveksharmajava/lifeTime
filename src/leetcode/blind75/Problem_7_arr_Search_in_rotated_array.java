package leetcode.blind75;
/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */

public class Problem_7_arr_Search_in_rotated_array {

	public static void main(String[] args) {
          System.out.println(searchInRotatedArray(new int[]{4,5,6,7,0,1,2}, 0));
          System.out.println(searchInRotatedArray(new int[]{4,5,6,7,0,1,2}, 3));
          System.out.println(searchInRotatedArray(new int[]{1}, 1));
	}

	public static int searchInRotatedArray(int [] nums,int target){

        int l = 0;
        int r = nums.length-1;
      //  if(nums[l] <= nums[r]) return -1;//array is not rotated.
        while(l <= r){
        	int mid = (l+r)/2;
        	//System.out.println("mid ="+mid);
        	if ( nums[mid] == target) return mid;
           if( nums[mid] > nums[r] && target < nums[l]) l = mid+1; //left half is sorted...
        	else r = mid-1;
        }
        return -1;
    
	}
}
