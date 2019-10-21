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
		
		
		LinkedList <Integer> beforesort = new LinkedList<Integer>();
		beforesort.add(30);
		beforesort.add(3);
		beforesort.add(10);
		beforesort.add(40);
		beforesort.add(40);
		System.out.println("Before mergeSort=");
		beforesort.printAll();
		
		SortListUsingMergeSort mergeSort = new SortListUsingMergeSort();
		
		Node <Integer> sortedHead = mergeSort.mergeSort(beforesort.getHead());
		LinkedList <Integer> afterSorting = new LinkedList <Integer>();
		afterSorting.addNode(sortedHead);
        
		System.out.println("AfterSorting Using mergeSort");
		afterSorting.printAll();
		
		RemoveDuplicateFromList remDuplicate = new RemoveDuplicateFromList();
		Node <Integer>  afterRemovingDuplicates = remDuplicate.removeDuplicateUsingHashMap(afterSorting.getHead());
		LinkedList <Integer> noDuplicate = new LinkedList <Integer>();
		
		noDuplicate.addNode(afterRemovingDuplicates);
		System.out.println("No Duplicate");
		noDuplicate.printAll();
		
		beforesort = new LinkedList<Integer>();
		//beforesort.add(30);
		beforesort.add(3);
		//beforesort.add(10);
		beforesort.add(40);
		beforesort.add(40);
		
		afterRemovingDuplicates = remDuplicate.removeDuplicateWithoudStorage(beforesort.getHead());
	    noDuplicate = new LinkedList <Integer>();
		noDuplicate.addNode(afterRemovingDuplicates);
		System.out.println("No Duplicate removeDuplicateWithoudStorage");
		noDuplicate.printAll();
		
		beforesort = new LinkedList<Integer>();
		//beforesort.add(30);
		beforesort.add(3);
		//beforesort.add(10);
		beforesort.add(40);
		beforesort.add(40);
		
		afterRemovingDuplicates = remDuplicate.removeAllOccurenceOfDuplicates(beforesort.getHead());
	    noDuplicate = new LinkedList <Integer>();
		noDuplicate.addNode(afterRemovingDuplicates);
		System.out.println("After Removing all occurence of Duplicate nodes");
		noDuplicate.printAll();
		
		
	}

}
