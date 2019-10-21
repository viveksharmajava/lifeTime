package sample.test.problems.linkedLists;

import java.util.HashMap;

public class RemoveDuplicateFromList {
	
	public <T> Node<T> removeDuplicateUsingHashMap(Node<T> input){
		Node<T> result= null;
		Node <T> first= null;
		HashMap <T ,Boolean> hm = new HashMap<T ,Boolean>();
		if(input == null)
		{
			return null;
		}
		while(input !=null){
			if(hm.containsKey(input.data)){
      		input = input.next;continue;
			}
			else{
				hm.put(input.data, true);
				Node <T> node = new Node<T>(input.data);
				if(result == null){
					first = result = node;
				}else {
					result.next = node;
					result =result.next;
				}
				input = input.next;
			}
			}
		
		return first;
	}
	
	//It is not a great solution. the worst case is O(n^2)
	public <T> Node<T> removeDuplicateWithoudStorage(Node<T> input){
		Node<T> result= null;
		Node <T> first= null;
		if(input == null)
		{
			return null;
		}
		while(input !=null){
			  boolean exist  = false;
				//Node <T> node = new Node<T>(input.data);
				if(result == null){
					first = result = input;
					//result.next = null;
				}else {
					//check node is already exist  in result 
					Node <T> findNode = first;
					while( findNode !=null ){
						if(findNode.data.equals(input.data)){
							exist =true;
							break;
						}
						findNode =findNode.next;
					}
					if(exist)
					{
						result.next = input.next;
						result = result.next;
					}
					
				}
				input = input.next;
		}
			
		return first;
	}
	
	public   <T> Node<T>  removeAllOccurenceOfDuplicates(Node<T> input){
		int approach = 2;
		/*
		 * Approach 1: put all node data and its count into map , rebuild the  list from map add only those node which data count is 1.
		 * Approach 2: If list is sorted then we can maintain pointer(reference) of prev node and points prev =  <once you found not duplicate node>
		 * 
		 *
		 *         
		 */
		
		//below is the implmentation of  approach 2
		if(approach == 2) {
			Node<T> prev= null;
			Node <T> first= null;
			Node <T> last= null;
			 boolean isDuplicateOccured = false;
			while(input !=null) {
				
				if(prev != null && prev.data == input.data) {
					isDuplicateOccured = true;
					input = input.next;
				}
				else if(isDuplicateOccured) {
					prev = input;
					input = input.next;
					isDuplicateOccured = false;
				}
				else {
					if(prev == null) {
						first= prev = input;
						input = input.next;
						prev.next = null;
					}
					else {
						prev.next = input;
						input = input.next;
						last = prev;
						prev = prev.next;
						prev.next = null;
					}
				}
			// input = input.next;
			}
			 if(isDuplicateOccured) {
				 last.next = null;
				
			}
			return first;
		}
		
		return null;
	}

}
