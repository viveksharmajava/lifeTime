package designguru.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] nums2 = {1,3,4,2};
	       System.out.println("nextGreaterElementGrokking_1\n ");
	       System.out.println(Arrays.toString(NGE(nums2)));
	}

	public static int[] NGE(int [] arr){
		Stack <Integer> stack = new Stack<>();
		int [] result = new int[arr.length];
		result[result.length-1] = -1;
		stack.push(arr[arr.length-1]);
		for(int i= arr.length-2; i>=0; i--){
			while(!stack.isEmpty() && stack.peek() <= arr[i]){
				stack.pop();
			}
			if(stack.isEmpty())result[i]=-1;
			else result[i] = stack.peek();
			
			stack.push(arr[i]);
		}
		return result;
	}
}
