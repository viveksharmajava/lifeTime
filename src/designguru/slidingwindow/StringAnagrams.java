package designguru.slidingwindow;

import java.util.HashMap;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6385d8b24a29c96532f7c329
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
	Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N! permutations (or anagrams) of a string having NN characters. For example, here are the six anagrams of the string “abc”:
	abc
	acb
	bac
	bca
	cab
	cba
	Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 [ 3, 5    ]   cab ( c: 1 ,a : 1, b:1

 */
public class StringAnagrams {

	public static void main(String[] args) {
     String s = "oidbcaf";
     String pattern = "ABC";
     findAnagrams(s, pattern);
	}
	public static void findAnagrams(String str, String pattern) {
		   pattern = pattern.toLowerCase();
		   int [] patternArr = new int [26];
		   for(int i = 0 ; i < pattern.length() ; i++) {
			   int  c = pattern.charAt(i)-97;
			   patternArr[c] = patternArr[c] + 1;
		   }
		   StringBuffer sb = new StringBuffer(pattern.length());
		   sb.append(str.substring(0,pattern.length()));
		   if(isPermutated(patternArr,sb)) {
			   System.out.println("Anagram starting from "+0);
		   }
		   for(int i = pattern.length(); i < str.length(); i++) {
			   sb.delete(0, 1);
			   sb.append(str.charAt(i));
			   if(isPermutated(patternArr,sb)) {
				   System.out.println("Anagram starting from "+(i+1-pattern.length()));
			   }
			   
		   }
		  
		}
	    private static boolean isPermutated(int [] patternCounts , StringBuffer sub) {
	    	HashMap <Character, Integer> map = new HashMap<>();
	    	for(int i=0; i < sub.length(); i++) {
	    		map.put(sub.charAt(i), map.getOrDefault(sub.charAt(i), 0)+1);
	    	}
	    	for( char key : map.keySet()) {
	    		
	    		if(patternCounts[key-97] != map.get(key)) return false;
	    	}
	    	return true;
	    }
}
