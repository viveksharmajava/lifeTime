package sample.test.ds.tree;

public class ConstructBSTGivenPreOrderArray {
	static class Node { 
		  
	    int data; 
	    Node left, right; 
	  
	    Node(int d) { 
	        data = d; 
	        left = right = null; 
	    } 
	} 
	  
	static class Index { 
	  
	    int index = 0; 
	} 
	  
	static class BinaryTree{
		Index index = new Index();
		
		
		  /**
		   * Method 1 ( O(n^2) time complexity )
		    The first element of preorder traversal is always root.
		   We first construct the root. 
		  Then we find the index of first element which is greater than root. 
		  Let the index be ‘i’.
		 The values between root and ‘i’ will be part of left subtree,
		  and the values between ‘i+1’ and ‘n-1’ will be part of right subtree. Divide given pre[] at index “i” and recur for left and right sub-trees.

		   For example in {10, 5, 1, 7, 40, 50}, 
		    10 is the first element, so we make it root.
		     Now we look for the first element greater than 10, we find 40. So we know the structure of BST is as following.
		     
		     Time Complexity: O(n^2)
		   */


		Node constructTreeUtil(int [] pre , Index preIndex , int low ,int high, int size) {
		
			//Base case
			if(preIndex.index > size || low > high) return null;
			
			//first node in preorder traversal is a root node.
			 Node root = new Node(pre[preIndex.index]);
			 preIndex.index = preIndex.index + 1;
			 if (low == high) return root;	
			 
			//find the first larger/bigger element than the root element 
			int i ;
			for (i = low; i <= high; ++i) { 
	            if (pre[i] > root.data) { 
	                break; 
	            } 
	        }
			
			// Use the index of element found in preorder to divide  
	        // preorder array in two parts. Left subtree and right subtree 
	        
			root.left = constructTreeUtil(pre, preIndex, preIndex.index, i-1, size);
			root.right = constructTreeUtil(pre, preIndex, i, high, size);
			return root;
			 
		}
		
		Node constructTree(int [] pre , int size) {
			return constructTreeUtil(pre, index, 0, size-1, size);
		}
		// A utility function to print inorder traversal of a Binary Tree 
		    void printInorder(Node node) { 
		        if (node == null) { 
		            return; 
		        } 
		        printInorder(node.left); 
		        System.out.print(node.data + " "); 
		        printInorder(node.right); 
		    } 
		    
	/**
	 * Method 2 ( O(n) time complexity )
      The idea used here is inspired from method 3 of this post. 
      The trick is to set a range {min .. max} for every node.
      Initialize the range as {INT_MIN .. INT_MAX}. 
      The first node will definitely be in range, 
       so create root node. To construct the left subtree,
       set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data},
        the values is part part of left subtree. To construct the right subtree, 
        set the range as {root->data..max .. INT_MAX}.	   
	 */
		    
	 Node improvedVersionUtil(int [] pre , Index preIndex,int key, int min , int max , int size) {
		if( preIndex.index >= size) return null;
		
		Node root = null;
		if( key > min && key < max) {
			
			root = new Node(key);
			preIndex.index = preIndex.index + 1;
			if(preIndex.index < size) {
				//Contruct the subtree under root 
                // All nodes which are in range {min .. key}  
                // will go in left subtree, and first such  
                // node will be root of left subtree. 
        
			  root.left = improvedVersionUtil(pre, preIndex, pre[preIndex.index] , min , key, size);
			// All nodes which are in range {key..max}  
              // will go in right subtree, and first such 
              // node will be root of right subtree. 
              root.right = improvedVersionUtil(pre, preIndex,  
                           pre[preIndex.index], key, max, size);
			  
			}
			
		}
		return root;
	 }
	 
	 Node improvedConstructTree(int [] pre , int size) {
			return improvedVersionUtil(pre,index,pre[0],Integer.MIN_VALUE,Integer.MAX_VALUE, size);
		}
		    
	}
	public static void main(String[] args) {
 		ConstructBSTGivenPreOrderArray.BinaryTree tree = new ConstructBSTGivenPreOrderArray.BinaryTree();
		int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
        int size = pre.length; 
        Node root = tree.constructTree(pre, size); 
        System.out.println("Inorder traversal of the constructed tree is "); 
        tree.printInorder(root);
        System.out.println("\n");
        root = tree.improvedConstructTree(pre, size); 
        System.out.println("Inorder traversal of the constructed tree is\n "); 
        tree.printInorder(root);
    } 

  
 
	}
	

