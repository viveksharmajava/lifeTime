package ds500.techiedelight1to500;
/*
 * https://techiedelight.com/practice/?problem=ZeroSum
 */
import java.util.*;

public class All500Problems {

	public static void main(String[] args) {
        //program 1
		System.out.println("Date time="+new Date().toGMTString());
		System.out.println("zero sum array ="+program_2_zeroSum(new int[] {4, -7, 1, -2, -1})); 
	   
		 
		Integer [] arr =  new Integer[] {4, 2, -3, -1, 0, 4};
		 List<Integer> list2 = new ArrayList<>();
		 list2.add(4);
		 list2.add(2);
		 list2.add(-3);
		 list2.add(-1);
		 list2.add(0);
		 list2.add(4);
		 
		//problem 3
		System.out.println("program_3_getAllZeroSumSubarrays = "+program_3_getAllZeroSumSubarrays(list2));
	    int [] arr3 =  new int[] {4, 2, -3, -1, 0, 4};
       //problem 3
	   printAllSubarrays(arr3);
	   //Problem 4
	   //sort binary array.. easy 2 pointers..
	   
	   //problem 5
	   list2 = new ArrayList<>();
		 list2.add(5);
		 list2.add(6);
		 list2.add(-5);
		 list2.add(5);
		 list2.add(3);
		 list2.add(5);
		 list2.add(3);
		 list2.add(-2);
		 list2.add(0);
	
	 System.out.println("problem_5_findMaxLenSubarray ="+ problem_5_findMaxLenSubarray(list2,8));
	 //problem 6
	 //
	 
	 //problem 7
	 //find the largest contiguous subarray with equal numbers of 0’s and 1’s.
	  System.out.println("problem7_largestSubarray ="+problem7_largestSubarray(new int[] {0, 0, 1, 0, 1, 0, 0}));
	//Problem8
	  
	  System.out.println("Problem8_findPair ="+Problem8_findPair(new int [] {-10, -3, 5, 6, -2}));
	
	  //Program13 Merge Arrays
	  //https://techiedelight.com/practice/?problem=MergeArrays
	  Program13_merge(new int[] {1, 4, 7, 8, 10}, new int [] {2, 3, 9});
	  //program14_merge
	  program14_merge(new int[] {0, 2, 0, 3, 0, 5, 6, 0, 0},new int[] {1, 8, 9, 10, 15});
	  //program15_dutchNationalFlagProblem
	  program15_dutchNationalFlagProblem(new int[] {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0});
	  //Problem16
	  System.out.println("Problem16_maximumContinuesSequences ="+Problem16_maximumContinuesSequences(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1}));
	  
	  //Problem17
	  /*
	   * Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 0
		Output: (6, 9)
		Explanation: The longest sequence of continuous 1’s is formed by index 6 to 9.
		
		Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 1
		Output: (3, 9)
	   */
	  Problem17_MaximumContinuousSequenceII(new int[] {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0} ,0);
	  //Problem18
	  Problem18_EquilibriumIndex(new int[] {0, -3, 5, -4, -2, 3, 1, 0});
	  Problem18_EquilibriumIndex(new int[] {-7, 3, 7, -3, 1});
	 
	  //Program353_DeleteNodesLinkedList
	   Node head = constructList(new int [] {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10});
	   printList(head);
	   Program353_DeleteNodesLinkedList(head,2,2);
	   printList(head);
	   head = constructList(new int [] { 9 ,9 ,9 , 3});
	   System.out.println("\n constructList2 \n");
	   printList(head);
	  head =  Program355_addDigit(head,7);
	  printList(head);
	  
	  //Program356_AddTwoLinkedLists
	  Node n1 = constructList(new int [] {5 ,7 ,3 ,4 });
	  Node n2 = constructList(new int [] {9,4,6});
	  printList(n1);
	  printList(n2);
	  Node sumList = Program356_AddTwoLinkedLists(n1,n2);
	  System.out.println("\nsumList\n");
      printList(sumList);
	  
      //Problem361_rearrange
      head = constructList(new int [] {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10});
      head = Problem361_rearrange(head);
      System.out.println("\n Problem361_rearrange \n");
      printList(head);
      
      Node n  = constructList(new int [] {1,2,3,4,5,6,7});
      System.out.println("before Problem378_reverseList\n");
      printList(n);
      n =  Problem378_reverseList(n,2,5);
      System.out.println("After Problem378_reverseList\n");
      printList(n);
      
      //Problem 379
      
      n  = constructList(new int [] {1,2,3,4,5,6,7});
      System.out.println("before Problem380_rearrange\n");
      printList(n);
      n =  Problem380_rearrange_easy(n);
      System.out.println("After Problem380_rearrange\n");
      printList(n);
      
