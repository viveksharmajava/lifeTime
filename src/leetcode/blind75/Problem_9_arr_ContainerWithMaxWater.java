package leetcode.blind75;
/*
 * problem: https://leetcode.com/problems/container-with-most-water/
 * solution: https://www.geeksforgeeks.org/container-with-most-water/
 */
public class Problem_9_arr_ContainerWithMaxWater {

	public static void main(String[] args) {
    System.out.println("maxArea = "+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
	 public static int maxArea(int[] height) {
		  int l = 0;
	      int r = height.length - 1;
	      int max_so_far =0 ;
	      int max_area = 0;
	      while( l < r){
	    	  
	    	  max_area = (r-l)*(Integer.min(height[l],height[r]));
	    	  if (max_area > max_so_far )  max_so_far = max_area;
	    	  if(height[l] <  height[r]) l++;
	    	  else r--;
	      }
	      return max_so_far;
	    }

}
