package ds500problems.heap;

import java.util.Arrays;
import java .util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapBasedProblems {

	public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6};
 
        // start with index 0 (the root of the heap)
        int index = 0;
 
        if (isMinHeap(A, index)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }
        
     // an array representing the max-heap
        int[] AA = { 9, 4, 7, 1, -2, 6, 5 };
 
        // build a min-heap by initializing it by the given array
        buildMinHeap(AA);
        HeapSort hs = new HeapSort();
       // hs.buildMinHeap(AA);
        //System.out.println(Arrays.toString(AA));
        // print the min-heap
        /*
                   -2
 
               1        5
 
            9    4    6    7
        */
        
        //find kth largest 
        System.out.println("1st Largest ="+kthLargest(AA, 1));
        System.out.println("2nd Largest ="+kthLargest(AA, 2));
        System.out.println("3rd Largest ="+kthLargest(AA, 3));
        
        //find kth Smallest 
        System.out.println("2nd Smallest ="+kthSmallest(AA, 2));
        System.out.println("3rd Smallest ="+kthSmallest(AA, 3));
        
        //sort k sorted array
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        System.out.println("before sorting list="+list);
        int k = 2;
        sortKSortedArray(list, k);
        
        //merge M sorted List of different size
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(10, 20, 30, 40),
                Arrays.asList(15, 25, 35),
                Arrays.asList(27, 29, 37, 48, 93),
                Arrays.asList(32, 33)
            );

        mergeMSortedList(lists);
	}

/*
 * Check if an array represents a min-heap or not
 * https://www.techiedelight.com/check-given-array-represents-min-heap-not/
 * Solution:
 *   array length :n
 *   i start from 0
 *   if 2*i+2 > n  , it means i represent leaf node. 
 *   if 2*i+2  <= n , it means i represent internal node in array.
 *   for example :[2, 3, 4, 5, 10, 15] array of size n=6 here [2,3,4] are internal node
 *   since i=0..2 and its 2*i+2 <= 6
 *   
 *   Recursive Solution:
 *   1. if the current node is leaf node return true.
 *   2. if the current node is internal node 
 *        2.1:recursive check if left child is min heap or not
 *        2.2: recursive check if right child is min heap or not if exist.
 *        2.3:if both child is min heap return true else return false.
 */
	public static boolean isMinHeap(int [] input ,int i )	{
		if(2*i+2 > input.length) return true;//evey leaf node is min heap
		
		boolean left = (input[i] <= input[2*i+1]) && isMinHeap(input , 2*i+1);
		boolean right = ((2*i+2 == input.length) || (input[i] <= input[2*i+2])) && isMinHeap(input , 2*i+2);
		return left && right;
	}
	
/* covert max into min heap in linear time
 * https://www.techiedelight.com/convert-max-heap-min-heap-linear-time/
 * 
 */
	
	public static void buildMinHeap(int [] input ) {
		int len = input.length;
		for(int i= len/2 ; i >=0 ; i--) {
			minHeapify(input, i, len);
		}
	  System.out.println(Arrays.toString(input));	
	}
	public static void minHeapify(int [] input , int i , int length) {
		
		int smallest = i;
		int left = 2*i+1, right = 2*i+2;
		if(left < length && input[left] < input[smallest]) smallest = left;
		if(right < length && input[right] < input[smallest]) smallest = right;
		
		if(smallest != i) {
			swap(input ,smallest ,i);
			minHeapify(input, smallest, length);
		}
		
		
	}
	// Utility function to swap two indices in the array
     static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
     
  //Find Kth largest element in the array
   /* https://www.techiedelight.com/find-kth-largest-element-array/
    * 
    *
    */
    public static int kthLargest(int [] input,int k) {
    	
    	PriorityQueue < Integer> queue = new PriorityQueue(k);
    	for(int i = 0 ; i < k ; i++) {
    		queue.add(input[i]);
    	}
    	for(int i = k; i < input.length ; i++){
    		if(input[i] > queue.peek()) {
    			queue.poll();
    			queue.add(input[i]);
    		}
    	}
    	return queue.poll();
    }
    
    
    /* 
     * Find Kth smallest element in the array
     * https://www.techiedelight.com/find-kth-smallest-element-array/
     */
     public static int kthSmallest(int [] input,int k) {
     	
     	PriorityQueue < Integer> queue = new PriorityQueue(k,Comparator.reverseOrder());
     	for(int i = 0 ; i < k ; i++) {
     		queue.add(input[i]);
     	}
     	for(int i = k; i < input.length ; i++){
     		if(input[i] < queue.peek()) {
     			queue.poll();
     			queue.add(input[i]);
     		}
     	}
     	return queue.peek();
     } 
     
     /*
      * sort a K sorted array 
      * https://www.techiedelight.com/sort-k-sorted-array/
      * Given a k–sorted array that is almost sorted such that each of the 
      * elements may be misplaced by no more than  positions from the correct sorted order. 
      * Find a space-and-time efficient algorithm to sort the array.
      * Input:
      * arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
      * k = 2
      * Output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

      */
     public static void sortKSortedArray(List <Integer>  list,int k) {
    	 if(k <=0 || k+1 > list.size()) return;
    	// create an empty min-heap and insert the first `k+1` elements into it
    	 PriorityQueue< Integer> pq = new PriorityQueue<Integer>(list.subList(0, k+1));
    	 
    	 int index = 0;
    	 for(int i = k+1 ; i < list.size()  ; i++) {
    		// pop the top element from the min-heap and assign them to the
             // next available array index
    		 list.set(index++, pq.poll());
    		 pq.add(list.get(i));
    	 }
    	 while (!pq.isEmpty()) {
             list.set(index++, pq.poll());
         }
    	System.out.println("Sorted list ="+list); 
     }
    /*
     *  Merge `M` sorted lists of variable length
     *  Input:  4 sorted lists of variable length
 
		[ 10, 20, 30, 40 ]
		[ 15, 25, 35 ]
		[ 27, 29, 37, 48, 93 ]
		[ 32, 33 ]
		 
		Output:
		 
		10 15 20 25 27 29 30 32 33 35 37 40 48 93
     */
     
     public static void mergeMSortedList(List<List<Integer>> lists) {
    	 PriorityQueue<Node> pq = new PriorityQueue<Node>();
    	 for(int i = 0 ; i < lists.size() ; i++) {
    		 if(lists.get(i).size() >= 1) {
    			 pq.add(new Node(lists.get(i).get(0),0,i));
    		 }
    	 }
    	 while(!pq.isEmpty()) {
    		 Node item = pq.poll();
    		 System.out.print(item.key+"\t");
    		 if(lists.get(item.listNumber).size() > (item.index+1)) {
    			 item.index = item.index+1;
    			 item.key= lists.get(item.listNumber).get(item.index);
    			 pq.add(item);
    		 }
    	 }
    	 
     }
     
}
class Node implements Comparable{
	
	Integer key;
	int index;
	int listNumber;
	public Node(Integer key, int index, int listNumber) {
		super();
		this.key = key;
		this.index = index;
		this.listNumber = listNumber;
	}
	@Override
	public int compareTo(Object o) {
		Node n = (Node) o;
		return this.key - n.key;
	}
	
}
