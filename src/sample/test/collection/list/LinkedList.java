package sample.test.collection.list;
public class LinkedList<T> {
	
	LinkedList <T> head ;
	T data;
	LinkedList <T> next ;
	LinkedList <T> prev ;
	LinkedList <T> trail ;
	public LinkedList(){
	  // head = this;
	  // this.data = null;
	  // this.next = this.prev = null;
	}
	public void add(T d){
		if(head == null) {
			trail = head = this;
			this.data = d;
			this.next = null;
			this.prev= null;
			
		}else {
			LinkedList <T> temp  = new LinkedList<T>();
			temp.data = d;
			temp.next = null;
			temp.prev= trail;
			trail.next= temp;
			trail = temp;
		}
	}
	
	public void printAll(){
		LinkedList<T> start = head;
		while(start != null){
			System.out.println(start.data);
			start = start.next;
		}
	}
}	

//public class LinkedList<T> {
//	
//	Node <T> head ;
//	Node <T> trail ;
//	LinkedList(){
//	}
//	
//	private  class Node<T>{
//		T data;
//		 Node<T> next;
//	}
//	
//	public void add(T d){
//		
//		Node <T> obj = new Node<T>();
//		obj.data = d;
//		obj.next = null;
//		if( head == null) head = trail =obj;
//		else{
//		  trail.next = obj;
//		  trail = trail.next;
//		}
//	}
//	
//	public void printAll(){
//		Node<T> start = head;
//		while(start != null){
//			System.out.println(start.data);
//			start = start.next;
//		}
//	}
//	
//	public void deleteEven(){
//		Node<T> start = head;
//		Node<T> trail = null;
//		Node <T> root =null;
//		while(start != null){
//			if((Integer)start.data % 2 != 0)
//			{
//				if(root == null){
//					root  = trail = start;
//				}
//				else{
//					trail.next = start;
//					trail = trail.next;
//				}
//				
//			}
//				start = start.next;
//		}
//	  if(trail != null){
//		  trail.next = null;
//	  }
//		head = root;
//	}
//}