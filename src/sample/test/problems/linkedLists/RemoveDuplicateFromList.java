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
	
	
	public <T> Node<T> removeDuplicateWithoudStorage(Node<T> input){
		Node<T> result= null;
		Node <T> first= null;
		if(input == null)
		{
			return null;
		}
		while(input !=null){
			  boolean exist  = false;
				Node <T> node = new Node<T>(input.data);
				if(result == null){
					first = result = node;
				}else {
					//check node is already exist  in result 
					Node <T> findNode = first;
					while( findNode != node){
						if(findNode.data.equals(node.data)){
							exist =true;
							break;
						}
						findNode =findNode.next;
					}
					if(!exist)
					{
						result.next = node;
						result =result.next;
					}
					
				}
				input = input.next;
		}
			
		return first;
	}
	
	

}
