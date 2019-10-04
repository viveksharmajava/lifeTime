package sample.test.problems.string;

import sample.test.problems.linkedLists.LinkedList;
import sample.test.problems.linkedLists.Node;

/**
 * 
 * @author viveksharma
 * 
 * Problem: Find the first non-recurring character in a string. Input “Teeter” output “r”.
 *Approach : 
 * Assumption: 
 *   lets assume string contains only alphabet from a-z and all are small letter.
 * Solution.
 *  (A) take an array of size 26 of Node type.
 *  (B) iterate over given string and 
 *    -->place each unique character into the the list node.
 *    --> same time place that node to character array based on the char value.
 *        --> Before placing any element/node into list or array please check below case.
 *        -->If char array already contains any node at that index ( for example 0 index for char 'a' after mode %97)
 *           it means that there is already character 'a' was present in previous part of string.
 *           so no need to insert that node into array.
 *           also delete the node from List only don't delete it from array because we need to keep it for future check.
 *  (C) the first node of the list is first Non repeating character of given String.       
 *       
 */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
      char c = firstNonRepeatingChar("vivek");
      System.out.println(c);
	}
    
	static char firstNonRepeatingChar(String input) {
		
		Node [] nodeArr = new Node[26];
		LinkedList<String> list = new LinkedList<String>();
		Node <String> a = null;
		int c;
		for(int i = 0 ; i < input.length() ; i++) {
			c = input.charAt(i);
			Character ch = new Character((char)c);
			
		 	c = c%97;
		 	if(nodeArr[c] != null)
		 	{
		 		list.removeGivenNode(nodeArr[c]);
		 	}else {
		 		a = new Node(ch.toString());
		 		nodeArr[c] = a;
		 		list.addNode(a);
		 	}
			
		}
		//String s = list.getFirst();
		int res = list.getFirst().charAt(0) ;
		
		return (char)res;
	}
}
