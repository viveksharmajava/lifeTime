package sample.test.collection.stack;

public class CheckLongestBalancedParenthisesInString {


	public static void main(String[] args) {
		CheckLongestBalancedParenthisesInString balanceP = new CheckLongestBalancedParenthisesInString();
		balanceP.matchingSubStringLength("[[[[{{()()]()}");
		balanceP.matchingSubStringLength("�[(])");
	}

	public void matchingSubStringLength(String input){
		Stack <Character> stack = new Stack <Character>();
		boolean isBalance = true;
		char [] inputArr = input.toCharArray();
		int maxLen=0;
		int len = 0;
		for(int i=0 ;i < inputArr.length ; i++){
			if(isPush(inputArr[i])) {
				stack.push(inputArr[i]); 
				
			}
			else if(isPop(inputArr[i])){
				
				 char c  = stack.pop();
				if ( reverse(inputArr[i]) == c ){
					len +=2;
				}
				else{
					
					if( len > maxLen) {
						maxLen = len;
						len = 0;
					}
					
				}
			}
			else {//wrong experession
				//isBalance =false;
				break;
			}
		}
		if( len > maxLen) {
			maxLen = len;
		}
		
			System.out.println("Longest Balanced  sub string length="+maxLen);
	
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
