package designguru.binarytree.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFSProblems {

	public static void main(String[] args) throws NumberFormatException, IOException {

		
	        String s = "4 4 10 5 10 7 2 N 3 8"; 
	                  //4 4 10 5 10 7 2 3 8
	        Node root = new Node(4);
	        root.left = new Node(4);
	        root.right = new Node(10);
	        
	        root.left.left = new Node(5);
	        root.left.right = new Node(10);
	        root.right.left = new Node(7);
	        root.right.right = new Node(2);
	        
	        
	        root.left.left.left = null;
	        root.left.left.right = new Node(3);
	        
	        root.left.right.left = new Node(8);
	        
 	    	//Node root = buildTree(s);
 	    	 connectSiblings(root);
             printSpecial(root);
             System.out.println();
             printInorder(root);
             System.out.println();
            
             
             //version 2
           //Node root = buildTree(s);
 	    	 connectSiblings2(root);
            // printSpecial(root);
             System.out.println();
             printInorder(root);
             System.out.println();
           
            
             
//		
//		printInorder(root);
//		System.out.println("\n ");
//		printSpecial(root);
	}
	
public static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

	public static void connectSiblings(Node root) {

	    
	        if(root == null) return;
	       // Deque <Node> queue = new ArrayDeque<Node>();
	        LinkedList < Node > queue = new LinkedList<>();
	        queue.add(root);
	        Node temp = null;
	        while(!queue.isEmpty()){
	        int s = queue.size();
	        for(int i = 0 ; i < s ; i++) {
	        		Node prev= temp;
	        		temp = queue.poll();
	        		if(i > 0 ) prev.next = temp;
	        		if(temp.left != null ) queue.add(temp.left);
	        		if(temp.right != null) queue.add(temp.right);
	        		
	        	}
	        	temp.next = null;
	        	
	        	
	        }
	}
   //version 2 
   // https://designgurus.io/course-play/grokking-the-coding-interview/doc/6399d2d989924acc4bea0939
   /*
    * Given a binary tree, connect each node with its level order successor. 
    * The last node of each level should point to the first node of the next level.
    */
	public static void connectSiblings2(Node root) {
        if(root == null) return;
       // Deque <Node> queue = new ArrayDeque<Node>();
        LinkedList < Node > queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        while(!queue.isEmpty()){
        	int s = queue.size();
        	Node first = null;
        	for(int i = 0 ; i < s ; i++) {
        		Node prev= temp;
        		temp = queue.poll();
        		if(i==0) first = temp;
        		if(i > 0 ) prev.next = temp;
        		if(temp.left != null ) queue.add(temp.left);
        		if(temp.right != null) queue.add(temp.right);
        		
        	}
        	temp.next = first;
        	
        	
        }
}
    public static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void printSpecial(Node root)
    {
       if (root == null)
         return;
    
       Node next_root=null;
    
       while (root != null)
       {
          System.out.print(root.data+" ");
    
          if( root.left!=null && next_root==null )
            next_root = root.left;
          else if( root.right!=null && next_root==null  )
            next_root = root.right;
    
          root = root.next;
       }
       
       printSpecial(next_root);
    }
    
    /*
     * Problem: Count Paths for a Sum
     * 
     * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’. 
     * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
     * 437. Path Sum III

     * solution: https://leetcode.com/problems/path-sum-iii/
     */
}
class Node {
	
	int data;
	Node left,right,next;
	Node(int d){
		data =d;
	}
	
	public String toString() {
		return ""+data;
	}
}