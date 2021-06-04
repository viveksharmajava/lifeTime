package ds500problems;
/**
 * 
 * @author viveksharma
 *
 */
public class Trie {

	Node [] root =  null;//new Node[26];
	
	public static void main(String[] args) {
//		int a  = 'b';
//		a = a%97;
//		char c = (char)( a + 97);
//  System.out.println(a);
//  System.out.println(c);
  
  Trie trie = new Trie();
  trie.insert("abb");
  trie.insert("add");
  trie.insert("addition");
  trie.insert("aim");
  trie.insert("adore");
  trie.insert("ball");
  trie.insert("backet");
  trie.insert("batting");
  trie.insert("bitter");
  System.out.println("abb="+trie.search("abb"));
  System.out.println("add="+trie.search("add"));
  System.out.println("addition="+trie.search("addition"));
  System.out.println("bucket="+trie.search("bucket"));
  System.out.println("bucket="+trie.search("bat"));
  System.out.println("aiming="+trie.search("aiming"));
  
	}
	Trie(){
		root = new Node[26];
	}
	
	public void insert(String s) {
		 Node [] searching = root;
		 int c ;
		 Node n;
		for(int i = 0 ; i < s.length() ; i++) {
		 	c = s.charAt(i);
		 	c = c%97;
		 	if( searching[c] == null) {
		 		char ch = (char)( c + 97);
		 		 boolean isLastChar = (i+1) == s.length()?true : false;
		 		n = new Node(new Character(ch),isLastChar);
		 		searching[c] = n;
		 		searching = n.next;
		 	}
		 	else {
		 		searching = searching[c].next;
		 	}
		}
	}
	
	public int search(String s) {
		int found = 1;

		 Node [] searching = root;
		 int c ;
		 Node n;
		for(int i = 0 ; i < s.length() ; i++) {
		 	c = s.charAt(i);
		 	c = c%97;
		 	if( searching[c] == null) {
		 		found = 0;
		 		return found;
		 	}
		 	else {
		 		if((i+1) == s.length() &&  searching[c].lastCharOfWord)
		 			return 1;
		 		else if((i+1) == s.length() &&  !searching[c].lastCharOfWord)
		 		    return 0;
		   
		 		searching = searching[c].next;
		 	}
		}
	
		return found;
	}
 class Node {
	 Character c;
	 boolean lastCharOfWord;
	 Node [] next;
	 Node(Character val,boolean lastChar){
		 this.c = val;
		 this.lastCharOfWord = lastChar;
		 this.next = new Node[26];
	 }
 }
}
