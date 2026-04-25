package designguru.trie;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class IndexPairsOfString {

	public static void main(String[] args) {

		LinkedHashMap <Character , LinkedList<Integer>> map = new LinkedHashMap<>();
        // Input keys (use only 'a' through 'z' and lower case)
        String keys = "bluebirdskyscraper";
       for(int i=0; i < keys.length() ; i++){
    	   Character c = keys.charAt(i);
    	   System.out.println("char "+c+" position"+i);
    	   map.putIfAbsent(c, new LinkedList<Integer>());
    	   map.get(c).add(i);
       }
       System.out.println(map);

	}

}
