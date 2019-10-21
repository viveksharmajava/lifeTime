package sample.test.problems.linkedLists;

public class SortListUsingMergeSort {

	public static void main(String[] args) {
		LinkedList <Integer> list = new LinkedList<Integer>();
		list.add(50);
		list.add(30);
		list.add(80);
		list.add(10);
		
		Node <Integer> head = mergeSort(list.getHead());
		LinkedList <Integer> sorted = new LinkedList<Integer>();
		sorted.addHead(head);
		sorted.printAll();
		
	}
	
	
	public static Node<Integer> mergeSort(Node <Integer>head) {
		if(head == null || head.next == null) {
			return head;
		}
		
	   Node <Integer> middle = middleNode(head);
	   Node <Integer> middleNext = middle.next;
	   middle.next = null;
	   
	   Node <Integer> left = mergeSort(head);
	   Node <Integer> right = mergeSort(middleNext);
	   Node<Integer> nodeLiast = mergeSorted(left,right);
	  return nodeLiast;
		
	}
	
	private static Node<Integer> mergeSorted(Node <Integer>a ,Node <Integer>b) {
		
	  Node <Integer> result;
	  
	  //Base case;
	   if(a == null) {
        return b;
	   }
	   if (b == null)
		return a;
	   
	   // choose either a or b
	   if(a.data <= b.data) {
		   result = a;
		   result.next = mergeSorted(a.next ,b);
	   }else {
		   result = b;
		   result.next = mergeSorted(a ,b.next);
	   }
	   
	   return result;
	}
	private static Node<Integer> middleNode(Node <Integer>head){
		
		if(head == null) return  head;
		
		Node <Integer> slow = head;
		Node <Integer> fast = head;
		
		while(fast.next != null && fast.next.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

}
