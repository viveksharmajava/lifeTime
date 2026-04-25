package designguru.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
      System.out.println("NGE ="+Arrays.toString(nextGreaterElement(new int[] {4, 5, 2, 25})));//[5, 25, 25, -1]
	  System.out.println("sortingAStack ="+Arrays.toString(sortingAStack(new int[] {43,23,2,5,5,30,0,1,1})));
	  System.out.println("simplifyPath ="+simplifyPath("/a//b////c/d//././/.."));
	}
	
	
	public static String simplifyPath(String str) {
		String [] dirs = str.split("/");
		Stack <String> paths= new Stack<>();
		for(String dir : dirs) {
			if(dir.isEmpty() || dir.equals(".")) continue;
			else if(dir.equals("..")) {
				if(!paths.isEmpty()) paths.pop();
			}
			else {
				paths.push(dir);
			}
		}
		return "/"+String.join("/", paths);
	}

	//https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-4-next-greater-element
	public static  int [] nextGreaterElement(int[] arr) {
		int []result = new int[arr.length];
		Stack <Integer> stack = new Stack<>();
		int j = result.length-1;
		//stack.add(arr[j]);
		//result[j] = -1;
		for(int i = arr.length-1;i >=0; i--) {
			while(!stack.isEmpty() && stack.peek() < arr[i]) stack.pop();
			
			if(stack.isEmpty()) {
				result[j--] = -1;
			}else {
				result[j--]  = stack.peek();
			}
			stack.add(arr[i]);
		}
		return result;
	}
	//https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-5-sorting-a-stack
	public static Object [] sortingAStack(int [] arr) {
		Stack <Integer>s1   = new Stack<>();
		Stack <Integer>s2   = new Stack<>();
		for(int num : arr) {
			while(!s1.isEmpty() && s1.peek() > num ) s2.push(s1.pop());
			
			s1.push(num);
			while(!s2.empty()) s1.push(s2.pop());
		}
		
		return s1.toArray();
	}
}
