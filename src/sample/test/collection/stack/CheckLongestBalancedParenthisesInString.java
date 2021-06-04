package sample.test.collection.stack;

public class CheckLongestBalancedParenthisesInString {


	public static void main(String[] args) {
		System.out.println(findMaxLen("((()()"));       // prints 4
        System.out.println(findMaxLen("(((()"));        // prints 2
        System.out.println(findMaxLen("(((("));         // prints 0
        System.out.println(findMaxLen("()()"));         // prints 4
        System.out.println(findMaxLen("(()())(()"));    // prints 6
	}

	public static int findMaxLen(String input){
		Stack <Integer> stack = new Stack <Integer>();
		boolean isBalance = true;
		char [] inputArr = input.toCharArray();
		int maxLen=0;
		stack.push(-1);// initialize the stack by -1
		for(int i=0 ;i < inputArr.length ; i++){
			if(isPush(inputArr[i])) {
				stack.push(i); 
				
			}
			else if(isPop(inputArr[i])){
				stack.pop();
				if(stack.isEmpty()) stack.push(i);
				int len = i - stack.peek();
				if( len > maxLen) maxLen = len;
				
			}
			else {//wrong experession
				//isBalance =false;
				break;
			}
		}
		 
		
		//	System.out.println("Longest Balanced  sub string length="+maxLen);
		return maxLen;
	
	}
	
	private static boolean isPush(char c){
		switch(c){
		case '{' :
		case '(' :
		case '[' : return true;
		default : return false;
		}
	}
	
	private static  boolean isPop(char c){
		switch(c){
		case '}' :
		case ')' :
		case ']' : return true;
		default : return false;
		}
	}
	
	private static char reverse(char c){
		switch(c){
		case '}' : return '{';
		case ')' : return '(';
		case ']' :  return '[';
		default : return '$';
		}
	}


}
