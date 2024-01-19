package designguru.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Longest Substring with Same Letters after Replacement (hard)
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6385d4b24a29c96532f7bb19
 * 
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

	Example 1:
	
	Input: String="aabccbb", k=2  
	Output: 5  
	Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
	Example 2:
	
	Input: String="abbcb", k=1  
	Output: 4  
	Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
	Example 3:
	
	Input: String="abccde", k=1
 */
public class LongestSubstringWithSameLetters {

	public static void main(String[] args) {
		String s = "aabccbb";
		int k=2 ;
		System.out.println(longestSameLetter(s,k));
	}
	
	public static int longestSameLetter(String str, int k) {
		String subStr = null;
		
		HashMap <Character,ArrayList<Integer>> hm = new HashMap<>();
		for(int i = 0 ; i < str.length(); i ++) {
		  Character  c = str.charAt(i);
		  if(hm.containsKey(c)) {
			  hm.get(c).add(i);
		  }else {
			 ArrayList <Integer> indexed =   new ArrayList<Integer>();
			 indexed.add(i);
			 hm.put(c ,indexed );
		  }
		}
		
		Character max_char ;
		int max = -1;
		for(Character c : hm.keySet()) {
			 ArrayList <Integer> indexList = hm.get(c);
			 int temp = k;
			 int prev = indexList.get(0);
			 int start = prev;
			// int  s = -1 , e = -1;
			 for(int m = 1 ; m < indexList.size(); m++) {
				 int current = indexList.get(m);
				 if((current-1 - prev) <= temp ) {
					 temp = temp - (current-1 - prev);
					 prev = current;
					 if( (current+1 - start) > max ) {
						 max = current+1 - start;
						// s = start ; e = current;
					 }
				 }else {
					 break;
				 }
			 }
		}
		return max;
	}

}
