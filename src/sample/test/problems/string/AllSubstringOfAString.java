package sample.test.problems.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AllSubstringOfAString {

	public static void main(String[] args) {
		//subStrings("abcd");
		//bodmas("a-(b-c)");
		//bodmas("a-(-b-c)");
		//bodmas("a+(b-c)");
		bodmas("a+b-(c-d-(e-f))");
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
	
	
	/**write a program for BODMAS rule , you don't need to calculate the result of expression only need to follow _,+ rule in BODMAS
	 * For example : a+(b-c) = a+b-c
	 *  		   : a-(b-c) = a-b+c
	 *  		   : a+(b) 	 = a+b
	 *  		   : a-(b+c-d -(e-f)) : a-b-c+d+e-f
	 */
	
	/*
	 * Rough work :  a-(b-c)   
	 */
	static void bodmas(String str) {
		if(str == null || str.length() < 2) {
			System.out.println(str);  return;
		}
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		Character prev= str.charAt(0);
		int i = 1;
		for(; i < str.length() ;) {
			
		 char c = str.charAt(i);
		 if((prev == '+' || prev == '-') && c == '(') {
			 stack.add(c);
			 i++;
			 int count = 1;
			 HashMap<Integer,Character> hm = new HashMap<Integer, Character>();
			 hm.put(count, prev);
			 String calculated = "";
			 while(hm.size()>0 && stack.size() > 0) {
				if(i < str.length()) {
				 char ch = str.charAt(i); i++;
				 if(ch != ')') {
					 stack.add(ch);
					 if(ch == '(') {
						 count++;
						 hm.put(count, str.charAt(i-2)); // because i already has increased
					 }
				 }
				 else {
					 char p;
					
					 char mapChar = hm.remove(count);
					 String s =calculated;
					  count--;
					while( (p = stack.pop()) !='(') {
					  
					  if(p != '+' && p !='-') s = p+s;
					  else if ( p == '-' && mapChar == '-') {
						  s = "+"+s;
					  }
					  else if ( p == '+' && mapChar == '+') {
						  s = "+"+s;
					  }
					  else {
						  s = "-" +s;
					  }
					}
					if(s != null && (s.charAt(0)!='+' && s.charAt(0)!='-')) {
						s = mapChar + s; // handle last char '+/-' also need to check if s' first character should not be +/- for example :a-(-b-c)
					}
					calculated = s;
					
				 }
				}
			 }
			 
			 sb.append(calculated);
			 
		 }
		 else {
			 sb.append(prev); 
			 prev = c;
			 i++;
		 }
		}
		
		System.out.println(sb); 
	 }
	 


}
