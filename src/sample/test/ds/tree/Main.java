package sample.test.ds.tree;

import java.util.ArrayList;
import java.util.List;

import sample.test.top25geeks.Node;

public class Main {
    final List list;
    Main(){
    	list = new ArrayList();
    }
	public static void main(String[] args) {
       
		BinaryTree btree = new BinaryTree();
		btree.add(20);
		btree.add(10);
		btree.add(40);
		btree.add(50);
		btree.add(5);
		btree.add(12);
		btree.add(45);
		btree.add(48);
		//btree.add(50);
		System.out.println("\n\n Pre-Order traversal");
		btree.preOrderTraverse();
		System.out.println("\n\n In Order traversal");
		btree.inOrderTraverse();
		
		System.out.println("\n\n Post Order traversal");
		btree.postOrderTraverse();
		
		Node root  = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		 btree = new BinaryTree(root);
		 System.out.println("Level traversal");
		 btree.levelTraversal();
		 System.out.println("***Vertical Order Traversal\n ***");
		 btree.verticalOrder();
		 
		 System.out.println("***Top View of BTree\n ***");
		 btree.topView();
		 System.out.println("InOrder traversal without Recurrsion");
		 btree = new BinaryTree();
		 btree.add(3);
		 btree.add(4);
		 btree.add(5);
		 btree.add(1);
		 btree.add(2);
		 btree.add(6);
		 btree.add(7);
		 btree.inOrderWithStack();
		 
		 btree = new BinaryTree(root);
		 System.out.println("Left View of BinaryTree");
		 btree.leftView();
		 
		 /*
		  * Create input like below 
		  * Input :
	        1
	      /   \
	    2       3
	      \   
	        4  
	          \
	            5
	             \
	               6
		  */
		 
		    root  = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.right = new Node(4);
			root.left.right.right = new Node(5);
			root.left.right.right.right = new Node(6);
			//root.right.right = new Node(7);
			
			 btree = new BinaryTree(root);
			 System.out.println("Left View of BinaryTree");
			 btree.leftView();
			 
			 System.out.println("\nHeight of the tree");
			 System.out.println(btree.height()); 
			 
			 System.out.println("\nHeight of the Node 2");
			 System.out.println(btree.heightOfTheNode(root.left));
			 System.out.println("\nHeight of the Node 3");
			 System.out.println(btree.heightOfTheNode(root.right));
			 /*
			  * Create input like below 
			  * Input :
			        10
			      /   \
			    20       30
			            /
			           (40)
		    *Output:10 ,20 ,40
		    */
			 
			 root  = new Node(10);
			 root.left = new Node(20);
			 root.right = new Node(30);
			 root.right.left = new Node(40);
			 btree = new BinaryTree(root);
			 System.out.println("Left View of BinaryTree");
			 btree.leftView();
			 System.out.println("\nHeight of the tree");
			 System.out.println(btree.height()); 
	}
	

}
