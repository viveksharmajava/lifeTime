package neetcode;

import java.util.PriorityQueue;

public class KthLargest {

	 PriorityQueue <Integer> minHeap = new PriorityQueue<>();
	 int k = 0;
	 KthLargest(int k , int [] nums){
		 this.k = k;
		 for(int i=0; i < nums.length; i++)
		 {
			 minHeap.offer(nums[i]);
			 if(minHeap.size() > k) {
				 minHeap.poll();
			 }
		 }
	 }
	 
	 public int add(int n) {
		 minHeap.offer(n);
		 if(minHeap.size() > k) {
			 minHeap.poll();
		 }
		 return minHeap.peek();
	 }
	
	 
	 
	public static void main(String[] args) {
         KthLargest kth = new KthLargest(3, new int[] {6, 1, 2, 3, 3,4,5});
         System.out.println("kth ="+kth.minHeap.peek());
         
	}


}
