package sample.test.collection.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 
 * Given an expression string exp, examine whether the pairs and the orders of �{�,�}�,�(�,�)�,�[�,�]� are correct in exp.
For example, the program should print 'balanced' for exp = �[()]{}{[()()]()}� and 'not balanced' for exp = �[(])�
 */
public class CheckBalancedParentheses {

	public static void main(String[] args) {
		CheckBalancedParentheses balanceP = new CheckBalancedParentheses();
		balanceP.isBalancedParentheses("[()]{}{[()()]()}");
		balanceP.isBalancedParentheses("�[(])");
		balanceP.isBalancedParentheses("[[]");
		System.out.println(isValid("[[]]"));
	}

	 public static boolean isValid(String s) {
		    Deque<Character> stack = new ArrayDeque<>();

		    for (final char c : s.toCharArray())
		      if (c == '(')
		        stack.push(')');
		      else if (c == '{')
		        stack.push('}');
		      else if (c == '[')
		        stack.push(']');
		      else if (stack.isEmpty() || stack.pop() != c)
		        return false;

		    return stack.isEmpty();
	 } 
	public boolean isBalancedParentheses(String input){
		Stack <Character> stack = new Stack <Character>();
		boolean isBalance = true;
		char [] inputArr = input.toCharArray();
		for(int i=0 ;i < inputArr.length ; i++){
			if(isPush(inputArr[i])) stack.push(inputArr[i]); 
			else if(isPop(inputArr[i])){
				if(stack.isEmpty()) return false;
				char c  = stack.pop();
				if ( reverse(inputArr[i]) != c ){
					isBalance =false;
					break;
				}
			}
			else {//wrong experession
				isBalance =false;
				break;
			}
		}
		if(!stack.isEmpty()) isBalance = false;
		if( isBalance){
			System.out.println("balanced");
		}else{
			System.out.println("not balanced");
		}
		return isBalance;
	}
	
	private boolean isPush(char c){
		switch(c){
		case '{' :
		case '(' :
		case '[' : return true;
		default : return false;
		}
	}
	
	private boolean isPop(char c){
		switch(c){
		case '}' :
		case ')' :
		case ']' : return true;
		default : return false;
		}
	}
	
	private char reverse(char c){
		switch(c){
		case '}' : return '{';
		case ')' : return '(';
		case ']' :  return '[';
		default : return '$';
		}
	}
}
