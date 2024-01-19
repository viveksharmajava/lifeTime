package ds500problems.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintKthSmallest {

	static int count = 0;
    // Recursive function to insert an key into BST
    public static Node insert(Node root, int x)
    {
        if (root == null)
            return new Node(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }
	public static void main(String[] args) {
		 Node root = null;
	        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
	      
	        for (int x : keys)
	            root = insert(root, x);
	         
	        int k = 3;
	        printKthSmallest(root, k);
	        Node kthLargest = kthLargest(root,new AtomicInteger(0),k);
	        if(kthLargest != null) {
	        	System.out.println("kth largest "+kthLargest.data);
	        }
	}
	 //Function to find k'th largest element in BST
	  public static void printKthSmallest(Node root, int k) {
		 count = 0;
		 Node res = kthSmalleset(root , k);
		 if (res == null)
	            System.out.println("There are less "
	                        + "than k nodes in the BST");
	        else
	            System.out.println("K-th Smallest"
	                    + " Element is " + res.data);
	 }
	private static Node kthSmalleset(Node root , int k) {
		if(root == null ) return null;
		
		// search to the left of bst 
		Node left =  kthSmalleset(root.left ,k);
		// if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;
        
        count++; //if current element is kth smallest return it.
        if(count == k) return root;
        
        //else search in the right sub-tree 
        return  kthSmalleset(root.right , k);
		
	}
	
	public static Node kthLargest(Node root , AtomicInteger i , int k) {
		if(root == null) return root;
		Node right = kthLargest(root.right,i,k);
		if(right != null)//kth element found in right
			return right;
		if(i.incrementAndGet() == k) return root;
		return kthLargest(root.left,i,k);
		
	}
}
