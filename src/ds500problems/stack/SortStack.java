package ds500problems.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);
		 
        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);
 
        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
	}

	public static void sortStack(Stack<Integer> stack) {
		//base case: 
		if(stack.isEmpty()) return;
		//remove the top element
		int top = stack.pop();
		//recur for remaining element
		sortStack(stack);
		//now insert sorted element
		
		sortedInsert(stack, top);
		
	}

	private static void sortedInsert(Stack<Integer> stack, int key) {
		//base case
		if(stack.isEmpty() || key > stack.peek() ) {
			stack.push(key);
			return;
		}
		
		//if we are here it means stack top is greater  than key
		//pop it till we find right place
		int pop = stack.pop();
		//iterate for remaining 
		sortedInsert(stack, key);
		stack.push(pop);
	}
}
