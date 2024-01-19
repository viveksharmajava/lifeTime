package ds500problems.tree;

public class ProblemsOnBST {

	public static void main(String[] args) {
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
        
        isBST(root);
        swap(root);
        isBST(root);
	}
	private static void swap(Node root)
    {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
public static void isBST(Node root) {
	 if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
         System.out.println("The tree is a BST.");
     }
     else {
         System.out.println("The tree is not a BST!");
     }
	}

private static boolean isBST(Node node, int minValue, int maxValue) {
	//base case:
	if(node == null) return true;
	
	if(node.data < minValue || node.data > maxValue) return false;
	//recursive check with left and right subtree with and updated range
	
	return isBST(node.left,minValue,node.data) && isBST(node.right,node.data,maxValue);
}

//recusive function to insert key in bst
  private static Node insert(Node root , int key) {
	  
	  if( root == null) return new Node(key);
	  
	  if(key < root.data) root.left = insert(root.left , key);
	  else {
		  root.right = insert( root.right,key);
	  }
	  return root;
  }

}
//A class to store a BST node
class Node
{
 int data;
 Node left = null, right = null;

 Node(int data) {
     this.data = data;
 }
}