package practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class TreePractice {

	public static void main(String[] args) {
		 // construct the first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
 
        // construct the second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);
 
        if (isIdentical(x, y)) {
            System.out.println("The given binary trees are identical");
        }
        else {
            System.out.println("The given binary trees are not identical");
        }
        
        x.right.right.left = new Node(28);
        System.out.println("height ="+height(x));
        
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        zigzackTraversal(root);
        
        
        
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        
        bottomView(root);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        topView(root);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
       // root.right.right.right = new Node(7); should return false
 
        
        System.out.println("isCompleteTree ="+isCompleteTree(root));
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("nextNodeSameLevel="+nextNodeSameLevel(root,root.left));
 
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        sumTree(root);
        System.out.println("After converting sumtree");
        preorder(root);
        
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isCousines(root, root.left.right, root.right.left)) {
            System.out.println("\nNodes are cousins of each other");
        }
        else {
            System.out.println("\nNodes are not cousins of each other");
        }
        
        root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.println("Binary tree is a sum tree");
        }
        else {
            System.out.println("Binary tree is not a sum tree");
        }
        AtomicBoolean isSum = new AtomicBoolean(true);
        isSumTree2(root,isSum);
        if (isSum.get()) {
            System.out.println("Binary tree is a sum tree 2");
        }
        else {
            System.out.println("Binary tree is not a sum tree ");
        }
	}
	
	public static int isSumTree2(Node root,AtomicBoolean isSumTree) {
		if(root == null ) return 0;
		//special case
		if(root.left == null && root.right == null) return root.val;
		
		int left = isSumTree(root.left);
		int right = isSumTree(root.right);
		if(root.val != left+right) {
			isSumTree.set(false);
		}
		return 2*root.val;
		
	}
	public static int isSumTree(Node root) {
		if(root == null ) return 0;
		//special case
		if(root.left == null && root.right == null) return root.val;
		
		int left = isSumTree(root.left);
		int right = isSumTree(root.right);
		if(left != Integer.MIN_VALUE && right != Integer.MIN_VALUE && root.val == (left+right)) return 2*root.val;
		else return Integer.MIN_VALUE;
	}
	public static boolean isCousines(Node root, Node first, Node second) {
		CNode [] cousions = new CNode[2];
		cousions[0] = null;
		cousions[1] = null;
		postorder3(root,null,first,second,cousions,1);
		if(cousions[0] == null || cousions[1] == null) return false;
		if(cousions[0].level == cousions[1].level && cousions[0].parent != cousions[1].parent ) return true;
		return false;
		
	}
	private static void postorder3(Node root,Node parent, Node first, Node second,CNode[] cousions,int level) {
		if(root == null) return ;
		if(root == first) {
			CNode cn =  new CNode();
			cn.level = level;
			cn.n = root;
			cn.parent = parent;
			cousions[0] = cn;
		}
		else if(root == second) {
			CNode cn =  new CNode();
			cn.level = level;
			cn.n = root;
			cn.parent = parent;
            cousions[1] = cn;
		}
		postorder3(root.left,root,first,second,cousions,level+1);
		postorder3(root.right,root,first,second,cousions,level+1);
	}
	
	
	// Function to print preorder traversal of a given tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
	public static void sumTree(Node root) {
		postorder(root);
	}
	
	private static int postorder(Node root) {
		if(root == null) return 0;
		int data = root.val;
		root.val = postorder(root.left) + postorder(root.right);
		return data+ root.val;
	}
	public static Node nextNodeSameLevel(Node root, Node n) {
		
		ArrayDeque <Node> q = new ArrayDeque<>();
		q.add(root);
		Node front;
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-- > 0) {
				front = q.poll();
				if(front == n) {
					if( size > 0) return q.peek();
					else return null;
				}
				if(front.left != null) q.add(front.left);
				if(front.right != null) q.add(front.right);
			}
		}
		 return null;
	}

	public static boolean isCompleteTree(Node root) {
		if(root == null) return false;
		ArrayDeque <Node> q = new ArrayDeque<>();
		q.add(root);
		boolean flag = false;//flag to mark the end of full node.
		Node front;
		while(!q.isEmpty()) {
			
			int size = q.size();
			while(size-- > 0) {
				front = q.poll();
				if(flag && (front.left !=null || front.right  != null) ) return false;
				
				if(front.left == null && front.right != null) return false;
				
				if(front.left != null) q.add(front.left);
				else flag = true;
				
				if(front.right != null) q.add(front.right);
				else flag = true;
			}
		}
		return true;
		 
	}
 public static void zigzackTraversal(Node root) {
	 ArrayDeque <Node> q = new ArrayDeque<>();
	 boolean left = true;
	 q.add(root);
	 while(!q.isEmpty()) {
		 int size = q.size();
		 while(size-- > 0) {
			
			 if(left) {
				 Node n = q.pollFirst();
				 System.out.print(n.val+"\t ");
				 if(n.left != null) q.addLast(n.left);
				 if(n.right != null) q.addLast(n.right);
				
				 
			 }else {
				 Node n = q.pollLast();
				 System.out.print(n.val+"\t ");
				 if(n.right != null) q.addFirst(n.right);
				 if(n.left != null) q.addFirst(n.left);
				 
				 
				 
				
				 
			 }
		 }
		 left = !left;
		 System.out.println();
	 }
 }
  public static int height(Node root) {
	  if(root == null) return 0;
	  int l = height(root.left);
	  int r = height(root.right);
	  return 1 + Math.max(l, r);
  }
   public static boolean isIdentical(Node t1, Node t2) {
	   if(t1 == null || t2 == null) return t1 == t2;
	   return t1.val == t2.val && isIdentical(t1.left,t2.left) && isIdentical(t1.right,t2.right);
   }
   public static void topView(Node root) {
	   Map<Integer,Pair> map = new HashMap<>();
	   preorder2(root, 0,1,map);
	   System.out.println("TopView ");
	   
	   for(Pair p : map.values()) {
		   System.out.println(p.val);
	   }
	   
   }
   static void preorder2(Node root, int dist, int level,Map<Integer,Pair> map ) {
	   if(root == null) return ;
	   if(map.containsKey(dist)) {
		   if(map.get(dist).level >= level) map.put(dist, new Pair(root.val,level));
      }else {
	   map.put(dist, new Pair(root.val,level));
    }
	
	   preorder2(root.left, dist-1,level+1,map);
	   preorder2(root.right, dist+1,level+1,map);

}
   public static void bottomView(Node root) {
	   Map<Integer,Pair> map = new HashMap<>();
	   preorder(root, 0,1,map);
	   System.out.println("bottomView ");
	   
	   for(Pair p : map.values()) {
		   System.out.println(p.val);
	   }
	   
   }
    static void preorder(Node root, int dist, int level,Map<Integer,Pair> map ) {
	   if(root == null) return ;
	   if(map.containsKey(dist)) {
		   if(map.get(dist).level <= level) map.put(dist, new Pair(root.val,level));
      }else {
	   map.put(dist, new Pair(root.val,level));
    }
	
	   preorder(root.left, dist-1,level+1,map);
	   preorder(root.right, dist+1,level+1,map);

}
    
}
class Pair{
	int val;
	int level;
	Pair(int v,int l){
		this.val = v;
		this.level = l;
	}
}
class Node{
	int val;
	Node left, right;
	Node(int v){
		val =v;
	}
	
	@Override 
	public String toString() {
		return ""+this.val;
	}
	
}

class CNode{
	Node n;
	Node parent;
	int level;
}