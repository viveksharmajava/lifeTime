package leetcode.blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions
public class Blind75 {

	public static void main(String[] args) {
     System.out.println("Blind75");
     
     problem1();
     problem2();
     problem3();
     problem4();
     problem5();
     problem6();
     problem7();
     problem8();
     problem9();
     
     
     //Binary
     problem10();
     problem11();
     problem12();
     problem13();
     
     //String
     
     //Longest Substring Without Repeating Characters
     problem14_lengthOfLongestSubstring("abbcdafeegh");
     problem14_lengthOfLongestSubstring_2("abbcdafeegh");
     
     //Longest Repeating Character Replacement
     //https://leetcode.com/problems/longest-repesating-character-replacement/description/
     System.out.println("characterReplacement "+Problem15_characterReplacement("AABABBA",1));
     System.out.println("charReplacementPractice  "+charReplacementPractice("AABABBA",1));
     
     //Problem 16
     //Minimum window substring
     //https://leetcode.com/problems/minimum-window-substring/description/
     System.out.println("minWindow ="+minWindow("ADOBECODEBANC", "ABC"));
     
     //Problem 17 is
     
     System.out.println("isAnagram="+isAnagram("anagram","nagaram"));
     System.out.println("isAnagram="+isAnagram("rat","car"));
     System.out.println("isAnagram="+isAnagram("dabba","babad"));
     
     //Problem 18 group anagram
     System.out.println("groupAnagrams ="+groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	//Problem 19
     
     System.out.println("isValid(String s)="+isValid("[]"));
     
     //Program 20
     
     System.out.println("isPalindrome() ="+isPalindrome("abc44bad"));
     
     System.out.println("longestPalindrome ="+longestPalindrome("babad"));
     
     System.out.println("uniquePaths "+uniquePaths(3,2));
     System.out.println("uniquePaths "+uniquePaths(3,7));
     
     System.out.println("uniquePaths1DArray ="+uniquePaths1DArray(3,2));
     System.out.println("uniquePaths1DArray = "+uniquePaths1DArray(3,7));
	}
	/*
	 * Unique Paths
	 * https://leetcode.com/problems/unique-paths/description/
	 * There is a robot on an m x n grid. The robot is initially located at
	 *  the top-left corner (i.e., grid[0][0]). The robot tries to move to 
	 *  the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can
	 *   only move either down or right at any point in time.
       Given the two integers m and n, return the number of possible unique
		 paths that the robot can take to reach the bottom-right corner.
	 */
	  //solution :https://walkccc.me/LeetCode/problems/62/#__tabbed_2_2
	   //2D dp array
	   //Time: O(mn) , space O(mn)
		public static int uniquePaths(int m, int n) {
			// dp[i][j] := the number of unique paths from (0, 0) to (i, j)
		      int[][] dp = new int[m][n];
		      Arrays.stream(dp).forEach(A -> Arrays.fill(A, 1));
		      for(int i=1; i < m;i++) {
		    	  for(int j=1; j < n; j++) {
		    		  dp[i][j] = dp[i-1][j] + dp[i][j-1];
		    	  }
		      }
		      return dp[m-1][n-1];
		 }
		public static int uniquePaths1DArray(int m, int n) {
			// dp[i][j] := the number of unique paths from (0, 0) to (i, j)
		      int[] dp = new int[n];
		      Arrays.fill(dp, 1);
		      for(int i=1; i < m;i++) {
		    	  for(int j=1; j < n; j++) {
		    		  dp[j] += dp[j-1];
		    	  }
		      }
		      return dp[n-1];
		 }
	/*
	 * https://leetcode.com/problems/longest-palindromic-substring/description/
	 * Description :5. Longest Palindromic Substring
	 * Input: s = "babad"
		Output: "bab"
		Explanation: "aba" is also a valid answer.
		Example 2:
		
		Input: s = "cbbd"
		Output: "bb"
	 */
	/* Program 20
	 * 125. Valid Palindrome
	 * https://leetcode.com/problems/valid-palindrome/description/
	 * 
	 */
	 public static String longestPalindrome(String s) {
		// base case
	        if (s == null || s.length() == 0) {
	            return s;
	        }
	      
	        String max_str ="" , current_str="";
		   for(int i=0; i < s.length(); i++) {
	        	 current_str = expand(s,i,i);
	        	 if(current_str != null && current_str.length() > max_str.length()) {
	        		 max_str = current_str;
	        	 }
	        }
		   return max_str;
	    }
	 public static String expand(String s , int low , int high) {
		 while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
			 low--;
			 high++;
		 }
		 return s.substring(low+1,high);
	 }
	
