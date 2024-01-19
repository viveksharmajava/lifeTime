package designguru.fastndslowpointer;

/*https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639105492e1c0a1cfe6c1eb9
 * Given the head of a Singly LinkedList, 
 * write a function to determine if the LinkedList
 *  has a cycle in it or not.
 */
public class LinkedListCycle {

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
    // n5.next = head;
     System.out.println(isCyclicList(head));
	}
	
	public static boolean isCyclicList(Node head) {
		boolean isCyclic = false;
		if(head == null || head.next == null ) return false;
		Node slow = head;
		Node fast  = head;
		while (fast != null && fast.next != null	) {
			
			if(fast == slow) {
				return true;
			}
			slow = slow.next; 
			fast = fast.next.next;
		}
		
		return isCyclic;
		
	}

}


