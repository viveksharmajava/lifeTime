package designguru.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class TreeTraversals {

	public static void main(String[] args) {
		
		 /* Construct the following tree
		        1
		      /   \
		     /     \
		    2       3
		   /      /   \
		  /      /     \
		 4      5       6
		       / \
		      /   \
		     7     8
		 */

		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Inorder\n ");
        inorder(root);
        System.out.println("Inorder Iterative \n ");
        inorderIterative(root);
       
        System.out.println("Preorer recursive \n ");
        preorder(root);
        System.out.println("Preorer Iterative \\n ");
       
        preorderIterative(root);
        System.out.println("Postorder  \\n ");
        postorder(root);
        System.out.println("Postorder Iterative \\n ");
        postordeIterative(root);
        
        System.out.println("Level order traversal!\n");
        levelOrder(root);
        
        System.out.println("\n Reverse Level order traversal!\n");
        reveseLevelOrder(root);
        
        System.out.println("\nSpiral order traversal !\n");
        spiralOrder(root);
        
        System.out.println("\n The height of tree is ="+height(root));
	   System.out.println("\n Check 2 tree are identical \n");
	  
	   Map < Integer , Pair> map  = new TreeMap<Integer, Pair>();
	   System.out.println("\n Top view is \n");
	   topView(root,1,0,map);
	   for(Pair p : map.values()) {
		   System.out.print(p.data+" ");
	   }
	// construct the first tree
       Node x = new Node(15);
       x.left = new Node(10);
       x.right = new Node(20);
       x.left.left = new Node(8);
       x.left.right = new Node(12);
       x.right.left = new Node(16);
       x.right.right = new Node(25);

       // construct the second tree
       Node y = new Node(15);
       y.left = new Node(10);
       y.right = new Node(20);
       y.left.left = new Node(8);
       y.left.right = new Node(12);
       y.right.left = new Node(16);
       y.right.right = new Node(25);
	   System.out.println(isIdenticalTrees(x, y));
	   System.out.println(isIdenticalTrees(x, root));
	   
	   root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       root.left.left.left = new Node(8);
       root.left.left.right = new Node(9);
       root.left.right.left = new Node(10);
       root.left.right.right = new Node(11);
       root.right.left.left = new Node(12);
       root.right.left.right = new Node(13);
       root.right.right.left = new Node(14);
       root.right.right.right = new Node(15);
	   printNodesInaSpecificOrder(root);
	   System.out.println("\n printNodesInaSpecificOrder2\n ");
	   printNodesInaSpecificOrder2(root);
	
	  /* is complete btree */
	   Node c1 = new Node (1);
	   Node c2 = new Node (2);
	   Node c3 = new Node (3);
	  // c1.left = c2;
	   c1.right = c3;
	   System.out.println("\n Is Complete btree \n");
	 // System.out.println( isCompleteBTree(c1)); //isCompleteBTree(c1);

	  Node t = buildTree("31 66 73 174 107 76 59 26 177 119 119 58 92 31 N 104 40 143 79 123 91") ; 
	  System.out.println("\n Balanced tree nodes \n");
	  levelOrder(t);
	 // System.out.println("\n"+ isCompleteBTree(t)); //isCompleteBTree(c1);
	Node t2 = buildTree("504 317 604 646");
	
	System.out.println("\n is complete tree\n"+ isCompleteBTree(t2));
	
	
	 root = new Node(1);

	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.right.left = new Node(6);
	root.right.right = new Node(7);
	root.right.left.left = new Node(8);
	root.right.right.right = new Node(9);

	// print all root-to-leaf paths
	System.out.println("\nfindRootToLeafPaths(root)\n ");
	findRootToLeafPaths(root);
	}
   
	public static void inorder(Node root) {
		
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
	    inorder(root.right);
	}
	public static void inorderIterative(Node root) {
		Stack <Node> stack = new Stack<>();
        Node cur = root;
        while(!stack.isEmpty() || cur != null) {
        	if(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	else {
        		cur = stack.pop();
        		System.out.print(cur.data+" ");
        		cur = cur.right;
        	}
        }
        
     
	}
	
	public static void preorder(Node root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void preorderIterative(Node root) {
		
		Stack <Node> preorder = new Stack<>();
		Node cur = root;
		preorder.add(cur);
		while(!preorder.isEmpty()) {
			cur = preorder.pop();
			System.out.print(cur.data+" ");
			if(cur.right != null)preorder.push(cur.right);
			if( cur.left != null) preorder.push(cur.left);
		}
		
	}
	public static void postorder(Node root) {
		
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	public static void postordeIterative(Node root) {
		
		Stack < Node> postorder = new Stack <>();
		Stack < Integer> result = new Stack <>();
		postorder.add(root);
		while(!postorder.isEmpty()) {
			
			Node poped = postorder.pop();
			result.push(poped.data);
			if(poped.left !=null) postorder.add(poped.left);
			if(poped.right !=null) postorder.add(poped.right);
		}
		
		while(!result.isEmpty()) {
			System.out.println(result.pop()+" ");
		}
	}
	
	
	public static void reveseLevelOrder(Node root) {
		Queue <Node > level = new ArrayDeque<>();
		level.add(root);
		Stack < Integer> result = new Stack <>();
		while(!level.isEmpty()) {
			
			Node n = level.poll();
		//	System.out.print(n.data+" ");
			result.push(n.data);
			if(n.right != null) level.add(n.right);
			if(n.left != null)level.add(n.left);
		
		}
		while(!result.isEmpty()) {
			System.out.print(result.pop()+" ");
		}
	}
	
	public static void levelOrder(Node root) {
		Queue <Node > level = new ArrayDeque<>();
		level.add(root);
		while(!level.isEmpty()) {
			
			Node n = level.poll();
			System.out.print(n.data+" ");
			if(n.left != null)level.add(n.left);
			if(n.right != null) level.add(n.right);
		}
	}
	
	public static void spiralOrder(Node root) {
		Deque<Node> level = new ArrayDeque<>();  
		level.add(root);
		boolean flag = true;
		while(!level.isEmpty()) {
		 // calculate the total number of nodes at the current level
          
           if(flag) {
        	int nodeCount = level.size();
            while(nodeCount > 0) {
			Node n = level.pollFirst();
			System.out.print(n.data+" ");
			if(n.left != null)level.addLast(n.left);
			if(n.right != null) level.addLast(n.right);
			nodeCount--;
            }
            flag = !flag;
          } 
           if(!flag) {
            int nodeCount = level.size();
        	while(nodeCount > 0) {
   			Node n = level.pollLast();
   			System.out.print(n.data+" ");
   			if(n.right != null) level.addFirst(n.right);
   			if(n.left != null)level.addFirst(n.left);
   			nodeCount--;
               }
               flag = !flag;
             } 
		}
	}
	
	public static int height(Node root) {
		if(root == null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static boolean isIdenticalTrees(Node t1, Node t2) {
		if( t1 == null && t2 == null)return true;
		if((t1 != null && t2 == null) || (t2 != null && t1 == null)) return false;
		
		if(t1.data != t2.data) return false;
		return isIdenticalTrees(t1.left,t2.left) && isIdenticalTrees(t1.right,t2.right);
	}
	
	public void deleteBTree(Node root) {
		if(root == null) return;
		deleteBTree(root.left);
		deleteBTree(root.right);
		root = null;
	}
	
	// 10) Print all nodes of a given binary tree in specific order
	// https://www.techiedelight.com/print-nodes-binary-tree-specific-order/
	// top down approach
	// 1, 2, 3, 4, 7, 5, 6, 8, 15, 9, 14, 10, 13, 11, 12
	public static void printNodesInaSpecificOrder(Node root) {
		
		if(root == null) return;
		Deque < Node> first = new ArrayDeque<>();
		Deque < Node> second = new ArrayDeque<>();
		System.out.print(root.data +" ");
		if (root.left != null && root.right != null)
        {
            first.add(root.left);
            second.add(root.right);
        }
		
		while(!first.isEmpty() ) {
			Node l  = first.poll();
			System.out.print(l.data+" ");
			
			if(l.left != null)first.add(l.left);
			if(l.right != null)first.add(l.right);
			
			
			Node r = second.poll();
			
			System.out.print(r.data+" ");
			
			if(r.right != null)second.add(r.right);
			if(r.left != null)second.add(r.left);
		}
	}
	
	
	// 10) Print all nodes of a given binary tree in specific order
		// https://www.techiedelight.com/print-nodes-binary-tree-specific-order/
		// bottom up approach
		//(8, 15, 9, 14, 10, 13, 11, 12, 4, 7, 5, 6, 2, 3, 1)
		public static void printNodesInaSpecificOrder2(Node root) {
			
			if(root == null) return;
			Deque < Node> first = new ArrayDeque<>();
			Deque < Node> second = new ArrayDeque<>();
			Deque < Integer> result = new ArrayDeque<>();
			result.addFirst(root.data);
			if (root.left != null && root.right != null)
	        {
	            first.add(root.left);
	            second.add(root.right);
	        }
			
			while(!first.isEmpty() ) {
				
				Node r = second.poll();
				
				//System.out.println(r.data+" ");
				result.addFirst(r.data);
				
				if(r.left != null)second.add(r.left);
				if(r.right != null)second.add(r.right);
				
				Node l  = first.poll();
				//System.out.println(l.data+" ");
				result.addFirst(l.data);
				if(l.right != null)first.add(l.right);
				if(l.left != null)first.add(l.left);
				
				
				
				
			}
			//System.out.print(root.data +" ");
			while(!result.isEmpty()) {
				System.out.print(result.poll()+" ");
			}
		}
		
		/*
		 * 11) https://www.techiedelight.com/print-left-view-of-binary-tree/
		 * Problem : Print left view of binary tree.
		 */
		
		//Function to return list containing elements of left view of binary tree.
	   public static ArrayList<Integer> leftView(Node root)
	    {
	      if(root == null  ) return new ArrayList<Integer>();
	      Deque < Node > levelNodes = new ArrayDeque<>();
	      Node curr;
	      ArrayList<Integer> result = new ArrayList<Integer>();
	      levelNodes.add(root);
	      while(!levelNodes.isEmpty()){
	          int count = levelNodes.size();
	          for(int i = 0 ; i < count; i++){
	              curr = levelNodes.poll();
	              if(i == 0) {
	                  result.add(curr.data);
	              }
	              if(curr.left != null) levelNodes.add(curr.left);
	              if(curr.right != null) levelNodes.add(curr.right);
	          }
	      }
	      return result;
	      
	    }
	   
	   public static void topView(Node root, int level ,  int distance, Map <Integer, Pair> map){
		   if(root == null  ) return;
		   if ( !map.containsKey(distance) || level <  map.get(distance).level) {
			  map.put(distance ,new Pair(root.data,level));
		   }
		   
		   topView(root.left , level+1 , distance-1,map);
		   topView(root.right , level+1 , distance+1,map);
	   }
	   
	   public static boolean isCompleteBTree(Node root) {  // return if the tree is empty
	        if (root == null) {
	            return true;
	        }
	 
	        // create an empty queue and enqueue the root node
	        Queue<Node> queue = new ArrayDeque<>();
	        queue.add(root);
	 
	        // to store the current node
	        Node front;
	 
	        // flag to mark the end of full nodes
	        boolean flag = false;
	 
	        // loop till queue is empty
	        while (!queue.isEmpty())
	        {
	            // dequeue front node
	            front = queue.poll();
	 
	            // if we have encountered a non-full node before and the current node
	            // is not a leaf, a tree cannot be complete
	            if (flag && (front.left != null || front.right != null)) {
	                return false;
	            }
	 
	            // if the left child is empty and the right child exists,
	            // a tree cannot be complete
	            if (front.left == null && front.right != null) {
	                return false;
	            }
	 
	            // if the left child exists, enqueue it
	            if (front.left != null) {
	                queue.add(front.left);
	            }
	            // if the current node is a non-full node, set the flag to true
	            else {
	                flag = true;
	            }
	 
	            // if the right child exists, enqueue it
	            if (front.right != null) {
	                queue.add(front.right);
	            }
	            // if the current node is a non-full node, set the flag to true
	            else {
	                flag = true;
	            }
	        }
	 
	        return true;
	    }
//	   public static  isCompleteUsingArray(Node root) {
//		   
//		   boolean [] A = new boolean[size(root)];
//		   
//		   
//	   }
	   public static void inorder(Node root , boolean [] A , int i) {
		   if(root == null || i >= A.length) return;
		   inorder(root.left, A, 2*i+1); // visit left node..
		   A[i] = true;//mark visited
		   inorder(root.right, A, 2*i+2); // visit right node..
		   
	   }
	   
	  static int size(Node root) {
		  if(root == null) return 0;
		  return 1+ size(root.left) + size(root.right);
	  }
	   static Node buildTree(String str){
	        
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
	    static void printInorder(Node root)
	    {
	        if(root == null)
	            return;
	            
	        printInorder(root.left);
	        System.out.print(root.data+" ");
	        
	        printInorder(root.right);
	    }
	    
		public static void findRootToLeafPaths(Node root)
		{
			Set<List<Integer>> paths = new HashSet<>();

			// Write your code here...
	  // list to store root-to-leaf path
	        List<Integer> path = new ArrayList<>();
	        leaftToRoot(root,path);
		return ;
		}
		public static boolean isLeaf(Node node) {
	        return (node.left == null && node.right == null);
	    }
		private static void leaftToRoot(Node root ,  List<Integer> path  ){
			if (root == null) return;
			
			
			path.add(root.data);
		  if(isLeaf(root))	
			{
				System.out.println(path);
			}	
		
			leaftToRoot(root.left,path );
			leaftToRoot(root.right,path);
			path.remove(path.size()-1);
		}    
}

class Pair{
	int data,level;
	Pair(int d, int p){
		this.data = d;
		this.level = p;
	}
}
