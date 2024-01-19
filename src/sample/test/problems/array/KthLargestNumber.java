package sample.test.problems.array;
import java.util.PriorityQueue;



public class KthLargestNumber{
	
	public static void main(String [] args) {
		int[] arr = {3,6,2,8,9,4,5};
		System.out.println(kThLargest(arr, 3));
		System.out.println(kThLargest(arr, 1));
		System.out.println(kThLargest(arr, 2));
		
		
		
		
		
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


