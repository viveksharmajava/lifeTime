package designguru.binarytree.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class BFSTreePractice {

	public static void main(String[] args) {
		/*
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
        System.out.println("inorder\n");
        inorder(root);
        System.out.println("\npreorder\n");
        preorder(root);
        System.out.println("\npostorder\n");
        postorder(root);
        
        System.out.println("inorderIterative ");
        inorderIterative(root);
        System.out.println("\n preorderIterative \n ");
        preorderIterative(root);
        System.out.println("postorderIterative \n ");
        postorderIterative(root);
        System.out.println("\n levelOrder \n");
        levelOrder(root);
        System.out.println("\n reverseLevelOrder\n ");
        reverseLevelOrder(root);
        System.out.println("\n ZigzagTraversal \n ");
        ZigzagTraversal(root);
        System.out.println("topView");
        topView(root);
        
        System.out.println("bottomView");
        bottomView(root);
        
        System.out.println("\n diagonalView\n ");
        diagonalView(root);
        System.out.println("isPathWithSumExist");
        isPathWithSumExist(root,10);
        
       
        Node level = new Node(20); 
        level.left = new Node(10); 
        level.left.left = new Node(4); 
        level.left.right = new Node(18); 
        level.right = new Node(26); 
        level.right.left = new Node(24); 
        level.right.right = new Node(27); 
        level.left.right.left = new Node(14); 
        level.left.right.left.left = new Node(13); 
        level.left.right.left.right = new Node(15); 
        level.left.right.right = new Node(19); 
     
        Node key = level.right.left; // node 24 
     
    Node res = levelOrderSuccessor(level, key); 
     
        if (res != null) 
            System.out.println("LevelOrder successor of "
                            +key.data + " is " + res.data); 
        else
            System.out.println("LevelOrder successor of "
                                +key.data + " is NULL");
	
        /* Constructed binary tree is
		        10
		      /   \
		    8      2
		  /         \
		3            90
		*/
		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(90);
		connectSiblings(root);
		 // Let us check the values of next pointers
        System.out.println("Following are populated next pointers in \n" +
        "the tree (-1 is printed if there is no next)");
        System.out.println("next of "+ root.data +" is "+
        ((root.next != null) ? root.next.data : -1));
        System.out.println("next of "+ root.left.data+" is "+
        ((root.left.next != null) ? root.left.next.data : -1));
        System.out.println("next of "+ root.right.data+" is "+
        ((root.right.next != null) ? root.right.next.data : -1));
        System.out.println("next of "+  root.left.left.data+" is "+
        ((root.left.left.next != null) ? root.left.left.next.data : -1));
        System.out.println("next of "+  root.right.right.data+" is "+
        ((root.right.right.next != null) ? root.right.right.next.data : -1));
   
        
        System.out.println("\n connectAllLevelOrder\n ");
        Node connected = connectAllLevelOrder(root);
        Node temp  = connected;
        while(temp !=null) {
        	System.out.print(temp.data+"  ");
        	temp =temp.next;
        }
        
        
        System.out.println("\n rightView \n ");
        rightView(root);
        
        System.out.println("\n Left View of BTree \n ");
        leftView(root);
        
        
     // arr[] : sequence of root to leaf path 
        int sequence[] = {5, 8, 6, 7}; 
         root = new Node(5); 
        root.left = new Node(3); 
        root.right = new Node(8); 
        root.left.left = new Node(2); 
        root.left.right = new Node(4); 
        root.left.left.left = new Node(1); 
        root.right.left = new Node(6); 
        root.right.left.right = new Node(7);
        System.out.println("\n pathWithGivenSequence\n ");
        pathWithGivenSequence(root,sequence);
	}
	
	public static void inorder(Node root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data +"  ");
		inorder(root.right);
	}
	
	public static void preorder(Node root) {
		if(root == null) return;
		System.out.print(root.data +"  ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void postorder(Node root) {
		if(root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data +"  ");
	}
	
	
	public static void inorderIterative(Node root) {
		if(root == null) return;
		Node n = root;
		Stack<Node >  s  =  new Stack<>();
		while (!s.isEmpty() || n != null) {
			if(n !=null) {
				s.push(n);
				n = n.left;
			}else {
				System.out.print(s.peek() +" ");
				n = s.pop().right;
			}
		}
	}
	
	public static void preorderIterative(Node root) {
		if(root == null) return;
		Node n = root;
		Stack<Node >  s  =  new Stack<>();
		s.add(n);
		while (!s.isEmpty()) {
			System.out.print(s.peek() +" ");
			n = s.pop();
			if(n.right != null) {
				s.push(n.right);
			}
			if(n.left != null) {
				s.push(n.left);
			}
			
		}
	}
	
	public static void postorderIterative(Node root) {
		if(root == null) return;
		Node n = root;
		Stack <Integer> result =  new Stack<>();
		Stack<Node >  s  =  new Stack<>();
		s.add(n);
		while (!s.isEmpty()) {
			n = s.pop();
			
			if(n.left != null) {
				s.push(n.left);
			}
			if(n.right != null) {
				s.push(n.right);
			}
			
			result.add(n.data);
	  }
	  while(!result.isEmpty()) {
		  System.out.print(result.pop() +" ");
	  }
	}
   public static void levelOrder(Node root) {
	   ArrayDeque<Node> q = new ArrayDeque<>();
	   q.add(root);
	   while(!q.isEmpty()) {
		   int s = q.size();
		   while(s > 0) {
			  Node n = q.poll();
			   System.out.print(n.data +"  ");
			   s--;
			   if(n.left != null)q.add(n.left);
			   if(n.right != null) q.add(n.right);
		   }
		   System.out.println();
	   }
   }
   
   public static void reverseLevelOrder(Node root) {

	   ArrayDeque<Node> q = new ArrayDeque<>();
	   Stack <Integer> result = new Stack<>();
	   q.add(root);
	   while(!q.isEmpty()) {
		   int s = q.size();
		   while(s > 0) {
			  Node n = q.poll();
			   //System.out.print(n.data +"  ");
			  result.add(n.data);
			   s--;
			  
			   if(n.right != null) q.add(n.right);
			   if(n.left != null)q.add(n.left);
			  
			  
		   }
		  // System.out.println();
	   }
	   while(!result.isEmpty()) {
		   System.out.print(result.pop()+" ");
	   }
   
   }
   //zigzag or spiral order traversal
   public static void ZigzagTraversal(Node root) {
	   ArrayDeque<Node> q = new ArrayDeque<>();
	   q.add(root);
	   boolean left = true;
	   while(!q.isEmpty()) {
		   int s = q.size();
		   while(s > 0) {
			   Node n;
			   if(left) {
			   n = q.pollFirst();
			   System.out.print(n.data +"  ");
			   //s--;
			  
			   if(n.left != null)q.addLast(n.left);
			   if(n.right != null) q.addLast(n.right);
		   }else {
			   n = q.pollLast();
			   System.out.print(n.data +"  ");
			   if(n.right != null) q.addFirst(n.right);
			   if(n.left != null)q.addFirst(n.left);
			  // s--;
		     }
			   s--;
		   }
		   System.out.println();
		   left = !left;
	   }
   }
   /*
    * Problem : Minimum depth
    * https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
    * 
    */
   public static int minDepth(Node root) {
	   //corner case
	   if(root == null) return 0;
	   // base case
	   if(root.left == null & root.right == null) return 1;
	   
	   //if leaf left subtree is null recur for right subtree
	   if(root.left == null && root.right != null) return minDepth(root.right) + 1;
	   
	   //if leaf right subtree is null recur for left subtree
	   if(root.left != null && root.right == null) return minDepth(root.left) + 1;
	   
	   return Math.min(minDepth(root.left),  minDepth(root.right)) +1;
	   
	   
   }
   
   /*
    * Problem : Level order successor 
    * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639894f2e4cab4072de783e2
    * 
    */
   
     public static Node levelOrderSuccessor(Node root, Node k) {
    	 if(root == null) return null;
    	 if(root.data == k.data )  {
    		 if(root.left !=null) return root.left;
    		 if(root.right != null) return root.right;
    		 else return null;
    	 }
    	 ArrayDeque < Node > q = new ArrayDeque<>();
    	 if(root.left !=null)q.add(root.left);
		 if(root.right != null) q.add(root.right);
		 while(!q.isEmpty()) {
			 Node n = q.poll();
			 if(n.data == k.data) {
				 if(!q.isEmpty()) return q.peek();
				 else if ( n.left != null) return n.left;
				 else if ( n.right != null) return n.right;
				 else return null;
			 }
			 if(n.left !=null)q.add(n.left);
			 if(n.right != null) q.add(n.right);
		 }
		 return null;
     }
     
     /* Problem: connect Siblings
      * 
      */
    
     public static void connectSiblings(Node root)
     {
     if(root == null) return;
     ArrayDeque  <Node> queue = new ArrayDeque<Node>();
    // LinkedList < Node > queue = new LinkedList<>();
     queue.add(root);
    
     while(!queue.isEmpty()){
          int s = queue.size();
          Node prev = null;
          while(s > 0) {
        	Node temp = queue.poll();
        	if( prev == null) prev = temp;
        	else {
        		prev.next = temp;
        		prev = temp;
        	}
        	if(prev.left != null) queue.add(prev.left);
        	if(prev.right != null) queue.add(prev.right);
        	s--;
          }	//end of inner while 
          prev.next = null;
       }//end of outer while
   } //eof function
     
     public static Node connectAllLevelOrder(Node root)
     {
     if(root == null) return null;
     ArrayDeque  <Node> queue = new ArrayDeque<Node>();
    // LinkedList < Node > queue = new LinkedList<>();
     queue.add(root);
     Node connect = null;
     Node prev = null;
     while(!queue.isEmpty()){
          int s = queue.size();
          
         
          while(s > 0) {
        	Node temp = queue.poll();
        	if( prev == null)connect =  prev = temp;
        	else {
        		prev.next = temp;
        		prev = temp;
        	}
        	if(prev.left != null) queue.add(prev.left);
        	if(prev.right != null) queue.add(prev.right);
        	s--;
          }	//end of inner while 
         // prev.next = null;
       }//end of outer while
     return connect;
   } //eof function
     
  public static void rightView(Node root) {
	  if(root == null) return ;
	     ArrayDeque  <Node> q = new ArrayDeque<Node>();
	    // LinkedList < Node > queue = new LinkedList<>();
	     q.add(root);
	     while(!q.isEmpty()){
	          int s = q.size();
	          int i=1;
	           while(i <= s) {
	        	Node n = q.poll();
	           if(n.left !=null)q.add(n.left);
			   if(n.right != null) q.add(n.right);
			   if(i == s) {
				   System.out.println(n.data);
			   }
	          i++;
	          }
	     }     
  }
  
  public static void leftView(Node root) {
	  if(root == null) return ;
	     ArrayDeque  <Node> q = new ArrayDeque<Node>();
	    // LinkedList < Node > queue = new LinkedList<>();
	     q.add(root);
	     while(!q.isEmpty()){
	          int s = q.size();
	          int i=1;
	           while(i <= s) {
	        	Node n = q.poll();
	           if(n.left !=null)q.add(n.left);
			   if(n.right != null) q.add(n.right);
			   if(i == 1) {
				   System.out.println(n.data);
			   }
	          i++;
	          }
	     }     
  }
  
  public static void topView(Node root) {
	  TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
	  preorderCustom(root,map,0);
	  System.out.println("map = "+map);
	  for(Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
		  System.out.print(entry.getValue().getFirst()+" ");
	  }
	  
  }
  
  public static void bottomView(Node root) {
	  TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
	  preorderCustom(root,map,0);
	  System.out.println("map = "+map);
	  for(Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
		  System.out.print(entry.getValue().getLast()+" ");
	  }
	  
  }
  public static void preorderCustom(Node root,TreeMap<Integer, LinkedList<Integer>> map , int level) {
		if(root == null) return;
		if(map.containsKey(level)){
			 LinkedList<Integer> list = map.get(level);
			 list.add(root.data);
			 map.put(level,list);
			//map.put(level , map.getOrDefault(level, new LinkedList()).add(root.data));
		}else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			map.put(level, list);
		}
		preorderCustom(root.left,map,level-1);
		preorderCustom(root.right,map,level+1);
	}
  
  public static void diagonalView(Node root) {

	  TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
	  preorderDiagonal(root,map,0);
	  System.out.println("diagonalView map = "+map);
	  for(Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
		  System.out.println(entry.getValue()+" ");
	  }
	  
  
  }
  
  public static void preorderDiagonal(Node root,TreeMap<Integer, LinkedList<Integer>> map , int level) {
		if(root == null) return;
		if(map.containsKey(level)){
			 LinkedList<Integer> list = map.get(level);
			 list.add(root.data);
			 map.put(level,list);
			//map.put(level , map.getOrDefault(level, new LinkedList()).add(root.data));
		}else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			map.put(level, list);
		}
		preorderDiagonal(root.left,map,level+1);
		preorderDiagonal(root.right,map,level);
	}
  
