package designguru.stack;

import java.util.ArrayList;


class MinStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		ms.push(1);
		ms.push(4);
		
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		
		

	}
	ArrayList<Integer> stack = new ArrayList<>();
   ArrayList<Integer> min = new ArrayList<>();
   // int i = -1;
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        if(min.size() > 0 && min.getLast() < val){
             min.add(min.getLast());
        }
        else{
            min.add(val);
        }
       // i++;

    }
    
    public void pop() {
        if(stack.size() > 0) {
            stack.removeLast();
            min.removeLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}


