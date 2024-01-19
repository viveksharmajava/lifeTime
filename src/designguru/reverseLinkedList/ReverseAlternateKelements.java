package designguru.reverseLinkedList;
/*
 *  Reverse alternate K nodes in a Singly Linked List
 *  Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 *	Output:   3->2->1->4->5->6->9->8->7->NULL. 
 *
 */
public class ReverseAlternateKelements {

	public static void main(String[] args) {

	       // 1 2 3 4 5 6 7 8 ->null
		   // 3 2 1 4 5 6 7 8 ->null
		   // 3 2 1 6 5 4 7 8 ->null
		   // 3 2 1 6 5 4 8 7 ->null
			
			 Node head = new Node(1);
		     Node n2 = new Node(2);
		     Node n3 = new Node(3);
		     Node n4 = new Node(4);
		     Node n5 = new Node(5);
		     Node n6 = new Node(6);
		     Node n7 = new Node(7);
		     Node n8 = new Node(8);
		     
		     head.next= n2;
		     n2.next = n3;
	         n3.next= n4;
	         n4.next = n5;
	         n5.next = n6;
		     n6.next = n7;
		     n7.next = n8;
		    // Node.print(head);
		    Node kReversed = kAltReverse(head,3);
		    Node.print(kReversed);
		
	}
	
	/*
	 *  Solution: https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
	 *  Method 1 (Process 2k nodes and recursively call for rest of the list) 
	 *  Its extension of reverse every K node.
	 *  Steps: 
	 *  1. revere every first k nodes.
	 *  2. in Modified list head points to kth node so changed it to next of head to (k+1) node.
	 *  3. move the current position to skip next k nodes.
	 *  4. call the kAltReverse to recursively for n-2k nodes.
	 *  5. return prev ,the new head of the list.
	 */
		public static Node kAltReverse(Node head, int k ) {
			if (head == null) return null;
			Node current = head;
			Node next = null;
			Node prev = null;
			int count = 0;
			
			/* 1) reverse the first k nodes of list*/
			while(count < k && current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count++;
			}
			/* 2) Now head points to the kth node.  So change next
	         of head to (k+1)th node*/
	        if (head != null) {
	            head.next = current;
	        }
	       /* 3) We do not want to reverse next k nodes. So move the current
	         pointer to skip next k nodes */
	        count = 0;
			while(count <k -1 && current !=null) {
				count++;
				current = current.next;
			}
			/* 4) next is now a pointer to (k+1)th node
	        Recursively call for the list starting from
	        current. And make rest of the list as next of
	        first node */
			if(current != null) current.next = kAltReverse(current.next , k);
			
			/* 5) prev is now  new head of reversed list */
			return prev;
		}
		

}
