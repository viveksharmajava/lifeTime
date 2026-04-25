package designguru.trie;

import java.util.Arrays;

public class Trie {

	private static final int ALPHABETS_SIZE = 26;
	
	 static class TrieNode{
		TrieNode [] childner = new TrieNode[ALPHABETS_SIZE];
		boolean isEndOfWord;
		
		
		TrieNode(){
		}
		
		
	}
	
public static void insert(String key){
		
		int level ;
		int  keylen = key.length();
		TrieNode crawl = root;
		int index;
		for(level = 0;  level < keylen ; level++){
			index = key.charAt(level) - 'a'; // get the childer[] index position
			if(crawl.childner[index] == null){
				crawl.childner[index] = new TrieNode();	
			}
			crawl = crawl.childner[index];
		}
		crawl.isEndOfWord = true;
	}
	
public static boolean search(String key){
	if (root == null) return false;
	int keylen = key.length();
	
	TrieNode crawl = root;
	int level, index;
	for(level = 0;  level < keylen ; level++){
		index = key.charAt(level) - 'a'; // get the childer[] index position
		if(crawl.childner[index] == null){
			return false;
		}
		crawl = crawl.childner[index];
	}
	return crawl.isEndOfWord;
}


public static int modifiedSearch(String key){ //bluebirdskyscraper
	if (root == null) return -1;
	int keylen = key.length();
	
	TrieNode crawl = root;
	int level, index;
	for(level = 0;  level < keylen ; level++){
		index = key.charAt(level) - 'a'; // get the childer[] index position
		if(crawl.childner[index] == null){
			return -1;
		}
		crawl = crawl.childner[index];
	}
	return level;
}
  static TrieNode root = new TrieNode(); 
	public static void main(String[] args) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"tthe", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
        root = new TrieNode();
      
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
      
        // Search for different keys
        if(search("tthe") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
         
	}

}
