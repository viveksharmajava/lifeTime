package sample.test.collection.stack;

public class StackSample {

	public static void main(String[] args) {

	/*	Stack <Integer> stack = new Stack<Integer>();
		stack.push(10);
		stack.push(30);
		stack.push(20);
		stack.push(3);
		System.out.println("stack peek ="+stack.peek());
		Integer i = null;
		while(( i = stack.pop()) !=null){
			System.out.println(i);
		}
		*/
		
		/*MinStack <Integer> stack = new MinStack<Integer>();
		stack.push(10);
		stack.push(30);
		stack.push(20);
		stack.push(3);
		System.out.println(""+stack.getMin());
		Integer i = null;
		
		while(( i = stack.pop()) !=null){
			System.out.println(stack.getMin());
		}
		*/
		
		//TODO check DoublyLinkedStack  push,pop , getMiddle() ,deleteMiddle() operations
		
		DoublyLinkedStack <Integer> stack = new DoublyLinkedStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("the middle element"+stack.getMiddle());
		System.out.println("Delete middle element"+stack.deleteMiddle());
		System.out.println("the middle element"+stack.getMiddle());
		Integer i = null;
		
		while(( i = stack.pop()) !=null){
			System.out.println(stack.getMiddle());
		}
	}
	
	

}
