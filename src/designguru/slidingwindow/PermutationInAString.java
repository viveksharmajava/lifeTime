package designguru.slidingwindow;

import java.util.HashMap;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6385d76c4a29c96532f7c16b
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Input: String="oidbcaf", Pattern="ABC"   
   Output: true   
   Explanation: The string contains "bca" which is a permutation of the given pattern.
    
 */
public class PermutationInAString {

	public static void main(String[] args) {
     int c = 'z';
		System.out.println(c);
		StringBuffer sb = new StringBuffer("abc");
		sb.delete(0, 1);
		System.out.println(sb);
		System.out.println(isPermuationString("oidbcaf","ABC"));
	}
	
	public static boolean isPermuationString(String str, String pattern) {
	   pattern = pattern.toLowerCase();
	   int [] patternArr = new int [26];
	   for(int i = 0 ; i < pattern.length() ; i++) {
		   int  c = pattern.charAt(i)-97;
		   patternArr[c] = patternArr[c] + 1;
	   }
	   StringBuffer sb = new StringBuffer(pattern.length());
	   sb.append(str.substring(0,pattern.length()));
	   if(isPermutated(patternArr,sb)) return true;
	   for(int i = pattern.length(); i < str.length(); i++) {
		   sb.delete(0, 1);
		   sb.append(str.charAt(i));
		   if(isPermutated(patternArr,sb)) return true;
		   
	   }
	   return false;
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
    
    
    public static boolean containsPermutation(String s, String p) {
		HashMap<Character,Integer> mapP = new HashMap<Character, Integer>();
		for(int i=0;i<p.length();i++) {
			int val=1;
			char key = p.charAt(i);
			if(mapP.containsKey(key)) {
				val=mapP.get(key);
				val++;
			}
			mapP.put(key, val);
		}
		int k = p.length(); //window size
		int start=0,end=0;
		HashMap<Character,Integer> mapS = new HashMap<Character,Integer>();
		while(end<s.length()) {
			if(!mapP.containsKey(s.charAt(end))) {
				start++;
				end=start;
				mapS.clear();
				continue;
			}
			int val = 1;
			if(mapS.containsKey(s.charAt(end))) {
				val = mapS.get(s.charAt(end));
				val++;
			}
			mapS.put(s.charAt(end), val);
			if(end-start+1==k) {
				int count=0;
				while(count<k) {
					int val1 = mapS.get(s.charAt(start+count));
					int valFromMap = mapP.get(s.charAt(start+count));
					if(val1!=valFromMap) {
						start++;
						end++;
						break;
					}
					count++;
				}
				return true;
			} else {
				end++;
			}
		}
		return false;
	}
    /*
     * Problem: 
     * Solution: https://github.com/Ayu-99/Data-Structures/blob/master/Leetcode%20Challenge/February/java/Permutation%20in%20String.java
     * 
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(char c : s1.toCharArray()) map[c - 'a']++;
        int j = 0, i = 0;
        int count_chars = s1.length();
        while(j < s2.length()){
            if(map[s2.charAt(j++) - 'a']-- > 0)
                count_chars--;
            if(count_chars == 0) return true;
            if(j - i == s1.length() && map[s2.charAt(i++) - 'a']++ >= 0)
                count_chars++;
        }
        return false;
    }
}
