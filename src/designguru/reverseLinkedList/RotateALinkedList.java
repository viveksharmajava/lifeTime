package designguru.reverseLinkedList;

public class RotateALinkedList {

	public static void main(String[] args) {
		 Node head = new Node(1);
	     Node n2 = new Node(2);
	     Node n3 = new Node(3);
	     Node n4 = new Node(4);
	     Node n5 = new Node(5);
	     Node n6 = new Node(6);
	    // Node n7 = new Node(7);
	    // Node n8 = new Node(8);
	     
	     head.next= n2;
	     n2.next = n3;
         n3.next= n4;
         n4.next = n5;
         n5.next = n6;
	   //  n6.next = n7;
	   //  n7.next = n8;
	     head = rotate(head,4);
	     Node.print(head);
	}
     
	public static Node rotate(Node head , int k) {
		if(k == 0)return head;
		Node current = head;
		int count = 1;
		while(count <  k && current != null) {
			current =current.next;
			count++;
		}
		if(current == null) return null ;
		 Node kthNode = current;
			while(current.next != null)
			    current = current.next;
			
			current.next = head;
			head = kthNode.next;
			 kthNode.next = null;
		 return head;
	}
}
