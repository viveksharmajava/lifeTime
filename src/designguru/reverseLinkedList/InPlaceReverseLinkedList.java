package designguru.reverseLinkedList;

public class InPlaceReverseLinkedList {

	public static void main(String[] args) {
     Node head = new Node(1);
     Node n2 = new Node(2);
     Node n3 = new Node(3);
     Node n4 = new Node(4);
     Node n5 = new Node(5);
     
     head.next= n2;
     n2.next = n3;
     n3.next= n4;
     n4.next = n5;
     
     Node rev = reverse(head);
     
     Node.print(rev);
     
	}
	
	
	public static Node reverse(Node head) {
		if(head == null || head.next == null) return head;
		Node cur = head;
		Node prev = null;
		Node temp;
		while(cur != null) {
			temp = cur.next;
			cur.next= prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}

}
