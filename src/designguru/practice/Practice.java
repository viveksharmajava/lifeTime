package designguru.practice;

import java.util.Arrays;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
      
		int zero = '0';
		int nine = '9';
		System.out.println(zero);
		System.out.println(nine);
		
		System.out.println(decodeString("100[leetcode]")); //"100[leetcode]"
		
		//3[z]2[2[y]pq4[2[jk]e1[f]]]ef
	}
	/*
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/651b8ab4d4b2fac24039f29e
	 * Input: "3[a3[c]]"
	   Expected Output: "acccacccaccc"
	   Justification: The inner 3[c] is decoded as ccc, and then a is appended to the front, forming acc
	 */
	public static String decodeString(String str) {
		
		Stack <Character> s = new Stack <>();
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if( c == '[') continue;
			if(c !=']') s.add(c);
			else if (c ==']') {
				StringBuffer temp = new StringBuffer();
				System.out.println("s ="+s);
			   while( !s.isEmpty() && ! ( s.peek() >=48 && s.peek() <=57)  ) {
					temp.append(s.pop());
				}
			   System.out.println("s ="+s);
			   System.out.println("temp ="+temp);
			   String number = new String();
			   while( !s.isEmpty() &&  ( s.peek() >=48 && s.peek() <=57)  ) {
					//temp.append(s.pop());
				   number = (s.pop() -48  )+ number;
				}
			   System.out.println("number ="+number);
			   
				//int repeatation = Integer.parseInt(number);
			   
			   
				int repeatation = 0;
				if(number != null && !"".equals(number)) {
					repeatation =Integer.parseInt(number);
				}
				String repeat = temp.reverse().toString();
				temp = new StringBuffer();
				while(repeatation > 0 ) {
				temp.append(repeat);
				repeatation--;
			}
			
				for(int j = 0 ; j < temp.length(); j++) {
					s.add(temp.charAt(j));
				}
				
		}
			
		
	}
		StringBuffer temp = new StringBuffer();
		   while( !s.isEmpty()  ) {
				temp.append(s.pop());
			}
		 System.out.println(temp.reverse());
		return temp.toString();
	}
}

