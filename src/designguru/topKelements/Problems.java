package designguru.topKelements;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Problems {

	public static void main(String[] args) {

		
//		int [] arr = {3, 1, 5, 12, 2, 11};
//		topKelements(arr, 3);
//		int [] arr2 = {1, 5, 12, 2, 11, 5};
//		System.out.println("KthSmallestNumber ="+KthSmallestNumber(arr2,3));
//		
//		int [][] cordinates = {{1,2},{1,3}};
//		System.out.println("kthClosestPointsToOrigin");
//		kthClosestPointsToOrigin(cordinates, 1);
//		
//		System.out.println("connectRopes");
//		int [] ropes = {1, 3, 11, 5, 2};
//		System.out.println(connectRopes(ropes));
		
		System.out.println("topK");
		int [] nums = {5,3,1,1,1,3,73,1};
		topK(nums,2);
		
		topKFrequent(nums,2);
		
		System.out.println("\n frequencySort\n ");
		System.out.println(frequencySort("Programming"));
		
		
		System.out.println("kClosestNumber");
		int [] closest = {5, 6, 7, 8, 9};
		int K = 3, X = 7;
		kClosestNumber(closest, K, X); 
		
		System.out.println("\n maximumDitinctElements \n ");
		int [] distinct  = {7, 3, 5, 8, 5, 3, 3};
		System.out.println(maximumDitinctElements(distinct , 2));
		int [] dist = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(maximumDitinctElements(dist , 5));
		int [] dist2 = {1, 2,3, 2, 3};
		System.out.println(maximumDitinctElements(dist2 , 3));
		
		int [] sum_elements = {1, 3, 12, 5, 15, 11 } ;
		SumofElements(sum_elements,3,6);
		
		System.out.println("\n aaabc \n ");
		System.out.println(rearrangeString("aaabc"));
		
		System.out.println("rearrangeKdistanceApart ");
	//	System.out.println(rearrangeKdistanceApart("mmpp",2));
		//
		
		System.out.println("rearrangeKdistanceApart Programming");
		System.out.println(rearrangeKdistanceApart("Programming",3));
		
		System.out.println("\n schedulingTasks \n ");
		
		char [] tasks = {'B','F','J','J','H','A','D','C','C','D','J','E','B','E','C','H','E','E','G','E','H','I','I','E','H','F','C','G','H','F','E','E','I','D','D','A','E','A','C','E','F','J','E','F','G','J','A','A','A','B','E','J','H','C','A','E','D','A','E','I','H','B','A','C','E','F','J','D','F','I','I','H','J','E','B','H','H','A','J','C','C','D','C','B','C','H','H','I','H','D','C','B','D','C','H','A','F','A','J','D','F','E','H','I','D','A','E','B','H','J','F','D','C','J','J','I','A','I','J','H','A','I','I','G','C','C','H','D','B','B','B','H','I','D','B','C','H','I','I','G','E','D','D','A','E','D','H','C','J','H','C','E','I','F','A','I','E','G','A','E','F','I','B','J','B','J','B','G','A','D','C','B','I','A','C','J','J','J','B','E','E','E','B','E','B','H','B','J','H','F','G','B','B','I','C','D','I','D','D','A','I','D','H','A','J','D','J','D','I','G','F','F','B','G','A','F','I','I','H','C','B','H','H','E','F','A','H','G','F','D','G','F','A','C','F','D','F','C','J','A','D','H','G','D','D','G','C','G','C','I','B','G','E','J','C','G','J','G','E','F','F','I','D','D','E','G','F','A','F','H','D','C','B','E','H','G','H','B','A','D','A','J','A','C','B','G','C','A','J','E','I','G','H','J','A','J','I','D','I','G','B','G','I','A','B','J','B','H','E','G','G','I','G','G','C','J','J','J','H','G','A','G','B','G','I','G','A','D','B','A','E','I','H','E','G','H','J','F','H','I','A','E','A','I','A','D','D','B','D','G','E','C','J','C','C','B','F','F','B','E','A','G','D','I','G','D','J','D','G','I','B','J','J','B','F','D','I','C','I','B','J','B','D','D','A','D','C','G','A','G','C','G','C','E','C','G','A','J','C','E','F','C','C','E','J','D','H','H','F','E','D','G','E','E','I','B','G','A','C','C','E','J','F','H','C','A','G','H','G','A','G','A','D','B','E','F','H','C','C','B','I','F','H','I','C','H','G','G','C','E','A','J','F','F','F','B','D','I','E','I','F','E','F','G','G','A','D','I','A','J','A','H','J','I','H','H','A','B','B','B','I','C','J','C','G','J','G','E','I','H','D','E','H','J','A','G','A','G','A','C','F','C','G','E','G','J','D','H','H','B','J','F','J','J','B','J','D','D','G','B','I','I','H','G','B','I','E','D','H','H','I','B','A','A','A','D','H','J','H','D','J','E','D','G','J','B','B','F','G','J','G','E','G','E','E','F','H','F','J','A','G','I','D','C','H','A','C','F','B','J','E','I','A','G','J','D','I','F','I','J','H','E','D','J','A','E','G','B','B','J','I','J','H','F','D','F','F','A','G','F','F','I','C','H','E','E','G','A','D','F','I','D','D','C','B','G','C','D','G','H','F','D','J','D','B','A','J','J','I','H','F','G','D','J','H','I','H','I','A','A','I','C','B','H','G','I','C','F','E','J','J','F','F','D','F','A','J','H','B','G','A','F','D','G','D','C','F','J','F','G','D','H','J','C','A','E','C','G','J','G','I','C','G','H','G','J','D','D','G','D','F','F','J','B','D','C','E','F','G','D','A','J','H','D','F','C','B','H','C','I','D','C','F','E','C','D','J','D','E','G','C','D','H','J','E','H','I','I','A','C','E','C','I','B','A','B','E','E','H','E','B','H','C','G','B','C','C','D','G','G','A','F','A','B','D','G','F','A','H','G','C','E','D','B','H','D','F','F','G','A','J','H','E','B','C','B','B','B','H','D','F','B','B','C','G','A','C','E','J','H','F','F','D','G','J','D','F','J','G','H','B','D','B','D','D','G','J','H','B','D','F','E','E','G','D','H','B','A','I','E','B','E','B','D','I','C','A','A','E','J','A','B','A','F','C','J','F','F','F','A','I','J','F','H','G','C','F','E','D','C','B','C','G','G','G','A','B','J','J','F','J','G','C','D','B','C','F','H','I','F','D','C','I','J','D','I','G','B','G','I','J','E','H','G','G','J','J','A','E','E','I','G','E','H','F','F','C','A','J','I','I','D','C','E','G','A','A','H','F','A','I','B','H','J','H','B','H','A','A','A','G','I','I','D','F','F','C','H','D','B','J','F','G','E','F','J','A','I','G','J','J','F','F','G','B','B','D','F','E','G','D','D','A','D','D','G','C','C','I','C','H','I','C','E','G','C','E','J','F','G','J','B','I','B','B','C','B','G','A','J','H','C','G','D','E','H','E','H','A','H','I','A','J','C','G','B','G','H','G','H'};
		
		System.out.println(schedulingTasks(tasks,36));
		
		
	}
	
	/*
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1c9d019e6a3ce13cedb21
	 */
	public static void topKelements(int [] arr, int k) {
		int i =0;
		PriorityQueue < Integer> queue = new PriorityQueue(k);
		for(  ; i < k ; i++) {
			queue.add(arr[i]);
		}
		System.out.println("initial queue "+ queue +" peek ="+queue.peek());
		System.out.println(i);
		for(i=k; i < arr.length ; i++) {
			if(queue.peek() < arr[i]) {
				queue.poll();
				queue.add(arr[i]);
			}
		}
		System.out.println("Final queue "+ queue);
	}
	
	/*
	 * Kth Smallest Number
	 */
	 public static int KthSmallestNumber(int [] arr ,int k) {

			int i =0;
			PriorityQueue < Integer> queue = new PriorityQueue(k,Comparator.reverseOrder());
			for(  ; i < k ; i++) {
				queue.add(arr[i]);
			}
			System.out.println("initial queue "+ queue +" peek ="+queue.peek());
			System.out.println(i);
			for(i=k; i < arr.length ; i++) {
				if(queue.peek() > arr[i]) {
					queue.poll();
					queue.add(arr[i]);
				}
			}
			System.out.println("Final queue "+ queue);
		return queue.peek();
	 }
	 /*
	  * Problem: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1cd9e19e6a3ce13cedcbc
	  * K' Closest Points to the Origin :
	  * Given an array of points in a 2D plane, find ‘K’ closest points to the origin.

		Example 1:
		
		Input: points = [[1,2],[1,3]], K = 1
		Output: [[1,2]]
		Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
		The Euclidean distance between (1, 3) and the origin is sqrt(10).
		Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
	  */
	 
	  public static void  kthClosestPointsToOrigin(int [][] arr ,int k) {

			int i =0;
			PriorityQueue < Cordinates> queue = new PriorityQueue(k,Comparator.reverseOrder());
			for(  ; i < k ; i++) {
				//queue.add(Math.sqrt(arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1]));
				queue.add(new Cordinates(arr[i][0], arr[i][1]));
			}
			System.out.println("initial queue "+ queue +" peek ="+queue.peek());
			for(i=k; i < arr.length ; i++) {
				if(queue.peek().distance > (Math.sqrt(arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1]))) {
					queue.poll();
					queue.add(new Cordinates(arr[i][0], arr[i][1]));
				}
			}
			System.out.println("Final queue "+ queue);
		System.out.println("Kth closest points ="+queue.peek());
	 }
	  
	 /*
	  * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1ceee19e6a3ce13ceddd0
	  * solution: https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
	  * 
	  * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.

		Example 1:
		
		Input: [1, 3, 11, 5]
		Output: 33
		Explanation:
		queue = [ 1,3,5,11] //thought its heap assume it gives in shorted order.
		 First connect 1+3(=4), 
		  put 4 back to queue [ 4,5,11],cost = 1+3 = 4
		then  connect 4+5(=9),put 9 back to queue
		[9,11] , cost = 4+ 9 = 13
		 
		connect 9, 11 , cost = 4+9+20 = 33
		and then 9+11(=20). So the total cost is 33 (4+9+20)
	  */
	 public static int connectRopes(int [] ropes) {
		
		 PriorityQueue < Integer> queue = new PriorityQueue();
		 for(int i =0 ; i < ropes.length ; i++) {
			 queue.add(ropes[i]);
		 }
		 System.out.println("ropes queue ="+queue);
		
		 int cost = 0;
		 int sum =0;
		 while(queue.size()> 1) {
			
				sum = queue.poll()+ queue.poll();
				cost = cost + sum;
			    queue.add(sum);
			
		 }
		 System.out.println("The total cost invole is ="+cost);
		 return cost;
	 }
	 
	 /*
	  * Top 'K' Frequent Numbers (medium)
	  * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1d04a19e6a3ce13cedede
	  * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
		Output: [12, 11]
		Explanation: Both '11' and '12' apeared twice.
	  * 
	  * Note; below solution is not accurate has some error ... 
	  */
	 public static void topK(int[] nums, int k) {
	        // Code here
	        
	        HashMap <Frequency,Frequency> map = new HashMap();
	        PriorityQueue < Frequency> queue = new PriorityQueue();
	        Frequency ff = null;
	        int i=0;
	        for(; i < nums.length && map.size() <= k; i++){
	        	//int count = 0;
	        	Frequency f = new Frequency(nums[i]);
	        	f.count =1;
	           if(!map.containsKey(f)){
	        	   map.put(f,f);
	        	   if(map.size() > k) {
	        		   map.remove(f);
	        		   //i--;
	        		   break;
	        	   }
	        	   queue.add(f);
	           } else{
	        	    ff  = map.get(f);
	        	    queue.remove(ff);
	        	    
	        	   ff.count = ff.count + 1;
	        	  // count = ff.count;
	        	   map.put(ff,ff);
	        	   queue.add(ff);
	           } 
	           
	        }
	        System.out.println("Map ="+map);
	        System.out.println("queue ="+queue);
	        for(; i < nums.length; i++){
	        	int count = 0;
	        	Frequency f = new Frequency(nums[i]);
	        	f.count =1;
	           if(!map.containsKey(f)){
	        	   map.put(f,f);
	        	   
	           } else{
	        	    ff  = map.get(f);
	        	    ff.count = ff.count + 1;
	        	   count = ff.count;
	        	   map.put(f,ff);
	        	   
	           } 
	             if(ff != null && queue.peek().count < count) {
		        	   queue.poll();
		        	   queue.add(ff);
		           }
	        }
	        System.out.println("Map ="+map);
	        System.out.println("queue ="+queue);
	        int [] ans = new int [k];
	        i = 0;
	        while(!queue.isEmpty()) {
	        	System.out.println(queue.peek().num);
	        	ans[i] =queue.poll().num; 
	        	i++;
	        }
	        //return ans;
	    }
	 //https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
	 //Note: the solution is correct..
	 
	 public static int [] topKFrequent(int [] arr , int k) {
		 
		 int  [] ans = new int[k];
		 HashMap <Integer,Integer> map = new HashMap();
		 
		 for(int i = 0 ; i < arr.length; i++) {
			 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		 }
		 PriorityQueue < Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
				 (a,b) -> a.getValue().equals(b.getValue())? Integer.compare(b.getKey(), a.getKey()): Integer.compare( b.getValue(),a.getValue())
				 );
		 
		    // Insert the data from the map
	        // to the Priority Queue.
		 for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			 queue.offer(entry);
		 }
		 for(int i= 0; i < k; i++) {
			 System.out.println(queue.poll().getKey());
		 }
		 return ans;
	 }
	 
	 public static String frequencySort(String input ) {
 
		 char [] arr = input.toCharArray();
		 HashMap <Character,Integer> map = new HashMap();
		 
		 for(int i = 0 ; i < arr.length; i++) {
			 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		 }
		 PriorityQueue < Map.Entry<Character,Integer>> queue = new PriorityQueue<>(
				 (a,b) -> a.getValue().equals(b.getValue())? Integer.compare(b.getValue(), a.getValue()): Integer.compare( b.getValue(),a.getValue())
				 );
		 
		    // Insert the data from the map
	        // to the Priority Queue.
		 for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			 queue.offer(entry);
		 }
		 StringBuffer sb = new StringBuffer();
		 while(!queue.isEmpty()) {
			 Map.Entry<Character, Integer> entry = queue.poll();
			 Character c= entry.getKey();
			 int freq  = entry.getValue();
			 while(freq > 0) {
				 sb.append(c);
				 freq--;
			 }
		 }
		 return sb.toString();
	 
	 }
	 
	 public static int kthLargest(int [] input,int k) {
	    	
	    	PriorityQueue < Integer> queue = new PriorityQueue(k);
	    	for(int i = 0 ; i < k ; i++) {
	    		queue.add(input[i]);
	    	}
	    	for(int i = k; i < input.length ; i++){
	    		if(input[i] > queue.peek()) {
	    			queue.poll();
	    			queue.add(input[i]);
	    		}
	    	}
	    	return queue.poll();
	    }
	    
	 /* 
	     * Find Kth smallest element in the array
	     * https://www.techiedelight.com/find-kth-smallest-element-array/
	     */
	     public static int kthSmallest(int [] input,int k) {
	     	
	     	PriorityQueue < Integer> queue = new PriorityQueue(k,Comparator.reverseOrder());
	     	for(int i = 0 ; i < k ; i++) {
	     		queue.add(input[i]);
	     	}
	     	for(int i = k; i < input.length ; i++){
	     		if(input[i] < queue.peek()) {
	     			queue.poll();
	     			queue.add(input[i]);
	     		}
	     	}
	     	return queue.peek();
	     } 
	     
	     /*
	      * Problem: 'K' Closest Numbers (medium)
	      * Input: [5, 6, 7, 8, 9], K = 3, X = 7
			Output: [6, 7, 8]
	      * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1d49473a7d4466d460b87
	      * 
	      */
	     public static int [] kClosestNumber(int [] arr , int k , int x) {
	    	 int  [] ans = new int[k];
			 HashMap <Integer,Integer> map = new HashMap();
			 
			 for(int i = 0 ; i < arr.length; i++) {
				 map.put(arr[i], Math.abs(x-arr[i]));
			 }
			 PriorityQueue < Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
			 
			    // Insert the data from the map
		        // to the Priority Queue.
			 for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				 queue.offer(entry);
			 }
			 System.out.println("Map ="+map);
		     System.out.println("queue ="+queue);
		     
			 for(int i= 0; i < k; i++) {
				 System.out.println(queue.peek().getKey());
				 ans[i] = queue.poll().getKey();
			 }
			 return ans;
	     }
	     
	     /*
	      * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1da0f1d305c96d5e6191d
	      * Problem: Maximum Distinct Elements (medium)
	      * Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.

			Example 1:
			
			Input: [7, 3, 5, 8, 5, 3, 3], and K=2
			Output: 3
	      */
	     public static int  maximumDitinctElements(int [] arr , int k ) {
			 HashMap <Integer,Integer> map = new HashMap();
			 int ans=0;
			 for(int i = 0 ; i < arr.length; i++) {
				 map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			 }
			 PriorityQueue <Integer> queue = new PriorityQueue<>();
			 
			    // Insert the data from the map
		        // to the Priority Queue.
			 for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				if(entry.getValue() == 1)ans++;
				else queue.offer(entry.getValue());
			 }
			 System.out.println("Map ="+map);
		     System.out.println("queue ="+queue);
		     System.out.println("ans ="+ans);
		     
		    int unique = queue.size();
			while( k !=0 &&  ! queue.isEmpty()) {
				int freq = queue.poll();
				 if(freq == 1) {
					 ans++;
				 }
				 else{
					 freq--;
					
					 k--;
					 queue.add(freq);
				 }
				
			 }
			
			 return ans;
	     }
	     
   public static int SumofElements(int [] arr , int k1, int k2) {
	   int max = k2 > k1 ? k2:k1;
	   int sum = 0;
	   PriorityQueue <Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
	   for( int i= 0 ; i < max ; i++) {
		 queue.add(arr[i]);
	   }
	   System.out.println("SumofElements queue "+queue);
	   for( int i= max  ; i < arr.length ; i++) {
		   if(queue.peek() > arr[i])
		   {
			   queue.poll();
			   queue.add(arr[i]);
		   }
	   }
	  queue.poll();
	  System.out.println("SumofElements queue "+queue);
	  int i = 0;
      while(i < max - (k2 > k1 ? k1:k2) -1) {
    	  sum = sum + queue.poll();
    	  i++;
      }
      
      System.out.println("sum = "+sum);
	   return sum;
	   
   }
   
   /*
    * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1e63eb231098e09f3c6b1
    * nput: "aappp"
	  Output: "papap"
	  Explanation: In "papap", none of the repeating characters come next to each other.
    */
   public static String rearrangeString(String str) {
	   
	  HashMap <Character , Integer> map = new HashMap<>();
	  for(int i = 0 ; i < str.length(); i++) {
		  map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
	  }
	  
	  PriorityQueue <Key> queue = new PriorityQueue<>();
	  for(Map.Entry<Character, Integer>entry : map.entrySet()){
		  queue.add(new Key(entry.getValue(),entry.getKey()));
	  }
	  
	  StringBuffer sb = new StringBuffer();
	// work as the previous visited element
      // initial previous element be. ( '#' and
      // it's frequency '-1' )
	 // System.out.println(queue);
      Key prev = new Key(-1, '#');
      while(!queue.isEmpty()) {
    	  Key k = queue.poll();
    	  sb.append(k.ch);
    	  if(prev.freq > 0 ) queue.add(prev);
    	  k.freq = k.freq - 1;
    	  prev = k;
    	 
      }
	  if(sb.length() != str.length()) return " Not possible ";
	  return sb.toString();
	  
   }
   /*
    * Title: Rearrange String K Distance Apart 
    *  
    *  Problem: 
       Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
		
		Example 1:
		Input: "mmpp", K=2
		Output: "mpmp" or "pmpm"
		Explanation: All same characters are 2 distance apart.
    * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1e7c1b231098e09f3c88d
    */
   public static String rearrangeKdistanceApart(String str,int k) {
	   HashMap <Character , Integer> map = new HashMap<>();
		  for(int i = 0 ; i < str.length(); i++) {
			  map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		  }
		  PriorityQueue <Key> queue = new PriorityQueue<>();
		  for(Map.Entry<Character, Integer>entry : map.entrySet()){
			  queue.add(new Key(entry.getValue(),entry.getKey()));
		  }
		  StringBuffer sb = new StringBuffer();
		 System.out.println(" queue ="+queue);
		 
		 char [] ch = new char[str.length()];
		 Arrays.fill(ch, '\0');
		 while(queue.size() !=0) {
			 Key key = queue.peek();
			 int p =0;
			 while(ch[p] !='\0') { //find first postion where  next char to inserted in the ch[]
				 p++;
			 }
			 
			 for(int d=0; d < key.freq ; d++) {
				 if(p+d*k >=str.length()) {
					 return " Not Possible ";
					 
				 }
				 ch[p + d*k] = key.ch;
				 
			 }
			 queue.poll();
			 
		 }
		
		 
		 return new String(ch);
   }
   /*
    * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a1e905b231098e09f3ca44
    * Problem Statement
		You are given a list of tasks that need to be run, in any order, on a server. Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
		
		If at any time the server can’t execute any task then it must stay idle.
		
		Example 1:
		
		Input: [a, a, a, b, c, c], K=2
		Output: 7
		Explanation: a -> c -> b -> a -> c -> idle -> a
		
		Solution: https://leetcode.com/problems/task-scheduler/
		
		correct solution looks like:
    */
   public static int schedulingTasks(char [] tasks, int k) {
	   HashMap <Character,Integer> map = new HashMap();
		 for(int i = 0 ; i < tasks.length; i++) {
			 map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
		 }
		 int count= 0;
		 int max_frequency =  0;
		 for(Map.Entry<Character, Integer>entry : map.entrySet()){
			 if(entry.getValue() > 1 ) 
			  {
				 count++;
			  }
			 if(entry.getValue() > max_frequency ) {
				 max_frequency = entry.getValue();
			 }
		  }
		 
		  int  max_freq = (k+1)*(max_frequency-1)+count;
		  System.out.println("total frequent numbers count "+count);
		  System.out.println("top frequent number frequncy "+max_frequency);
		  System.out.println("max_freq = "+max_freq);
		  int minimum_cpu_units = Math.max(max_freq, tasks.length);
		  return minimum_cpu_units;
    
   }
   
   
}


