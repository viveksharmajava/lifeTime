package sample.test.ds.tree;

public class BinaryTree
//I shoud use comparable
{
	
	Node root;
	
	private  class Node{
		Integer value;
		Node left;
		Node right;
		 Node(Integer data){
			 this.value = data;
		 }
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
	 System.out.println(temp.value);
	 preOrder(temp.left);
	 preOrder(temp.right);
 }
  private void inOrder(Node temp){
	 if(temp == null ){
	  return;
	 }
	
	 preOrder(temp.left);
	  System.out.println(temp.value);
	 preOrder(temp.right);
 }
 
  private void postOrder(Node temp){
		 if(temp == null ){
		  return;
		 }
		
		 postOrder(temp.left);
		 preOrder(temp.right);
		 System.out.println(temp.value);
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

}
