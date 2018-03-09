package sample.test.problems.linkedLists;

public class LinkedList<T> {/*
    private transient Node <T> head = null;
    private transient Node <T> node = null;
    public LinkedList(){
    	 node =head;
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
	
	
	private static class Node<T> {
		
		T data ;
		Node <T> next;
		Node(T data ) {
			this.data = data;
			this.next = null;
		}
	 }
	public void printAll(){
		Node<T> start = head;
		while(start.next != null){
			System.out.println(start.data);
			start = start.next;
		}
	}
*/}