package designguru.twoHeaps;

import java.util.PriorityQueue;

/*
 * Problem : Find median from a data-stream
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639b685c5cda0fa79d72b471
 * solution : https://stephenjoel2k.medium.com/two-heaps-min-heap-max-heap-c3d32cbb671d
 * Descripton : go to above solution:
 * 
 */
public class MedianFinder {
 
	PriorityQueue <Integer> maxHeap = new PriorityQueue<Integer>((a,b)-> b-a);
	PriorityQueue <Integer> minHeap = new PriorityQueue<Integer>((a,b)-> a-b);
	
	public static void main(String[] args) {
      int [] arr = {1, 2 , 3, 4, 5};
      MedianFinder mf = new MedianFinder();
    
//      mf.insert(1);
//      
//      mf.insert(2);
//      mf.insert(3);
//      mf.insert(4);
//      mf.insert(5);
//      System.out.println("max heap ="+mf.maxHeap);
//      System.out.println("min heap ="+mf.minHeap);
//      System.out.println("median = "+mf.findMedian());
//      mf.remove(new Integer(4));
//      System.out.println("max heap ="+mf.maxHeap);
//      System.out.println("min heap ="+mf.minHeap);
//      System.out.println("median = "+mf.findMedian());
      int [] profits = {1,2,3} ;
      int []capital = {0,1,2};
      System.out.println("\n findMaximizedCapital \n ");
      System.out.println(findMaximizedCapital(3, 0, profits, capital)) ; 
	}
	
	public void insert(int x) {
		
		if(maxHeap.isEmpty() || x <= maxHeap.peek()) maxHeap.add(x);
		else minHeap.add(x);
		balanceMinMax_Heap();
		
	}
	
	public void remove( Integer x) {
		if(x <= maxHeap.peek()) maxHeap.remove(x);
		else minHeap.remove(x);
		balanceMinMax_Heap();
	}
    public double findMedian() {
    	if(maxHeap.size() == minHeap.size()) {//even number of nodes.
    		double d=  ((double)(maxHeap.peek() + minHeap.peek()))/2;
    		return d;
    	}
    	return maxHeap.peek();
    }
	private void balanceMinMax_Heap() {
		if(maxHeap.size() > minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
			
		}
		else if(maxHeap.size() < minHeap.size() ) {
			maxHeap.add(minHeap.poll());
		}
	}
	
  public  double[] slidingWindowMedian(int [] arr, int k) {
	  
	  double [] result = new double [arr.length-k +1];
	  
	  for(int i=0 ; i < arr.length ; i++) {
		  insert(arr[i]);
		  if(i-k+1 >=0) {//heap has atleast k elements
			  result[i-k+1] = findMedian();
			  Integer removeElement = arr[i-k+1];
			  remove(removeElement);
		  }
	  }
	  return result;
  }
  /*
   * https://leetcode.com/problems/ipo/
   * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

	You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
	
	Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
	
	Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
	
	The answer is guaranteed to fit in a 32-bit signed integer.
	
	 
	
	Example 1:
	
	Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
	Output: 4
	Explanation: Since your initial capital is 0, you can only start the project indexed 0.
	After finishing it you will obtain profit 1 and your capital becomes 1.
	With capital 1, you can either start the project indexed 1 or the project indexed 2.
	Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
	Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
	Example 2:
	
	Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
	Output: 6
	 
   */
  public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) { 
	  PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
  PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
  
  for (int i = 0; i < Profits.length; i++) {
      pqCap.add(new int[] {Capital[i], Profits[i]});
  }
  
  for (int i = 0; i < k; i++) {
      while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
          pqPro.add(pqCap.poll());
      }
      
      if (pqPro.isEmpty()) break;
      
      W += pqPro.poll()[1];}
  return W;
}
}