	public static boolean isPalindrome(String s) {
		 int l = 0;
		    int r = s.length() - 1;

		    while (l < r) {
		      while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
		        ++l;
		      while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
		        --r;
		      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
		        return false;
		      ++l;
		      --r;
		    }

		    return true;
		
	}
	/*
	 * Program 19
	 * 20. Valid Parentheses
	 * https://leetcode.com/problems/valid-parentheses/description/
	 * Given a string s containing just the characters '(', ')', '{', '}', 
	 * '[' and ']', determine if the input string is valid.
	 */
	 public static boolean isValid(String s) {
		    Deque<Character> stack = new ArrayDeque<>();

		    for (final char c : s.toCharArray())
		      if (c == '(')
		        stack.push(')');
		      else if (c == '{')
		        stack.push('}');
		      else if (c == '[')
		        stack.push(']');
		      else if (stack.isEmpty() || stack.pop() != c)
		        return false;

		    
		    for(final char c: s.toCharArray()) {
		    	if(c == '(') stack.push(')');
		    	else if (c == '{') stack.push('}');
		    }
		    return stack.isEmpty();
	 } 
	
	/*
	 * Problem 18
	 * Description: group Anagrams
	 * Given an array of strings strs, group the 
		anagrams
		 together. You can return the answer in any order.
		
		Example 1:
		
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 */
	
	   public static List<List<String>> groupAnagrams(String[] strs) {
	       HashMap<String, List<String>> map = new HashMap<>();
	       for(String str : strs) {
	    	   char[] chars =str.toCharArray();
	    	   Arrays.sort(chars);
	    	   String key = String.valueOf(chars);
	    	   map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
	    	   
	       }
	       return new ArrayList<>(map.values());
	    }
	
	/*
	 * Problem17 :isAnagram
	 * https://leetcode.com/problems/valid-anagram/
	 */
	 public static boolean isAnagram(String s, String t) {
		   if(s.length() != t.length()) return false;
		   int [] count = new int[26];
		   for(char c : s.toCharArray()) {
			   count[c-'a']++;
		   }
		   for(char c : t.toCharArray()) {
			   if(count[c-'a'] ==0) return false;
			   count[c-'a']--;
		   }
		   return true;
	   }
	
	//Problem 16
    //Minimum window substring
    //https://leetcode.com/problems/minimum-window-substring/description/
	//Time O(m+n)
	//Space O(128) = O(1)
	 public static String minWindow(String s, String t) {
		 int[] count = new int[128];
		    int required = t.length();
		    int bestLeft = -1;
		    int minLength = s.length() + 1;

		    for (final char c : t.toCharArray())
		      ++count[c];

		    for (int l = 0, r = 0; r < s.length(); ++r) {
		      if (--count[s.charAt(r)] >= 0)
		        --required;
		      while (required == 0) {
		        if (r - l + 1 < minLength) {
		          bestLeft = l;
		          minLength = r - l + 1;
		        }
		        if (++count[s.charAt(l++)] > 0)
		          ++required;
		      }
		    }

		    return bestLeft == -1 ? "" : s.substring(bestLeft, bestLeft + minLength);
	       
	 }
	        
	   
	 public static int Problem15_characterReplacement(String s, int k) {
	        
   	  // Initialising an empty array to store the count of the 
         // characters in the given string s
         int[] arr = new int[26];
         int res = 0;
         int max = 0;

         // The left pointer for the sliding window is l AND r is the 
         // right pointer
         int l = 0;
         for (int r = 0; r < s.length(); r++) {
             // Counting the number of each character in the string s
             arr[s.charAt(r) - 'A']++;

             // Checking the character with max number of occurrence
             max = Math.max(max, arr[s.charAt(r) - 'A']);

             // Now we check if our current window is valid or not
             if (r - l + 1 - max > k) { 
             // this means the no. of replacements is more than
             // allowed (k)
                 // Decrementing the count of the character which was 
                 // at l because it is no longer in the window
                 arr[s.charAt(l) - 'A']--;
                 l++;
             }

             // The max our window can be
             res = Math.max(res, r - l + 1);
         }

         return res;
   }
	public static int charReplacementPractice(String s, int k) {
		
		//initialize the empty array to store the count of characters in given string s.
		int [] counts = new int[26];
		int l=0;//left pointer of sliding window..
		int res = 0;
		int max =0;
		int r ;//right pointer of slding window..
		for( r =0; r < s.length(); r++) {
			counts[s.charAt(r)-'A']++;
			//check the character with max number of occurence.
			max = Math.max(max, counts[s.charAt(r)-'A']);
			if(r-l +1 -max > k) {
				counts[s.charAt(l)-'A']--;
				l++;
			}
			//the max our window can be..
			res = Math.max(res, r-l+1);
		}
		
		return res;
	}

	
	/*
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 * solution:solution:https://www.techiedelight.com/find-longest-substring-given-string-containing-distinct-characters/
	 * 
	 */
	public static String problem14_lengthOfLongestSubstring(String str) {// base case
        if (str == null || str.length() == 0) {
            return str;
        }
 
        // boolean array to mark characters present in the current window
        boolean[] window = new boolean[128];
 
        // stores the longest substring boundaries
        int begin = 0, end = 0;
 
        // `[low…high]` maintain the sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            // if the current character is present in the current window
            if (window[str.charAt(high)])
            {
                // remove characters from the left of the window till
                // we encounter the current character
                while (str.charAt(low) != str.charAt(high))
                {
                    window[str.charAt(low)] = false;
                    low++;
                }
 
                low++;        // remove the current character
            }
            else {
                // if the current character is not present in the current
                // window, include it
                window[str.charAt(high)] = true;
 
                // update the maximum window size if necessary
                if (end - begin < high - low)
                {
                    begin = low;
                    end = high;
                }
            }
        }
 
