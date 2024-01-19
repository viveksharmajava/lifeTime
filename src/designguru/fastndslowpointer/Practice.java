package designguru.fastndslowpointer;

import java.util.Stack;

public class Practice {

	public static void main(String[] args) {

		 Node head  = new Node();
	     head.data = 1;
	     Node n2 = new Node();
	     n2.data = 2;
	     Node n3 = new Node();
	     n3.data = 3;
	     Node n4 = new Node();
	     n4.data = 4;
	     Node n5 = new Node();
	     n5.data = 5;
	     Node n6 = new Node();
	     n6.data = 6;
	     head.next = n2; 
	     n2.next = n3;
	     n3.next = n4;
	     n4.next = n5;
	     n5.next = n6;
	     printList(head);
	     System.out.println();
	     Node new_h = rearrangeList(head);
	     printList(new_h);
	     System.out.println(middleNode(head));
	     
	     
	     testcycle();
	     System.out.println("isHappyNumber ="+isHappyNumber(23));
	     System.out.println("isHappyNumber ="+isHappyNumber(20));
	     
	     test_palindrome();
	}
	public static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data +" -- >");
			head = head.next;
		}
		System.out.println();
	}
	public static void test_palindrome() {
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
	     System.out.println("isPalindromList = "+isPalindromList(head));
	}
		
	public static void testcycle() {
		Node head  = new Node();
	     head.data = 1;
	     Node n2 = new Node();
	     n2.data = 2;
	     Node n3 = new Node();
	     n3.data = 3;
	     Node n4 = new Node();
	     n4.data = 4;
	     Node n5 = new Node();
	     n5.data = 5;
	     head.next = n2; 
	     n2.next = n3;
	     n3.next = n4;
	     n4.next = n5;
	     n5.next = n2;
	     System.out.println(isCycleExist(head));
        System.out.println(startOfTheCycle(head));
       
	}
	public static Node middleNode(Node head) {
		if(head == null || head.next == null) return null;
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
		
	}
	
	
	public static boolean isCycleExist(Node head) {
		
		if(head == null || head.next == null) return false;
		Node slow = head, fast = head;
		slow = slow.next;
		fast = fast.next.next;
		while(fast != null && fast.next != null) {
			if(slow == fast) return true;;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	
   public static Node startOfTheCycle(Node head) {
		
		if(head == null || head.next == null) return null;
		Node slow = head, fast = head;
		slow = slow.next;
		fast = fast.next.next;
		while(fast != null && fast.next != null) {
			if(slow == fast) break;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != slow) return null;
		slow = head;
		while(slow != fast) {
			slow =slow.next;
			fast = fast.next;
		}
		return slow;
	}
   
   public static int squareNum(int n) {
		int square = 0;
		while (n != 0) {
			square += (n%10)*(n%10);
			n /=10;
		}
		return square;
	}
	
   public static boolean isHappyNumber(int num) {
	   int slow = num,fast=num;
	   do {
		   slow = squareNum(slow);
		   fast = squareNum(squareNum(fast));
	   }while(slow != fast);
	   return slow == 1;
   }
   //https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63922d27b689b698075a9ab3
   public static boolean isPalindromList(Node head) {
	   if(head == null || head.next == null) return true;
	   Node slow = head;
	   Stack <Node>  stack = new Stack<>();
	 //  stack.add(slow);
	  
	   while(slow !=null) {
		   stack.add(slow);
		   slow = slow.next;
			
			
		}
	   
	  
	   while(!stack.isEmpty() && head != null) {
		   if( stack.pop().data != head.data) return false;
		   head =head.next;
	    }
	    
		if(!stack.isEmpty() || head != null)   return false;
		return true;
	   }
	  
   
   public static Node rearrangeList(Node head) {
	   if(head == null || head.next == null)return head;
	   Node slow = head;
	   Stack <Node>  stack = new Stack<>();
	 //  stack.add(slow);
	  
	   while(slow !=null) {
		   stack.add(slow);
		   slow = slow.next;
			
			
		}
	  System.out.println(stack);
	  int count = stack.size()/2;
	  System.out.println(count);
	  Node temp_head = null , temp = null;
	   while(count > 0) {
		   
		   if(temp_head == null) {
			   temp_head = temp = head;
			   head = head.next;
			   temp.next= stack.pop();
			   temp = temp.next;
		   }else {
			   temp.next = head;
			   temp =temp.next;
			   head = head.next;
			   temp.next = stack.pop();
			   temp = temp.next;
		   }
		    
		  
		   count--;
	    }
	  
	   temp.next = null;
	   return temp_head;
   }

}
