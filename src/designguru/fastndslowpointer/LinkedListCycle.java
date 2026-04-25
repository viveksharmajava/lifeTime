package designguru.fastndslowpointer;

import java.util.HashSet;
import java.util.Set;

/*https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639105492e1c0a1cfe6c1eb9
 * Given the head of a Singly LinkedList, 
 * write a function to determine if the LinkedList
 *  has a cycle in it or not.
 */
public class LinkedListCycle {

	public static void main(String[] args) {
     CustomNode head  = new CustomNode();
     head.data = 1;
     CustomNode n2 = new CustomNode();
     n2.data = 2;
     CustomNode n3 = new CustomNode();
     n3.data = 3;
     CustomNode n4 = new CustomNode();
     n4.data = 4;
     CustomNode n5 = new CustomNode();
     n5.data = 5;
    head.next = n2; 
    n2.next = head;
    //n3.next = n4;
    //n4.next = n5;
   // n5.next = head;
     System.out.println(isCyclicList(head));
     System.out.println(isCycleUsingHash(head));
	}
	
	public static boolean isCyclicList(CustomNode head) {
		boolean isCyclic = false;
		if(head == null || head.next == null ) return false;
		CustomNode slow = head;
		CustomNode fast  = head;
		while ( fast != null && fast.next != null	) {
			
			slow = slow.next; 
			fast = fast.next.next;
			if(fast == slow) {
				return true;
			}
			
		}
		
		return isCyclic;
		
	}
	
	public static boolean isCycleUsingHash(CustomNode head){
		Set <CustomNode> set = new HashSet<>();
		
		while(head != null){
			if(set.contains(head))return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}
	
	public static boolean detectCycle(CustomNode head){
		Set <CustomNode> set = new HashSet<>();
		
		while(head != null){
			if(head.visited)return true;
			head.visited = true;
			head = head.next;
		}
		return false;
	}
	
}


class CustomNode {

	CustomNode next;
	Integer data;
	boolean visited;
	
	@Override
	public String toString() {
		return "["+this.data+"]";
	}
	
}
