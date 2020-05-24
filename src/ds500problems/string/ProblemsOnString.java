package ds500problems.string;

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
