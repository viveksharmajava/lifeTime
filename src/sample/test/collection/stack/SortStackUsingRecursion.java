package sample.test.collection.stack;

/*
 * URL:http://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 * Sort a stack using recursion
Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. We can only use the following ADT functions on Stack S:

is_empty(S)  : Tests whether stack is empty or not.
push(S)	     : Adds new element to the stack.
pop(S)	     : Removes top element from the stack.
top(S)	     : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example:

Input:  -3  <--- Top
        14 
        18 
        -5 
        30 

Output: 30  <--- Top
        18 
        14 
        -3 
        -5 
 * 
 * 
 */
public class SortStackUsingRecursion {

	public static void main(String[] args) {

		Stack <Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(33);
		stack.push(2);
		stack.push(77);
		System.out.println("stack peek ="+stack.peek());
		SortStackUsingRecursion sort = new SortStackUsingRecursion();
		sort.sortStack(stack);
		Integer i = null;
		while(( i = stack.pop()) !=null){
			System.out.println(i);
		}
	}
	
	public void sortStack(Stack stack){
		
		if(stack.isEmpty() ){
			return;
		}
		Object ob = stack.pop();
		sortStack(stack);
		insertAfterSort(ob,stack);
		
		
	}
	
private void insertAfterSort(Object item , Stack stack){
		Integer in = (Integer) item;
		if(stack.isEmpty()) stack.push(item);
		else{
			Integer temp  = (Integer)stack.peek();
			if( temp >= in) stack.push(item);
			else{
				temp  = (Integer)stack.pop();
				insertAfterSort(item, stack);
				stack.push(temp);
			}
			
		}
		
	}

}