class NumKey implements Comparable<NumKey>{
	 
    int freq; // store frequency of character
    char ch;
    int prev_count = -1;
    NumKey(char c,int val )
    {
        freq = val;
        ch = c;
    }
    @Override
    public int compareTo(NumKey k)
    {
        if (this.freq < k.freq)
            return 1;
        else if (this.freq > k.freq)
            return -1;
        return 0;
    }
    
    @Override
	public String toString() {
		return "{ch :"+ch+", frequncey :"+freq+", prev:"+prev_count+"}";
	}
}
class Key implements Comparable<Key>{
	 
    int freq; // store frequency of character
    char ch;
    Key(int val, char c)
    {
        freq = val;
        ch = c;
    }
    @Override
    public int compareTo(Key k)
    {
        if (this.freq < k.freq)
            return 1;
        else if (this.freq > k.freq)
            return -1;
        return 0;
    }
    
    @Override
	public String toString() {
		return "{ch :"+ch+", frequncey :"+freq+"}";
	}
}
class Frequency implements Comparable<Frequency>{
	Integer num;
	int count;
	
	Frequency(Integer n){
		this.num = n;
	
	}
	
	@Override
	public boolean equals(Object o) {
		Frequency f = (Frequency)o;
		return this.num.equals(f.num);
	}
	
	@Override
	public int hashCode() {
		return this.num.hashCode();
	}
	@Override
	public int compareTo(Frequency o) {
		return this.count > o.count? 1:-1;
		
	}
	
	@Override
	public String toString() {
		return "{num :"+num+", frequncey :"+count+"}";
	}
	
}
class  Cordinates implements Comparable<Cordinates>{
	int x;
	int y;
	double distance;
	Cordinates(int x , int y){
		this.x = x;
		this.y = y;
		this.distance = Math.sqrt(x*x + y*y);
	}
	@Override
	public int compareTo(Cordinates o) {
		return this.distance > o.distance? 1:-1;
		
	}
	
	@Override
	public String toString() {
		return "["+x+","+y+"]";
	}
	
}
