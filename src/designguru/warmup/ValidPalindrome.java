package designguru.warmup;

public class ValidPalindrome {

	public static void main(String[] args) {
		
		System.out.println(isValidPalindrom("Was it a car or a cat I saw?"));

	}
	
	public static boolean isValidPalindrom(String input) {
		boolean isValid = true;
		
		char [] ch = input.toCharArray();
		int start = 0, end = ch.length-1;
		int lv = -1 , rv= -1;
		while(start < end) {
			if(isAlphabetChar(ch[start]))  lv =start;
			else start++;
			if(isAlphabetChar(ch[end]))  rv =end;
			else end--;
			
			if(lv != -1 && rv !=-1) {
				if(Character.toLowerCase(ch[lv]) != Character.toLowerCase(ch[rv])) 
					{
					System.out.println(ch[lv]+"\t "+ch[rv]);
					return false;
					}
				
				lv = rv= -1;
				start++;
				end--;
			}
			
		}
		
		return isValid;
	}
	private static boolean isAlphabetChar(char c) {
		if( (c >=65 && c <=90) ||  (c >=97 && c <=122) ) {
			//System.out.println(true);
			return true;
			
		}
		else {
			//System.out.println(false);
			return false;
		}
	}

}
