package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindPalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPalindromicSubstrings("google"));
		System.out.println("findPalindromicSubstrings2\n");
		findPalindromicSubstrings2("google");

	}
	public static Set<String> findPalindromicSubstrings(String s)
	{
		
		HashSet <String> set = new HashSet<>();
		int len = s.length();
		for(int i = 0 ; i < len ; i++){
			
			int next = i ;
			int prev = i ;
			while(prev >=0  && s.charAt(prev) == s.charAt(i)){
				prev--;
			}
			while( next < len   && s.charAt(next) == s.charAt(i)){
				next++;
			}
		//	if(next != i ) next++;
			while(prev >=0  && next < len   && s.charAt(prev) == s.charAt(next)){
				prev--;
				next++;
			}
			//System.out.println(s +" "+prev +" "+next);
			//if(prev  < 0 ) prev++;
			//if( next >= len) next--;
			while( prev < next)
			{
				set.add(s.substring(prev+1 , next));
				prev++;
				next--;
			}
		}
		
	//	System.out.println(set);
		
	return set;
		
	}
	
	
	/*
	 * Solution: https://www.techiedelight.com/find-possible-palindromic-substrings-string/
	 */
	
	public static void findPalindromicSubstrings2(String str)
	{
		// base case
        if (str == null) {
            return ;
        }
 
        // create an empty set to store all unique palindromic substrings
        HashSet<String> set = new HashSet<>();
 
        for (int i = 0; i < str.length(); i++)
        {
            // find all odd length palindrome with `str[i]` as a midpoint
            expand(str, i, i, set);
 
            // find all even length palindrome with `str[i]` and `str[i+1]`
            // as its midpoints
            expand(str, i, i + 1, set);
        }
 
        // print all unique palindromic substrings
        System.out.print(set);
	}
	
	private static void expand(String s , int i , int j , HashSet <String> set) {
		
		while( i >= 0  && j < s.length() && s.charAt(i) == s.charAt(j)) {
			
			//put all palindrom substring into set
			set.add(s.substring(i,j+1));
			//expand both
			i--;
			j++;
		}
	}
	
}
