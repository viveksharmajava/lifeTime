package designguru.reverseLinkedList;

public class ReverseSubList {

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
	     Node.print(head);
	     Node reversePToQ = reverseSubList(head,2,4);
	     System.out.println();
	     Node.print(reversePToQ);
	}
	
	public static Node reverseSubList(Node head, int p, int q) {
		
		if (head == null || head.next == null)return head;
		
		Node cur = head;
		Node prev = null;
		Node temp;
		int count = 1;
		Node before_p = cur;
		while(count < p) {
			before_p = cur;
			cur = cur.next;
			count++;
		}
		
		Node currOld = cur;
		while(p <= q && cur != null) {
			temp = cur;
			cur = cur.next;
			temp.next = prev;
			prev = temp;
			p++;
		}
		currOld.next = cur;
		if(count != 1) {
			before_p.next = prev;
		}else {
			head = prev;
		}
		
		return head;
	}

}
