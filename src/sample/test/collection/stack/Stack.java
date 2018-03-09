package sample.test.collection.stack;

public class Stack<T> {
	
    private  Node <T> top;
     
    private class Node<T>{
    	T data ;
    	Node <T>next;
    }
     public void push(T data) {
    	 Node s = new Node();
		 s.data = data;
    	 s.next = top;
    	 top = s;
     }
     
     public T pop(){
    	
    	 if( top != null ){
    		 T  d = top.data;
        	 top = top.next;
        	 return d;
    	 }
    	 else{
    		 return null;
    	 }
     }
     
     public T peek(){
    	 if( top !=null)
    	     return top.data;
    	 
    	 return null;
     }
     
     public boolean isEmpty(){
    	 
    	 return top == null;
     }

}
