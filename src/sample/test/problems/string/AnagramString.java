package sample.test.problems.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramString {

	/**
	 * @param args Anagram a word, phrase, or name formed by rearranging the letters of another, such as spar, formed from rasp.
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=in.readLine()) != null){
			
			String[] inputArr = s.split(" ");
			//boolean  anagram = anagramUsingHashMap(inputArr[0], inputArr[1]);
			boolean  anagram = anagramBySortingString(inputArr[0], inputArr[1]);
			System.out.println(inputArr[0]+"\t and "+inputArr[1]+"\t are anagram="+anagram);
		}
	}
	//TODO easiest way is to sort both string 
	public static boolean anagramBySortingString(String s1, String s2){
		
		char [] arr1 =s1.toCharArray();
		char [] arr2 =s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(String.valueOf(arr1).equals(String.valueOf(arr2))){
			return true;
		}
		
		return false;
	}
	
	//Here we can user hasMap and count of each character so it will count character for first string then reduce count for the same character occurance in another string
	public static boolean anagramUsingHashMap(String s1, String s2){
		boolean anagram = true;
		HashMap<Character ,Integer> hm  = new HashMap <Character ,Integer>();
		if(s1 == null || s2 == null){
			return false;
		}
		
	    int length1 = s1.length();
	    int length2 = s2.length();
	    
	    if(length1 != length2){
	    	return false;
	    }
	    
	    for(int i=0; i<length1 ; i++){
	    	Character c = s1.charAt(i);
	    	if(hm.containsKey(c)){
	    		hm.put(c, hm.get(c)+1);
	    	}else{
	    		hm.put(c, 1);
	    	}
	    }
		//reduce count for the same character  in another string
	    for(int i=0; i<length2 ; i++){
	    	Character c = s2.charAt(i);
	    	if(hm.containsKey(c)){
	    		hm.put(c, hm.get(c)-1);
	    	}else{
	    		return false;
	    	}
	    }
	    //now check in hashMap each characther should have zeoro count.
	    for(int i=0; i<length2 ; i++){
	    	Character c = s2.charAt(i);
	    	if(hm.get(c) != 0){
	    		return false;
	    	}
	    }
	    
		return anagram;
	}
	
	//another way to achieve this to use char array 256 size only condition is if string charset is unicode(256 bit)
	
	

}
