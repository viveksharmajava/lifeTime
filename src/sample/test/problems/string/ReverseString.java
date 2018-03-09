package sample.test.problems.string;

public class ReverseString {
	public static void main(String[] args) {
	
		String input = "abcdefghi";
		char [] charArr = input.toCharArray();
		char temp ;
		int length =charArr.length-1;
		for(int i=0;i <length ;i++){
			
			temp = charArr[i];
			charArr[i] = charArr[length];
			charArr[length] = temp;
			length--;
		}
	 String output = new String(charArr);	
	 System.out.println(input);
	 System.out.println(output);
	}

}
