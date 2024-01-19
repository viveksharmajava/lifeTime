package designguru.warmup;

import java.util.HashSet;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63d9b8744bb2155485a195e9
 * Problem Statement:
 * Given a string s, reverse only all the vowels in the string and return it.

 *The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

   Example 1:

   Input: s= "hello"
    Output: "holle"
 */
public class ReverseVowels {

	public static void main(String[] args) {
     
		String s = "DesignGUrus";
		System.out.println(reverseVowels(s));
	}
	
	public static String reverseVowels(String input) {
	  HashSet <Character> vowels = new HashSet<Character>();
	  vowels.add('a');
	  vowels.add('e');
	  vowels.add('i');
	  vowels.add('o');
	  vowels.add('u');
	  vowels.add('A');
	  vowels.add('E');
	  vowels.add('I');
	  vowels.add('O');
	  vowels.add('U');
	  char [] ch = input.toCharArray();
	   int lv = -1;
	   int rv = -1;
	   int start =0;
	   int end = input.length()-1;
	   while(start < end) {
		   if(vowels.contains(ch[start])) {
			   lv = start;
		   }
		   if(vowels.contains(ch[end])) {
			   rv = end;
		   }
		   if(lv != -1 && rv != -1) {
			   char temp = ch[lv];
			   ch[lv] = ch[rv];
			   ch[rv] = temp;
			   lv = -1;
			   rv = -1;
		   }
		   start++;
		   end--;
	   }
	   return new String(ch);
	}

}
