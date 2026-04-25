package leetcode.blind75;

import java.util.HashMap;

public class Problem_1_Two_sum {

	public static void main(String[] args) {

	}
	
	 public int[] twoSum(int[] nums, int target) {
	        
		 int [] result = new int[2];
		 HashMap<Integer,Integer> map = new HashMap<>();
		 for(int i=0 ; i < nums.length; i++){
			 if(map.containsKey(target-nums[i])) 
			 {
				 result[0] = map.get(target-nums[i]);
				 result[1] = i;
				// return result;
				 break;
			 }
			 else{
				 map.put(nums[i], i);
			 }
		 }
		 return result;
	    }

}