      //Problem384
      Node s1 = constructList(new int[] {1,2,3,4,5});
      Node s2 = constructList(new int [] {6,7,8,9,10});
      Node sortedList = Problem384_mergeSortedList(s1,s2);
      System.out.println("\n List after merge ");
      printList(sortedList);
      System.out.println("\n mergeSortedListDecreasing \n ");
      s1 = constructList(new int[] {0,2,3});
      s2 = constructList(new int [] {4,5,6,17});
      Node reversed = Problem385_mergeSortedListDecreasing(s1,s2);
      printList(reversed);
      
      //Problem386
     // First List: 2 —> 6 —> 9 —> 10 —> 15 —> NULLSecond List: 1 —> 4 —> 5 —> 20 —> NULL
      s1 = constructList(new int[] {2,6,9,10,15});
      s2 = constructList(new int [] {1,4,5,20});
     System.out.println("\nProblem386_suffleSorted\n");
      printList(s1);
      System.out.println();
      System.out.println();
      printList(s2);
      System.out.println();
      //verify again..
      Node s2_post = Problem386_mergeLists(s1, s2);
      System.out.println("\nProblem386_suffleSorted s2 post\n");
      printList(s1);
      System.out.println();
      printList(s2);
      System.out.println();
      
      List <Node> list = new LinkedList();
      Node l1 = constructList(new int[] {1,2,3});
      Node l2 = constructList(new int[] {4,5,6,7});
      Node l3 = constructList(new int [] {8,9,10});
      list.add(l1);
      list.add(l2);
      list.add(l3);
      Node merged = Problem387_mergeKSorted(list);
      printList("Result after K merge", merged);
      
      Node palin= constructList(new int[] {1,2,2});
      System.out.println("Problem388_isPalindrome="+Problem388_isPalindrome(palin));
      System.out.println("\nProblem388_2_CheckPalin ="+Problem388_2_checkPalin(palin));
	}

	 // Helper function to print a given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
    
	private static void printList(Node head) {
		// TODO Auto-generated method stub
	    Node n = head;
	    System.out.println("\nprintList\n ");
		while(n != null) {
			System.out.print(n.data+"\t");
			n = n.next;
		}
		
	}
	
	

	/*
	 * Program 2:https://techiedelight.com/practice/?problem=ZeroSum
	 * Zero Sum 
	 * 
	 */
	public static boolean  program_2_zeroSum(int [] nums) {
		Set <Integer> set = new HashSet <>();
		// base case , when the input array start with 0 value at 0th index...
		set.add(0);
		int sum = 0;
		for(int i = 0 ; i < nums.length; i++) {
			sum += nums[i];
			if(set.contains(sum)) return true;
			set.add(sum);
		}
		return false;
	}
	
	/*
	 * problem 3 
	 * 
	 * Get All zero sum 
	 */
	public static List<List<Integer>>  program_3_getAllZeroSumSubarrays(List<Integer> nums)
	{
		List<List<Integer>> subarrays = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();
		// insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
		insert(map,0,-1);
		int sum = 0;
         for(int i = 0 ; i < nums.size(); i++) {
        	 sum += nums.get(i);
        	 if(map.containsKey(sum)) {
        		 List<Integer> list = map.get(sum);
        		 List<Integer> list2 = new ArrayList<>();
        		 // find all subarrays with the same sum
                 for (Integer value: list)
                 {
                     System.out.println("Subarray [" + (value + 1) + "…" +
                                             i + "]");
                     list2.add(value + 1);
                     System.out.println("list2 ="+list2);
                 }
        		 subarrays.add(list2);
        	 }
        	 insert(map, sum,i);
         }
		return subarrays;
	}
	public static void insert(Map <Integer,  List<Integer>>map, int sum ,int index) {
		 map.putIfAbsent(sum, new ArrayList <>());
         map.get(sum).add(index);
	}
	
	/* Problem: 5 Maximum Length Subarray
	 * https://techiedelight.com/practice/?problem=MaximumLengthSubarray
	 * 
	 */
	public static List<Integer> problem_5_findMaxLenSubarray(List<Integer> nums, int target)
	{
		// Write your code here...
		List<Integer>  result = new ArrayList <>();
	    HashMap <Integer, Integer> map = new HashMap<>();
	    int end_index = -1;
	    int sum = 0;
	    int len = 0;
	    //base case , 
	    
	    // insert (0, -1) pair into the set to handle the case when a
        // subarray with sum `S` starts from index 0
        map.put(0,-1);
        
	    for(int i = 0 ; i < nums.size(); i ++){
	        sum += nums.get(i);
	    	map.putIfAbsent(sum , i);
	    	if( map.containsKey(sum-target) && len < ( i - map.get(sum-target) )){
	    		len = i - map.get(sum-target);
	    		end_index = i;
	    	}
	    	
	    }
	    int start = end_index-len+1;
	    while(start <= end_index){
	    	result.add(nums.get(start++));
	    }
		return result;
	}
