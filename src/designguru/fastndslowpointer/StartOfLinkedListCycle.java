package designguru.fastndslowpointer;

public class StartOfLinkedListCycle {

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
	     head.next = n2; 
	     n2.next = n3;
	     n3.next = n4;
	     n4.next = n5;
	     n5.next = n2;
         System.out.println(startNodeOfCycle(head));
	}
    /*
     *  Floyd’s loop detection algorithm
     */
	public static Node startNodeOfCycle(Node head) {
		if(head == null || head.next == null ) return null;
		
		Node slow = head;
		Node fast  = head;
		slow = slow.next;
		fast = fast.next.next;
		while (fast != null && fast.next != null	) {
			
			if(fast == slow) {
				break;
			}
			slow = slow.next; 
			fast = fast.next.next;
		}
		
		if(fast != slow ) return null;//no loop
		// If loop exists. Start slow from
		  // head and fast from meeting point.
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
		
	}
}
