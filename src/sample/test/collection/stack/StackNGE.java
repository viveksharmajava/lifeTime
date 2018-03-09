package sample.test.collection.stack;


public class StackNGE<T> {

	
    private  Node <T> top;
     
    private class Node<T>{
    	T data ;
    	T nge;
    	Node <T>next;
    }
     public void push(T data,T nge) {
    	 Node s = new Node();
		 s.data = data;
		 s.nge = nge;
    	 s.next = top;
    	 top = s;
     }
     
     public T pop(){
    	
    	 if( top != null ){
    		 T  d = top.nge;
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



}
