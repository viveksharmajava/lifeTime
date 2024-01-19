package designguru.mergeintervals;
import java.util.*;
/*
 * Given a list of non-overlapping intervals sorted by their start time, 
 * insert a given interval at the correct position and merge all necessary 
 * intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertGivenInterval {

	public static void main(String[] args) {
      //[[1,3], [5,7], [8,12]], New Interval=[4,6] , output:[1,3], [4,7], [8,12]]
		LinkedList<Interval> input = new LinkedList<Interval>();
	    input.add(new Interval(1, 3));
	    input.add(new Interval(5, 7));
	    input.add(new Interval(8, 12));
	    
	    Interval i  = new Interval(4,10);
	    System.out.println(merge(input,i));
	}
	/*
	 *  https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
	 *  check Method 3: Another Approach Using Stack:
	 *  Time Complexity: O(N) 
		Auxiliary Space: O(N)
	 *  
	 */
	public static  List <Interval> merge( LinkedList <Interval> intervals, Interval newInt){
		
		Stack <Interval> stack = new Stack<>();
		stack.push(intervals.removeFirst());
		
		// Storing the top element
		Interval top = stack.peek();
		// Checking is newPair.start
	    // is less than top.end
		if(newInt.start  < top.end) {
			stack.pop();
			top.start = Math.min(top.start, newInt.start);
			top.end = Math.min(top.end, newInt.end);
			stack.push(top);
		}
		else {
			stack.push(newInt);
		}
		
		for(Interval it : intervals) {
			
			top = stack.peek();
			if(it.start < top.end ) {
				top.start = Math.min(top.start, it.start);
				top.end = Math.max(top.end, it.end);
				stack.pop();
				stack.push(top);
			}
		else {
			stack.push(it);
		}
	  }
	  // reverse the stack so that elements are in ordered.
		Stack <Interval> stack2 = new Stack<>();
		while(!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		LinkedList <Interval> result = new LinkedList<Interval>();
		while(!stack2.isEmpty()) {
			result.add(stack2.pop());
		}
		return result;
	}

}

