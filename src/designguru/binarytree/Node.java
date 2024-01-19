package designguru.binarytree;

public class Node {

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
