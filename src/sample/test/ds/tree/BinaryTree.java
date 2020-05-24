package sample.test.ds.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import sample.test.top25geeks.Node;

public class BinaryTree
//I shoud use comparable
{
	
	Node root;
	
//	private  class Node implements Comparable{
//		Integer value;
//		Node left;
//		Node right;
//		 Node(Integer data){
//			 this.value = data;
//		 }
//		@Override
//		public int compareTo(Object o) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//	}
//	
	public BinaryTree() {
		
	}
	public BinaryTree(Node root) { //you can use this method to create binary tree not binary search tree.
		this.root =root;
	}
	
	public void add(Integer data){
		
		Node node = new Node(data);
		if(root == null) root = node;
		else{
			
			Node temp = root;
			while(temp != null){
				if(temp.value < node.value && temp.right != null){
					temp = temp.right;
				}
				else if(temp.value < data && temp.right == null){
					temp.right = node;
					return;
				}
				else if (temp.value >= data && temp.left != null){
					temp = temp.left;
				}
				else if (temp.value >= data && temp.left == null){
					temp.left = node;
					return;
				}
			}
		}
	}
	
 private void preOrder(Node temp){
	 if(temp == null ) return;
	 System.out.print(temp.value+"  ");
	 preOrder(temp.left);
	 preOrder(temp.right);
 }
  private void inOrder(Node temp){
//	 if(temp.left == null ){
//	 System.out.print(temp.value+"  ");
//	  //return;
//	 }
//	 if(temp.left != null)
//	 {
//		 inOrder(temp.left);
//		 System.out.print(temp.value+" ");
//	 }
//	 if(temp.right != null)inOrder(temp.right);
	  
	  // other best way
	  if(temp == null) return ;
	  inOrder(temp.left);
	  System.out.print(temp.value+"  ");
	  inOrder(temp.left);
	  inOrder(temp.right);
	 
 }
//Postorder (Left, Right, Root)
  private void postOrder(Node temp){
		 if(temp == null ){
		  return;
		 }
		
		 postOrder(temp.left);
		 preOrder(temp.right);
		 System.out.print(temp.value+"  ");
	 }
  
   /*
    * Root Left right
    */
   public void preOrderTraverse(){
	  Node temp = root;
	  preOrder(temp);
	
	 
	}
  
   /*  Left Root right
    * Process root
    * Process left
    * Process right
    * 
    */
   public void inOrderTraverse(){
	   Node temp = root;
		  inOrder(temp);
	}
   //Postorder (Left, Right, Root)
   public void postOrderTraverse(){
	   
	   Node temp = root;
	   postOrder(temp);
		
	}
   
   /*Level traversal or BFS Tree
    * 			 (1)
		    	/    \ 
		   	(2)       (3)
		   /   \      /   \ 
		(4)    (5)   (6)   (7)
		
	Result : 1,2,3,4,5,6,7	
    */
   
   public void levelTraversal() {
	   
	  ArrayList<Node> arr = new ArrayList<Node>();
	 
//	   this.root  = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
	   Node temp = root;
	   while(temp != null) {
		 System.out.print(temp.value+" ");
		 if(temp.left != null) {
			 arr.add(arr.size(),temp.left);
		 }
		 if(temp.right != null) {
			 arr.add(arr.size(),temp.right);
		 }
		 if(arr.size()==0) return;
		 
		 temp = arr.remove(0);
	   }
 }
 /*
  * Algo :
  * 1. create an empty stack S.
  * 2. Initialize current_node as root.
  * 3. Push the current_node to stack S and set current_node = current_node->left
  * 4.If current_node == NIL and S != NIL
  *   (a) Pop the top element from stack into popped_item
  *   (b) print the popped_item and  set current_node =  popped_item->right
  *   (c) go to step 3
  * 5. If current_node == NIL and S == NIL , EXIT 
  */
 public void inOrderWithStack() {
	java.util.Stack <Node> stack = new java.util.Stack<Node>();
	Node current_node = root,popped_node = null;
	stack.add(current_node);
	current_node = current_node.left;
	while(current_node != null || !stack.isEmpty()) {
		if(current_node != null && current_node != root)
			{
			stack.add(current_node);
			current_node = current_node.left;
			}
		
		if(current_node == null) {
			popped_node = stack.remove(stack.size()-1);
			System.out.print(popped_node.value+" ");
			current_node = popped_node.right;
		}
	}
  }
 
/*
 * Left view of Binary Tree 
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/
 * Input : 
                 1
               /   \
              2     3
             / \     \
            4   5     6             

   Output : 1 2 4

Input :
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6

 Output :1 2 4 5 6
 */
 public void leftView() {
	 Node node = this.root;
	 leftViewOfTree(node,1);
	 max_level = 0;
 }
 private static int max_level = 0; // it will be used to make sure whether right node  will be visible or not.
 public void leftViewOfTree(Node node, int level) {
	 
	 if(node == null) return;
	 
	  if(max_level < level) {
		System.out.print(node.value+" ");
		max_level = level;
	  }
	  leftViewOfTree(node.left, level+1);
	  leftViewOfTree(node.right, level+1);
 }
 
 /*
  * Top view of Binary tree
  * 
  * refer to vertical traversal  in the below example node 5,6 should not be printed for
  * top view.
  * 
  * Approach: 
  *  call vertical-traversal
  *  if any vertical has 1+ node remove other node.
  *  print the result.
  */
 
 public void topView() {
	 TreeMap<Integer,ArrayList>  ht  = new TreeMap<Integer,ArrayList>();
		
		Node temp = this.root;
		vertical(temp, 0 , ht);
		Set<Integer> i = ht.keySet();
	    for (int keys : i) {
	        System.out.print(ht.get(keys).get(0)+" ");
	    }
		
 }
 
 
 
 
 /*
  *  			 (1)
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
 public void verticalOrder() {
	TreeMap<Integer,ArrayList>  ht  = new TreeMap<Integer,ArrayList>();
	
	Node temp = this.root;
	vertical(temp, 0 , ht);

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
 
 private void vertical(Node n , int level,TreeMap<Integer,ArrayList>  ht ) {
	 
	 if(n== null) return;
	 
	 if(ht.containsKey(level)) {
		 ArrayList a = ht.get(level);
		 a.add(n.value);
		 ht.put(level, a);
	 }else {
		 
		 ArrayList a  = new ArrayList();
		 a.add(n.value);
		 ht.put(level,a);
	 }
	 vertical(n.left,level+1,ht);
	 vertical(n.right,level-1,ht);
	 
 }
 /*
  *  complexity O(n) for binary tree or binary search tree
  *  O(logn) for AVL tree
  */
 public int height() {
	
	return calculateHeight(this.root);
 }
 private  int calculateHeight(Node node) {
	 if (node == null) return 0;
	 
	 return Math.max(calculateHeight(node.left), calculateHeight(node.right) )+ 1;
 }
 /*
  * Height of the Node n is the longest  to longest path from that node to leaf node.
  */
 public int heightOfTheNode(Node n) {
	 return calculateHeight(n);
 }
}