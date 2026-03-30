package leetcode.blind75;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("numSubseq = "+numSubseq(new int[]{3,5,6,7},9));
	}

    public static int numSubseq(int[] nums, int target) {
        int count = 0;
       // if (nums[0] <= target ) count++;
       // else return count;
        for(int i = 0 ; i < nums.length; i ++){
        
            for(int j=i; j < nums.length; j++){
               System.out.println(nums[i]+" "+nums[j]);
               if(i == j && nums[i] <= target){
            	   count++;
               }
               else if((nums[i]+nums[j]) <= target) {
            	  int l =0,m = i;
            	  int r= 0;
            	  while(m < j  && nums[m] == nums[m+1]){
            		  
            	  }
            	   count++;
            	  
               }
               
            }
        }
        return count;
    }
}
