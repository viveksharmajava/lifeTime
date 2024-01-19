package designguru.topKelements;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
/*
 * https://leetcode.com/problems/maximum-frequency-stack/
 * Input
	["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
	[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
	Output
	[null, null, null, null, null, null, null, 5, 7, 5, 4]
	
	Explanation
	FreqStack freqStack = new FreqStack();
	freqStack.push(5); // The stack is [5]
	freqStack.push(7); // The stack is [5,7]
	freqStack.push(5); // The stack is [5,7,5]
	freqStack.push(7); // The stack is [5,7,5,7]
	freqStack.push(4); // The stack is [5,7,5,7,4]
	freqStack.push(5); // The stack is [5,7,5,7,4,5]
	freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
	freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
	freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
	freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 */
public class FreqStack {

	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
	freqStack.push(5); // The stack is [5]
	freqStack.push(7); // The stack is [5,7]
	//freqStack.push(5); // The stack is [5,7,5]
	//freqStack.push(7); // The stack is [5,7,5,7]
	freqStack.push(4); // The stack is [5,7,5,7,4]
	//freqStack.push(5); // The stack is [5,7,5,7,4,5]
	System.out.println(freqStack.map);
	System.out.println(freqStack.queue);
	System.out.println(freqStack.stack);
	System.out.println("Popped ="+freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
	
	System.out.println(freqStack.queue);
	System.out.println(freqStack.stack);
	System.out.println("Popped ="+freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
	/*System.out.println(freqStack.queue);
	System.out.println(freqStack.stack);
	System.out.println("Popped ="+freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
	System.out.println(freqStack.queue);
	System.out.println(freqStack.stack);
	System.out.println("Popped ="+freqStack.pop());  // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].}
	System.out.println(freqStack.queue);
	System.out.println(freqStack.stack);
	*/
	}
    PriorityQueue <MyKey> queue = new PriorityQueue<>();
    public FreqStack() {
        
    }
    HashMap <Integer , Integer> map = new HashMap<>();
	Stack <Integer> stack = new Stack <>();
	
    public void push(int val) {
        this.map.put(val, this.map.getOrDefault(val, 0)+1); 
        MyKey key = new MyKey(val, map.get(val));
        if(queue.contains(key)){
          queue.remove(key);
          queue.add(key);
        }
        else {
        	queue.add(key);
        }
        stack.push(val);
      
    }
    
    public int pop() {
	int ans = 0 ;
	int returnVal = 0;
	if(queue.isEmpty() || stack.isEmpty()) return Integer.MIN_VALUE;
	MyKey k = queue.poll();
	if(k.freq == 1) {
		//stack.remove(new Integer(k.ch));
		Integer sk = stack.pop();
		queue.remove(new MyKey(sk,map.get(sk)));
		return sk;
	}
	if(!queue.isEmpty()) {
    	MyKey next = queue.peek();
    	if((k.freq ==next.freq) && stack.lastIndexOf(k.ch) <= stack.lastIndexOf(next.ch)){
    	   
    		queue.add(k); // add it back to queue since,
            //it is not the candidate
    		ans =next.freq;
    	    returnVal = next.ch;
    		map.put( next.ch,ans-1 );
    		MyKey mapKey = new MyKey(next.ch,ans-1);
    		queue.poll();
    		queue.add(mapKey);
    		
    		stack.remove((int)stack.lastIndexOf(new Integer(next.ch)));
    		//System.out.println(());
    	}else {
    		ans = k.freq;
    		 returnVal = k.ch;
    		
    		k.freq = ans-1;
    		if( (ans-1) > 0) {
    		System.out.println("In  if( (ans-1) > 0) ="+(ans-1));
    		System.out.println("before map.put "+map +"\t returnVal "+returnVal);
    		map.put(returnVal,ans-1 );
    		System.out.println("after map.put "+map);
    		queue.add(k);
    		System.out.println("after queue.add(k)"+queue);
    		}
    		stack.remove((int)stack.lastIndexOf(new Integer(k.ch)));
    			
    	  }
    	}else {//queue has only 1 item left ..
			stack.pop();
			return k.ch;
    	 }
    	
    	System.out.println(stack);
        return returnVal;
    }
}

class MyKey implements Comparable<MyKey>{
	 
    int freq; // store frequency of character
    int ch;
    MyKey(int c,int val )
    {
    	 ch = c;
        freq = val;
       
    }
    @Override
    public int compareTo(MyKey k)
    {
        if (this.freq < k.freq)
            return 1;
        else if (this.freq > k.freq)
            return -1;
        return 0;
    }
    @Override
    public boolean equals(Object o) {
    	MyKey k =(MyKey)o;
    	return this.ch == k.ch;
    	
    }
    
    @Override
    public int hashCode() {
    	Integer i = new Integer(this.ch);
    	return i.hashCode();
    }
    @Override
	public String toString() {
		return "{element :"+ch+", frequncey :"+freq+"}";
	}
}
