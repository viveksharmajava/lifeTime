package leetcode.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/description/
 * 
 */
public class Problem_8_arr_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
       System.out.println("After sorting "+Arrays.toString(nums));
        for(int i = 0 ; i < nums.length; i++){
        	int target = nums[i];
        	int l = i+1;
        	int r = nums.length-1;
        	
        	while(l <  r){
        		if(target + nums[l]+nums[r] == 0){
        			ArrayList <Integer> arr = new ArrayList <Integer>();
        			arr.add(target);
        			arr.add(nums[l]);
        			arr.add(nums[r]);
        			result.add(arr);
        			break;
        			
        		}
        		else if ( target +nums[l]+nums[r] < 0) l++;
        		else r--;
        	}
        }
        
        return result;
        
    }
	

}
