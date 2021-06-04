package ds500problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProblemsOnString {

	public static void main(String[] args) {

		System.out.println(isPalindrome("abcdcba", 0, 6));
		// palindromic string
		String str = "ABCBA";
		// rotate it by 2 units
		str = str.substring(2) + str.substring(0, 2);

		System.out.println("isRotatedPalindrome="+isRotatedPalindrome(str));
		System.out.println("isRotatedP_Using_LongestPalindromeSubStr="+isRotatedP_Using_LongestPalindromeSubStr(str));
		System.out.println("getExcelCoumnName for 24="+getExcelCoumnName(24));
		System.out.println("getExcelCoumnName for 26="+getExcelCoumnName(26));
		System.out.println("getExcelCoumnName for 27="+getExcelCoumnName(27));
		System.out.println("getExcelCoumnName for 103="+getExcelCoumnName(103));
		System.out.println("patternMatching="+patternMatching("ABCDE","BCD"));
		System.out.println("patternMatching="+patternMatching("ABCDE","AB"));
		System.out.println("patternMatching="+patternMatching("ABCDE","DE"));
		System.out.println("patternMatching="+patternMatching("ABCDE","A"));
		System.out.println("patternMatching="+patternMatching("ABCDE","D"));
		System.out.println("patternMatching="+patternMatching("ABCDE","EF"));
		System.out.println("patternMatching="+patternMatching("ABCDE","OK"));
		System.out.println("patternMatching="+patternMatching("ABCDE","BD"));
		System.out.println("Permuations");
		permutation("ABC");
		System.out.println("Reversed Integer");
		int reverse = reverseInt(Integer.MAX_VALUE);
		System.out.println("Integer Max="+Integer.MAX_VALUE);
		System.out.println("reversed ="+reverse);
		
		System.out.println("Pattern Match");
		// list of words
        List<String> words = Arrays.asList("leet", "abcd", "loot", "geek",
                "cool", "for", "peer", "dear", "seed",
                "meet", "noon", "otto", "mess", "loss");
 
        // given pattern
        String pattern = "moon";
 
        patternMatch(words, pattern);
        
        //group anagram 
     // list of words
        String[] words2 = {
                "CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
                "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN"
        };
        System.out.println("Group Anagram");
        groupAnagram(Arrays.asList(words2));
        String first = "ADCB";
        String second = "ABCD";
 
        if (isTransformable(first.toCharArray(), second.toCharArray()))
        {
            System.out.println("The minimum operations required to convert the string "
                                    + first + " to string " + second + " are "
                                    + getMinimumOperations(first, second));
        }
        else {
            System.out.println("The string cannot be transformed");
        }
        
      //  Determine whether a string can be transformed into another string in a single edit
       System.out.println("Determine whether a string can be transformed into another string in a single edit");
        System.out.println(checkEditDistance("xyz", "xz"));     // true
        System.out.println(checkEditDistance("xyz", "xyyz"));   // true
        System.out.println(checkEditDistance("xyz", "xyx"));    // true
        System.out.println(checkEditDistance("xyz", "xxx"));    // false
        
        
        String str2 = "abcbdbdbbdcdabd";
        int k = 2;
 
        System.out.print(longestSubStringKDistinctChars(str2, k));
	}
	
	// Function to find the longest substring of a given string containing
    // `k` distinct characters using a sliding window
	// https://www.techiedelight.com/find-longest-substring-containing-k-distinct-characters/
	
	public static String longestSubStringKDistinctChars(String str,int k) {
		// stores the longest substring boundaries
		int end = 0, begin = 0;

		// set to store distinct characters in a window
		Set<Character> window = new HashSet<>();

		// Count array `freq` stores the frequency of characters present in the
		// current window. We can also use a map instead of a count array.
		int[] freq = new int[128];

		// `[low…high]` maintains the sliding window boundaries
		for (int low = 0, high = 0; high < str.length(); high++)
		{
			window.add(str.charAt(high));
			freq[str.charAt(high)]++;

			// if the window size is more than `k`, remove characters from the left
			while (window.size() > k)
			{
				// If the leftmost character's frequency becomes 0 after
				// removing it in the window, remove it from the set as well
				if (--freq[str.charAt(low)] == 0) {
					window.remove(str.charAt(low));
				}

				low++;		// reduce window size
			}

			// update the maximum window size if necessary
			if (end - begin < high - low)
			{
				end = high;
				begin = low;
			}
		}

		// return the longest substring found at `str[begin…end]`
		return str.substring(begin, end + 1);}
	
	/*
	 * https://www.techiedelight.com/determine-string-transformed-into-another-string-single-edit/
	 * Determine whether a string can be transformed into another string in a single edit
	 */
	
	public static boolean checkEditDistance(String first , String second) {
		int m = first.length() , n = second.length();
		if(Math.abs(m-n)>1) return false;
		
		int edit= 0; // to keep track of the total number of edits
		int i = 0 , j=0;
		while( i < m && j < n) {
			
			if(first.charAt(i) != second.charAt(j)) {
				if(m > n) { //remove first character from first string
					i++;
				}
				if(n > m) {//remove first character from second string
					j++;
				}
				//when length of the both string are same means replace the character.
				else {
					i++;
					j++;
				}
				edit++;
				
			}else {
				
				i++;
				j++;
			}
			
		}
		
		// remove any extra characters left in the first string
        if (i < m) {
            edit++;
        }
 
        // add any extra characters left in the second string at the end of
        // the first string
        if (j < n) {
            edit++;
        }
        
        return (edit==1);
	}
	/* 
	 * https://www.techiedelight.com/find-minimum-operations-required-transform-string-into-another/
	 * Function to find the minimum number of operations required to transform a given
     string into another string
     
     */
	public static int getMinimumOperations(String first, String second) {
		// to keep track of the minimum number of operations required
        int count = 0;
 
        // `i` and `j` keep track of the current characters' index in the
        // first and second strings, respectively
 
        // start from the end of the first and second string
		for(int i = first.length()-1, j=i ; i >=0; i--,j--) {
			
			// if the current character of both strings doesn't match,
            // search for `second[j]` in substring `first[0, i-1]` and
            // increment the count for every move
			while(i >=0 && first.charAt(i) != second.charAt(j)) {
				i--;
				count++;
			}
		}
		return count;
	}
	// Function to determine if the first string can be transformed into
    // the second string
	public static boolean isTransformable(char [] first , char [] second) {
		if (first.length != second.length) return false;
		Arrays.parallelSort(first);
		Arrays.parallelSort(second);
		return (Arrays.toString(first).equals(Arrays.toString(second)));
	}
	
	//GROUP ANAGRAM
	/*
	 * https://www.techiedelight.com/group-anagrams-together-given-list-words/
	 */
	 public static void groupAnagram(List<String> words) {
		 //sor each word on the list
		List <String> sortedWords = words.stream().map(s -> s.toCharArray()).map(chars -> {
			 Arrays.parallelSort(chars);
			 return new String(chars);
		 }).collect(Collectors.toList());
		
		 
		HashMap <String,ArrayList<Integer>> wordMap = new HashMap<>();
		for(int i = 0 ; i < words.size() ; i++) {
			wordMap.putIfAbsent(sortedWords.get(i), new ArrayList<Integer>());
			wordMap.get(sortedWords.get(i)).add(i);
		}
		
		for(Map.Entry<String,ArrayList<Integer>> entry : wordMap.entrySet()) {
			
			System.out.println(entry.getValue().stream().map(index -> words.get(index)).collect(Collectors.toList()));
		}
			
	 }
	
	
	//patternMatch
	/* https://www.techiedelight.com/find-words-that-follows-given-pattern/
	 * Find all words that follow the same order of characters as given pattern
	 * list = [leet, abcd, loot, geek, cool, for, peer, dear, seed, meet, noon, otto, mess, loss]
 	   pattern = moon (pattern is 4 digits with distinct character at first and last index, and same character at 1st and 2nd index)
 	   Output: [leet, loot, geek, cool, peer, seed, meet]
	 * 
	 */
	
	public static void patternMatch(List<String> words , String pattern) {
		int len  = pattern.length();
		for(String word : words) {
			
			HashMap <Character,Character> wordMap  = new HashMap<>();
			HashMap <Character,Character> patternMap  = new HashMap<>();
			if(len == word.length()) {
				for(int i = 0; i<len ; i++) {
					Character w = word.charAt(i);
					Character p = pattern.charAt(i);
					
					Character prev = wordMap.putIfAbsent(w, p);
					if(prev != null && wordMap.get(w) != p) break;
					
				    Character prevP = patternMap.putIfAbsent(p, w);
				    if(prevP != null && patternMap.get(p) != w) break;
				    
				    System.out.print(word+"\t");
				}
			}
			
		} 
		
	}

	
	
	
	public static int reverseInt(int num) {
		boolean negativeNumber = false;
		if(num < 0) {
			negativeNumber = true;
			num = -num;
		}
		
		int  reverse_num = 0 , previous_num=0;
		while(num !=0) {
			int digit = num%10;
			reverse_num = reverse_num*10 + digit;
			//handle overflow  if (reverse_num - digit)/10 != previous_num  
			//it means number get overflow from interger range.
			if((reverse_num -digit)/10 != previous_num) {
				System.out.println("Revesed number is overflowed than Integer limit");
				return 0;
			}
			previous_num = reverse_num;
			num = num/10;
		}
        
	   
	    return previous_num;
	}
	public static void permutation(String input) {
		permutations(input.toCharArray(),0);
	}
	
	private static void permutations(char [] ch, int currentIndex) {
 	   if(currentIndex == ch.length-1) 	System.out.println(String.valueOf(ch));
 	   
 	   for(int i = currentIndex; i < ch.length ; i++) {
 		   swap(ch, i ,currentIndex);
 		   permutations(ch ,currentIndex+1);
 		   swap(ch,i, currentIndex );
 	   }
 	}
    private static void swap(char [] ch , int x, int y) {
	  char c = ch[x];
	  ch[x]  = ch[y];
	  ch[y] = c;
     }
	//https://www.techiedelight.com/check-given-string-rotated-palindrome-not/
	/*
	 * Given a string check if it is rotated palindrome or not.
	 */
	
    //Approach 1: Naive solution with O(n^2)
	// check for all rotations of the given string if it
			// is palindrome or not
	public static  boolean isRotatedPalindrome(String str) {
		
		if( str == null || str.length()==0) return false;
		int len = str.length();
		for(int i = 0 ; i < len ; i++) {
			str = str.substring(1)+ str.charAt(0);
			if(isPalindrome(str, 0, len-1)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * Approach 2: Longest Palindrome subtring solution , 
	 */
	
		public static  boolean isRotatedP_Using_LongestPalindromeSubStr(String str) {
			
			if( str == null || str.length()==0) return false;
			int len = str.length();
			 str = str + str;
			
			for(int i = 0 ; i < str.length() ; i++) {
				if( expand(str, i,i,len)) {
					return true;
				}
			}
			return false;
		}
		
		private static boolean expand(String str, int low, int high , int k) {
			while((low >=0 && high < str.length()) && (str.charAt(low) == str.charAt(high)) )
			{
				if(high-low +1  == k) return true;
				else {
					low--;
					high++;
				}
			}
			return false;
		}
	// Recursive function to check if str[low..high] is a palindrome or not
	public static boolean isPalindrome(String str, int low, int high)
	{
		return (low >= high) || (str.charAt(low) == str.charAt(high) &&
								isPalindrome(str, low + 1, high - 1));
	}
	
	
	
	//Probem :https://www.techiedelight.com/convert-given-number-corresponding-excel-column-name/
	/*
	 * Convert number into corresponding excel column name.
	 * 
	 */
	
	public static String getExcelCoumnName(int n) {
		
		StringBuilder sb  = new StringBuilder();
		while(n > 0 ) {
			int index = (n-1)%26; //0-A ---- 25-Z
			sb.append((char)(index+'A'));
			n = (n-1)/26;
		}
		
		
		return sb.reverse().toString();
	}
	
	//https://www.techiedelight.com/check-strings-can-derived-circularly-rotating/
	/*
	 * Check if string can be derived by each other from circular rotation
	 * Input : x=  ABCD  
	 *          y= DABC
	 * 
	 * Output: YES
	 * 
	 *  Ans : do plus of  x+x  = ABCD + ABCD = ABCDABCD  now check if Y is substring of X  if so then we can derived from each other
	 */
	
	
	
	/*
	 * https://www.techiedelight.com/introduction-pattern-matching/
	 *  
	 *  Problem Pattern matching  or search a word in given string  or check if a string contains substring etc.
	 *  
	 */
	
	 public static boolean patternMatching(String str , String pattern) {
		 
		if ( (str == null || pattern == null) || pattern.length() > str.length() ) return false;
		
		int n = str.length();
		int m = pattern.length();
		for(int i=0; i <= n-m; i++) {
			int j=  0 ;
			for(; j < m ; j++) {
				if(str.charAt(i+j) != pattern.charAt(j)) break;
			}
			if(j == m) return true;
		}
		return false;
	 }
	 
	 /*
	  * https://www.techiedelight.com/reverse-text-without-reversing-individual-words/
	  *  Reverse given TEXT without reversing words
	  *  INPUT: Senior Software engineer
	  *  OUTPUT: engineer Software Senior
	  *  
	  *  Approach : Step 1: First revere each words inplace and then reverse whole sentence(TEXT) .
	  */

}
