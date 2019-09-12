package sample.test.problems.linkedLists;

public class SumOf2NumbersStoredin2List {

	/**
	 *You have two decimal numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1�s digit is at the head of the list.
	 * Write a function that adds the two numbers and returns the sum as a linked list.
	 */
	
	/**
	 * Implement an algorithm to find the nth to last element of a singly linked list.
	 * @param <T>
	 */

	public static Node<Integer> sumOfTwoList(Node <Integer> list1 ,Node <Integer> list2){
		Node <Integer> output = null;
		Node <Integer>temp = null ;
		int carry=0;
		while(list1 != null && list2 != null) {
		  int val = list1.data + list2.data +carry;
		  if (val >9) {
			  carry = val/10;
			  val =val%10;
		  }else {
			  carry = 0;
		  }
		  Node <Integer> newNode = new Node<Integer>(val);
		  if(temp == null) {
			  output= temp = newNode;
		  }else {
			  temp.next = newNode;
			  temp = newNode;
		  }
		  list1 = list1.next;
		  list2 = list2.next;
		}
		if(list1 == null && list2 != null) {
			while( list2 != null) {
				  int val = list2.data +carry;
				  if (val >9) {
					  carry = val/10;
					  val =val%10;
				  }else {
					  carry = 0;
				  }
				  Node <Integer> newNode = new Node<Integer>(val);
				  if(temp == null) {
					  output= temp = newNode;
				  }else {
					  temp.next = newNode;
					  temp = newNode;
				  }
				  list2 = list2.next;
			}
			
		}	
			else if(list2 == null && list1 != null) {
				while( list1 != null) {
					  int val = list1.data +carry;
					  if (val >9) {
						  carry = val/10;
						  val =val%10;
					  }else {
						  carry = 0;
					  }
					  Node <Integer> newNode = new Node<Integer>(val);
					  if(temp == null) {
						  output= temp = newNode;
					  }else {
						  temp.next = newNode;
						  temp = newNode;
					  }
					  list1 = list1.next;
		  
			}
			}
			else if(carry > 0) {
				Node <Integer> newNode = new Node<Integer>(carry);
				  if(temp == null) {
					  output= temp = newNode;
				  }else {
					  temp.next = newNode;
				  }

			}
		return output;
		
	}
}
