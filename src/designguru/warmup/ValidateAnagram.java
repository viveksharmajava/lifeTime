package designguru.warmup;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ValidateAnagram {

	public static void main(String[] args) {
System.out.println(isValidAnagram("listen","silent"));
System.out.println(isValidAnagram("rat","car"));
System.out.println(isValidAnagram("adf","adffdsf"));
	}
	
	public static boolean isValidAnagram(String s1, String s2) {
		
		if (s1 == null  || s2 == null ) return false;
		if(s1.length() != s2.length()) return false;
		HashMap <Character , Integer> charMap = new HashMap<>();
		for(int i=0 ; i < s1.length(); i++) {
		 if(charMap.containsKey(s1.charAt(i)))	{
			 charMap.put(s1.charAt(i),charMap.get(s1.charAt(i))+1);
		 }else {
			 charMap.put(s1.charAt(i),1);
		 }
		 if(charMap.containsKey(s2.charAt(i)))	{
			 charMap.put(s2.charAt(i),charMap.get(s2.charAt(i))-1);
		 }else {
			 charMap.put(s2.charAt(i),-1);
		 }
		}
		Collection<Integer> list = charMap.values();
		for(Integer a : list) {
			if(a != 0) return false;
		}
		return true;
	}

}
