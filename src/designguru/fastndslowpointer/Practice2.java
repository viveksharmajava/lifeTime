package designguru.fastndslowpointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(isHappyNumber(12));
		 Node head  = new Node();
	     head.data = 1;
	     Node n2 = new Node();
	     n2.data = 2;
	     Node n3 = new Node();
	     n3.data = 2;
	     Node n4 = new Node();
	     n4.data = 1;
	    
	     head.next = n2; 
	     n2.next = n3;
	     n3.next = n4;
	     
	    // System.out.println("startOfCycle="+startOfCycle(head));
	     //Node reverse = reverseList(head);
	    // printList(head);
	     System.out.println(isPalindromList(head));
	     
	     System.out.println("loopInCircularArray\n");
	     int [] arr = {-2,1,-1,-2,-2};
	     System.out.println("is look exist ="+loopInCircularArray(arr));
	}

	public static boolean isHappyNumber(int num){
		
		int slow = num;
		int fast = num;
		do{
			slow = squareNum(slow);
			fast = squareNum(squareNum(fast));
		}while(slow != fast);
		return slow == 1;
	}
	
	public static int squareNum(int n) {
		int square = 0;
		while (n != 0) {
			square += (n%10)*(n%10);
			n /=10;
		}
		return square;
	}
	
	public static Node startOfCycle(Node head){
		Node s= head;
		Node f = head;
		while(s != null & f != null && f.next != null){
			s = s.next;
			f= f.next.next;
			if(s == f) break;
		}
		if(s != f) return null;
		s = head;
		while(s != f){
			s = s.next;
			f = f.next;
		}
		return s;
	}
	
	
	public static boolean isPalindromList(Node head){
		if(head == null || head.next == null)return false;
		Node s = head;
		Node f = head;
		Node prev = null;
		while(f != null && f.next != null){
			prev = s;
			s = s.next;
			f = f.next.next;
		}
		
		
		prev.next = null;
		printList(head);
		System.out.println("Second part of the list");
		printList(s);
		Node rervese = reverseList(s);
		System.out.println("After reversing second half");
		printList(rervese);
		Node temp_rev= rervese;
		Node temp = head;
		
		while(temp_rev!= null || temp != null){
			if(temp_rev.data != temp_rev.data) return false;
			temp_rev = temp_rev.next;
			temp = temp.next;
		}
		
		System.out.println("If you see this message, means list is palindrome"); //but you forgot to 
		                                                                         //re-arrange second part of the list before return.
		rervese = reverseList(rervese);
		prev.next = rervese;
		System.out.println("Original List");
		printList(head);
		return true;
		
	}

	private static void printList(Node n) {
		// TODO Auto-generated method stub
		while(n !=null){
			System.out.println(n.data);
			n = n.next;
		}
		
	}
	
	private static Node reverseList(Node n){
		if(n == null) return null;
		Node next = n.next,nHead;
		nHead = n;
		nHead.next= null;
		while(next != null){
			Node temp = next;
			next = next.next;
			temp.next = nHead;
			nHead= temp;
		}
		return nHead;
	}
	
	//this is try to make -2,1,-1,-2,-2
	                     //0 1  2  3 4
	private static boolean loopInCircularArray(int [] arr){
		System.out.println(Arrays.toString(arr));
		Set <Integer> set = new HashSet<>();
		 int position =0;
		 set.add(position);
		 System.out.println("position ="+position);
		     while(set.size() < arr.length-1){
			  position =  position + arr[position];
			 // System.out.println(" arr[position]="+ position);
			 if(position > 0 ) position = position%arr.length;
			 else if(position < 0) {
				 position = arr.length  + position;
			 }
			 System.out.println("position ="+position);
			if(set.contains(position) ) return true;
		
			set.add(position);
		}
		return false;
	}
}

