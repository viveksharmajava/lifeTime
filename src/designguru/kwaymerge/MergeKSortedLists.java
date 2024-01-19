package designguru.kwaymerge;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// Number of linked lists
        int k = 3;
 
        // Number of elements in each list
        int n = 4;
 
        // an array of pointers storing the
        // head nodes of the linked lists
 
        Node[] arr = new Node[k];
 
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
 
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
 
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        printList(mergeKLists(arr));
	}
	
	public static Node mergeKLists(Node [] lists) {
		
		for(int i=1 ; i < lists.length;i++) {
		   while(true)	{
				Node head_0 = lists[0];
				Node head_i = lists[i];
				
				// list is ended here
				if(head_i ==  null)
				  break;
				
				if(head_0.data >= head_i.data) {
				lists[i] = head_i.next;
				head_i.next = head_0;
				lists[0] = head_i;
				}
				else {
					//travese the first list 
				  while(head_0.next !=null) {
					if(head_0.next.data >= head_i.data) {
						lists[i] = head_i.next;
						head_i.next = head_0.next;
					    head_0.next = head_i;
					    break;
					}
					head_0 = head_0.next;

                    // if last node
                    if (head_0.next == null) {
                    	lists[i] = head_i.next;
                        head_i.next = null;
                        head_0.next = head_i;
                        head_0.next.next = null;
                        break;
                    }
				 }
				}
		   }
			
		}
		return lists[0];
	}
	
	static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
 
            node = node.next;
        }
        System.out.println();
    }
 

}
//A Linked List node
class Node {
 int data;
 Node next;

 // Utility function to create a new node.
 Node(int key)
 {
     data = key;
     next = null;
 }
}

