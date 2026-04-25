package neetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JumpGame2 game = new JumpGame2();
       System.out.println(game.minJump.get());
       game.jump(new int[] {2,4,1,1,1,1});
       System.out.println(game.minJump.get());
	}
	 AtomicInteger minJump = new AtomicInteger(Integer.MAX_VALUE);
	    public int jump(int[] nums) {
	       dfs(nums,0,0);
	       return minJump.get();
	    }

	    private void dfs(int [] nums, int i,int count){
	      
	    	if(i == nums.length-1){
	    		 System.out.println("count ="+count);
	    		if(minJump.get() > count){
	            minJump.set(count);
	           }
	            return ;
	        }
	        int end = Math.min(nums.length-1 , i+nums[i]);
	        // do the dfs from i... end to check 
	        //if can reach end of the array.
	        for(int j= i+1; j <= end; j++){
	            dfs(nums,j, count+1);
	        }
	        
	    }
	}
