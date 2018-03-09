package sample.test.collection.stack;

public class MinStack {
    private  Node <Integer> top;
     
    private class Node<Integer>{
    	Integer data ;
    	Node  <Integer>min;
    	Node <Integer>next;
    }
     public void push(Integer data) {
    	 Node s = new Node();
		 s.data = data;
    	 s.next = top;
    	//set the min 
    	 if( top != null &&  top.min != null ){
    		int a = top.min.data;
    		int b =  data;
    		if (a <= b){
    			s.min = top.min;
    		}
    		else {
    			s.min = s;
    		}
    	 }
    	 if(top == null) s.min = s;
    	 top = s;
    	 
    	 
     }
     
  
     public Integer getMin(){
    	 
    	 return (Integer) (top != null ?top.min.data : null);
     }
     public Integer pop(){
    	
    	 if( top != null ){
    		 Integer  d = top.data;
        	 top = top.next;
        	 return d;
    	 }
    	 else{
    		 return null;
    	 }
     }
     
     public Integer peek(){
    	 if( top !=null)
    	     return top.data;
    	 
    	 return null;
     }
     
     public boolean isEmpty(){
    	 
    	 return top == null;
     }


}