//DFS practice
  
  /*
   * Binary Tree Path Sum (easy) 
   * 
   */
  public static boolean isPathWithSumExist(Node root , int x) {
	  boolean exist = false;
	  ArrayDeque<Integer> list = new ArrayDeque<Integer> ();
	  preorderPathCheck(root, list ,x);
	  return exist;
  }
  public static void preorderPathCheck(Node root, ArrayDeque<Integer> list , int k) {
		if(root == null) return;
		list.add(root.data);
		k = k- root.data;
		if(isLeaf(root)  && k == 0) {
			System.out.println("path with given sum exist ="+list);
		}
		preorderPathCheck(root.left,list,k);
		preorderPathCheck(root.right,list,k);
		list.removeLast();
	}

private static boolean isLeaf(Node root) {
	return root.left == null && root.right == null;
}
 /* https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63dd75bab9c2c77f772dee2d
  *  Path With Given Sequence
  *  
  */
 public static void  pathWithGivenSequence(Node root , int [] arr) {
	 ArrayDeque<Integer> list = new ArrayDeque<Integer> ();
	 preorderPathWithSequenceCheck(root,list ,arr ,0);
 }
 public static void preorderPathWithSequenceCheck(Node root, ArrayDeque<Integer> list ,int [] arr, int k) {
	if(root == null) return;
	if(root.data == arr[k])
	 {
	 list.add(root.data);
    }else return ;
	if(isLeaf(root)  && k == arr.length-1) {
	  System.out.println("path with given sum exist ="+list);
	  return;
	}
	preorderPathWithSequenceCheck(root.left,list,arr,k+1);
	preorderPathWithSequenceCheck(root.right,list,arr,k+1);
	list.removeLast();
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
