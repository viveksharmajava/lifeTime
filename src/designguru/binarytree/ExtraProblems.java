package designguru.binarytree;

import java.util.Stack;

public class ExtraProblems {

	public static void main(String[] args) {
             System.out.println("Hello from ExtraProblems");
	}

    //Function to check if two trees are identical.
	public static boolean isIdentical(Node root1, Node root2)
	{ 
	    if(root1 == null && root2 == null) return true;
	    if((root1 != null && root2== null ) || (root1 == null && root2 !=null)) return false;
	    
	    if(root1.data != root2.data)  return false;
	    return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
	}
	
	public static void mirrorTree(Node root) {
		if(root == null) return;
		mirrorTree(root.left);
		mirrorTree(root.right);
		swap(root);
	}

	private static void swap(Node root) {
		if(root == null) return;
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
	}
	
}


class BSTIterator {

	Stack <Node> stack;
    public BSTIterator(Node root) {
    	stack = new Stack<>();
    	Node curr = root;
    	while(curr != null) {
    		stack.add(curr);
    		curr = curr.left;
    	}
    }
    public int curr() {
    	 Node n = stack.peek();
         return n.data;
    }
    public int next() {
        Node popped = stack.pop();
    	Node temp = popped.right;
    	while(temp != null) {
    		stack.push(temp);
    		temp = temp.left;
    	}
    	return popped.data;
    }
    
    
    public boolean hasNext() {
       return !stack.isEmpty();
    }
}
