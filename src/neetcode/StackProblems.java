package neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
	public int evalRPN(String[] strs) {
	       Stack <String> stack = new Stack<>();
	        for(String s: strs){
	            if(s.equals("+") || s.equals("*")|| s.equals("-")||
	            s.equals("/"))
	            {
	               if(stack.isEmpty() || stack.size() < 2) return 0;
	               Integer b = Integer.parseInt(stack.pop());
	               Integer a = Integer.parseInt(stack.pop());
	               Integer r = new Integer(0);
	               if(s.equals("+")) {
	            	   r = a+b;
	               }
	               else if( s.equals("*")) {
	            	   r = a*b;
	               }
	               else if(s.equals("-")) {
	            	   r = a-b;
	               }
	               else if (
	       	            s.equals("/")) {
	            	   r = a/b;
	               }
	               else {
	            	   return 0;
	               }
	               stack.push(r.toString());
	            }
	            else {
	            	stack.push(s);
	            }
	        }
	       if(stack.isEmpty()) return 0;
	       return Integer.parseInt(stack.pop());
	    }
	
	 public int[] dailyTemperatures(int[] temperatures) {
		 int[] ans = new int[temperatures.length];
		    Deque<Integer> stack = new ArrayDeque<>(); // a decreasing stack

		    for (int i = 0; i < temperatures.length; ++i) {
		      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
		        final int index = stack.pop();
		        ans[index] = i - index;
		      }
		      stack.push(i);
		    }

		    return ans;
	 }
	 
	 public int carFleet(int target, int[] position, int[] speed) {
	    int ans =0;
		Car [] cars = new Car[position.length];
		for(int i = 0 ; i < position.length; i++) {
			cars[i] = new Car(position[i],(double)(target-position[i])/speed[i]);
		}
		Arrays.sort(cars,(a,b) -> Integer.compare(b.position, a.position));
		double maxTime = 0;//the time of the slowest car to reach the target.
		for(Car car : cars) {
			if(car.time > maxTime) {
				maxTime = car.time;
				ans++;
			}
		}
		return ans;
}
}
class Car{
	int position;
	double time;
	Car(int pos, double time){
		this.position = pos;
		this.time = time;
	}
}
