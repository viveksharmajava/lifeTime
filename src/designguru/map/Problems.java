package designguru.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class Problems {

	public static void main(String[] args) {
        
		System.out.println("maximumNumberOfBaloon ="+maximumNumberOfBaloon("bbaall"));
		System.out.println("fistNonRepeatingChar="+fistNonRepeatingChar("apple"));
       System.out.println("fistNonRepeatingChar="+fistNonRepeatingChar("abcab"));
       int []a = {5, 7, 3, 7, 5, 8};
       System.out.println("\nlargest unique="+largestuniqueNumber(a));
       int []b = {1, 2, 3, 2, 1, 4, 4};
       System.out.println("\nlargest unique="+largestuniqueNumber(b));
       System.out.println("maxLengthPalindrom ="+maxLengthPalindrom("applepie"));
       System.out.println("maxLengthPalindrom ="+maxLengthPalindrom("aabbcc"));
       System.out.println("maxLengthPalindrom ="+maxLengthPalindrom("abcdaa"));
	}

	//first non-repeating character
	
   //https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-1-first-nonrepeating-character-easy
	public static Character fistNonRepeatingChar(String s) {
		LinkedHashMap <Character, LinkedList<Integer>> map = new LinkedHashMap<>();
		Character c = null;
		for(int i = 0 ; i < s.length() ; i++) {
			map.putIfAbsent(s.charAt(i), new LinkedList<Integer>());
			map.get(s.charAt(i)).add(i);
		}
		for( LinkedList<Integer> values: map.values()) {
			if(values.size() ==1) {
				c = s.charAt(values.get(0));
				break;
				
			}
		}
		return c;
	}
	
	//largest unique number
	/*
	 * Given an array of integers, identify the highest value that appears only once in the array. If no such number exists, return -1.

		Examples:
		
		Example 1:
		
		Input: [5, 7, 3, 7, 5, 8]
		Expected Output: 8
	 */
	public static int largestuniqueNumber(int [] arr) {
		LinkedHashMap <Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
		for(int i = 0 ; i < arr.length ; i++) {
			map.putIfAbsent(arr[i], new LinkedList<Integer>());
			map.get(arr[i]).add(i);
		}
		int largest  = -1;
		for( LinkedList<Integer> values: map.values()) {
			if(values.size() ==1) {
				if( arr[values.get(0)] > largest) largest =  arr[values.get(0)];
			}
		}
		return largest;
	}
	public static int maximumNumberOfBaloon(String s) {
		int result =0;
		String balloon = "balloon";
		//base case 
		if(s == null || s.length() < balloon.length()) return -1;
		
		HashMap <Character,Integer> baloonMap = new HashMap<>();
		
		baloonMap.put('b',1);
		baloonMap.put('l',2);
		baloonMap.put('o',2);
		baloonMap.put('n',1);
		System.out.println("baloonMap ="+baloonMap);
		HashMap <Character,Integer> map = new HashMap<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c)+1);
		}
		
		Set <Character > keys =  baloonMap.keySet();
		while(true) {
			for(Character key: keys) {
				
				if(!map.containsKey(key)) {
					System.out.println("input does not contains all the characters ");
					return -1;
				}
				if(map.get(key) < baloonMap.get(key)) return result;
				map.put(key,map.get(key)-baloonMap.get(key));
			
			}
			result++;
		}
	}
	public static int maxLengthPalindrom(String s) {
		HashMap <Character, Integer> map = new HashMap <>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c)+1);
		}
		int max_odd_len = -1;
		int even_len = 0;
		for(Integer v : map.values() ) {
			if(v%2 == 1 && v > max_odd_len) {
				max_odd_len = v;
			}
			else if( v%2 ==0) {
				even_len +=v;
			}
		}
		if(max_odd_len !=-1) {
			return even_len + max_odd_len;
		}
		return even_len;
	}
}
