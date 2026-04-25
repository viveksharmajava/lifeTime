package designguru.monotonicstack;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class Practice2 {

	public static void main(String[] args) {
		int [ ] arr = {7, 8, 1, 4 };
		removeKdigits("15",2);
        printNGE(arr);
        Stack <Integer> s = new Stack<>();
        s.add(7);
        s.add(8);
        s.add(1);
        s.add(4);
        sortStack(s);
        String ss = "/a//b////c/d//././/.."; //not working for "/a//b////c/d//././/..
  	  System.out.println("\n simplifyPath s= "+ss);
  	  simplifyPath(ss);
  	  System.out.println(removeAdjacentDuplicate("abccba"));
      int [] temperatures = {70, 73, 75, 71, 69, 72, 76, 73};
  			//Output: [1, 1, 4, 2, 1, 1, 0, 0]
	  System.out.println(Arrays.toString(temperatures)+"\n");
	  dailyTemprature(temperatures);
	}

	public static void printNGE(int []arr) {
		int len = arr.length;
		int [] nge = new int[len];
		nge[len-1]  = -1;
		Stack<Integer> stack = new Stack<>();
		stack.add(arr[len-1]);
		for(int i=len-2 ; i >=0; i--) {
			while(!stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				nge[i]=-1;
			}else {
				nge[i] = stack.peek();
			}
			stack.push(arr[i]);

		}
	  System.out.println("Arry elemets="+Arrays.toString(arr));
	  System.out.println("NGE elemetns="+Arrays.toString(nge));
	 
	}
	public static void sortStack(Stack <Integer> s) {
		Stack<Integer> result = new Stack<>();
		Stack <Integer> temp = new Stack<>();
		while(!s.isEmpty()) {
			Integer a = s.pop();
			while(!result.isEmpty() && result.peek() > a) {
				temp.push(result.pop());
			}
			result.push(a);
			while(!temp.isEmpty()) {
				result.push(temp.pop());
			}
		}
		System.out.println(result);
	 }
	/*
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-6-simplify-path
	 * Given an absolute file path in a Unix-style file system, simplify it by converting ".." to the previous directory and removing any "." or multiple slashes. The resulting string should represent the shortest absolute path.

		Examples:
		1. 
		   Input: "/a//b////c/d//././/.."
		   Output: "/a/b/c"
	 */
	/*solution using vector :https://www.geeksforgeeks.org/simplify-directory-path-unix-like/
	  Whenever we encounter any file’s name, we simply push it into the stack. when we come across ” . ” we do nothing. When we find “..” in our path, we simply pop the topmost element as we have to jump back to parent’s directory. 
	 When we see multiple “////” we just ignore them as they are equivalent to one single “/”. 
	
	*/
	public static void simplifyPath(String path) {
	 Vector <String> v = new Vector<>();
	 for(int i = 0 ; i < path.length() ; i++) {
		 String dir = "";
		 while(i < path.length() && path.charAt(i) !='/') {
			 dir +=path.charAt(i);
			 i++;
		 }
		 // check .. if .. we pop
		 if(dir.equals("..")) {
			 if(!v.isEmpty()) v.remove(v.size()-1);
			 
		 }
		 else if (dir.equals(".") || dir.equals("")) {
			 //do nothig just added for better understand..
		 }
		 else {
			 v.add(dir);
		 }
		 
		 
	 }
	 String ans = "";
	 //formatting the ans
	 for(String s : v)	 {
		 ans +="/" +s;
	 }
	 if(ans.equals(""))//emptry
	 {
		 ans = "/";
	 }
	 System.out.println("After simplified ="+ans);
	}
	
	public static String removeAdjacentDuplicate(String input) {
		String result ="";
		//abccba result=""
		Stack <Character> s  = new Stack<>();
		for(int i=0;i  < input.length() ; i++) {
			Character c = input.charAt(i);
			if(!s.isEmpty() && s.peek()== c) {
				while(!s.isEmpty() && s.peek()== c) {
				s.pop();
				}
			}
			else {
				s.push(c);
			}
		}
		System.out.println("Stack after removing adjacent ="+s);
		while(!s.isEmpty()) {
			result = s.pop()+result;
		}
		return result;
	}
	
	public static int [] dailyTemprature(int [] temp){
	    int len = temp.length;
		int [] result = new int[len];
		Stack <Integer> s = new Stack<>();
		for(int i=0; i < len ; i++) {
			int days =0;
			while(!s.isEmpty() && temp[s.peek()] < temp[i]) {
				 int t =s.pop();
				 result[t]=i-t;
				
			}
			s.push(i);
			
		}
		while(!s.isEmpty()) {
			result[s.pop()] =0;
		}
		System.out.println("Daily Temperatures waiting array=\n"+Arrays.toString(result));
		return result;
	}
	 
	public static String removeKdigits(String input, int k) {
		if(k == input.length()) {
			System.out.println("removeKdigits=");
			return "";
		}
		String result ="";
		Stack <Character> s = new Stack <>();
		for(int i =0 ; i  < input.length() ; i++) {
			while(!s.isEmpty() && s.peek() > input.charAt(i) && k > 0) {
				s.pop();
				k--;
			}
			s.push(input.charAt(i));
		}
		System.out.println("removeKdigits ="+s);
		return result;
	}
	}
