package sample.test.top25geeks;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 			      (1)
		    	/    \ 
		   	(2)       (3)
		   /   \      /   \ 
		(4)    (5)   (6)   (7)
		
		LCA(4,5) = 2
		LCA(4,6) = 1
		LCA(3,4) = 1
 *  
 *  
 *  
 */
public class LowestCommonAncestorInBTree {
	 static List<Node> path1 = new ArrayList<>(); 
	static   List<Node> path2 = new ArrayList<>(); 
	public static void main(String[] args) {
		
		Node root  = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node head = root;
		
		Node lca = LCA(head,4,6);
		System.out.println("LCA ="+lca.value);
		
		lca = LCA(head,4,5);
		System.out.println("LCA ="+lca.value);
		lca = LCA(head,4,3);
		System.out.println("LCA ="+lca.value);

	}

//	private  static class Node{
//		Integer value;
//		Node left;
//		Node right;
//		 Node(Integer data){
//			 this.value = data;
//		 }
//	}
	private static Node LCA(Node r , Integer n1 , Integer n2) {
		return findLCA( r , new Node(n1) , new Node( n2));
	}
	private static Node findLCA(Node r , Node n1 , Node n2) {
		path1.clear();
		path2.clear();
		  findPath(r,n1,path1);
		  findPath(r,n2,path2);
//		  if(!findPath(r,n1,path1) && !findPath(r,n2,path2)) {
//			  System.out.println("Given Node does not exist in tree");
//			  return null;
//		  }
		  int i=0;
		  for( i=0 ; i < path1.size() && i<path2.size() ; i++ ) {
			  if(!path1.get(i).value.equals(path2.get(i).value)) {
				  break;
			  }
		  }
		  
		return path1.get(i-1);
		
	}
	private static boolean findPath(Node root , Node n,List<Node> path) {
		// base case 
        if (root == null) { 
            return false; 
        } 
        path.add(root);
        if(root.value == n.value) {
        	return true;
        }
        
        if(root.left != null && findPath(root.left , n , path)) {
        	return true;
        }
        if(root.right != null && findPath(root.right , n , path)) {
        	return true;
        }
     // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        path.remove(path.size()-1); 
  
        return false; 
        
	}
	
	
}
