package designguru.binarytree.dfs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class DFSProblems {

	public static void main(String[] args) {
		 /* Constructed binary tree is
        10
       /  \
     8     2
    / \   /
   3   5 1
  */
  Node root = new Node(10);
  root.left = new Node(8);
  root.right = new Node(2);
  root.left.left = new Node(3);
  root.left.right = new Node(5);
  root.right.left = new Node(11);
   System.out.println(isPath_SumExist(root,23));
   LinkedList < Integer> path = new LinkedList<>();
   allPaths_for_a_Sum(root,23,path);
   System.out.println("pathSum\n "+pathSum(root,23));
   root = new Node(4);
   root.left = new Node(9);
   root.right = new Node(0);
   
   root.left.left = new Node(5);
   root.left.right = new Node(1);
   
   System.out.println(sumNumbers(root));
   
   root = new Node(1);
   root.left = new Node(2);
   root.right = new Node(3);
   root.left.right = new Node(4);
   root.right.left = new Node(5);
   root.right.right = new Node(6);
   root.right.left.left = new Node(7);
   root.right.left.right = new Node(8);
   System.out.println("\n getDiameter \n ");
  System.out.println("diameter ="+getDiameter( root)); 
  
		   //buildTree("10,5,-3,3,2,null,11,3,-2,null,1");
   Node n =  new Node(10);
   n.left = new Node(5);
   n.right = new Node(-3);
   
   n.left.left = new Node(3);
   n.left.right = new Node(2);
   n.right.left = null;
   n.right.right = new Node(11);
   
   n.left.left.left = new Node(3);
   n.left.left.right = new Node(-2);
   
   n.left.right.left = null;
   n.left.right.right = new Node(1);
   System.out.println("pathSum_subPath(n,8)");
   System.out.println(pathSum_subPath(n,8));
  
 }
public static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(",");
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

	
	/*
	 * Problem 1: Binary Tree Path Sum
	 * designgurus.io/course-play/grokking-the-coding-interview/doc/6399d2d989924acc4bea0939
	 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
	 */
	
	public static boolean isPath_SumExist(Node root, int target) {
		
		if(root == null || target < 0 ) return false;
		target = target - root.data;
		if( target == 0 && isLeaf(root) ) return true;
		boolean left =  isPath_SumExist(root.left,target) ;
		boolean right =  isPath_SumExist(root.right,target);
		if(left || right ) return true;
		return false;
			
	}
     private static boolean isLeaf(Node n) {
    	 return n != null && n.left == null && n.right == null;
     }
     
     /*
      * Problem 2: All Paths for a Sum
      * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6399d2d989924acc4bea0939
      */
     public static void allPaths_for_a_Sum(Node root, int target, LinkedList <Integer> path) {
    	 
    	 if(root == null || target < 0 ) return ;
 		target = target - root.data;
 		path.add(root.data);
 		if( target == 0 && isLeaf(root) ) {
 			System.out.println(path);
 		}
 		allPaths_for_a_Sum(root.left,target,path) ;
 		allPaths_for_a_Sum(root.right,target,path);
 		//target = target + root.data;
 		path.removeLast();
     }
     
     /*
      * https://leetcode.com/problems/sum-root-to-leaf-numbers/
      * 
      */
     public static int sumNumbers(Node root) {
    	 AtomicInteger sum = new AtomicInteger();
    	 StringBuffer sb = new StringBuffer();
    	 sumToRootNumbers(root, sb, sum);
    	 return sum.get();
     }
     private static void sumToRootNumbers(Node root,StringBuffer number, AtomicInteger totalSum) {
         if(root  == null ) return;
         number.append(""+root.data);
         if(isLeaf(root)){
             int n = Integer.parseInt(number.toString());
             totalSum.set(totalSum.get()+n);
         }
         sumToRootNumbers(root.left,number,totalSum);
         sumToRootNumbers(root.right,number,totalSum);
         number.deleteCharAt(number.length()-1);
     }
     
     // https://leetcode.com/problems/path-sum-ii/
     
     public static LinkedList<LinkedList<Integer>> pathSum(Node root, int targetSum) {
    	 LinkedList<LinkedList<Integer>> result = new LinkedList < LinkedList<Integer>>();
    	 LinkedList < Integer> path = new  LinkedList < Integer> ();
    	 sum_To_a_Number(root,targetSum,path, result);
    	 return result;
     }
     private static void sum_To_a_Number(Node root,int target, LinkedList < Integer> path, LinkedList<LinkedList<Integer>> result) {
    	 
    	 if(root == null || target < 0 ) return ;
 		target = target - root.data;
 		path.add(root.data);
 		if( target == 0 && isLeaf(root) ) {
 		  result.add(new LinkedList<Integer>(path));
 		}
 		sum_To_a_Number(root.left,target,path,result) ;
 		sum_To_a_Number(root.right,target,path,result);
 		//target = target + root.data;
 		path.removeLast();
     }
     
     /*
      * https://leetcode.com/problems/path-sum-iii/
      */
     public static int pathSum_subPath(Node root, int targetSum) {
         
    	 LinkedList <Integer> path = new LinkedList<>();
    	 AtomicInteger result = new AtomicInteger();
    	 HashSet <String> visited = new HashSet<>();
    	 sum_To_a_Number1(root, targetSum, path, result,visited);
    	 return result.get();
     }
 private static void sum_To_a_Number1(Node root,int target, LinkedList < Integer> path,AtomicInteger result,Set <String> visited) {
	if(root == null ) return ;
	path.add(root.data);
	
	if(isLeaf(root) && isSumExist(path,target,visited)) {
		System.out.println(path);
		result.set(result.get()+1);
	}
	sum_To_a_Number1(root.left,target,path,result,visited) ;
	sum_To_a_Number1(root.right,target,path,result,visited);
	//target = target + root.data;
	path.removeLast();
     }

	private static boolean isSumExist(LinkedList<Integer> path,int target,Set < String> visited) {
		if(path == null || path.size() < 1) return false;
		int sum_so_far = 0;
		int s =0;
		String sb = new String();
		for(int i = 0 ; i < path.size(); i++) {
			sum_so_far += path.get(i);
			sb = sb + ""+path.get(i);
			if(sum_so_far == target ) {
				//System.out.println(visited +" sb ="+sb +"visited.contains(sb)"+visited.contains(sb));
				if(visited.contains(sb)) {
					return false;
				}
				
				visited.add(sb);
				return true;
			}
			if(sum_so_far > target) {
				sum_so_far = sum_so_far - path.get(s);
				sb = sb.substring(1,sb.length());
				s = s+1;
			}
		}
		
		return false;
	}
	
	public static int getDiameter(Node root) {
		AtomicInteger diameter = new AtomicInteger();
		calculateDiameter(root,diameter);
		return diameter.get();
	}
	private  static int calculateDiameter(Node node ,AtomicInteger diameter ) {
		if(node == null ) return 0;
		int left_diam = calculateDiameter(node.left, diameter);
		int right_diam = calculateDiameter(node.right, diameter);
		int max_diameter = left_diam + right_diam +1;
		diameter.set(Math.max(diameter.get(), max_diameter));
		
		//it is important to return the height of subtree rooted at current node.
		 return Math.max(left_diam, right_diam)  +1;
		
	}
}

 class Node {

	Node left;
	Node right;
	int data;
	Node(int d){
		this.data = d;
	}
	
	@Override
	public String toString() {
		return ""+this.data;
	}
}

