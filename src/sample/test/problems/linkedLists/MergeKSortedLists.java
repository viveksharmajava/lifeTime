package sample.test.problems.linkedLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Approach 1: merge all the list and sort using merge sort
 *  		   O(n(logn)) no advantage of already sorted list.
 * Approach 2: Using Min Heap O(n(logK))
 */

public class MergeKSortedLists {
	private static class Node{
		int data;
		Node next;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
    public static void printList(Node node) {
    	while(node != null) {
    		System.out.print(node.data+"-->");
    		node = node.next;
    	}
    	System.out.print("NULL");
    }
	public static void main(String[] args) {
		
			int k = 3; // Number of linked lists
		 
        // An array to store the head nodes of the linked lists
        Node[] list = new Node[k];
 
        list[0] = new Node(1);
        list[0].next = new Node(5);
        list[0].next.next = new Node(7);
 
        list[1] = new Node(2);
        list[1].next = new Node(3);
        list[1].next.next = new Node(6);
        list[1].next.next.next = new Node(9);
 
        list[2] = new Node(4);
        list[2].next = new Node(8);
        list[2].next.next = new Node(10);
 
        // Merge all lists into one
       // Node head = mergeKLists(list, k);
        printList(list[0]);
        System.out.println();
        printList(list[1]);
        System.out.println();
        printList(list[2]);
        System.out.println("After sorting K list");
     // Merge all lists into one
        Node head = mergeKLists(list, k);
        printList(head);

	}
	public static Node mergeKLists(Node[] list, int k) {
		PriorityQueue <Node> pq = new PriorityQueue(Comparator.comparingInt(a -> ((Node) a).data));
		pq.addAll(Arrays.asList(list).subList(0, k));
		// take two pointers, head and tail, where the head points to the first node
        // of the output list and tail points to its last node
        Node head = null, last = null;
        while(!pq.isEmpty()) {
        	Node min = pq.poll();
        	//	 add the minimum node to the output list
            if (head == null) {
                head = last = min;
            } else {
                last.next = min;
                last = min;
            }
        	// take the next node from the "same" list and insert it into the min-heap
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return head;
	}

}
