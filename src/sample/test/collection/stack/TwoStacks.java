package sample.test.collection.stack;

import java.lang.reflect.Array;

/*
 *  URL = http://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 * Implement two stacks in an array
Create a data structure twoStacks that represents two stacks. 
Implementation of twoStacks should use only one array,
 i.e., both stacks should use the same array for storing elements. 
 Following functions must be supported by twoStacks.

push1(int x) �> pushes x to first stack
push2(int x) �> pushes x to second stack

pop1() �> pops an element from first stack and return the popped element
pop2() �> pops an element from second stack and return the popped element

Implementation of twoStack should be space efficient.
 */
public class TwoStacks<T> {
	
	
	public static void main(String [] args){
		TwoStacks <Integer> two  = new TwoStacks<Integer>(Integer.class, 10);
		two.push1(10);
		two.push1(20);
		two.push2(100);
		two.push2(90);
		
		System.out.println(two.pop1());
		System.out.println(two.pop1());
		
		System.out.println(two.pop2());
		System.out.println(two.pop2());
		
		System.out.println(two.pop1());
	}
	
	private T [] data ;
	private int aCount=0;
	private int bCount;
	
	TwoStacks(Class<T> c ,int arraySize){
		
		data = (T []) Array.newInstance(c, arraySize);
		bCount = arraySize-1;
	}
	
	public void push1(T data) {
   	 
		if(aCount+1 < bCount) this.data[aCount++] =data;
		
    }
    
    public T pop1(){
   	
    	if( aCount >0) {
    		return this.data[--aCount];
    	}
    	else{
    		return null;
    	}
    }
    
    public void push2(T data) {
    	if(aCount+1 < bCount) this.data[bCount--] =data;
    }
    
    public T pop2(){
    	if( bCount <data.length) return this.data[++bCount];
    	else return null;
    }
    
}
