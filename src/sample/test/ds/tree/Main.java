package sample.test.ds.tree;

import java.util.ArrayList;
import java.util.List;

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
		
		btree.preOrderTraverse();
		System.out.println("\n\n In Order traversal");
		btree.inOrderTraverse();
		
		System.out.println("\n\n Post Order traversal");
		btree.postOrderTraverse();
	}

}
