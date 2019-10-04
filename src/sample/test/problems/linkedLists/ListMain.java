package sample.test.problems.linkedLists;

public class ListMain {

	public static void main(String[] args) {

		LinkedList <String> list = new LinkedList<String>();
		Node a = new Node<String>("a");
		Node b = new Node<String>("b");
		Node c = new Node<String>("c");
		//a.next =b;
		//b.next = c;
		
		
		list.add("a");
		list.add("b");
		list.add("c");
		//list.printAll();
//		list.remove("b");
//		System.out.println("after removing b");
//		list.printAll();
//		list.remove("c");
//		System.out.println("After removeing c");
//		list.printAll();
//		list.remove("a");
//		System.out.println("After removing a");
//		list.printAll();
		//list.removeGivenNode(b);
	//	System.out.println("after removing given node ");
	//	list.printAll();
		
		
		LinkedList <String> nodeList = new LinkedList<String>();
		 a = new Node<String>("a");
		 b = new Node<String>("b");
		 c = new Node<String>("c");
		nodeList.addNode(a);
		nodeList.addNode(b);
		System.out.println("Before removing any node ");
		nodeList.addNode(c);
		nodeList.printAll();
		nodeList.removeGivenNode(b);
		System.out.println("after removing given node ");
		nodeList.printAll();
		
		
	}

}
