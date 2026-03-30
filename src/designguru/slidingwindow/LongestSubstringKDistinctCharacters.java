package designguru.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
 * Longest Substring with K Distinct Characters (medium)
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6384513a635674508787c7c3
 */
public class LongestSubstringKDistinctCharacters {

	public static void main(String[] args) {
     String s ="abcdeffg" ;//"araaci";
     System.out.println(longestSubstringKDistinctCharacters(s,3));
	}

	
	public static String longestSubstringKDistinctCharacters(String str,int k) {
		
		String subStr = null;
		int windowStart = 0;
		int maxLength =0;
		
		HashMap < Character, Integer > map = new HashMap<>();
		for(int i = 0 ; i < str.length(); i++) {
			Character c = str.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
			while(map.size() > k) {
				char leftChar = str.charAt(windowStart);
				map.put(leftChar, map.get(leftChar)-1);
				if(map.get(leftChar) ==0) map.remove(leftChar);
				
				windowStart++;
			}
			maxLength = Math.max(maxLength, i - windowStart +1 );
		}
		System.out.println("maxLength ="+maxLength);
		return str.substring(windowStart,windowStart+maxLength);
		
	}
	
	 public int longestSubstringKDistinct(String s, int k) {
	        int windowStart = 0;
	        int maxLength = 0;
	        Map<Character, Integer> charFrequency = new HashMap<>();

	        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
	            char rightChar = s.charAt(windowEnd);
	            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

	            while (charFrequency.size() > k) {
	                char leftChar = s.charAt(windowStart);
	                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
	                if (charFrequency.get(leftChar) == 0) {
	                    charFrequency.remove(leftChar);
	                }
	                windowStart++;
	            }

	            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	        }

	        return maxLength;
	    }

}
