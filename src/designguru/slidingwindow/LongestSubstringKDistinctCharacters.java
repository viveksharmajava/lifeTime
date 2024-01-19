package designguru.slidingwindow;

import java.util.HashMap;
/*
 * Longest Substring with K Distinct Characters (medium)
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6384513a635674508787c7c3
 */
public class LongestSubstringKDistinctCharacters {

	public static void main(String[] args) {
     String s ="aabacbebebe" ;//"araaci";
     System.out.println(longestSubstringKDistinctCharacters(s,3));
	}

	
	public static String longestSubstringKDistinctCharacters(String str,int k) {
		
		String subStr = null;
		int s =0 ,start=0;
		int e = 0, end = -1;
		int max = -1;
		
		HashMap < Character, Integer > map = new HashMap<>();
		for(int i = 0 ; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(map.size() < k || map.containsKey(c) ) {
				if(map.containsKey(c)) {
					map.put(c,map.get(c)+1);
				}
				else {
					map.put(c,1);
				}
				end = i;
			}else {
			  	
			  	if(max < (end- start+1)) {
			  		max = end -start+1;
			  		s = start;
			  		e = end;
			  		
			  	}
			  	int m = start;
			  	while( map.size() == k) {
			  		Character cc = str.charAt(m);
			  		if(map.get(cc) == 1) map.remove(cc);
			  		else {
			  			map.put(cc, map.get(cc)-1);
			  		}
			  		m++;
			  	}
			  	if(m <= i && map.size() < k) {
			  		start  = m;
			  		map.put(c, 1);
			  		end = i;
			  	}
			  }//end of else;
		
		
		}
		if(max < (end- start)) {
	  		max = end -start;
	  		s = start;
	  		e = end;
	  		
	  	}
		if(max > 0) {
			subStr = str.substring(s,e+1);
		}
		return subStr;
		
	}
}
