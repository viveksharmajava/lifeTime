package sample.test.collection.queue;

public class Queue<T> {
	Node <T> front;
	Node <T> rear;
	
	private static class Node<T>{
		T data;
		 Node<T> next;
	}

	public void enqueue(T data){
		
		Node <T> node = new Node<T>();
		node.data = data;
		if(front == null){
			front = rear = node;
		}
		else {
			rear.next = node;
			rear = node;
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
}
