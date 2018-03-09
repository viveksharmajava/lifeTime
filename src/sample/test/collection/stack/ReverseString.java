package sample.test.collection.stack;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString("ABCD"));
		

	}
	
	public String reverseString(String input){
		
		Stack <Character> stack = new Stack();
		for(int i=0; i<input.length();i++){
			stack.push(input.charAt(i));
		}
		
		char [] output = new char[input.length()];
		int i=0;
		while(stack.peek() != null){
			output[i++] = stack.pop();
		}
		return new String(output) ;
	}
}
