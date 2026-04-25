package designguru.reverseLinkedList;

import java.util.Stack;

import javax.print.event.PrintJobAttributeListener;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node head = new Node(1);
	     Node n2 = new Node(2);
	     Node n3 = new Node(3);
	     Node n4 = new Node(4);
	     Node n5 = new Node(5);
	     
	     head.next= n2;
	     n2.next = n3;
	     n3.next= n4;
	     n4.next = n5;
	     Node.print(head);
	     System.out.println("\n\nAfter reversing !\n");
	     Node rev = reverse(head);
	     
	     Node.print(rev);
	   
	     Node n6 = new Node(6);
	     Node n7 = new Node(7);
	     Node n8 = new Node(8);
	     head = new Node(1);
	      n2 = new Node(2);
	      n3 = new Node(3);
	      n4 = new Node(4);
	      n5 = new Node(5);
	     
	     head.next= n2;
	     n2.next = n3;
	     n3.next= n4;
	     n4.next = n5;
         n5.next = n6;
	     n6.next = n7;
	     n7.next = n8;
	     System.out.println("\n\n before Kreverse\n");
	     Node.print(head);
	     System.out.println("\n\nAfter k reversing !\n");
	     Node kReversed = kAltReverse(head,3);
	     Node.print(kReversed);
	     
	     // 5 -> 3 -> 7 -> 4 -> 2 -> 1
	    // Output: 7 -> 4 -> 2 -> 1
	     head.data = 5;
	     n2.data = 3;
	     n3.data = 7;
	     n4.data =4;
	     n5.data =2;
	     n6.data = 1;
	     head.next= n2;
	     n2.next = n3;
	     n3.next= n4;
	     n4.next = n5;
         n5.next = n6;
         n6.next = null;
	     
         Node result = removeNode(head);
         System.out.println("\nafter removing greate nodes\n");
         Node.print(result);
	}

	 private static Node kAltReverse(Node head, int k) {
		 
		 if(head == null || head.next == null)return head;
		 Node prev = null;
		 Node n = head;
		 Node temp ;
		 int i = 0;
		 while(n != null && i < k){
			 temp = n;
			 n= n.next;
			 temp.next = prev;
			 prev = temp;
			 i++;
		 }
		 if(n != null) head.next = kAltReverse(n,k);
		 return prev;
		
	}

	public static Node reverse(Node head){
		 if(head == null || head.next == null)return head;
		 Node prev = null;
		 Node n = head;
		 Node temp ;
		 while(n != null){
			 temp = n;
			 n= n.next;
			 temp.next = prev;
			 prev = temp;
		 }
		 return prev;
	 }
	
	
	/*
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/remove-nodes-from-linked-list-easy
	 * Given the head node of a singly linked list, modify 
	 * the list such that any node that has a node with a greater value to its right gets removed.
	 *  The function should return the head of the modified list.
	 * Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
        Output: 7 -> 4 -> 2 -> 1
	 */
	public static Node removeNode(Node head) {
		Stack<Node> s = new Stack<>();
		while(head != null) {
			s.push(head);
			head = head.next;
		}
		int max = Integer.MIN_VALUE;
		Node res = null ,temp;
		while(!s.isEmpty()) {
			Node p = s.pop();{
				if(res == null) {
					res = p;
					max = p.data;
					res.next = null;//not required.
				}
				else if( max > p.data ){
					//do nothing...
				}else {
					//update max
					max = p.data;
					temp = p;
					temp.next = res;
					res = temp;
					
				}
				
			}
		}
		
		return res;
	}
}
