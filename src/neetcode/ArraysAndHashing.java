package neetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class ArraysAndHashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Deque<Integer> stack = new ArrayDeque<>();
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 System.out.println(stack.peek());
		
		System.out.println("topKFrequent ="+Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3},2)));

		String str = encode(Arrays.asList(new String[] {"neet","code","love","you"}));
		System.out.println("str = "+str);
		System.out.println("decode ="+decode(str));
		System.out.println("longestConsecutive ="+longestConsecutive(new int[] {2,20,4,10,3,4,5}));
		
		System.out.println("findMedianSortedArrays ="+findMedianSortedArrays(new int[] {1,2},new int[] {3,4}));
		System.out.println("findMedianSortedArrays ="+findMedianSortedArrays(new int[] {1,3},new int[] {2}));
		
		System.out.println("maxProfit2 ="+maxProfit2(new int[] {7,1,5,3,6,4}));
	}
	
	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
	//leetcode 123
	
      public static int maxProfit(int[] prices) {
         if(prices == null || prices.length <2) return 0;
    	  int a = -prices[0];
    	  int b = Integer.MIN_VALUE;
    	  int c = Integer.MIN_VALUE;
    	  int d = Integer.MIN_VALUE;
    	  
    	  for(int price: prices) {
    		  a = Math.max(a, -price);
    		  b = Math.max(b, a + price);
    		  c = Math.max(c , b-price);
    		  d = Math.max(d, c + price);
    	  }
    	  return d;
    }
	
	
	/*Best time to buy and sell stocks.
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
	 * max profit buy and sell stocks n number of times..
	 */
	private static int maxProfit2(int []prices) {
		int profit = 0;
		for(int i = 1; i < prices.length ; i++) {
			if(prices[i-1] < prices[i])  profit +=prices[i] -prices[i-1];
		}
		return profit;
	}
	 public static  int longestConsecutive(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	        int max = -1;
	        for(int num:  nums){
	            set.add(num);
	            }
	         for(int num: nums)  {
	        	 if(set.contains(num-1)) {
		              
		                continue;
		            }else{
		              
		               int  len = 1;
		               while(set.contains(++num)) {
		            	   ++len;
		               }

		                if(len > max) {
		                	max = len;
		                }   
		           }
	        }
	        return max;
	    }
	 public boolean isValidSudoku(char[][] board) {
		    Set<String> seen = new HashSet<>();

		    for (int i = 0; i < 9; ++i)
		      for (int j = 0; j < 9; ++j) {
		        if (board[i][j] == '.')
		          continue;
		        final char c = board[i][j];
		        if (!seen.add(c + "@row" + i) || 
		            !seen.add(c + "@col" + j) || 
		            !seen.add(c + "@box" + i / 3 + j / 3))
		          return false;
		      }

		    return true;
		  }
	 public static String encode(List<String> strs) {
      StringBuffer sb  = new StringBuffer();
      for(String str : strs) {
    	  sb.append(str.length()).append("/").append(str);
      }
      return sb.toString();
	 }

	 public static List<String> decode(String str) {
			//System.out.println("str = "+str);
		 List<String> list = new ArrayList<>();
		 for(int i =0 ; i < str.length(); ) {
			 int slash = str.indexOf('/',i);
			// System.out.println("i ="+i+"\t slash="+slash);
			// System.out.println(str.substring(i,slash));
			 int len = Integer.parseInt(str.substring(i,slash));
			 i = slash+len+1;
			 list.add(str.substring(slash+1, i));
		 }
		 return list;
	  }
	public boolean hasDuplicate(int[] nums) {
		 
		return false;
    }
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
		int [] chars = new int[128];
        for(char c : s.toCharArray()){
            chars[c]++;
        }
        for(char c : t.toCharArray()){
            chars[c]--;
            if(chars[c] < 0) return false;
        }
        
        return true;
    }
	 public int[] twoSum(int[] nums, int target) {
	        HashMap<Integer,Integer> map
	         = new HashMap<>();
	         int [] indx = new int[2 ];
	         int i=0;
	         for(int n : nums){
	            if(map.containsKey(target- nums[i])){
	             indx[0]=  map.get(target- nums[i]);
	             indx[1]= i;
	             return indx;
	            }
	            map.put(nums[i],i );
	            i++;
	         }
	         
	       return null;  
	    }
	 public static int[] topKFrequent(int[] nums, int k) {
		 PriorityQueue <Pair> q = new PriorityQueue<Pair>((a,b) -> Integer.compare(b.freq, a.freq)); 
		 HashMap <Integer, Integer> map = new HashMap<>();
		// map.putIfAbsent(null, null)
		 int [] topk = new int[k];
		 for(int i = 0 ; i< nums.length ; i++) {
			 map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		 }
		 for(Map.Entry<Integer, Integer> me: map.entrySet()) {
			Pair p = new Pair(me.getKey(),me.getValue());
			q.add(p);
		 }
		 for(int i=0; i < k; i++) {
			 topk[i] = q.poll().num;
		 }
		 return topk;
	 }	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int len = nums1.length + nums2.length;
	        if(len%2 == 0){
	            return evenMedian(nums1,nums2,len/2);
	        }
	        return oddMedian(nums1,nums2,len/2);
	    }
	 public static double oddMedian(int[] nums1, int[] nums2,int mid){
		 double sum = 0.0;
         int m = 0;
         int n  = 0;
         ArrayList <Integer> list = new ArrayList<>();
         while( m < nums1.length && n < nums2.length) {
        	
        	 if(nums1[m] < nums2[n]) {
        		 list.add(nums1[m]);
        		 m++;
        		
        	 }else {
        		 list.add(nums2[n]);
        		 n++;
        	 }
         }
         
         if(m < nums1.length) {
        	 while(m < nums1.length) {
        		 list.add(nums1[m]);
        		 m++;
        	 }
         }
         else if( n < nums2.length) {
        	 while(n < nums2.length) {
        		 list.add(nums2[n]);
        		 n++;
        	 }
         } 
       //  sum = list.get(m-1);
         sum += list.get(mid);
         return sum;
         
    }
	   public static double evenMedian(int[] nums1, int[] nums2,int mid){
		   double sum = 0;
	         int i = -1;
	         int m = 0;
	         int n  = 0;
	         ArrayList <Integer> list = new ArrayList<>();
	         while( m < nums1.length && n < nums2.length) {
	        	
	        	 if(nums1[m] < nums2[n]) {
	        		 list.add(nums1[m]);
	        		 m++;
	        		
	        	 }else {
	        		 list.add(nums2[n]);
	        		 n++;
	        	 }
	        	 i++;
	         }
	         
	         if(m < nums1.length) {
	        	 while(m < nums1.length) {
	        		 list.add(nums1[m]);
	        		 m++;
	        	 }
	         }
	         else if( n < nums2.length) {
	        	 while(n < nums2.length) {
	        		 list.add(nums2[n]);
	        		 n++;
	        	 }
	         } 
	         sum = list.get(mid-1);
	         sum += list.get(mid);
	         return sum/2;
	         
	    }
}

class Pair{
    Integer num;
    Integer freq;
    Pair(int n) {
    	this.num = n;
    	this.freq = 1;
    }
    Pair(int n,int f) {
    	this.num = n;
    	this.freq = f;
    }
    @Override
    public boolean equals(Object o){
      Integer b = ((Pair )o).num;
      return this.num.equals(b );
    }

    @Override
    public int hashCode(){
        return this.num.hashCode();
    }

	@Override
	public String toString() {
		return "Pair [num=" + num + ", freq=" + freq + "]";
	}
    
}