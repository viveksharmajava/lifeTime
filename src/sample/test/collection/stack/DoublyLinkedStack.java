package sample.test.collection.stack;


public class DoublyLinkedStack <T> {
	
    private  Node <T> top;
    private  int midFactor = 0;
    private Node <T> mid;
    private class Node<T>{
    	T data ;
    	Node <T> prev;
    	Node <T>next;
    }
     public void push(T data) {
    	 Node s = new Node();
		 s.data = data;
    	 if( top !=null)
    	 {
    		 top.next = s;
    		 s.prev = top;
    		 top = s;
    	 }else
    	 {
    		 mid = top = s;
    	 }
    	 
    	 midFactor++;
    	 if(midFactor%2 == 0){
    		 mid = mid.next;
    		 midFactor = 0;
    	 }
    	 
     }
     
     public T pop(){
    	
    	 if( top != null ){
    		 T  d = top.data;
        	 top = top.prev;
        	 midFactor--;
        	 if(midFactor%2 == 0){
        		 mid = mid.prev;
        		 midFactor = 0;
        	 } 
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
     
     
     public T getMiddle(){
    	 if( mid !=null)
    	     return mid.data;
    	 
    	 return null;
     }
     
     
     
     public T deleteMiddle(){ //Mid cann't be last node if list has more than one node..
     	T d;
    	 if( mid != null ){
    		if( mid.next == null ){//Mid is the first element
    			d = mid.data;
    			mid = top = null;
    			
    		}
    		// check if below conditon is really  required
    		else if( mid.next != null && mid.prev == null ){ //mid is first node in list
    			d = mid.data;
    			mid = mid.next;
    			mid.prev= null;
    			
    		}
    		else{//mid is somewhere  in middle  in the list
    		  d = mid.data;
    		  mid.prev.next = mid.next;
    		  mid.next.prev = mid.prev;
    		}
        	 return d;
    	 }
    	 else{
    		 return null;
    	 }
     }
     
}