//357 sort linked List
// https://www.techiedelight.com/?problem=SortLinkedList	
	public static Node sort(Node head)
	{
	  	Node result = null;
	  	Node current = head;
	  	while(current != null){
	  	    Node n = current;
	  	    current = current.next;
	  		result = insertSort(result ,  n);
	  	}
	  	return result;
	}
	
	private static Node insertSort(Node n , Node newNode){
		if(n == null || n.data >= newNode.data){
			newNode.next = n;
			n = newNode;
			return n;
		}
		Node current = n;
		while(current.next != null && current.next.data < newNode.data){
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		return n;
	}
	
	// Utility function to insert <key, value> into the multimap
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }
 
    // Function to print all subarrays with a zero-sum in a given array
    public static void printAllSubarrays(int[] nums)
    {
        // create an empty multimap to store the ending index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
 
        // insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);
 
        int sum = 0;
 
        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            sum += nums[i];
 
            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);
 
                // find all subarrays with the same sum
                for (Integer value: list)
                {
                    System.out.println("Subarray [" + (value + 1) + "…" +
                                            i + "]");
                }
            }
 
            // insert (sum so far, current index) pair into the multimap
            insert(hashMap, sum, i);
        }
        
    }
  //problem 7
    //find the largest contiguous subarray with equal numbers of 0’s and 1’s.
    //https://techiedelight.com/practice/?problem=LargestSubarray
    public static List<Integer> problem7_largestSubarray(int [] nums){
    	 List<Integer> result = new ArrayList<>();
    	 for(int i=0; i < nums.length; i++) {
    		 if(nums[i] == 0 ) nums[i]  = -1;
    	 }
    	 //now find the longest sum with sum zero..
    	 int sum = 0;
    	 HashMap <Integer,Integer> map = new HashMap <>();
 		// base case , when the input array start with 0 value at 0th index...
 		// map.put(0,-1);
 		 int end_index = -1;
 		 int len =0;
 		for(int i = 0 ; i < nums.length; i++) {//0, 0, 1, 0, 1, 0, 0
 			sum += nums[i];
 			if(map.containsKey(sum) && len < i- map.get(sum)) {
 				len = i - map.get(sum);
 				end_index = i;
 			}
 			else{
 				map.put(sum, i);
 			}
 			
 		}
 		if(end_index != -1) {
 			for(int i = end_index -len+1 ; i <= end_index ; i++) {
 				if(nums[i] == -1) result.add(0);
 				else result.add(1);
 			}
 		}
 		
    	 return result;
    }
    
    //problem 8
    
	/* The Pair<U, V> class have
	1. Two member variables, first and second.
	2. Factory method `Pair.of(U, V)` for creating its immutable instance.
	3. equals() and hashCode() methods overridden.
*/

