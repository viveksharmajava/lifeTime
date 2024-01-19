package designguru.monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Problems {

	public static void main(String[] args) {
       int abc = 2147483647;
       boolean b= true;
       String s = ""+b;
       System.out.println(s);
       System.out.println(abc);
		long [ ] arr = {7, 8, 1, 4 };
        printNGE(arr);
       long [] arr2 = {7, 8, 1, 4 };
       // 8, 1,
       // 8, 
        System.out.println(Arrays.toString(nextLargerElement(arr2,arr.length)));
	
       int [] nums1 = {4,1,2};
       int [] nums2 = {1,3,4,2};
       System.out.println("nextGreaterElementGrokking_1\n ");
        System.out.println(Arrays.toString( nextGreaterElementGrokking_1(nums1,nums2)));
	   System.out.println("nextGreaterElementGrokking_2\n ");
	   System.out.println(Arrays.toString( nextGreaterElementGrokking_2(nums1,nums2)));
	
	// ngeInCircularArray
	    int [] circular  = {1,2,1};
	    System.out.println("ngeInCircularArray\n ");
	    System.out.println(Arrays.toString( ngeInCircularArray(circular)));
	 // 
	    int [] circular2 = {1,2,3,4,3};
	    
	    System.out.println("ngeInCircularArray\n ");
	    System.out.println(Arrays.toString( ngeInCircularArray(circular2)));
	 
	 // ngeInCircularArray2
	    
	    int [] circular3 = {5,4,3,2,1};
	    System.out.println("ngeInCircularArray2 \n ");
	    System.out.println(Arrays.toString( ngeInCircularArray2(circular3)));
	    System.out.println("\n NextGreaterElementIII\n ");
	    System.out.println(NextGreaterElementIII(2147483486));//2147483846 , 2147483486
	  int [] temprature  = {73, 74, 75, 71, 69, 72, 76, 73 };
	  System.out.println(Arrays.toString(dailyTemperatures(temprature)));
	
	  String rremove = "abcd";
	  System.out.println("\n rremove\n ");
	  System.out.println(rremove(rremove));
	//Input: 5 -> 3 -> 7 -> 4 -> 2 -> 1
	Node head = new Node(5);
	head.next = new Node(3);
	head.next.next = new Node(7);
	head.next.next.next = new Node(4);
	head.next.next.next.next = new Node(2);
	head.next.next.next.next.next = new Node(1);
	Node node =   removeNodesFromLinkedList(head);
	System.out.println("removeNodesFromLinkedList\n ");
	printList(node);
	System.out.println("\nremoveAdjacentDuplicate2\n");
	System.out.println(removeAdjacentDuplicate2("abbbaaca",3));
	
	System.out.println("\n removeKdigits\n ");
	System.out.println(removeKdigits("10",2));
	}
	
	/*i
	 * 
	 * Problem : find Next greater Element in an Array
	 */
	
	public static void printNGE(long [] arr) {
        long[] result = new long[arr.length];
        Stack<Long> st = new Stack<>();
        st.push(arr[arr.length-1]);
       // result[arr.length-1]=-1;
        System.out.println(arr[arr.length-1]+" --> -1"); 
        for(int i = arr.length-2; i >= 0; i--){
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }if(st.empty()){
              System.out.println(arr[i]+" --> -1"); 
              //result[i]=-1;
            } else {
            	 System.out.println(arr[i]+" --> "+st.peek()); 
            	//result[i] = st.peek();
            }
            st.push(arr[i]);
        }
       // return result;
        // Your code here
    }
	//Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] result = new long[arr.length];
        Stack<Long> st = new Stack<>();
        st.push(arr[arr.length-1]);
        result[arr.length-1]=-1;
        for(int i = arr.length-2; i >= 0; i--){
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }if(st.empty()){
                result[i]=-1;
            } else {
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return result;
        // Your code here
    }
    
    //grokking 1 problem  is equal to below leetcode pracitice
    //https://leetcode.com/problems/next-greater-element-i/
    
   //below approach is O(m*n) find solution which can solve in o(m)+O(n) 
  public static  int[] nextGreaterElementGrokking_1(int[] nums1, int[] nums2) {
	  int[] result = new int[nums1.length];
	  
	  HashMap < Integer, Integer> map = new HashMap<>();
	  for(int i = 0 ; i < nums2.length ; i++) {
		 map.put(nums2[i],i);
	  }
	  for(int i = 0 ; i < nums1.length ; i++) {
			 int index = map.get(nums1[i])+1;
			 boolean nge_exist = false;
			 while(index < nums2.length) {
				 if(nums1[i] < nums2[index]) {
					 result[i] = nums2[index];
					 nge_exist  = true;
					 break;
				 }
				 index++;
			 }
			 if(!nge_exist)result[i] = -1;
	   }
	  
	  return result;
    }
 // Next Greater Element || Java || Stack + HashMap
  // Could you find an O(nums1.length + nums2.length) solution?
  //https://leetcode.com/problems/next-greater-element-i/description/
  // Next Greater Element || Java || Stack + HashMap
  public static  int[] nextGreaterElementGrokking_2(int[] nums1, int[] nums2) {
	  int ans [] = new int [nums1.length];
	  Stack <Integer> stack = new Stack();
	  int  [] next  = new int [nums2.length];
	 for(int i=0; i < nums2.length ; i++) {
		 while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
			next[ stack.pop()] = nums2[i];
		 }
		 stack.push(i);
	 }
	 while(!stack.isEmpty()) {
		 next[stack.pop()] = -1;
	 }
	 
	 HashMap < Integer, Integer> map = new HashMap<>();
	  for(int i = 0 ; i < nums2.length ; i++) {
		 map.put(nums2[i],next[i]);
	  }
	  for(int i = 0; i < ans.length; i++) {
		  ans[i] = map.get(nums1[i]);
	  }
	  return ans;
  }
  
  //Note: This solution is not 100% correct. it has problem, it may return farthest element as greater element
  // while there is nearest element available 
  //example : [5,4,3,2,1] output: -1,5,4,3,2 , correct result: -1,5,5,5,5
  public static int [] ngeInCircularArray(int [] arr) {
	int [] next = new int [arr.length];  
	int [] prev = new int [arr.length];  
	int [] ans = new int [arr.length];
	int k = 0; 
	Stack <Integer> stack = new Stack<>();
	for(int i=0 ; i < arr.length ; i++ ) {

		while( !stack.isEmpty() && arr[stack.peek()] < arr[i]) {
			next[stack.pop()]= arr[i];
			
		}
		stack.push(i);
		
	}
	while(!stack.isEmpty()) {//populate -1 for remaining
		next[stack.pop()] = -1;
		
	}
	//iterate the above steps in reverse order 
	// means create an prev array which hold greater element occurred before than current element position.
	
	for(int i=arr.length-1 ; i >=0 ; i-- ) {

		while( !stack.isEmpty() && arr[stack.peek()] < arr[i]) {
			prev[stack.pop()]= arr[i];
			
		}
		stack.push(i);
		
	}
	while(!stack.isEmpty()) {//populate -1 for remaining
		prev[stack.pop()] = -1;
		
	}
	// Now next[] and prev [] arrays hold greater element occurred in left and right direction if any.
	
	for(int i=0; i < arr.length ; i++) {
		ans[i] = next[i] != -1? next[i]: prev[i];
	}
	return ans;
  }
  
  /*
   * This program will solve the problem highlighted in above example
   * solution: 
   * */
  public static int [] ngeInCircularArray2(int [] arr) {
	  
	  int ans[] = new int [arr.length];
	  int n = arr.length;
	  Stack <Integer> stack = new Stack<>();
	  
	  for(int i = 2*n-1 ; i>=0 ; i-- ) {
		// Remove all the elements in Stack that are less than arr[i%n]
		  while(!stack.isEmpty() &&  arr[i%n] >= stack.peek() ) {
			 stack.pop();
		  }
		  if( i < n) {
			  if(!stack.isEmpty()) {
				  ans[i] = stack.peek();
			  }else {
				  ans[i] = -1;  // When none of elements in Stack are greater than arr[i%n]
			  }
		  }
		  stack.push(arr[i%n]);
	  }
	 return ans; 
  }
  
 /* Next Greater Element III
  * https://leetcode.com/problems/next-greater-element-iii/description/
  * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

	Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
	
	 
	
	Example 1:
	
	Input: n = 12
	Output: 21
	Example 2:
	
	Input: n = 21 
	Output: -1
  */
    public static int NextGreaterElementIII(int input) {
    	String s = Integer.toString(input);
	char [] chars =s.toCharArray();
			int len = s.length();
	int  [] ans = new int [len];
		int min_so_far = len-1;
	
		for(int i= len-1; i >0 ; i--){
	   	char	temp ;
			if(chars[i] > chars[i-1]) {
				if(chars[min_so_far] >  chars[i-1]){
			 	temp = chars[i-1];
				char temp2 = chars[i];
				chars[i-1] = chars[min_so_far];
				chars[i]  = temp;
				chars[min_so_far] = temp2;
				
				}
				else {
				temp = chars[i];
				chars[i] = chars[i-1];
				chars[i-1]  = temp;}
				break;
			
			}
			if(chars[min_so_far] > chars[i]){
				min_so_far = i;
			}
			
		}
/*	Stack < Integer> stack = new Stack();
	
	for(int i=0; i < chars.length; i++) {
		while(!stack.isEmpty() && chars[stack.peek()] < chars[i]) {
			ans[stack.pop()] = chars[i];
		}
		stack.push(i);
	}
	while(!stack.isEmpty()) {
		ans[stack.pop()] = -1;
	}
	
	int index = -1, i = ans.length-1;
	while(i >= 0) {
		if(ans[i] != -1) {
			index = i;
			break;
		}
		i--;
	}
	//System.out.println("Before "+new String(chars) );
	if(index != -1) {
		char c = (char) ans[index];
		int ind = s.indexOf(c,index);
		char temp = chars[ind];
		chars[ind] =chars[index] ;
		chars[index] = temp;
	}
   // System.out.println("After "+new String(chars) );
  */
		  if(s.equals(new String(chars) )) return -1;
    

   try {
	   return Integer.parseInt(new String(chars));
   }catch(NumberFormatException e) {
	   return -1;
   }
}
    
  /*
   * Daily temperature
   * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/64c151c7505e25aa946412b6
   *  Given an array of integers temperatures representing daily temperatures, your task is to calculate how many days you have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

	Examples
	
	Input: temperatures = [70, 73, 75, 71, 69, 72, 76, 73]
	Output: [1, 1, 4, 2, 1, 1, 0, 0]
	Explanation: The first day's temperature is 70 and the next day's temperature is 73 which is warmer. So for the first day, you only have to wait for 1 day to get a warmer temperature
  *   
   */
  public static int[] dailyTemperatures(int[] temperatures) {
       Stack <Integer>  stack = new Stack<>();
       int [] ans = new int [ temperatures.length];
       Arrays.fill(ans, -1);
       for(int i = 0 ; i < temperatures.length ; i++)
        {
    	   while( !stack.isEmpty() && temperatures[stack.peek()]  < temperatures[i]) {
    		   ans[stack.peek()] = i- stack.peek();
    		   stack.pop();
    	   }
    	   stack.push(i);
        }
       return ans;
       
    }
  static String rremove(String input) {
      // code here
      //first lets solve this using monotonic stack..
      if( input == null || input.length() == 1 ) return input;
      Stack <Character> stack = new Stack<>();
       char c_last ='0';
      for(int i = 0 ; i < input.length(); i++){
         boolean found = false;
       
          while(!stack.isEmpty() && stack.peek() == input.charAt(i)){
              c_last=  stack.pop();
              found = true;
            
          }
          if(!found  &&    c_last !=input.charAt(i) )stack.push(input.charAt(i));
          
          
      }
      StringBuffer sb = new StringBuffer();
      while(!stack.isEmpty()){
          sb.append(stack.pop());
      }
      return sb.reverse().toString();
     
      
  } 
  /*
   * 
   * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/64c14baaee20248bcc6d1d4c
   * Problem: 
   * Input: s = "abbbaaca", k = 3
	Output: "ca"
	Explanation: First, we remove "bbb" to get "aaaca". Then, we remove "aaa" to get "ca".
   */
  public static String removeAdjacentDuplicate2(String s,int k) {
	  if(s.length() < k) return s;
	  LinkedList <Character > stack = new LinkedList<>();
	 for(int i = 0 ; i < s.length() ; i++) {
		 
		 char c = s.charAt(i);
		 boolean found = false;
		 if(stack.size() >=k-1 && stack.getLast() == c) {
			 int temp = k-1;
			 int j = stack.size()-1;
			 while(j >=0 && temp > 0) {
				 if(c == stack.get(j)) {
					 temp--;
					 j--;
				 }
				 else break;
			 }
			 if(temp == 0) {//pattern found
				temp = k-1;
				while(temp > 0) {
					stack.removeLast();
					temp--;
				}
				found = true;
			 }
			 
		 } if (!found) stack.addLast(c);
	 }
	StringBuffer sb = new StringBuffer();
	while(!stack.isEmpty()) {
		sb.append(stack.removeFirst());
	}
	  return sb.toString();
	  
  }
  
  public static Node removeNodesFromLinkedList(Node head) {
	  if( head == null || head.next == null) return head;
	  LinkedList<Integer > stack = new LinkedList<>();
	  stack.add(head.data);
	  int max = head.data ;
	  head = head.next;
	  Node temp = null;
	  Node prev = null;
	  while (head != null) {
		  if(head.data > max) {
			  stack.clear();
			 max =  head.data;
		  }
		  
		  stack.add(head.data);
		  head = head.next;
	  }
	int i =0 ; 
	while(i < stack.size()) {
		temp = new Node(stack.get(i));
		if(head == null ) {
			prev = head = temp;	
		}
		else{prev.next = temp;
		prev  = temp;}
		i++;
	}
	  return head;
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
  
  public static String removeKdigits(String num, int k) {
      
	   if(num == null || num.length() < k ) return num;
	   LinkedList<Character > stack = new LinkedList<>();
	   int i = 0;
	   while( i < num.length() && k > 0) {
		   char  c = num.charAt(i);
		   while(stack.size() > 0 && stack.getLast() > c && k >0) {
			   stack.removeLast();
			   k--;
		   }
		   stack.addLast(c);
		   i++;
	   }
	   StringBuffer sb = new StringBuffer();  
	   for(int j = 0 ; j < stack.size(); j++) {
		   sb.append(stack.get(j));
	   }
	   
	   if(i < num.length()) {
		   sb.append(num.substring(i, num.length()));
	   }
	   Integer  val = Integer.parseInt(sb.toString());
	 // System.out.println(sb);
	  return val.toString();
  }
}




