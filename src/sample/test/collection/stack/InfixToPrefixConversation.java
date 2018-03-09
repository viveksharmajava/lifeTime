package sample.test.collection.stack;

public class InfixToPrefixConversation {

	public static void main(String[] args) {

		String expression ="-i+*^+*hgf-e^dcba";
		char [] inputArray = expression.toCharArray();
		//Reversed array
		int l = inputArray.length-1;
		char temp;
		for(int i=0 ;i <=l/2 ;i++){
			
			temp = inputArray[i];
			inputArray[i] = inputArray[l-i];
			inputArray[l-i] = temp;
		}
		
		System.out.println("input array after reversed ="+new String(inputArray));
		
		//Change '(' to ')' and vice versa 
		
		inputArray = "a+b*(c^d-e)^(f+g*h)-i".toCharArray();
				
		
		//call prefix method 
		Stack prefix = prefix(inputArray);
		//Pop the element and reverse to make it prefix order 
		//Note :reverse below output
		while(prefix.peek() != null ){
			System.out.print(prefix.pop());
		}
	}
	
	
	// A utility function to check if the given character is operand
	static boolean isOperand(char ch)
	{
	    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}
	 
	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	static int prec(char ch)
	{
	    switch (ch)
	    {
	    case '+':
	    case '-':
	        return 1;
	 
	    case '*':
	    case '/':
	        return 2;
	 
	    case '^':
	        return 3;
	    }
	    return -1;
	}

	static public Stack prefix(char [] input){
		
		Stack <Character> stack = new Stack<Character>();
		Stack <Character> prefix = new Stack<Character>();
		int k=-1;
		for(int i=0 ;i < input.length ;i++){
			
			if(isOperand(input[i])){
				
				prefix.push(input[i]);
				input[++k] = input[i];
			}
			else if(input[i] == '('){
				stack.push(input[i]);
			}
			
			else if(input[i] == ')'){
				while(stack.peek() !=null && stack.peek() != '('){
					prefix.push(stack.pop());
				}
				if(stack.peek() !=null && stack.peek() != '('){//invalid experession
				 	return null;
				}else {
					stack.pop();
				}
				
			}
			else{//character is operator
				while(stack.peek() !=null &&  prec(stack.peek()) >= prec(input[i])){
					prefix.push(stack.pop());
					//input[++k] = stack.pop();
				}
				
				stack.push(input[i]);
			}
		}
		
		while(stack.peek() != null ){
			prefix.push(stack.pop());
			//input[++k] = stack.pop();
		}
		
		return prefix;
	}
}
