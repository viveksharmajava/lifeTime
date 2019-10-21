package sample.test.problems.string;

import java.util.HashSet;
import java.util.Set;

public class AllSubstringOfAString {

	public static void main(String[] args) {
		subStrings("abcd");
	}
	
	public static Set <String> subStrings(String input){
		
		Set <String> set  = new HashSet<String>();
		
		for(int i = 1 ; i <= input.length(); i++) {
			
			int m = 0;
			int n = i;
			
			while(n <= input.length()) {
				
				String sub = input.substring(m,n);
				System.out.println(sub);
				n++;
				m++;
			}
		}
		
		return null;
	}

}
