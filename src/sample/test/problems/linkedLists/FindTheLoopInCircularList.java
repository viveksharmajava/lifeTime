package sample.test.problems.linkedLists;

public class FindTheLoopInCircularList {

	/**
	 *Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node�s next pointer points to an earlier node, so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
	 */
	
	public <T> Node <T> findLoop(Node <T> linkedStart){
		
		Node <T> n1 = linkedStart;
		Node <T> n2 = linkedStart;
		
		 // Find meeting point
		 while (n2.next != null) {
		 n1 = n1.next;
		n2 = n2.next.next;
		 if (n1 == n2) {
		 break;
		 }
		 }
		
		 // Error check - there is no meeting point, and therefore no loop
		 if (n2.next == null) {
		 return null;
		 }
		 /* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps
		 /* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		 n1 = linkedStart;
		 while (n1 != n2) {
		 n1 = n1.next;
		 n2 = n2.next;
		 }
		 // Now n2 points to the start of the loop.
		 return n2;
	}

}
