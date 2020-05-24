package ds500problems.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProblemsOnBTree {
     static class Node{
    	
    	 Node left;
    	 Integer data;
    	Node right;
    	Node(Integer val){
    		this.data = val;
    	}
     }
	public static void main(String[] args) {
	   Node root = new Node(20);
	   root.left = new Node(10);
	   root.left.left = new Node(5);
	   root.right = new Node(20);
	   root.right.left = new Node(15);
	   System.out.println("inorder using recurssion");
	   inorder(root);
	   System.out.println("inorder without recurssion");
	   inorderWithoutRecurssion(root);
	   System.out.println("preorder using recurssion");
	   preorder(root);
	   System.out.println("preorder without  recurssion");
	   preorderWithoutRecurssion(root);
	   System.out.println("postorder using recurssion");
	   postorder(root);
	   System.out.println("postorder using recurssion");
	   postorderWithoutRecussion(root);
	   //Check if 2 given binary tree are identical or not
	    Node y = new Node(20);
	   y.left = new Node(10);
	   y.left.left = new Node(5);
	   
	   System.out.println("isIdentical ="+isIdentical(root, y));
	   System.out.println("isIdentical Iterative="+isIdenticalIterative(root, y));
	   
	   System.out.println("LevelOrder traversal\n");
	   levelOrder(root);
	   System.out.println("vertical order traversal");
	   verticalOrder(root);
	   System.out.println("\nTop View of BinaryTree");
	   topview(root);
	   System.out.println("\n Bottom up View of BinaryTree");
	   bottomview(root);
	   System.out.println("\nLeft View Iterative of  BinaryTree");
	   leftviewIterative(root);
	   System.out.println("\nLeft View Recursive of  BinaryTree");
	   leftViewRecursive(root);
	   System.out.println("\nRight View Iterative of  BinaryTree");
	   rightViewIterative(root);
	   System.out.println("Spriral View of BTree");
	   spiralView(root);
	   
	   System.out.println("Diagonal View of BTree");
	   diagonalView(root);
	   
	}
	
	// Left root right
	/*
	 * Visit left node
	 * process root
	 * visit right node
	 */
	public static void inorder(Node root) {
		
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}
	
public static void inorderWithoutRecurssion(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while(root !=null || !stack.isEmpty()) {
			if(root == null) {
				root = stack.pop();
				  System.out.println(root.data);
				 root = root.right;
				}
			else{
				stack.push(root);
				root = root.left;
			}
		}
	}//end of method here

/* 
 * Root Left Right
 * 1. Process root node
 * 2. Visit Left Node
 * 3. Visit right Node
 */
 public static void preorder(Node root) {
	 if( root == null) return;
	 System.out.println(root.data);
	 preorder(root.left);
	 preorder(root.right);
 }
 
 public static void preorderWithoutRecurssion(Node root) {
	 if( root == null) return;
	 Stack <Node> stack = new Stack<Node>();
	 stack.push(root);
	 while(!stack.isEmpty()) {
		Node temp = stack.pop();
		System.out.println(temp.data);
		if(temp.right != null) stack.push(temp.right);
		if(temp.left != null) stack.push(temp.left);
	 }
 }
 
 /*
  * Post order traversal
  * LEFT RIGHT ROOT
  * 1. Visit Left
  * 2. Visit right
  * 3. process root
  */
  public static void postorder(Node root) {
	  if( root == null) return;
	  postorder(root.left);
	  postorder(root.right);
	  System.out.println(root.data);
  }
  /*
   * Important: To convert above recursion procedure to iterative we need to use 2 stack
   * here 1 extra stack to hold output
   */
  public static void postorderWithoutRecussion(Node root) {
	  if( root == null) return;
	  Stack <Node> stack = new Stack<Node>();
	  Stack <Integer> out = new Stack<Integer>();
	  stack.push(root);
	  while(!stack.isEmpty())
	  {
		 root = stack.pop();
		 out.push(root.data);
		 if(root.left != null) stack.push(root.left);
		 if(root.right != null) stack.push(root.right);
	  }
	  while(!out.isEmpty()) {
		  System.out.println(out.pop());
	  }
  }
  
  /*
   * Level Order traversal of BTree
   * 1. Put root Node to the queue
   * 2. Pop from queue and process it 
   * 3. enqueue popped node's left and right child to queue
   * 4. Repeat step 1..3 till queue is empty
   */
  
  public static void levelOrder(Node root) {
	  if(root == null) return;
	  Deque <Node> queue = new  ArrayDeque<ProblemsOnBTree.Node>();
	  queue.add(root);
	  while(!queue.isEmpty()) {
		  root = queue.poll();
		  System.out.println(root.data);
		  if(root.left != null) queue.add(root.left);
		  if(root.right != null) queue.add(root.right);
	  }
  }
  /*
   * Check if 2 given binary tree are identical or not
   * https://www.techiedelight.com/check-if-two-binary-trees-are-identical-not-iterative-recursive/
   *
   */
  public static boolean isIdentical(Node x, Node y) {
	  if (x == null && y== null ) return true;
	  return ( (x!=null && y!=null) && ( x.data == y.data ) && isIdentical(x.left, y.left) && isIdentical(x.right, y.right));
  }
  //Iterative approach for above problem check isIdentical iteravtily
  public static boolean isIdenticalIterative(Node x, Node y) {
	  if (x == null && y== null ) return true;
		// if first tree is empty (& second tree is non-empty), return false
		if (x == null) {
			return false;
		}
	
		// if second tree is empty (& first tree is non-empty), return false
		if (y == null) {
			return false;
		}
	  class Pair<U, V>{
		  U u;
		  V v;
		  Pair(U u , V v){
			  this.u  = u;
			  this.v  = v;
		  }
	  }
		// create a stack to hold Node pairs
	Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
	  stack.push(new Pair(x,y));
	  while(!stack.isEmpty()) {
		  Pair <Node,Node> p  = stack.pop();
		  x = p.u;
		  y = p.v;
		 if( x.data !=y.data ) return false;
		 if( x.left !=null && y.left != null ) {
			 stack.push(new Pair(x.left,y.left));
		 }
		 else  if ((x.left ==null  &&  y.left != null) || (x.left !=null  &&  y.left == null )){
			 return false;
		 }
		 if( x.right !=null && y.right != null ) {
			 stack.push(new Pair(x.right,y.right));
		 }
		 else  if ((x.right ==null  &&  y.right != null) || (x.right !=null  &&  y.right == null )){
			 return false;
		 }
		 
	  }
	  return true;
	 }
  
  /*
   *  Calculate the height of BTree
   *  https://www.techiedelight.com/calculate-height-binary-tree-iterative-recursive/
   */
  
  public static int heightOfBTree(Node root) {
	  return height(root);
  }
  private static int height(Node root) {
	  if (root == null) return 0;
	  return Math.max(height(root.left), height(root.right))+1;
  }
  /*
   *  Calculate the height of the Node
   *  Height of the Node is the longest path from that node to leaf node
   */
  
  public static int heightOfNode(Node n) {
	  return height(n);
  }
  
  /*
   * Vertical order Traversal
   *  (1)
		    	/    \ 
		   	(2)       (3)
		   /   \     /   \ 
		(4)    (5)(6)   (7)
		
		
		root = Level = 0
		go left : level++
		go righ : leve --
		
		
		 		    (1)l=0
		    l++	/          \ l--
		   	 (2)l=1         (3) l=-1
	    l++ /   \l--    l++ /   \ l--
		(4)l=2   (5)l=0   (6)l=0   (7)l=-2
		
		
		Result :  [4],[2],[1,5,6],[3],[7]
		         
		
		Algo :
		
		 Do the preordertraversal.
        Take a variable called level, when ever you go left, do level++ AND when ever you go right do level–.
        With step above we have separated out the levels vertically.
        Now you need to store the elements of each level, so create a TreeMap and the (key,value) pair will be (level,elements at that level).
       At the end iterate through the TreeMap and print the results.
		
   */
  public static void verticalOrder(Node root) {
		TreeMap<Integer,ArrayList>  ht  = new TreeMap<Integer,ArrayList>();
		vertical(root, 0 , ht);

	 SortedSet<Map.Entry<Integer, ArrayList>> sortedset = new TreeSet<Map.Entry<Integer, ArrayList>>(
	  new Comparator<Map.Entry<Integer, ArrayList>>() {
	      @Override
	      public int compare(Map.Entry<Integer, ArrayList> e1,
	              Map.Entry<Integer, ArrayList> e2) {
	          return e2.getKey().compareTo(e1.getKey());
	      }
	  });
		sortedset.addAll(ht.entrySet());

	    for (Map.Entry<Integer,ArrayList> entry : sortedset) {
	        System.out.print(entry.getValue()+" ");
	    }
		
	 } 
  
    private static void vertical(Node root , int level , TreeMap <Integer, ArrayList>map) {
    	if(root == null) return;
    	if(map.containsKey(level)) {
    		map.get(level).add(root.data);
    	}else {
    		ArrayList a = new ArrayList();
    		a.add(root.data);
    		map.put(level, a);
    	}
    	vertical(root.left, level+1,map);
    	vertical(root.right, level-1,map);
    }
    
   public static void topview(Node root) {
	   if(root == null) return ;
	   TreeMap<Integer,ArrayList>  ht  = new TreeMap<Integer,ArrayList>(
          //Add comparator so that  output should get printed from left to right.
		  new Comparator<Integer>() {
		      @Override
		      public int compare(Integer e1,
		              Integer e2) {
		          return e2.compareTo(e1);
		      }
		  }
			   );
		vertical(root, 0 , ht);
	   Set<Map.Entry<Integer,ArrayList>> set = ht.entrySet();
	   for(Map.Entry <Integer,ArrayList> me : set) {
		   System.out.print(me.getValue().get(0)+"\t "); //fetch only first element so that it will give top view.
	   }
   }
   /*
    * It should be reverse of top view 
    * There is a problem with 
    */
   public static void bottomview(Node root) {

 	   if(root == null) return ;
 	   TreeMap<Integer,ArrayList>  ht  = new TreeMap<Integer,ArrayList>(
          //Add comparator so that  output should get printed from left to right.
 		  new Comparator<Integer>() {
 		      @Override
 		      public int compare(Integer e1,
 		              Integer e2) {
 		          return e2.compareTo(e1);
 		      }
 		  }
 			   );
 		vertical(root, 0 , ht);
 	   Set<Map.Entry<Integer,ArrayList>> set = ht.entrySet();
 	   for(Map.Entry <Integer,ArrayList> me : set) {
 		   System.out.print(me.getValue().get(me.getValue().size()-1)+"\t "); //fetch only last element so that it will give view view.
 	   }
   
   }
  /* Left View
   * We can modify level order traversal to get the left view or right view
   * 1. keep track of each level size
   * 1. print first node of each level
   * 
   * 
   */
   
  public static void leftviewIterative(Node root) {
	  
	  if(root == null) return;
	  Queue <Node> queue = new ArrayDeque();
	  queue.add(root);
	  while(!queue.isEmpty()) {
		  
		 int size  = queue.size();
		 int i = 0;
		 while(i++ < size) {
			Node n = queue.poll();
			if( i == 1)System.out.println(n.data);
			if(n.left != null) queue.add(n.left);//put left node first for right view,
											      // since we are printing only first node of each level.
			if(n.right != null) queue.add(n.right);
		 }
		  
	  }
	  
  }
  /* 
   * Right View of BTree
   * We can modify level order traversal to get the right view or right view
   * 1. keep track of each level size
   * 1. print first node of each level
   * 
   * 
   */
   
  public static void rightViewIterative(Node root) {
	  
	  if(root == null) return;
	  Queue <Node> queue = new ArrayDeque();
	  queue.add(root);
	  while(!queue.isEmpty()) {
		  
		 int size  = queue.size();
		 int i = 0;
		 while(i++ < size) {
			Node n = queue.poll();
			if( i == 1)System.out.println(n.data);
			if(n.right != null) queue.add(n.right);//put right node first for right view,
			      								   // since we are printing only first node of each level.
			if(n.left != null) queue.add(n.left);
			
		 }
		  
	  }
	  
  }
  public static void leftViewRecursive(Node root) {
	  TreeMap <Integer, Integer> hm = new TreeMap<Integer, Integer>(
//			   new Comparator<Integer>() {
//				   @Override
//				   public int compare(Integer n1, Integer n2) {
//					   return n1.compareTo(n2);//to print element from 
//				   }
//			   }
			  );
	  leftView(root, 1 , hm);
	  Set<Integer> keys = hm.keySet();
	  for( Integer key : keys) {
		  System.out.println(hm.get(key));
	  }
  }
  private static void leftView(Node n ,int level ,TreeMap <Integer, Integer> hm ) {
	  if(n == null) return;
	  if(!hm.containsKey(level)) {
		  hm.put(level, n.data);
	  }
	  leftView(n.left , level+1,hm);
	  leftView(n.right , level+1,hm);
  }
  public static void rightViewRecursive(Node root) {
	  TreeMap <Integer, Integer> hm = new TreeMap<Integer, Integer>(
//			   new Comparator<Integer>() {
//				   @Override
//				   public int compare(Integer n1, Integer n2) {
//					   return n1.compareTo(n2);//to print element from 
//				   }
//			   }
			  );
	  leftView(root, 1 , hm);
	  Set<Integer> keys = hm.keySet();
	  for( Integer key : keys) {
		  System.out.println(hm.get(key));
	  }
  }
  private static void rightView(Node n ,int level ,TreeMap <Integer, Integer> hm ) {
	  if(n == null) return;
	  if(!hm.containsKey(level)) {
		  hm.put(level, n.data);
	  }
	  leftView(n.right , level+1,hm);
	  leftView(n.left , level+1,hm);
	 
  }
  
  
  public static void outerview(Node root) {
	  
  }
  
  /*
   * We can customised  level order traversal using a queue here main
   * idea is if it's even row (level) print left to right and if it's odd row( level) print right to left
   * Use a queue.
   * When printing element from left to right : 
   * 1. Pop from front  of the queue
   * 2. print element 
   * 3. add all child node of popped one's to end of the queue.
   * 
   * When printing element from right to left:
   * 1. Pop from end of  the queue.
   * 2. Print element.
   * 3. Add child element to the first (front ) of the queue.
   * 
   */
  public static void spiralView(Node root) {
	  if(root == null) return;
	  
	  Deque <Node> queue = new ArrayDeque<Node>();
	  boolean flag = true;
	  queue.add(root);
	  while(!queue.isEmpty()) {
		  int size = queue.size();
		  if(flag) {//print element from left to right of current level
			int i = 0;
			while(i++ < size) {
				Node n = queue.removeFirst();
				System.out.print(n.data+"\t");
				if(n.left != null) queue.addLast(n.left);
				if(n.right != null) queue.addLast(n.right);
			}
			System.out.println();
		  }
		  else {//print element from right to left of current level
				int i = 0;
				while(i++ < size) {
					Node n = queue.removeLast();
					System.out.print(n.data+"\t");
					if(n.left != null) queue.addFirst(n.left);
					if(n.right != null) queue.addFirst(n.right);
				}
				System.out.println();
			  }
		  flag = !flag; // trip the flag
	  }
    }
  
  /*
   * Diagonal view of BTree
   * Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		     /      /  \
		    /      /    \
		   4      5      6
		         / \
		        /   \
		       7     8
	    
	   Output: 1,3,6  2,5,8  4,7 

   */
  
  public static void diagonalView(Node root) {
	  if(root == null) {
		  return ;
	  }
	  Deque <Node> queue = new ArrayDeque();
	  while(root != null) {
		  queue.add(root);
		  root = root.right;
	  }
	// create a sentinel (dummy) node to denote end of a diagonal
	Node sentinel = new Node(-1);
	queue.add(sentinel);
	  while(queue.size() != 1) {
		  Node n = queue.poll();
		  if(n != sentinel) {
			  System.out.print(n.data+"\t");
			  Node left = n.left;
			  while(left != null) {
				  queue.add(left);
				  left = left.right;
			  }
		  }else {
			  queue.add(sentinel);
			  System.out.println();
		  }
		   
	  }
  }
}
