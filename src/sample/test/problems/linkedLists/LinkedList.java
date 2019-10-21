package sample.test.problems.linkedLists;

public class LinkedList<T> {
    private transient Node <T> head = null;
    private transient Node <T> node = null;
    public LinkedList(){
    	 node =head;
    }
    
    public boolean addHead(Node <T> h) {
    	this.head = h;
    	return true;
    }
    public boolean addNode(Node <T> element){
		if(head == null){
			head = node = element;
		}
		else{
		    node.next = element;
		    node = element;
		}
		   return true;
	   }
	public boolean add(T element){
		if(head == null){
			head = node = new Node<T>(element);
		}
		else{
			Node <T>  newNode =   new Node<T>(element);
		    node.next = newNode;
		    node = newNode;
		}
		   return true;
	   }
	public boolean remove(T element){
		if(head == null){
			return false;
		}
		else{
			//Node <T>  newNode =   new Node<T>(element);
			 Node <T> node  = this.head;
			 Node <T> prev = null;
		    while(node !=  null) {
		    	if(node.data == element)
		    	{
		    		if(node == head) head = head.next;
			    	else if(node.next == null) prev.next = null;
			    	else {
			    		prev.next = node.next;
			    	}
		    	 break;	
		    	}
		    	else {
		    		prev= node;
		    		node = node.next;
		    	}
		    	
		    }
		}
		   return true;
	   }
	public T getFirst() {
		return head.data;
	}
	public boolean removeGivenNode(Node<T> element){
		if(head == null){
			return false;
		}
		else{
			if(element == head) {
				head = head.next;
			}
			else {
				//element =  head.next;//here i'm just hard coding the value to test my program.
				if(element.next == null) { //last node
					//node = prev; // we have to maintain temp prev while adding or use DoublyLinkedList
				}
				element.data = element.next.data;
				element.next = element.next.next;
				element = element.next;
				
			}
			
			
			
		}
		   return true;
	   }
	
//	private static class Node<T> {
//		
//		T data ;
//		Node <T> next;
//		Node(T data ) {
//			this.data = data;
//			this.next = null;
//		}
//	 }
	
	//This method just only for programming purpose. we should never return reference.
	public Node <T> getHead(){
		return this.head;
	}
	//Node will always points to lastNode
	public void setLastNode(Node <T>  last) {
		node = last;
	}
	public void printAll(){
		Node<T> start = head;
		while(start != null){
			System.out.println(start.data);
			start = start.next;
		}
	}
}