package sample.test.problems.linkedLists;

public class FindNthtoLastElement {

	/**
	 * Implement an algorithm to find the nth to last element of a singly linked list.
	 * @param <T>
	 */

	public <T> Node<T> findNthFromLast(Node <T> inputList ,int nth){
		Node <T> nthNode = inputList;
		Node <T> lastNode = inputList;
		if(inputList == null) return null;
		int i =1 ;
		while(i <= nth){
			lastNode = lastNode.next;
			i++;
		}
		while(lastNode !=null){
			lastNode = lastNode.next;
			nthNode  = nthNode.next;
		}
		
		return nthNode;
		
	}

}
