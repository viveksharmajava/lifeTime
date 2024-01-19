package ds500problems.tree.revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
	int data;
	Node left, right;
	Node(int value){
		this.data = value;
	}
}
public class Main {

	public static void main(String[] args) {
		   Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.right.left = new Node(5);
	        root.right.right = new Node(6);
	        root.right.left.left = new Node(7);
	        root.right.left.right = new Node(8);
	        inorderIterative(root);
	        root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.right.left = new Node(5);
	        root.right.right = new Node(6);
	        root.right.left.left = new Node(7);
	        root.right.left.right = new Node(8);
	        preorderIterative(root);
	        root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.right.left = new Node(5);
	        root.right.right = new Node(6);
	        root.right.left.left = new Node(7);
	        root.right.left.right = new Node(8);
	        System.out.println();
	        postorderIterative(root);
	        
	        System.out.println("\nReverse level order");
	        root = new Node(15);
	        root.left = new Node(10);
	        root.right = new Node(20);
	        root.left.left = new Node(8);
	        root.left.right = new Node(12);
	        root.right.left = new Node(16);
	        root.right.right = new Node(25);
	 
	        reverseLevelOrder(root);
	        
	        System.out.println("\n printAllPathsFromRootToLeaf");
	        root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.right.left = new Node(6);
	        root.right.right = new Node(7);
	        root.right.left.left = new Node(8);
	        root.right.right.right = new Node(9);
	        Deque < Integer > path = new ArrayDeque<>();
	        printAllPathsFromRootToLeaf(root, path);
	       System.out.println("\n print diagonal elements");
	        root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.right.left = new Node(5);
	        root.right.right = new Node(6);
	        root.right.left.left = new Node(7);
	        root.right.left.right = new Node(8);
	       
	       HashMap <Integer , List<Integer>> diag = new HashMap<>();
	       printDiagonalNodes(root, 0, diag);
	       System.out.println(diag.values());
	}
	
	public static void  inorderIterative(Node root) {        // create an empty stack
        Stack<Node> stack = new Stack<>();
    
        // start from the root node (set current node to the root node)
        Node curr = root;
    
        // if the current node is null and the stack is also empty, we are done
        while (!stack.empty() || curr != null)
        {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                curr = stack.pop();
                System.out.print(curr.data + " ");
    
                curr = curr.right;
            }
        }}

	public static void preorderIterative(Node r) {
		//base case
		if(r == null) return;
		Stack <Node> stack  = new Stack<>();
		stack.add(r);
		System.out.println();
		while(!stack.isEmpty()) {
			Node curr = stack.pop();
			System.out.print(curr.data+"\t");
			if(curr.right != null) stack.add(curr.right);
			if(curr.left != null) stack.add(curr.left);
		}
	}
	
	public static void postorderIterative(Node r) {
		if(r == null) return;
		
	    Stack <Node> stack = new Stack();
	    Stack <Integer> output = new Stack();
	    stack.add(r);
	    while(!stack.isEmpty()) {
	    	
	    	Node  curr  = stack.pop();
	    	output.add(curr.data);
	    	if(curr.left != null) stack.add(curr.left);
	    	if(curr.right != null) stack.add(curr.right);
	    	
	    }
	    while(!output.isEmpty()) {
	    	System.out.print(output.pop()+" ");
	    }
	    
	}
	public static void reverseLevelOrder(Node r) {
		if(r == null) return;
		
		Queue < Node > q = new ArrayDeque<>();
		Deque <Integer> stack = new ArrayDeque<>();
		q.add(r);
		while(!q.isEmpty()) {
			Node current = q.poll();
			stack.push(current.data);
			if(current.right != null) q.add(current.right);
			if(current.left != null) q.add(current.left);
		}
		// pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
	}
	
	 // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static void convertToMirror(Node root) {
    	if(root == null) return;
    	convertToMirror(root.left );
    	convertToMirror(root.right);
    	swap(root);
    	
    }
    
    public static void printAllPathsFromRootToLeaf(Node r,Deque <Integer> path ) {
    	
    	if( r == null) return;
    	path.addLast(r.data);
    	if(isLeaf(r)) System.out.println(path);
    	
    	printAllPathsFromRootToLeaf(r.left,path);
    	printAllPathsFromRootToLeaf(r.right, path);
    	path.removeLast();
    }
    
    private static boolean isLeaf(Node n) {
    	return n.left == null & n.right == null;
    }
   public static void printDiagonalNodes(Node r , int diagonalLevel, HashMap <Integer,List<Integer>> diagMap) {
	   if(r == null) return;
	   diagMap.put(diagonalLevel, diagMap.getOrDefault(diagonalLevel, new ArrayList<Integer>()));
	   diagMap.get(diagonalLevel).add(r.data);
	   printDiagonalNodes(r.left,diagonalLevel+1 , diagMap);
	   printDiagonalNodes(r.right,diagonalLevel, diagMap);
	   
   }
}
