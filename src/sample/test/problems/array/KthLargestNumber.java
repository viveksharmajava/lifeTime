package sample.test.problems.array;
import java.util.PriorityQueue;

import sample.test.ds.heap.MaxHeap;

public class KthLargestNumber{
	
	public static void main(String [] args) {
		int[] arr = {3,6,2,8,9,4,5};
		System.out.println(kThLargest(arr, 3));
		System.out.println(kThLargest(arr, 1));
		System.out.println(kThLargest(arr, 2));
		
		MaxHeap mh = new MaxHeap(7);
		mh.insert(3);
		mh.insert(6);
		mh.insert(2);
		mh.insert(8);
		mh.insert(9);
		mh.insert(4);
		mh.insert(5);
		
		mh.printSortedMaxHeap();
		
		
		
	}
	
	public static int kThLargest(int[] input, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i= 0 ; i< k; i++) {
			pq.add(input[i]);
		}
		for(int i=k; i< input.length ; i++) {
			if(pq.peek() < input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		
		return pq.peek();
	}
}