        // return the longest substring found at `str[begin…end]`
        System.out.println("substring ="+str.substring(begin, end + 1));
        return str.substring(begin, end + 1);
        
	}
	   //without using boolean array
	public static String problem14_lengthOfLongestSubstring_2(String s) {
		//base case 
		if (s == null || s.isEmpty()) return s;
		HashMap<Character,Integer> map = new HashMap<>();
		int begin =0, end = 0;
		int start =0;
		int len = Integer.MIN_VALUE;
		// `[low…high]` maintain the sliding window boundaries
        for (int i=0; i < s.length(); i++)
        {
          if(map.containsKey(s.charAt(i)) &&  map.get(s.charAt(i)) > begin) {
        	  if(len < (i-begin)) {
        		  len = i-begin;
        		  start = begin;
        	  }
        	  begin = map.get(s.charAt(i)) +1;
          }
          map.put(s.charAt(i),i);
        }
    // return the longest substring found at `str[begin…end]`
    System.out.println( "begin ="+start+"\t len="+len);
    System.out.println(s.substring(start, start+len ));
   return s.substring(start, start+len );
      // return "";
}
	public static void problem13(){
	System.out.println("missingNumber ="+missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	private static int missingNumber(int [] nums) {
		 int xor1 = 0;
	        int xor2 = 0;
	        for(int i=0; i < nums.length; i++){
	            xor1 ^=nums[i];
	        }
	        for(int i =0 ;i <= nums.length;i++){
	            xor2 ^= i;
	        }
	        return xor1 ^ xor2;
	}
	public static void problem12(){
		//it is same as problem 11..
	}
	public static void problem11() {
		System.out.println("hammingWeight  ="+hammingWeight(11));
		System.out.println("hammingWeight  ="+hammingWeight(8));
		System.out.println("hammingWeight  ="+hammingWeight(7));
		System.out.println("hammingWeight  ="+hammingWeight(2147483645));
	}
   private static  int hammingWeight(int n) {
        int result = 0;
        while(n > 0) {
        	if(n%2 == 1) result++;
        	n = n/2;
        }
        return result;
    }
	public static void problem10() {
		System.out.println("sumOf2numbers="+binary_sumOf2numbers(2,3));
		
	}
	private static int binary_sumOf2numbers(int a , int b) {
		// 2   10 , 3 , 11 , result : 101    , 101
		int sum= 0;
		int carry = b;
		while(carry != 0) {
			sum = a ^ b;
			carry = (a& b)<<1;
			a = sum;
			b = carry;
		}
		return sum;
	}
	
	public static void problem9() {
		System.out.println("maxWater ="+maxWater(new int [] {1,8,6,2,5,4,8,3,7}));
	}
	private static int maxWater(int [] height) {
		int l = 0, r = height.length-1;
		int max_so_far = 0;
		while(l < r) {
			int distance = (r-l);
			int max = distance*(Integer.min(height[l],height[r]));
			if(max_so_far < max) max_so_far = max;
			if(height[l]< height[r]) l++;
			else r--;
		}
		return max_so_far;
	}
	public static void problem8() {
		System.out.println("3 sum problem="+three_sum(new int[] {-1,0,1,2,-1,-4}));
	}
	//remove duplicates
	private static List<List<Integer>> three_sum(int [] nums){
		  List<List<Integer>> result = new LinkedList<>( );
        for(int i = 0 ; i < nums.length-2; i ++){
            
            int a = nums[i];
          
            HashSet <Integer> set  = new HashSet <>();
            for(int j = i+1; j < nums.length; j++){
                 int b =  nums[j];
                 if(set.contains(-(a+b))){
                    List<Integer> triplet = new LinkedList<>();
                    triplet.add(a);
                    triplet.add(-(a+b));
                    triplet.add(b);
                    result.add(triplet);
                 }
                 set.add(b);
            }
           
        }  
        return result;
	}
	public static void problem7() {
		System.out.println("searchInRotedSorted ="+searchInRotedSorted(new int[] {3,5,1,2},2));
	}
	
	private static int searchInRotedSorted(int [] nums, int target) {
		int pivot = findPivot(nums);
		if(pivot == 0) return binarySearch(nums, 0, nums.length-1 ,target);
		if(target == nums[pivot]) return pivot; // match with pivot else search in left or right...
		if(target <= nums[nums.length-1])  return binarySearch(nums, pivot+1, nums.length -1,target);
		return  binarySearch(nums, 0,pivot-1, target);
	}
	//solution inspired from geeks
	/*    https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	 * 1. find pivot point.
	 * 2. divide the array into 2 part .. and do the binary search..
	 * 3. 
	 *
	 */
	private static int binarySearch(int [] nums, int l , int r, int target) {
	       while(l <= r){
	          int mid = (l+r )/2;
	          if(nums[mid] == target) return mid;
	          if( target > nums[mid]) l = mid+1;
	          else r = mid - 1;
	          
	       }
	       return -1;
	}
	
	private static int findPivot(int [] nums) {
		if(nums.length == 1) return 0;
		int l = 0; 
	     int r = nums.length-1;
	  
	     while( l < r) {
	    	   if(nums[l] < nums[r]) return l;
	    	   int mid = (l+r)/2;
	    	   if(nums[mid] > nums[r]) l = mid+1;
	    	   else r = mid;
	    	   
	     }
	     return l;
	       
	}
	public static void problem1() {
		//two sum problem..
		//https://leetcode.com/problems/two-sum/description/
		Set <Integer> set = new HashSet<>();
		int [] nums = {2,7,11,15};
		int target = 9;
		for(Integer i : nums) {
			if(set.contains(target -i )) {
				System.out.println("Target sum Pair ("+(target-i)+","+i+")");
			}
			set.add(i);
		}
		
	}
	public static void problem2() {
		//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
		//121. Best Time to Buy and Sell Stock
		int [] arr = { 7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
		int [] arr2 = { 7,6,5,4};
		System.out.println(maxProfit(arr2));
	}
     public static int maxProfit(int[] prices) {
        
        int max_profit =0;
      int   min_so_far = prices[0 ];
        for(int i =1; i < prices.length; i++){
            if(prices[i]- min_so_far > max_profit) 
            {
            	max_profit= prices[i]-min_so_far ;
            }
            if(min_so_far > prices[i]) min_so_far = prices[i];
        }
        return max_profit;
    }
     
   public static void problem3(){
	   int [] arr = {1,2,3};
	   System.out.println("containsDuplicate ="+containsDuplicate(arr));  
   }
   public static  boolean containsDuplicate(int[] nums) {
       int x = 0;
       for(int i : nums ){
           x = x ^ i;
        
       }
       System.out.println(" x ="+x);
       return !( x == 0);
   }
   
   public static void problem4() {
	  
	   System.out.println("maxSubArray = "+maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
   }
   public static int maxSubArray(int[] nums) {
       int max_so_far = 0;
       int max = Integer.MIN_VALUE ;
       for(int val : nums){
           max_so_far += val;
           if(max_so_far > max ) max = max_so_far;
           if(max_so_far < 0  ) max_so_far = 0;
       }
       return max;

   }
   public static void problem5() {
	   System.out.println("Max product of subarray="+maxProduct(new int[] {2,0,3,-2,4}));
   }
   public static int maxProduct(int[] nums) {
	   int max_so_far = nums[0];
       int max =  nums[0];
       int min =  nums[0];
       for(int i = 1 ; i < nums.length; i ++){
           int temp = max;
           max  = Integer.max(nums[i],Integer.max(nums[i]*max, nums[i]*min));
           min = Integer.min(nums[i],Integer.min(nums[i]*temp,nums[i]*min));
         max_so_far = Integer.max(max_so_far,max );
       }
       return max_so_far;
   }
   public static void problem6() {
	   System.out.println("findMin ="+findMin(new int[] {3,4,5,1,2}));
	   System.out.println("findMin ="+findMin(new int[] {4,5,6,7,0,1,2}));
	   System.out.println("findMin ="+findMin(new int[] {11,13,15,17}));
   }
   public static int findMin(int[] nums) {
       int l = 0; 
       int r = nums.length-1;
       if( nums[l] < nums[r]) return nums[l ]; //array is sorted.
       while(l <= r){
          int mid = (l+r )/2;
          if(mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];
          if (nums[mid] > nums[r]) l = mid+1;//left hand is sorted.
          else r = mid-1;
       }
       return -1;
   }
}
