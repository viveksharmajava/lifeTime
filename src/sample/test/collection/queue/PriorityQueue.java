package sample.test.collection.queue;;


public class PriorityQueue<T> {
	Node <T> front;
	Node <T> rear;
	
	private static class Node<T>{
		 T data;
		 Node<T> next;
		 int priority;
	}

	public void enqueue(T data , int priority){
		
		Node <T> node = new Node<T>();
		node.data = data;
		node.priority = priority;
		if(front == null){
			front = rear = node;
		}
		else {
			 Node <T> temp = front;
			 while(temp != null && temp.priority >= priority){
				 temp = temp.next;
			 }
			 if(temp != null && temp == front){//New node need to be @ first position
				 node.next = temp;
				 front = node;
			 }
			 
			 else if(temp != null && temp.next != null){//New node need to be inserted in middle
				 node.next = temp.next;
				 temp.next = node;
			 }
			 else{//new Node will be inserted at last since it priority is less
				 rear.next = node;
			    rear = node;
			    
			 }
			 
		}
	}
	
	
	public T dequeue(){
		T data = null;
		if (front != null) {
			data = front.data;
			front = front.next;
		}
		return data;
	}
	
	public T getHighestPriority(){
		T data  = null;
		if( front !=null) data = front.data;
		return data;
		
	}
	
	public T deleteHighestPriority(){
		T data  = null;
		if( front !=null){
			data = front.data;
			front = front.next;
		}
		return data;
		
	}
}
