package designguru.fastndslowpointer;
/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6392394ee4cb724ea7189954
 * 
 * Correct problem statement:
 * 
 * https://www.jiakaobo.com/leetcode/457.%20Circular%20Array%20Loop.html
 * 
 * Solution explained:
 * https://medium.com/@mithlesh.kumar.4257/leetcode-457-circular-array-loop-fdcec9ea5746
 */
public class CycleInCicrularArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [] arr = {2,-1,1,2,2};
     System.out.println("circularArrayLoop "+circularArrayLoop(arr));
	}

	 public static boolean circularArrayLoop(int[] nums) {
	        if(nums.length <= 1) return false;

	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] == 0) continue;

	            int slow = i;
	            int fast = getNext(nums, i);

	            while(nums[slow] * nums[fast] > 0){
	                if(slow == fast){
	                    if(slow == getNext(nums, slow)){
	                        return false;//single lenght
	                    }

	                    return true;
	                }
	                
	                // [-2,1,-1,"-2",-2]
	                if(nums[fast] * nums[getNext(nums, fast)] < 0) break;
	 
	                slow = getNext(nums, slow);
	                fast = getNext(nums, getNext(nums, fast));
	            }
	        }

	        return false;
	    }

	   static  private int getNext(int[] nums, int index){
	        
	        int next = (index + nums[index]) % nums.length;
	        if(next >= 0) {
	        	return next;
	        }else {
	        	return next + nums.length;
	        }
	    }
	}

