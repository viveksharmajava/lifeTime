package designguru.reverseLinkedList;

public class Node {

	 Node next;
	 int data;
	 
	 public Node(int d) {
		 this.data = d;
	 }
	 
	@Override
	public String toString() {
		return "data ="+data;
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
			if(head != null) System.out.print("->");
			else System.out.print("->null");
		}
	}
}
