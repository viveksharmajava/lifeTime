package ds500problems.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.*;
public class SortStack {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);
		 
        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);
 
        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
	
	  System.out.println("Merge intervals");
	  List<Interval> intervals = Arrays.asList(
              new Interval(1, 5), new Interval(2, 3),
              new Interval(4, 6), new Interval(7, 8),
              new Interval(8, 10), new Interval(12, 15)
      );

      mergeIntervals(intervals);
      intervals = Arrays.asList(
              new Interval(1, 3), new Interval(6, 8)
      );
      System.out.println("InsertAndMergeIntervals\n");
      InsertAndMergeIntervals(intervals,new Interval(2,5));
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
	
	//Merging Overlapping Intervals
	//https://www.techiedelight.com/merging-overlapping-intervals/
	
	public static void mergeIntervals(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));
		System.out.println(intervals);
		Stack <Interval> stack = new Stack();
		for(Interval curr : intervals) {
			if(stack.isEmpty() || curr.begin > stack.peek().end) {
				stack.push(curr);
			}
			
		     // merge if required
			if(stack.peek().end < curr.end) {
				stack.peek().end = curr.end;
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}


//insert an interval  in sorted set of intevals merge if it is overlapped
//https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
// solution https://www.interviewbit.com/discussion/p/o-n-solution-pass-all-test-cases/71518/#
	public static void InsertAndMergeIntervals(List<Interval> intervals,Interval insert) {
	//Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));
	System.out.println(intervals);
	int size= intervals.size();
    boolean  inserted = false;
    int index= -1;
    Stack <Interval> stack = new Stack();
	stack.push(insert);
    for(int i=0 ; i < size;i++) {
		Interval a = stack.pop();
    	Interval b = intervals.get(i);
		
		if(a.begin > b.end) {
			stack.push(b);
			stack.push(a);
		}
		else if( a.end < b.begin) {
			stack.push(a);
			stack.push(b);
		}
		else {
			stack.push(new Interval(Integer.min(a.begin,b.begin),Integer.max(a.end, b.end)));
		}
	}
    
    System.out.println(stack);
	
}
}
class Interval{
	int begin , end;
	Interval(int b ,int e){
		this.begin =b ;
		this.end= e;
	}
	@Override
	public String toString() {
		return "Interval [begin=" + begin + ", end=" + end + "]";
	}
	
}
