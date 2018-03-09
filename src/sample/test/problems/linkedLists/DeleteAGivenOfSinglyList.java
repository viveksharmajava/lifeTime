package sample.test.problems.linkedLists;

public class DeleteAGivenOfSinglyList {

	/**
	 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
	 * @param <T>
	 */
	
	public <T> boolean deleteGivenNode(Node<T> n ){
		    if (n == null || n.next == null) {
			 return false; // Failure
			 }
		    
		    Node <T> next = n.next;
		    n.data = next.data;
		    n.next = next.next;
		    return true;
		
	}

}
