package sample.test.problems.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckStringIsRotation {

	/**
	 * @param args
	 * Assume you have a method isSubstring which 
	 * checks if one word is a substring of another.
	 *  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 
	 *  using only one call to isSubstring 
	 * (i.e., �waterbottle� is a rotation of �erbottlewat�).
	 */
	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s= in.readLine()) !=null){
			
			String [] inputArr = s.split(" ");
			System.out.println("input String ="+s);
			System.out.println("is rotation string="+isSubstring(inputArr[0],inputArr[1]));
		}
	}
	
	public static boolean isSubstring(String s1 ,String s2){
		boolean isRotation = false;
		if( s1 == null || s2 == null) return isRotation;
		
		int l1 = s1.length();
		int l2 = s2.length();
		if( l1 != l2) return isRotation;
		if(l1 == 1 && s1.equals(s2)) return true;
		
		for(int i=0 ;i<l1-1 ;i++){
			
			//StringBuilder sub = new StringBuilder(s1.substring(0, i+1));
			StringBuilder sub = new StringBuilder(s1.substring(i+1, l1));
			sub.append(s1.substring(0, i+1));
			if(sub.toString().equals(s2)){
				isRotation = true;
				break;
			}
			
		}
	    
		return isRotation;
		
	}

	
	/*
	 * 2. Else, concatenate s1 with itself and see whether s2 is substring of the result.
      input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap
     input: s1 = apple, s2 = ppale ==> apple is not a substring of ppaleppale
	 */
	public static boolean isRotation(String s1, String s2) {
		 int len = s1.length();
		 /* check that s1 and s2 are equal length and not empty */
		 if (len == s2.length() && len > 0) {
		 /* concatenate s1 and s1 within new buffer */
		 String s1s1 = s1 + s1;
		 return isSubstring(s1s1, s2);
		 }
		 return false;
		 }
}
