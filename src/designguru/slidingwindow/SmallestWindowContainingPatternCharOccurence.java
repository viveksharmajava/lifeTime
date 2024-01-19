package designguru.slidingwindow;

import java.util.HashMap;

public class SmallestWindowContainingPatternCharOccurence {

	public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(smallestSubString(s,p));
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
