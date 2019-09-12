package sample.test.problems.linkedLists;


import sample.test.collection.FindLoopInList;

public class TestCustomList {

	/**
	 * @param args test custom LinkedList written by vivek
	 */
	public static void main(String[] args) {

		Node<Integer> node = null;
		Node <Integer> head = null;
		Node <Integer> fourthNode = null;
		Node <Integer> headForDeleteNode = null;
		     
		int i=1;
		while(i<=10){
			 if(node == null){

				 node = new Node<Integer>(5);
			     head = node;
			 }
			 else{
				Node <Integer> newNode = new Node<Integer>(i);
				node.next = newNode;
				node = newNode;
			 }
			 if(i==4){
				 fourthNode = node;
				 headForDeleteNode = head;
			 }
			i++;
		}
		
		
		
		Node <Integer> thisWillcreateLoop  = node; //add thisWillcreateLoop-->next = fourthNode; to create loop
		System.out.println("before removing duplicate");
		node = head;
		while(node != null){
			System.out.print(node.data+" ");
			node =node.next;
		}
		RemoveDuplicateFromList rd = new RemoveDuplicateFromList();
		//head = rd.removeDuplicateUsingHashMap(head);
		head = rd.removeDuplicateUsingHashMap(head);
		System.out.println("\nAfter removing duplicate");
		node = head;
		while(node != null){
			System.out.print(node.data+" ");
			node =node.next;
		}
		
	//Find nth node from last
		FindNthtoLastElement find = new  FindNthtoLastElement();
		Node <Integer> nth  = find.findNthFromLast(head, 3);
		System.out.println("\n nth from last ="+nth.data);
		
		//Delete a node from the list 
		System.out.println("\n Node before delete ="+fourthNode.data);
		System.out.println("\n Before delete Fourth Node list");
		node = headForDeleteNode;
		while(node != null){
			System.out.print(node.data+" ");
			node =node.next;
		}
		DeleteAGivenOfSinglyList delete = new DeleteAGivenOfSinglyList();
		delete.deleteGivenNode(fourthNode);
		System.out.println("\nAfter delete Fourth Node list");
		node = headForDeleteNode;
		while(node != null){
			System.out.print(node.data+" ");
			node =node.next;
		}
		
	//Find middle element of list in one scan
		
		FindMiddleElementInListInOnePass middle = new FindMiddleElementInListInOnePass();
		Node <Integer> mid = middle.middleNode(head);
		System.out.println("\n middle ="+mid.data);

		/// Find loop in linked list 
		//first create loop 
		thisWillcreateLoop.next = fourthNode;
		FindTheLoopInCircularList findLoop  = new  FindTheLoopInCircularList();
		Node<Integer> looped = findLoop.findLoop(headForDeleteNode);
		System.out.println("looped ="+looped.data);
		
		
		//Find the some of the 2 list 
		Node<Integer> node2 = null;
		Node <Integer> head2 = null;
		i=1;
		while(i<=3){
			 if(node == null){

				 node = new Node<Integer>(i+4);
			     head = node;
			 }
			 else{
				Node <Integer> newNode = new Node<Integer>(i+4);
				node.next = newNode;
				node = newNode;
			 }
			i++;
		}
		i=4;
		while(i<7){
			 if(node2 == null){

				 node2 = new Node<Integer>(i+3);
			     head2 = node2;
			 }
			 else{
				Node <Integer> newNode = new Node<Integer>(i+3);
				node2.next = newNode;
				node2 = newNode;
			 }
			i++;
		}
		
		System.out.println("SumOf2NumbersStoredin2List");
		Node<Integer> addedList = SumOf2NumbersStoredin2List.sumOfTwoList(head, head2);
		while(addedList!=null) {
			System.out.print(addedList.data);
			addedList = addedList.next;
		}
	}
	
	


}
