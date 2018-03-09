package sample.test.collection.stack;

import sample.test.collection.queue.Queue;

/*
 * URL: http://www.geeksforgeeks.org/next-greater-element/
 * Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
 */
public class PrintNextGreaterElement {

	public static void main(String[] args) {
		PrintNextGreaterElement nge = new PrintNextGreaterElement();
		Integer [] array = new Integer [] {4,5,2,25};
		//nge.printNGE(array);
		nge.printNGEUsingQueue(array);
	}

	
	//Using  Stack  scan array from left to right  Note this will not mentaion order of element   if you run this example it will print follwoing for  input {5,4,2,1}
	/*
	 * 
	 *  Next greater Element for 5 is =-1
 		Next greater Element for 1 is =-1
 		Next greater Element for 2 is =-1
 		Next greater Element for 4 is =-1

	 */
	
	//Can we use queue??? so that it will print the element in the same order of array 0,1,2 ... N
	public void printNGE(Integer [] input){
		
		Stack <Integer> stack = new Stack<Integer>();
		int  element = input[0];
		for(int i=1;i<input.length ;i++){
			if(element > input[i]) stack.push(input[i]);
			else{
				System.out.println(" Next greater Element for "+element +" is ="+input[i]);
				while(stack.peek() != null){
					System.out.println(" Next greater Element for "+stack.pop() +" is ="+input[i]);
				}
				element =input[i];
			}
		}
		System.out.println(" Next greater Element for "+element +" is ="+-1);
		while(stack.peek() != null){
			System.out.println(" Next greater Element for "+stack.pop() +" is ="+-1);
		}
		
		
		
	}
public void printNGEUsingQueue(Integer [] input){
		
		Queue <Integer> queue = new Queue<Integer>();
		Integer data;
		int  element = input[0];
		for(int i=1;i<input.length ;i++){
			if(element > input[i]) queue.enqueue(input[i]);
			else{
				System.out.println(" Next greater Element for "+element +" is ="+input[i]);
				while( ( data = queue.dequeue())!= null){
					System.out.println(" Next greater Element for "+data +" is ="+input[i]);
				}
				element =input[i];
			}
		}
		System.out.println(" Next greater Element for "+element +" is ="+-1);
		while( ( data = queue.dequeue())!= null){
			System.out.println(" Next greater Element for "+data +" is ="+-1);
		}
		
		
		
	}
	
	

}
