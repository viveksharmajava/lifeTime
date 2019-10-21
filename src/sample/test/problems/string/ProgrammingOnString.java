package sample.test.problems.string;

import java.util.HashMap;

public class ProgrammingOnString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {/*
		// TODO Auto-generated method stub
		ProgrammingOnString programming = new ProgrammingOnString();
		
		// 1. find if the given string is uni-character string or not.
		String unicode= "\u0009";
		System.out.println("unicode="+unicode);
		System.out.println("is unique="+programming.checkUniCharacterString("aba"));
		//2.  find number of duplicate character in a given string
		HashMap<String, Integer> charMap = programming.findDuplicateChar("aba");
		Set<Map.Entry<String, Integer>> set = charMap.entrySet();
		
		for(Map.Entry <String, Integer> e : set){
			
			System.out.println(e.getKey()+"="+e.getValue());
		}
		
		//3.  find sub string in given string
		 *
	*/
	 
			  
	  }  
	  
	
	  
	 
	
	//This program will be  having time complexity O(n^2)
	public boolean checkUniCharacterString(String source){
		
		boolean isUnique = true;
		int sourceLenght=  source !=null?source.length():0;
		for(int i=0;i<sourceLenght ; i++){
			char c = source.charAt(i) ;
			if( i != source.lastIndexOf(c)) isUnique = false; //too much costly operation
			
			break;
		}
		return isUnique;
	}
	
	public HashMap<String, Integer> findDuplicateChar(String source){
		
		int sourceLenght=  source !=null?source.length():0;
		HashMap<String, Integer> charMap = new HashMap<String,Integer>();
		
		for(int i=0;i<sourceLenght ; i++){
			if(charMap.containsKey(""+source.charAt(i))){
				charMap.put(""+source.charAt(i),charMap.get(""+source.charAt(i))+1);
			}
			else{
				charMap.put(""+source.charAt(i),1);
			}
		}
		
		return charMap;
	}
	
	

}
