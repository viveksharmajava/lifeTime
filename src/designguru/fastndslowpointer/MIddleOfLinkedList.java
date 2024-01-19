package designguru.fastndslowpointer;

public class MIddleOfLinkedList {

	public static void main(String[] args) {
		 Node head  = new Node();
	     head.data = 1;
	     Node n2 = new Node();
	     n2.data = 2;
	     Node n3 = new Node();
	     n3.data = 3;
	     Node n4 = new Node();
	     n4.data = 4;
	     Node n5 = new Node();
	     n5.data = 5;
	     Node n6 = new Node();
	     n6.data = 6;
	     head.next = n2; 
	     n2.next = n3;
	     n3.next = n4;
	     n4.next = n5;
	     n5.next = n6;
	     System.out.println(middleOfList(head));
	}
    public static Node middleOfList(Node head) {
    	if(head == null || head.next == null ) return head;
    	Node slow = head;
		Node fast  = head;
		while(fast != null && fast.next != null) {
			System.out.println("slow ="+slow +" fast "+fast);
			slow = slow.next;
			fast = fast.next.next;
			
		}
		System.out.println("Middle element is "+slow.data);
		return slow;
    }
}