public static Pair Problem8_findPair(int[] nums)
{
   if (nums == null || nums.length  < 2) return null;
	Arrays.sort(nums);
	if(nums[0]*nums[1] > nums[nums.length-1]*nums[nums.length-2]){
		return  Pair.of(nums[0],nums[1]);
	}
	return   Pair.of(nums[nums.length-1],nums[nums.length-2]);
}
//Program13
//https://techiedelight.com/practice/?problem=MergeArrays
public static void Program13_merge(int[] X, int[] Y)
{
	// Write your code here...
    int l1 = X.length-1;
    int l2 =Y.length-1;
    int i = 0;
    int j=0;
    while(i <=l1 && j <= l2){
    	if(X[i] <= Y[0]){
        	i++;
         	continue;
    	} 
    	int temp = X[i];
    	X[i]  = Y[0];
    	Y[0] = temp;
    	j = 0;
    	while(j < l2 && Y[j] > Y[j+1] ){
    		temp =  Y[j+1];
    		 Y[j+1] = Y[j];
    		 Y[j] = temp;
    		 j++;
    	}
    
    }
    System.out.println("X ="+Arrays.toString(X));
    System.out.println("Y ="+Arrays.toString(Y));
  }

  //program14 https://techiedelight.com/practice/?problem=MergeArraysII
		public static void program14_merge(int[] X, int[] Y)
		{
			int k=0; 
			for(int x : X) {
				if(x != 0) {
					X[k++] =x;
				}
			}
			k--;
			int M  = X.length-1;
			int N = Y.length-1;
			while( k >=0 && N >=0) {
				if(X[k] > Y[N]) {
					X[M--] = X[k--];
				}else {
					X[M--] = Y[N--];
				}
			}
			//copy remaining elements of Y
			while(N >=0) {
				X[M--] = Y[N--];
			}
			System.out.println("X ="+Arrays.toString(X));
			Arrays.fill(Y, 0);
		}
  //program15_dutchNationalFlagProblem
		public static void program15_dutchNationalFlagProblem(int[] nums)
		{
	     
	     int start = 0 , mid = 0, pivot = 1,end = nums.length-1;
	     while(mid <= end ){
	     	
	     	if(nums[mid] < pivot){//current element is 0
	     		swap(nums , start ,mid);
	     		start++;
	     		mid++;
	     		
	     	}
	     else	if(nums[mid] > pivot) {//curent element is 2
	     		swap(nums,mid, end);
	     		end--;
	     	}
	     	else{
	     		mid++;
	     	}
	     }
	     System.out.println("Result ="+Arrays.toString(nums));
		}
		
		private static void swap(int []nums , int a, int b){
			int temp  = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
		}
		
	//Problem16 maximum continues sequences..
	// https://techiedelight.com/practice/?problem=MaximumContinuousSequence
	//Input : [0, 0, 1, 0, 1, 1, 1, 0, 1, 1]
	//	Output: 7
		
    public static int Problem16_maximumContinuesSequences(int [] nums) {
    	int max_count = 0;
    	int count= 0;
    	int previous_zero = -1;
    	int max_index = -1;
    	for(int i=0; i < nums.length; i++) {
    		if(nums[i] == 1) count++;
    		else {
    			//set count + 1 previous 0 position..
    			count = i - previous_zero;
    			
    			previous_zero = i;
    			if(max_count < count) {
    				max_count = count;
    				max_index= previous_zero;
    			}
    		}
    	}
    	return max_index;
    }
    
   //Problem17
   //https://techiedelight.com/practice/?problem=MaximumContinuousSequenceII
    /*
     * Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 0
		Output: (6, 9)
		Explanation: The longest sequence of continuous 1’s is formed by index 6 to 9.
		
		Input : nums[] = [1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0], k = 1
		Output: (3, 9)
     */
    public static void Problem17_MaximumContinuousSequenceII(int [] nums, int k) {
    	
    	int window = 0;
    	int left =0;
    	int leftIndex = 0;
    	int count = 0;
    	for(int right = 0 ; right < nums.length ; right++) {
    		if(nums[right] ==0) count++;
    		
    		while(count> k) {
    			 if(nums[left] == 0) count--;
    			 left++;
    		}
    		if(right-left + 1 > window) {
    			window = right-left +1;
    			leftIndex = left;
    		}
    	}
    	 // no sequence found
        if (window == 0) {
            return;
        }
    	 // print the maximum sequence of continuous 1's
        System.out.println("The longest sequence has length " + window +
                " from index " + leftIndex + " to " + (leftIndex + window - 1));
    }
    //Problem18 
    //https://techiedelight.com/practice/?problem=EquilibriumIndex
    public static void Problem18_EquilibriumIndex(int [] nums) {
    	int [] left = new int [nums.length];
    	int sum = 0;
    	for(int i=0; i < nums.length; i++) {
    		sum += nums[i];
    		left[i] = sum;
    	}
    	sum = 0;
    	for(int i=nums.length-1; i >=0 ; i--) {
    		sum += nums[i];
    		if(left[i] == sum) {
    			System.out.println("EquilibriumIndex "+i);
    		}
    	}
    }
    
   //Problem348
    public static Node constructList(int [] keys) {
    	// Write your code here...
		Node head  = new Node(keys[keys.length-1],null);
		for(int i = keys.length-2 ; i >=0 ; i--)
	     {
	     	 head = new Node(keys[i],head);
          	}
         	
          return head;	
    }
    
    public static Node constructList2(int [] keys) {
    	// Write your code here...
		Node head  = new Node(keys[0],null);
		for(int i = 1; i < keys.length; i++)
	     {
	     	 head = new Node(keys[i],head);
          	}
         	
          return head;	
    }
    
    //Problem351
    //https://techiedelight.com/practice/?problem=SortedInsertInLinkedList
    public static Node Problem351_insertIntoSortedList(Node head, Node node) {
    	// Write your code here...
		if(head == null || head.data >= node.data)
		{
			 node.next = head;
			 return node;
		}	
		 Node next = head.next;
		 Node prev = head;
		 while(next != null && next.data < node.data){
		 	prev = next;
		 	next = next.next;
		 }
		 node.next =prev.next;
		 prev.next =node;
		 return head;
    }
    //Program252
    //https://techiedelight.com/practice/?problem=KthNodeFromEnd
	public static int findKthNode(Node head, int k)
	{
		// Write your code here...
		Node result = null;
		Node temp = head;
		Node prev = head;
		while(temp != null && k > 0){
		
		  temp = temp.next;
	   	k--;
		}
		while(temp != null){
			prev = prev.next;
			temp = temp.next;
		}
		return prev.data;
		
	}
	//Program353
	//given m,n , skipp m nodes and delete n nodes alternatvily 
	//https://techiedelight.com/practice/?problem=DeleteNodesLinkedList
	//Input: List: 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , null, m = 1, n = 3
	//Output: 1 , 5 , 9 , null
	
	public static Node Program353_DeleteNodesLinkedList(Node head,int m, int n) {

		// Write your code here...
		int a = m;
		int b = n;
		Node prev = head;
		if(prev == null)  return head;
		while( --a > 0 && prev.next != null){
			prev = prev.next;
		}
		if(prev.next == null) return head;
		Node skip = prev.next;
		while(b-- > 0 && skip != null){
			skip = skip.next;
		}
		prev.next = skip;
		
	 return	Program353_DeleteNodesLinkedList(skip,m,n);
	}
	//Program355
	//https://techiedelight.com/practice/?problem=AddNumberToLinkedList
	//Input: List = 9 —> 9 —> 9 —> 3 —> null, k = 7
	//Output: 1 —> 0 —> 0 —> 0 —> 0 —> null
	public static Node Program355_addDigit(Node head, int k) {
		
		Node rev = reverseList(head);
		System.out.println("reverseList");
		
		printList(rev);
		
		Node list = new Node((rev.data+k)%10 ,null);
		k = (rev.data +k)/10;
		rev = rev.next;
		while(rev != null && k > 0) {
			 Node n = new Node((rev.data+k)%10 ,list);
			 list = n;
			 k = (rev.data +k)/10;
			 rev  = rev.next;
		}
		if(rev == null && k > 0) {
			Node n = new Node(k ,list);
			 list = n;
		}
		else if ( rev !=null) {
			while(rev!=null) {
				 Node n = rev;
				 rev  = rev.next;
				 n.next = list;
				 list = n;
			}
		}
		return list;
		
	}
	//Problem376
	//https://techiedelight.com/practice/?problem=ReverseLinkedList
	public static Node reverseList(Node n) {
		Node rev = null;
		while(n != null) {
			Node t  = n;
			n = n.next;
			t.next = rev;
			rev = t;
		}
		return rev;
	}
	//Problem376
	//https://techiedelight.com/practice/?problem=ReverseLinkedListII
	public static Node Problem377_reverseAjacentK(Node head, int k)
	{
		if(head == null) return head;
		Node rev = null;
		Node n = head;
		int i =0;
		while(n != null && i++ <k) {
			Node t  = n;
			n = n.next;
			t.next = rev;
			rev = t;
		}
		 
		head.next = Problem377_reverseAjacentK(n,k);
		return rev;
	}
	//Problem377
	//https://techiedelight.com/practice/?problem=ReverseLinkedListIII
	public static Node Problem378_reverseAjacentAlternateK(Node head, int k)
	{
		if(head == null) return head;
		Node rev = null;
		Node n = head;
		int i =0;
		while(n != null && i++ <k) {
			Node t  = n;
			n = n.next;
			t.next = rev;
			rev = t;
		}
		 i =0;
			while(n != null && i++ <k) {
				head.next  = n;
				head = n;
				n = n.next;
			}
		head.next = Problem378_reverseAjacentAlternateK(n,k);
		return rev;
	}
	//Problem378
	//https://techiedelight.com/practice/?problem=ReverseLinkedListIV
		public static Node Problem378_reverseList(Node head, int m,int n)
		{
			if(m > n) return head;
			Node prev = null;
			Node curr = head;
			int i=1;
			while(i++ < m && curr !=null) {
				prev  = curr;
				curr = curr.next;
			}
			//prev now point to (m-1)th Node
			//curr now point to 
			Node start = curr;
			Node end = null;
			//traverse and reverse  nodes from m to n..
			while(i++ <=n && curr != null) {
				//take a note of next node
				Node next = curr.next;
				//move the current node on the end.
				curr.next = end;
				
				end = curr;
				//move to next node.
				curr = next;
			}
			/*
			 * start point to mth node
			 * curr point to n+1 th node
			 * end point to nth node.
			 */
			//fix the pointers
			
			if(start !=null) {
				start.next =curr;
				if(prev != null) {
					prev.next = end;
				}else {
					head = end;
				}
			}
			return head;
			
			
		}
	//Program356
	//https://techiedelight.com/practice/?problem=AddTwoLinkedLists
	public static Node Program356_AddTwoLinkedLists(Node list1, Node list2) {
       Node result = null;
       list1 = reverseList(list1);
     
       list2 = reverseList(list2);  
       System.out.println("after reverse");
       printList(list1);
       printList(list2);
       int k = 0;
       while(list1 != null || list2 != null) {
    	   int data ;
    	   if( list1 != null && list2 != null)
    	  {
    		   data  = list1.data + list2.data + k;
        	   k = data/10;
        	   data = data%10;
        	   list1 = list1.next;
        	   list2 = list2.next;
    	  }
    	   else if(list1 != null) {
    		   data  = list1.data  + k;
        	   k = data/10;
        	   data = data%10;
        	   list1 = list1.next;
    	   }
    	   else {
    		   data  =  list2.data + k;
        	   k = data/10;
        	   data = data%10;
        	   list2 = list2.next;
    	   }
    	   Node n = new Node(data,null);
    	   n.next = result;
    	   result = n;
    	   
       }
       if( k != 0) {
    	   Node n = new Node(k,null);
    	   n.next = result;
    	   result = n;
       }
       return result;
	}
	//Problem361
	//https://techiedelight.com/practice/?problem=SwapNodesLinkedList
	/*

	Given a singly-linked list of integers, pairwise swap its adjacent nodes. The swapping of data is not allowed, only links should be changed.
    node =temp.next;
    temp.next = temp.next.next;
    node.next = temp;
    temp = temp.next;
    
    node = 2
    1->3
    2-> 1
    temp 3>4
	Input : 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> null
	Output: 2 —> 1 —> 4 —> 3 —> 6 —> 5 —> 8 —> 7 —> null

	*/
	//not working ..
	public static Node Problem361_rearrange(Node head)
	{
		 // if the list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }
 
        Node curr = head, prev = null;
 
        // consider two nodes at a time and swap their links
        while (curr != null && curr.next != null) // 1  2 3 4 5 6 7 8
        {
            Node temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
 
            if (prev == null) {
                head = temp;
            }
            else {
                prev.next = temp;
            }
 
            prev = curr;
            curr = curr.next;
        }
 
        return head;
		
	}
	//Problem362
	//https://techiedelight.com/practice/?problem=DetectCycleLinkedList
	public static boolean Problem362_detectCycle(Node head)
	{
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
	//Program363
	//https://techiedelight.com/practice/?problem=RemoveCycleLinkedList
	//use set to identify and delete..
	public static void Problem363__1_removeCycle(Node head)
	{
		HashSet <Node> set = new HashSet<>();
		Node n = head;
		Node prev = null;
		while(n != null) {
			if(set.contains(n)) {
				prev.next = null;
			}
			set.add(n);
			prev = n;
			n = n.next;
		}
		
	}
	
	//Program363
		//https://techiedelight.com/practice/?problem=RemoveCycleLinkedList
		//use set to identify and delete..
		public static void Problem363__2_removeCycle(Node head)
		{
			Node slow = head, fast = head;
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow == fast) break;
			}
			
			for(Node curr = head; curr != null; curr = curr.next) {
				Node ptr = slow;
				while(ptr.next != slow && ptr.next != curr) {
					ptr = ptr.next;
				}
				// If `ptr` meets `curr`, then that means there is a loop, and `curr`
	            // points to the first node of the loop and `ptr` points to the last node
	            if (ptr.next == curr)
	            {
	                // set next pointer of `ptr` to `null` to break the chain
	                ptr.next = null;
	                return;
	            }
			}
			
		}
	/*
	 * Problem369: 
	 * Clone list contains random pointers..
	 * https://www.techiedelight.com/clone-a-linked-list-with-random-pointers/
	 * 
	 */
		public static Node cloneList(Node head) {
			
			Node n = null;
			HashMap <Node, Node> map = new HashMap<>();
			n = clone(head,map);
			//associate random pointers
			//we can do this recursive  too..
			for(Node key : map.keySet()) {
				map.get(key).random = map.get(key.random);
			}
			return n;
		}
		
		private static Node clone(Node head,HashMap<Node,Node> map) {
			if(head == null) return head;
			map.put(head, new Node(head.data));
			return map.get(head).next = clone(head.next,map);
			
		}
		/*
		 * Problem372
		 * https://techiedelight.com/practice/?problem=SortedIntersect
		 * Input:

			X: 1 —> 4 —> 7 —> 10 —> null
			Y: 2 —> 4 —> 6 —> 8 —> 10 —> null
			
			Output: 4 —> 10 —> null
		 */
		public static Node Problem372_sortedIntersect(Node x, Node y)
		{
			// Write your code here...
			Node head = null, prev = null ;
			while(x != null && y != null){
				if(x.data == y.data){
				   	Node temp = new Node(x.data);
				    if(head == null ){
				    	head = prev = temp;
				    }else{
				    	prev.next = temp;
				    	prev = temp;
				    }
				
					x = x.next;
					y = y.next;
				}else if(x.data > y.data){
					 y = y.next;
				}
				else{
					x = x.next;
				}
			}
			return head;
		}
      //Problem374,Problem375 also same
		public static Node Problem374_shuffleMerge(Node x, Node y) {
			// Write your code here...

			// Write your code here...
			Node head = null, prev = null;
			boolean first = true;
			while (x != null && y != null) {
				Node temp = null;
				if (first) {
					temp = new Node(x.data);
					x = x.next;
					first = false;
				} else {
					temp = new Node(y.data);
					y = y.next;
					first = true;
				}
				if (head == null) {
					head = prev = temp;
				} else {
					prev.next = temp;
					prev = temp;
				}
			}
			if (x != null) {
				if (head == null) {
					head = x;
				} else {
					prev.next = x;

				}
			} else {
				if (head == null) {
					head = y;
				} else {
					prev.next = y;

				}
			}
			return head;

		}
	    /* Problem: 380
	     * https://techiedelight.com/practice/?problem=RearrangeLinkedList
	     * https://www.techiedelight.com/move-even-nodes-to-end-of-list-in-reverse-order/
	     */
		/*

		Given a singly-linked list of integers, move every even node to the end of the list in reverse order.

		Input : 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> null
		Output: 1 —> 3 —> 5 —> 7 —> 6 —> 4 —> 2 —> null
		
		

		*/
		public static Node Problem380_rearrange_easy(Node head){

	        // empty list
	        if (head == null) {
	        	return head;
	        }
	 
	        // maintain two lists, odd and even
	        Node odd = head;
	        Node even = null, prev = null;
	 
	        // do for each odd node
	        while (odd != null && odd.next != null)
	        {
	            // "move" next node (which will be even)
	            // to the front of even list
	            if (odd.next != null)
	            {
	                Node newNode = odd.next;
	                odd.next = odd.next.next;
	 
	                newNode.next = even;
	                even = newNode;
	            }
	 
	            // update `prev` and move to the next odd node
	            prev = odd;
	            odd = odd.next;
	        }
	 
	        // append even list to odd list
	        if (odd != null) {
	            odd.next = even;
	        }
	        else {
	            prev.next = even;
	        }
	        return head;
		}
		public static Node Problem380_rearrangeComplex(Node n) {
			if(n == null || n.next == null) return n;
			Node head = n;
			Node first = n;
			Node second = n.next;
			Node prev = null;
			while(second.next !=null && second.next.next != null) {
				first.next = second.next;
				first = first.next;
				Node temp = second;
				second = second.next.next;
				temp.next = prev;
				prev = temp;
			}
			if(second.next != null) {
				first.next = second.next;
				first = first.next;
				second.next = prev;
				prev = second;
			}else if(second != null) {
				second.next = prev;
				prev = second;
			}
			first.next = prev;
			return head;
			
		}
	/*
	 * Problem384
	 * https://techiedelight.com/practice/?problem=SortedMerge
	 * Given two sorted singly-linked lists of integers, merge them into a single list in increasing order, and return it.

	Input:
	
	X: 1 —> 3 —> 5 —> 7 —> null
	Y: 2 —> 4 —> 6 —> null
	
	Output: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> null

	 */
	 public static Node Problem384_mergeSortedList(Node n1, Node n2) {
		 Node head = null;
		 Node tail = null;
		 while(n1 != null && n2 != null) {
			 Node temp;
			 if(n1.data < n2.data) {
				 temp =n1;
				 n1 = n1.next;
			 }
			 else {
				 temp = n2;
				 n2 = n2.next;
			 }
			 if(head == null) head = tail=temp;
			 else {
				 tail.next = temp;
				 tail = temp;
			 }
		 }
		 if(n1 != null) {
			 tail.next = n1;
		 }else {
			 tail.next = n2;
		 }
		return head; 
	 }
	 
		/*
		 * Problem385
		 * https://techiedelight.com/practice/?problem=SortedMergeII
		Given two sorted singly-linked lists of integers, merge them into a single list in decreasing order, and return it. In other words, merge two sorted linked lists from their end.
		
		Input:
		
		X: 1 —> 3 —> 5 —> null
		Y: 2 —> 6 —> 7 —> 10 —> null
		
		Output: 10 —> 7 —> 6 —> 5 —> 3 —> 2 —> 1 —> null

		 */
		 public static Node Problem385_mergeSortedListDecreasing(Node n1, Node n2) {
			 Node prev = null;
			 while(n1 != null && n2 != null) {
				 Node temp;
				 if(n1.data < n2.data) {
					 temp =n1;
					 n1 = n1.next;
				 }
				 else {
					 temp = n2;
					 n2 = n2.next;
				 }
				 temp.next = prev;
				 prev = temp;
			 }
			 
			 Node n;
			 if(n1 != null) {
				n = n1;
			 }else {
				 n = n2;
			 }
			 while(n != null) {
				 Node t = n;
				 n = n.next;
				 t.next = prev;
				 prev = t;
			 }
			return prev; 
		 }
		/*
		 * Problem386
		 * https://techiedelight.com/practice/?problem=SortedMergeIII
		 * 
		 */
		 
		 /*

		 Given two sorted singly-linked lists of integers, merge them without modifying the links of the first list.

		 If m and n are the total number of nodes in the first and second list, then the first m smallest nodes in both lists combined should become part of the first list, and the remaining nodes should become part of the second list. 
		 The solution should preserve the sorted order of elements in both lists.

		 Input:

		 X: 2 —> 6 —> 9 —> 10 —> 15 —> null
		 Y: 1 —> 4 —> 5 —> 20 —> null

		 Output:

		 X: 1 —> 2 —> 4 —> 5 —> 6 —> null
		 Y: 9 —> 10 —> 15 —> 20 —> null

		 Note: The solution should rearrange the first list X without modifying its links, and return the second list Y.

		 */
		 // Function to in-place merge two sorted linked lists without
		    // modifying links of the first list.
		    public static Node Problem386_mergeLists(Node first, Node second)
		    {
		        // loop till either list runs out
		        while (first != null && second != null)
		        {
		            // compare each element of the first list with the first element
		            // of the second list
		            if (first.data > second.data)
		            {
		                // exchange data if the current node of the first list has more value
		                // than the first node of the second list
		                swapData(first, second);
		 
		                // pop the front node from the second list
		                Node front = second;
		                second = (second).next;
		 
		                // insert the front node at its correct place into the second list
		                second = sortedInsert(second, front);
		            }
		 
		            // advance the first list to the next node
		            first = first.next;
		        }
		 
		        return second;
		    }
		 // Function to exchange data of the given linked list nodes
		    public static void swapData(Node first, Node second)
		    {
		        int data = first.data;
		        first.data = second.data;
		        second.data = data;
		    }
		 
		    // Function to insert a given node at its correct sorted position into
		    // a given list sorted in increasing order
		    public static Node sortedInsert(Node head, Node newNode)
		    {
		        // special case for the head end
		        if (head == null || (head).data >= newNode.data)
		        {
		            newNode.next = head;
		            head = newNode;
		            return head;
		        }
		 
		        // locate the node before the point of insertion
		        Node current = head;
		        while (current.next != null && current.next.data < newNode.data) {
		            current = current.next;
		        }
		 
		        newNode.next = current.next;
		        current.next = newNode;
		 
		        return head;
		    }
		 
		//Problem387
		/*
		 * https://techiedelight.com/practice/?problem=SortedMergeIV

		Given k sorted singly-linked lists of integers, merge them into a single list in increasing order, and return it.
		
		Input: [
			1 —> 5 —> 7 —> null,
			2 —> 3 —> 6 —> 9 —> null,
			4 —> 8 —> 10 —> null
		]
		
		Output: 1 —> 2 —> 3 —> 4 —> 5 —> 6 —> 7 —> 8 —> 9 —> 10 —> null

		 */
		    
		public static Node Problem387_mergeKSorted(List<Node> list) {
			PriorityQueue <Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
			// push the first node of each list into the min-heap
	       for(Node n: list) {
	    	   pq.add(n);
	       }
	        Node head = null, tail = null;
	        while(!pq.isEmpty()) {
	        	Node min = pq.poll();
	        	if(head  == null) {
	        		head = tail = min;
	        	}else{
	        	  tail.next = min;
	        	  tail = min;
	        	}
	        	//move the next element to queue from the same list.
	        	if(min.next != null) {
	        		pq.add(min.next);
	        	}
	        }
	        return head;
		}
	/*
	 * Problem388_2
	 * More accurate solution
	 * https://www.techiedelight.com/check-if-linked-list-is-palindrome/
	 */
		// Recursive function to check if the linked list is a palindrome or not
	    public static boolean checkPalindrome(NodeWrapper left, Node right)
	    {
	        // base case
	        if (right == null) {
	            return true;
	        }
	 
	        boolean result = checkPalindrome(left, right.next) &&
	                            (left.node.data == right.data);
	        left.node = left.node.next;
	 
	        return result;
	    }
	 
	    // Function to check if the linked list is a palindrome or not
	    public static boolean Problem388_2_checkPalin(Node head)
	    {
	        // Wrap the `head` node, so its reference can be changed inside the
	        // `checkPalindrome()`
	        return checkPalindrome(new NodeWrapper(head), head);
	    }
	/*
	
	Problem: Given a singly-linked list of integers, determine whether the linked list is a palindrome.
	Problem388 https://techiedelight.com/practice/?problem=PalindromeLinkedList
	Input: 1 —> 2 —> 3 —> 2 —> 1 —> null
	Output: true
	
	Input: 1 —> 2 —> 3 —> 3 —> 1 —> null
	Output: false	 
	 */
      public static boolean Problem388_isPalindrome(Node head) {
    	 if(head == null || head.next == null) return true;
    	  Node slow = head;
    	  Node  fast = head.next;
    	  Node prev = null;
    	  Node t;
    	  int count =0;
    	  while(fast !=null && fast.next != null) {
    		   t = slow;
    		 
    		  slow =slow.next;
    		  fast =fast.next.next;
    		  t.next = prev;
    		  prev = t;
    		  count++;
    	  }
    	System.out.println("count ="+count);
    	  if(fast != null) {
    		  t = slow;
    		  slow = slow.next;
    		  t.next  = prev;
    		  prev = t;
    	  }
    	  if(count%2 ==0) slow = slow.next;
    	  printList("Reversed half list =",prev);
    	  while(prev != null && slow != null) {
    		  System.out.println(prev.data+"\t "+slow.data);
    		  if(prev.data !=slow.data) return false;
    		  prev = prev.next;
    		  slow = slow.next;
    	  }
    	 return true; 
      }
}
//Wrapper over `Node` class
 class NodeWrapper
{
    public Node node;

    NodeWrapper(Node node) {
        this.node = node;
    }
}

class Node {
	int data;		// data field
	Node next;		// pointer to the next node
    Node random;
	Node() {}
	
	Node(int data) { this.data = data; }
	Node(int data, Node next) { 
		this.data = data; this.next = next; 
	}
}
