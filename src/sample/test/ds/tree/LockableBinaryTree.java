package sample.test.ds.tree;


public class LockableBinaryTree {

	public static void main(String[] args) {

	}
	
	
	static class Node { 
		  
	    int data; 
	    Node left, right,parent; 
	    boolean isLocked = false;
	    int locked_descendants_count = 0;
	   
	    Node(int d) { 
	        data = d; 
	        left = right = null; 
	    } 
	    
	    boolean canLockOrUnlock() {
	    	
	    	if (locked_descendants_count > 0 ) return false;
	    	
	    	Node curr = this.parent;
	    	while(curr != null) {
	    		if(curr.isLocked) return false;
	    		
	    		curr = curr.parent;
	    	}
	    	return true;
	    }
	    
	    boolean isLocked() {
	    	return this.isLocked;
	    }
	    
	    boolean lock() {
	    	if(this.canLockOrUnlock()) {
	    		this.isLocked = true;
	    		
	    		Node curr = this.parent;
	    		while(curr != null) {
	    			curr.locked_descendants_count = curr.locked_descendants_count + 1;
	    			curr = curr.parent;
	    	
	    		}
	    	 return true;	
	    	}else {
	    		return false;
	    	}
	    }
	    }

}
