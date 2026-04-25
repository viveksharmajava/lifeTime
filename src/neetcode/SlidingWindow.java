package neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

	public static void main(String[] args) {

	}
   //Sliding Window Maximum
	//https://walkccc.me/LeetCode/problems/239/#__tabbed_1_2
	//https://neetcode.io/problems/sliding-window-maximum
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans = new int[nums.length-k +1];
        Deque <Integer> maxQ = new ArrayDeque<>();
        for(int i=0; i < nums.length;i++) {
        	while(!maxQ.isEmpty() && maxQ.peekLast() < nums[i]) maxQ.pollLast();
        	
        	maxQ.add(nums[i]);
        	
        	if(i >= k && nums[i-k] == maxQ.peekFirst())//out of bound
        		maxQ.pollFirst();
        	
        	if(i >=k-1) {
        		ans[i-k+1] = maxQ.peekFirst();
        	}
        }
        return ans;
    }
}
