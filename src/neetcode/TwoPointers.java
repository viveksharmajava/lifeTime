package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

	public static void main(String[] args) {

	}
	
      public int[] twoSum(int[] numbers, int target) {
        int [] ans = new int[2];
         int l = 0; 
         int r = numbers.length -1 ;
         while(l < r) {
        	 if(numbers[l]+numbers[r] == target) {
        		 ans[0] =l;
        		 ans[1] = r;
        	 }
        	 if (numbers[l]+numbers[r] < target) {
        		 l++;
        	 }
        	 else {
        		 r--;
        	 }
         }
         return ans;
     }
      //3 Sum remove duplicates and return all triplets..
    	  public List<List<Integer>> threeSum(int[] nums) {
    	    if (nums.length < 3)
    	      return new ArrayList<>();

    	    List<List<Integer>> ans = new ArrayList<>();

    	    Arrays.sort(nums);

    	    for (int i = 0; i + 2 < nums.length; ++i) {
    	      if (i > 0 && nums[i] == nums[i - 1])
    	        continue;
    	      // Choose nums[i] as the first number in the triplet, then search the
    	      // remaining numbers in [i + 1, n - 1].
    	      int l = i + 1;
    	      int r = nums.length - 1;
    	      while (l < r) {
    	        final int sum = nums[i] + nums[l] + nums[r];
    	        if (sum == 0) {
    	          ans.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
    	          while (l < r && nums[l] == nums[l - 1])
    	            ++l;
    	          while (l < r && nums[r] == nums[r + 1])
    	            --r;
    	        } else if (sum < 0) {
    	          ++l;
    	        } else {
    	          --r;
    	        }
    	      }
    	    }

    	    return ans;
    	  }
    	  //
    	   public int maxArea(int[] heights) {
    	       int max = 0;
    	       int l = 0;
    	       int r = heights.length-1;
    	       while(l < r) {
    	    	   int min = Integer.min(heights[l],heights[r]);
    	    	   int distance = r-l;
    	    	   int area = distance * min;
    	    	   if( max < area) max =area;
    	    	   if( heights[l] < heights[r])l++;
    	    	   else r--;
    	       }
    	       return max;
    	    }
    	   //https://neetcode.io/problems/trapping-rain-water
    	   public static int trap(int[] heights) {
    	        int n = heights.length;
    		   int [] l = new int [n];
    		   int [] r = new int[n];
    		   for(int i = 0 ; i< n ; i++) {//store left max heights.. similar to NGE
    			   l[i] = i==0 ? heights[i] : Math.max(heights[i],l[i-1]);
    		   }
    		   for(int i = n-1 ; i >=0 ; i--) {//store right max heights.. similar to NGE
    			   r[i] = i==n-1 ? heights[i] : Math.max(heights[i],r[i+1]);
    		   }
    		   
    		   int ans = 0;
    		   for(int i =0 ; i < n; i++) {
    			   ans +=( Math.min(l[i], r[i])- heights[i]);
    		   }
    		   return ans;
    	    }
    	   //Permutation in String
    	   //https://neetcode.io/problems/permutation-string
    	   public boolean checkInclusion(String s1, String s2) {
    		    int[] count = new int[26];
    		    int required = s1.length();

    		    for (final char c : s1.toCharArray())
    		      ++count[c - 'a'];

    		    for (int l = 0, r = 0; r < s2.length(); ++r) {
    		      if (--count[s2.charAt(r) - 'a'] >= 0)
    		        --required;
    		      while (required == 0) {
    		        if (r - l + 1 == s1.length())
    		          return true;
    		        if (++count[s2.charAt(l++) - 'a'] > 0)
    		          ++required;
    		      }
    		    }

    		    return false;
    		  }
}
