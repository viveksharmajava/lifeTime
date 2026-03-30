package designguru.slidingwindow;

import java.util.HashMap;
/*
 * Problem:Problem Challenge 3: Smallest Window containing Substring (hard)
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-3-smallest-window-containing-substring-hard
   
 *
 */
public class SmallestWindowContainingPatternCharOccurence {

	public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(smallestSubString(s,p));//not efficient..
        //below one is accurate..
        System.out.println("minWindow ="+minWindow("ADOBECODEBANC", "ABC"));

	}
	
	
	//Problem 16
    //Minimum window substring
    //https://leetcode.com/problems/minimum-window-substring/description/
	//Time O(m+n)
	//Space O(128) = O(1)
	 public static String minWindow(String s, String t) {
		 int[] count = new int[128];
		    int required = t.length();
		    int bestLeft = -1;
		    int minLength = s.length() + 1;

		    for (final char c : t.toCharArray())
		      ++count[c];

		    for (int l = 0, r = 0; r < s.length(); ++r) {
		      if (--count[s.charAt(r)] >= 0)
		        --required;
		      while (required == 0) {
		        if (r - l + 1 < minLength) {
		          bestLeft = l;
		          minLength = r - l + 1;
		        }
		        if (++count[s.charAt(l++)] > 0)
		          ++required;
		      }
		    }

		    return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
	       
	 }
	public static String smallestSubString(String str , String pattern) {
           System.out.println("Input String "+str+"\t pattern "+pattern);
		   pattern = pattern.toLowerCase();
		   HashMap <Character, Integer> patternMap = new HashMap<>();
		   for(int i = 0 ; i < pattern.length() ; i++) {
			   patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
		   }
		   StringBuffer sb = new StringBuffer(pattern.length());
		   sb.append(str.substring(0,pattern.length()));
		   System.out.println(sb);
		   if(isPermutated(patternMap,sb)) {
			   System.out.println("Smallest window starting from "+0);
			   return new String(str.substring(0,pattern.length()));
		   }
		   int start = 0;
		   int min_lengh = Integer.MAX_VALUE;
		   for(int i = pattern.length(); i < str.length(); i++) {
			   sb.append(str.charAt(i));
			  // System.out.println(sb);
			   int k =start;
			   if(isPermutated(patternMap,sb)) {
				  // System.out.println("inside if "+ sb);
				   while(isPermutated(patternMap,sb.delete(0, 1))) {
					  // System.out.println("inside while "+ sb);
					   k++;
			   }
			   start = k;
			   if(sb.length()+1 < min_lengh) {
				   min_lengh = sb.length()+1;
				   //System.out.println(min_lengh);
			   }
			   }
			   
		   }
		   if(min_lengh != Integer.MAX_VALUE) {
			   //System.out.println("start "+start);
			   StringBuffer  substring = new StringBuffer();
			   for(int i=1; i <=min_lengh; i++,start++) {
				   substring.append(str.charAt(start));
			   }
			   return  substring.toString();
		   }
		   return null;
	}
	private static boolean isPermutated(HashMap<Character , Integer> patternCounts , StringBuffer sub) {
    	HashMap <Character, Integer> map = new HashMap<>();
    	for(int i=0; i < sub.length(); i++) {
    		map.put(sub.charAt(i), map.getOrDefault(sub.charAt(i), 0)+1);
    	}
    	for( char key : patternCounts.keySet()) {
    		if(map.get(key) == null ||  patternCounts.get(key) > map.get(key)) return false;
    	}
    	return true;
    }
	
	
	

}
