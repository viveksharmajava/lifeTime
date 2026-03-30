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
	    input.add(new Interval(4, 6));
	    //input.add(new Interval(8, 12));
	    
	    Interval i  = new Interval(2,5);
	    //=[[1,3],[4,6]]
	    System.out.println("insert ="+insert(input, i));
	    System.out.println(merge(input,i));
	}
	/*
	 *  https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
	 *  check Method 3: Another Approach Using Stack:
	 *  Time Complexity: O(N) 
		Auxiliary Space: O(N)
	 *  
	 */
	//not working for all cases.
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
	
	//https://leetcode.com/problems/insert-interval/solutions/21602/short-and-straight-forward-java-solution/
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
}

