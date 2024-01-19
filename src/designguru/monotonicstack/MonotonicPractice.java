package designguru.monotonicstack;

import java.util.Arrays;
import java.util.Stack;



public class MonotonicPractice {

	public static void main(String[] args) {
		int [ ] arr = {7, 8, 1, 4 };
		printNGE(arr);
		long [ ] arr2 = {7, 8, 1, 4 };
		System.out.println(Arrays.toString(NGE(arr2)));
		//Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
		Node head = new Node(5);
		head.next = new Node(3);
		head.next.next = new Node(7);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(1);
		System.out.println(" before removeNodesFromLinkedList\n ");
		printList(head);
		Node node =  removeNodes(head);
		System.out.println("removeNodesFromLinkedList\n ");
		printList(node);
		System.out.println("\n removeAdajacentDuplicate\n ");
		System.out.println(removeAdajacentDuplicate("abccba")); //""
		System.out.println(removeAdajacentDuplicate("foobar"));//fbar
		System.out.println("\nremoveKdigits ");
		System.out.println(removeKdigits("10200",1));
	}
	public static void printList(Node head) {
		  while(head != null) {
			  System.out.print(head.data+" -> ");
			  head = head.next;
		  }
		  System.out.print("  null \n ");
	  }
	  
	  
	  private static class Node{
			int data;
			Node next;
			Node(int d){
				this.data = d;
			}
			
	  } 
	public static void printNGE(int [] arr) {
		Stack <Integer> s = new Stack<>();
		for(int i=0 ; i< arr.length; i++) {
			while(!s.isEmpty() && s.peek() < arr[i]) {
				System.out.println("The NGE for "+s.pop() +" is "+arr[i]);
			}
			s.push(arr[i]);
		}
		while(!s.isEmpty()) {
			System.out.println("The NGE for "+s.pop() +" is  -1");
		}
	}
	
	public static long[] NGE(long [] arr) {
        long[] result = new long[arr.length];
        Stack<Long> st = new Stack<>();
        st.push(arr[arr.length-1]);
        result[arr.length-1]=-1;
        System.out.println(arr[arr.length-1]+" --> -1"); 
        for(int i = arr.length-2; i >= 0; i--){
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }if(st.empty()){
              System.out.println(arr[i]+" --> -1"); 
              result[i]=-1;
            } else {
            	 System.out.println(arr[i]+" --> "+st.peek()); 
            	result[i] = st.peek();
            }
            st.push(arr[i]);
        }
       return result;
        // Your code here
    }
	
	public static int[] dailytemprature(int [] temprature) {
		 Stack <Integer> s = new  Stack<>();
		 int [] ans = new int [temprature.length];
		 Arrays.fill(ans, -1);
		 for(int i=0 ; i < temprature.length ; i++) {
			 while(!s.isEmpty() && temprature[s.peek()] < temprature[i]) {
				 ans[i] = i - s.peek();
				 s.pop();
			 }
			 s.push(i);
		 }
		 //for(int i = 0 ; )
		 return ans;
	}
	
	public static Node removeNodes(Node head) {
		Stack <Integer> s = new Stack<>();
		while( head !=null) {
			while(!s.isEmpty() && s.peek() < head.data) {
				s.pop();
			}
			s.add(head.data);
			head = head.next;
			
		}
		Node  prev = null;
		 while(!s.isEmpty()) {
			 Node n = new Node(s.pop());
			 n.next = prev;
			 prev = n;
		 }
		 return prev;
		 
	}
	 
	public static String removeAdajacentDuplicate(String str) {
		Stack <Character> s = new Stack<>();
		for(int i=0; i < str.length(); i ++) {
			boolean found = false;
			while(!s.isEmpty() && s.peek() == str.charAt(i) ) {
				s.pop();
				found = true;
			}
			if(!found) {
				s.push(str.charAt(i));
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		return sb.reverse().toString();
	}
	
	  public static String removeKdigits(String num, int k) {
		  
		  Stack < Character > s = new Stack<>();
		  int i =0;
		  for(; i < num.length(); i++) {
			  char c= num.charAt(i);
			  while(!s.isEmpty() && s.peek() > c && k > 0) {
				  s.pop();
				  k--;
			  }
			  s.push(c);
		  }
		  if(i < num.length()) {
			  while(i < num.length()) {
				  s.push(num.charAt(i++));
			  }
		  }
		  StringBuffer sb = new StringBuffer();
		  while(!s.isEmpty()) {
			  sb.append(s.pop());
		  }
		  return sb.reverse().toString();
	  }

}

