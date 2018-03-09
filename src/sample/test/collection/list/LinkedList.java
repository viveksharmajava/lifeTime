package sample.test.collection.list;


public class LinkedList<T> {
	
	Node <T> head ;
	Node <T> trail ;
	LinkedList(){
	}
	
	private  class Node<T>{
		T data;
		 Node<T> next;
	}
	
	public void add(T d){
		
		Node <T> obj = new Node<T>();
		obj.data = d;
		obj.next = null;
		if( head == null) head = trail =obj;
		else{
		  trail.next = obj;
		  trail = trail.next;
		}
	}
	
	public void printAll(){
		Node<T> start = head;
		while(start != null){
			System.out.println(start.data);
			start = start.next;
		}
	}
	
	public void deleteEven(){
		Node<T> start = head;
		Node<T> trail = null;
		Node <T> root =null;
		while(start != null){
			if((Integer)start.data % 2 != 0)
			{
				if(root == null){
					root  = trail = start;
				}
				else{
					trail.next = start;
					trail = trail.next;
				}
				
			}
				start = start.next;
		}
	  if(trail != null){
		  trail.next = null;
	  }
		head = root;
	}
}