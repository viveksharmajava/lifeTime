package designguru.warmup;
/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63daaa1a0d01fe363b68c8d4
 * Problem Statement
	Given an array of strings words and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
	
	Example 1:
	
	Input: words = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"], word1 = "fox", word2 = "dog"
	Output: 5
	Explanation: The distance between "fox" and "dog" is 5 words.
	Example 2:
	
	Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
	Output: 1
	Explanation: The shortest distance between "a" and "b" is 1 word
 */
public class ShortestWordDistance {

	public static void main(String[] args) {
        String [] input  = {"a", "c", "d", "b", "a"};
        
		System.out.println(shortestDistance(input,"a","b"));
	}
	
	public static int shortestDistance(String [] input , String w1, String w2) {
		int dist = -1;
		int a_index=-1;
		int b_index=-1;
	    boolean a_found = false , b_found= false;
		for(int i=0 ; i < input.length; i++) {
			if(w1.equals(input[i])) {
				a_found = true;
				a_index= i;
			}
			else if(w2.equals(input[i])) {
				b_found = true;
				b_index = i;
			}
			if(a_found && b_found) {
				dist = Math.abs(a_index-b_index);
				a_found = false;
				b_found = false;
			}
			else if ( a_found && !b_found  && dist !=-1) {
				int new_dist = a_index - b_index;
				if(new_dist < dist ) dist  = new_dist;
			}
			else if ( b_found && !a_found  && dist !=-1) {
				int new_dist = b_index - a_index;
				if(new_dist < dist ) dist  = new_dist;
			}
		}
		return dist;
	}

}
