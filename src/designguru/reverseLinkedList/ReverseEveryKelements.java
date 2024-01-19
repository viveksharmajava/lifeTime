package designguru.reverseLinkedList;

public class ReverseEveryKelements {

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
	    Node kReversed = reverse(head,3);
	    Node.print(kReversed);
	}
	
	//solution: https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size/
	public static Node reverse(Node head, int k) {
		if (head == null) return null;
		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;
		
		/* reverse the first k nodes of list*/
		while(count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		/* next is now a pointer to (k+1)th node
        Recursively call for the list starting from
        current. And make rest of the list as next of
        first node */
		if(next != null) head.next = reverse(next , k);
		
		//prev is now head of reversed list
		return prev;
	}
	
	
	
	//below one is not working..
	public static Node reverseK(Node head, int k) {
		if(head == null || head.next == null) return head;
		
		Node cur = head;
		Node prev = null;
		Node temp;
		int n = 0;
		int f = 0 ;
		Node currOld = cur;
		Node next ;
		while(cur != null ) {
			next = cur;
			temp = cur.next;
			cur.next= prev;
			
			prev = cur;
			cur = temp;
			n++;
			if(n%k == 0) {
				
				if( f == 0) {
					 head = prev;
					 prev = null;
					 f++;
				}
				else {
					currOld.next = prev;
					next.next = null;
				    currOld = next;
					prev = null;
				}
			}
		}
		if(n%k != 0) {
		if( f == 0) {
			 head = prev;
		}
		else {
			currOld.next = prev;
		}
		}
		return head;
	}

}
