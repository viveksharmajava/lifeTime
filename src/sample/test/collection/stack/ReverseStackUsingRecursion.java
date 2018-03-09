package sample.test.collection.stack;

/*
 * 
 * URL:http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * Reverse a stack using recursion
You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

Solution:
The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty. When the stack becomes empty, insert all held items one by one at the bottom of the stack.

For example, let the input stack be

    1  <-- top
    2
    3
    4   
First 4 is inserted at the bottom.
    4 <-- top

Then 3 is inserted at the bottom
    4 <-- top    
    3

Then 2 is inserted at the bottom
    4 <-- top    
    3 
    2
     
Then 1 is inserted at the bottom
    4 <-- top    
    3 
    2
    1
 */
//Its similar stack as queue
public class ReverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack <Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println("stack peek ="+stack.peek());
		ReverseStackUsingRecursion reverse = new ReverseStackUsingRecursion();
		reverse.reverse(stack);
		Integer i = null;
		while(( i = stack.pop()) !=null){
			System.out.println(i);
		}
	}
	
	public void reverse(Stack  stack){
		
		if(stack.isEmpty())
		 {
			return;
		 }
		 
		 Object obj = stack.pop();
		 reverse(stack);
		 insertAtBottom(obj, stack);
		
	}
	
	//Its similar like  stack as queue
	private void insertAtBottom(Object item , Stack stack){
		
		if(stack.isEmpty()) stack.push(item);
		else{
			Object temp  = stack.pop();
			insertAtBottom(item, stack);
			stack.push(temp);
		}
		
	}

}
