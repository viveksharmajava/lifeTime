package designguru.modified_bst;

import java.util.Arrays;
import java.util.Stack;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f1a8b44223ca42ca4a723
 * Write a function to return the index of the ‘key’ if it is present in the array,
 * otherwise return -1.
 * Example 1:

	Input: [4, 6, 10], key = 10
	Output: 2
 * 
 */
public class BSTProblems {

	public static void main(String[] args) {
		int [ ] arr = {4,6,10};
		int key = 10;
		System.out.println("bstSearch = "+bstSearch(arr,key));
		System.out.println("ceilingOfNumber="+ceilingOfNumber(arr, 6));
		int [] ceiling = {1, 3, 8, 10, 15};
		System.out.println("Ceil ="+ceil(ceiling, 12));
		System.out.println("Floor ="+floor(ceiling, 5));
		System.out.println("ceilingOfNumber="+ceilingOfNumber(ceiling, 12));
		char [] letters = {'c','f','j'};
		char  target = 'k';
		System.out.println("nextGreatestLetter ="+nextGreatestLetter(letters,target));
//		 target = 'f';
//		System.out.println("nextGreatestLetter ="+nextGreatestLetter(letters,target));
//		 target = 'c';
//		System.out.println("nextGreatestLetter ="+nextGreatestLetter(letters,target));
//		 target = 'j';
//		System.out.println("nextGreatestLetter ="+nextGreatestLetter(letters,target));
	
	
		int [] range = {1, 3, 8, 10, 15} ;
		 target = 10;
		System.out.println(Arrays.toString(numberRange(range,target)));
		
		
		 int infinte[] = new int[]{3, 5, 7, 9, 10, 90, 
                 100, 130, 140, 160, 170};
		int found_index =  searchInInfiniteSortedArray(infinte, 10);
		System.out.println(" found_index = "+found_index);
		
		int [] minDIff  = {4, 6, 10 }; 
		int ans = minimumDifferenceElement(minDIff , 7);
		System.out.println("minimumDifferenceElement = "+ans);
		
		int [] bitonic = {4,6,10,5,3,2};
		int  res =  bitonicArrayMaximum(bitonic);
		System.out.println("bitonicArrayMaximum " +res);
		
		int [] rotated = {8, 11, 13, 15, 1, 4, 6};
		int rotatedSearch =  searchInRotatedSortedArray(rotated , 1);
		System.out.println("rotatedSearch ="+rotatedSearch);
	     int rotation_count = rotationCount(rotated);
	     System.out.println("rotation_count ="+rotation_count);
	     
	     int min = minInRotatedArray(rotated);
	     System.out.println("minInRotatedArray(arr)"+ min);
	     
	     //bitonicArraySearch
	    int [] bitonic2 =  {1, 3, 8, 9,11};
	    int index  = bitonicArraySearch(bitonic2, 1);
	    System.out.println(" bitonicArraySearch ="+index);
	    
	    int x = -2;
        int n = 10;
 
        System.out.println("pow(" + x + ", " + n + ") = " + power(x, n));
        
        System.out.println("isValidSquare ="+ isValidSquare(54));
        
        int almost[] =  {10, 3, 40, 20, 50, 80, 70};
        int searched_index  = searchInNearlyShortedArray(almost, 40);
        System.out.println(" searchInNearlyShortedArray ="+searched_index);
        
        //10 4 9 1 3 5 9 4
        // output : 10 9 3 9 4 5 1 4
        Node node = new  Node(10);
        node.next = new Node(4);
        node.next.next = new Node(9);
        node.next.next.next = new Node(1);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next = new Node(4);
       Node newList =  rearrange(node);
       while(newList!=null) {
    	   System.out.println(newList.data);
    	   newList  = newList.next;
       }
        
	}

	public static int bstSearch(int [] arr,int key) {
		
		int s = 0; 
		int e = arr.length-1;
		
		while(s <= e) {
			int mid = s + (e-s)/2;
			//System.out.println("mid = "+mid);
			if(arr[mid] == key) return mid;
			if(arr[mid] > key) e = mid-1;
			else s = mid+1;
		}
		return -1;
	}
	/*
	 *  problem: 2
	 *  https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f1fd54e4f288d4a83ab44
	 *  The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

		Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
		
		Example 1:
		
		Input: [4, 6, 10], key = 6
		Output: 1
	 */
	public static int ceilingOfNumber(int [] arr,int key) {
		
		int s = 0; 
		int e = arr.length-1;
		
		while(s <= e) {
			int mid = s + (e-s)/2;
			//System.out.println("mid = "+mid);
			if(arr[mid] == key) return mid;
			if(mid- 1 >=0  && arr[mid] > key && arr[mid-1]  < key) return mid;
			else if(mid- 1 >=0  && arr[mid] > key && arr[mid-1]  >= key) e = mid-1;
			else if(mid + 1 <= e  && arr[mid] < key && arr[mid + 1]  >= key) return mid+1;
			if(mid + 1 <= e  && arr[mid] < key) s = mid+1;
		}
		return -1;
	}
	/* Find the ceil of an element:
	 * 
	 * https://www.callicoder.com/binary-search-ceiling-of-element-in-sorted-array/
	 */
	public static int ceil(int [] arr , int x) {
		int s = 0;
		int e = arr.length - 1;
		int ceil = -1;
		while( s <= e) {
			int mid = (s+e)/2;
			if(arr[mid] == x) //arr[mid] is the ceil
			return  arr[mid];
			
		   if(x < arr[mid] ) { //arr[mid] is the smallest element found so far that is greater than x
			   ceil = arr[mid];
			   e = mid-1;
		   }else {
			   s = mid+1;
		   }
			
		}
		
		return ceil;
	}
	
	public static int floor(int [] arr ,int x) {
		int s = 0;
		int e = arr.length-1;
		int floor = -1;
		while(s <= e) {
			int mid = (s+e)/2;
			if(arr[mid] == x) //arr[mid] is the floor
			return  arr[mid];
			
			if( arr[mid] < x) { // arr[mid] is the first element found lesser than x so far.
				floor = arr[mid];
				s = mid+1;
			}else {
				e = mid-1;
			}
				
		}
		return floor;
	}
	
	/*
	 * Problem : 3
	 * Next Letter 
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f23b94e4f288d4a83ae0d
	 * Given an array of lowercase letters sorted in ascending order,
	 * find the smallest letter in the given array greater than a given ‘key’.
	 * Input: ['a', 'c', 'f', 'h'], key = 'f'
	   Output: 'h'
	   
	   Problem statement 2:
	   https://leetcode.com/problems/find-smallest-letter-greater-than-target/
	   You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

	Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
	
	 
	
	Example 1:
	
	Input: letters = ["c","f","j"], target = "a"
	Output: "c"
	Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
	Example 2:
	
	Input: letters = ["c","f","j"], target = "c"
	Output: "f"
	Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
	  
	   
	   condition:
	   1. mid  === key  , return next element if exist else return first element in the array.
	   2.mid < key , s = mid+1;
	   3.mid > key ,e  = mid-1
	    
	   
	 */
      public static  char nextGreatestLetter(char[] arr, char key) {

  		
  		int s = 0; 
  		int e = arr.length-1;
  		
  		while(s <= e) {
  			int mid =s +(e-s)/2;
  			if(arr[mid] >  key  ) {
  				e  = mid-1;
  			}
  			else
			{
			s = mid+1;
			}
  		}
  		return arr[s%arr.length];
  	
    }
     
     public static int[] numberRange(int [] arr , int key) {
    	 int [] range = new int [2];
    	 
    	 int s = 0,e = arr.length-1;
    	 int indx  = -1;
    	 while(s < e) {
    		int mid = s + (e-s)/2;
    		if(arr[mid] == key)  {
    			indx = mid;
    			break;
    		}else if (arr[mid] < key) s = mid+1;
    		else e = mid-1;
    	 }
    	 System.out.println("indx ="+indx);
    	 //find left
    	 int el = indx;
    	 s = 0;
    	 while(s < el) {
     		int mid = s + (el-s)/2;
     		if(arr[mid] == key)  {
     			el = mid;
     		}else s = mid+1;
     	 }
    	 System.out.println("el = "+el);
    	 range[0] = el;
    	 //find right
    	 
    	 int sr = indx;
    	 int er= arr.length-1;
    	 while(sr < er) {
     		int mid = sr + (er-sr)/2;
     		if(arr[mid] == key)  {
     			sr = mid+1;
     		}else er = mid-1;
     	 }
    	 System.out.println("start right = "+(sr-1));
    	 range[1] = sr-1;
    	 return range;
    	 
     }
    
     public static int searchInInfiniteSortedArray(int [] arr ,int key) {
    	  
    	 int l = 0;
    	 int h= 1;
    	 while(true) {
    		if(arr[h] != Integer.MAX_VALUE && key < arr[h] )
    		 break;
    		else if (arr[h] == Integer.MAX_VALUE ) {
    			h = l + (h-l)/2;
    		}
    		else if( key > arr[h]) {
    			l = h;
    			h = 2*h;
    		}else {
    			break;
    		}
    		
    	 }
    	 
    	 //search element key in  l ...h  sub-array..
    	 
   System.out.println("l ="+l +" h = "+h);
 		int s = l; 
 		int e = h;
 		
 		while(s <= e) {
 			int mid = s + (e-s)/2;
 			//System.out.println("mid = "+mid);
 			if(arr[mid] == key) return mid;
 			if(arr[mid] > key) e = mid-1;
 			else s = mid+1;
 		}
 		return -1;
    	 
     }
     
     /*
      * Problem: Minimum Difference Element
      * Description: Given an array of numbers sorted in ascending order,
      * find the element in the array that has the minimum difference with the given ‘key’.

		Example 1:
		
		Input: [4, 6, 10], key = 7
		Output: 6
		Explanation: The difference between the key '7' and '6' is minimum than any 
		other number in the array 
	 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f967aba1e473bb5b8d519
	 * 
	 * 
	 * solution: 
	 * 
	
	 * https://www.callicoder.com/minimum-difference-element-in-sorted-array/#alternate-solution-approach
       If you analyze the binary search algorithm carefully,
       then you will find that at the end of the loop, the start and end indices 
       point to the numbers that are closest to the target value being searched for.
       So essentially, at the end of the loop, the start index points to the ceiling 
       of the target and the end index points to the floor of the target value.
	 *   
     */
     public static int minimumDifferenceElement(int [] arr ,int key) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	   if(arr[mid] == key) return arr[mid];
    	   if(arr[mid] > key) e = mid-1;
    	   else s = mid+1;
    	 }
    	 System.out.println(" s "+s+" e "+e);
    	 int element = Math.abs(key- arr[s])> Math.abs(arr[e]-key) ? arr[e] : arr[s];
    	 return element;
     }
     /*
      * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f977fa24c2a2e65e84c02
      * Input: [1, 3, 8, 12, 4, 2] Output: 12
      * 
      * solution:
      * https://www.callicoder.com/maximum-element-in-bitonic-array/#:~:text=Binary%20Search%20to%20find%20the%20Maximum%20Element%20in%20a%20Bitonic%20Array&text=If%20the%20mid%20element%20is,the%20left%20side%20of%20mid%20.
      */
     public static int  bitonicArrayMaximum(int [] arr) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	  if( (mid == 0 || arr[mid] > arr[mid-1] ) &&  (mid == arr.length-1 || arr[mid] > arr[mid+1])) {
    	 //arr[mid] is greater than both the side element...
    		  return arr[mid];
    	  }
    	  else if (arr[mid] < arr[mid-1]) {
    		  //arr[mid] is smaller than previous element, max element lies in left sub-array.
    		  e = mid-1;
    	  }else {
    		  s = mid+1;// maximum lies in the right half.	
    	  }
     }
    	 return -1;
    }
     
     public static int  bitonicArraySearch(int [] arr, int target) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 int max_index=-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	  if( (mid == 0 || arr[mid] > arr[mid-1] ) &&  (mid == arr.length-1 || arr[mid] > arr[mid+1])) {
    	 //arr[mid] is greater than both the side element...
    		  //return arr[mid];
    		  max_index = mid;
    		  break;
    	  }
    	  else if (arr[mid] < arr[mid-1]) {
    		  //arr[mid] is smaller than previous element, max element lies in left sub-array.
    		  e = mid-1;
    	  }else {
    		  s = mid+1;// maximum lies in the right half.	
    	  }
     }
    	if( max_index !=0 || max_index != arr.length-1) { // max element exist somewhere between of the array elements..
    		if(target >= arr[0] && target <= arr[max_index] && target < arr[arr.length-1]) {//target exist in left of the bitonic index
    			s= 0;
    			e = max_index;
    			while(s <= e) {
    				int mid = s + (e-s)/2;
    				//System.out.println("mid = "+mid);
    				if(arr[mid] == target) return mid;
    				if(arr[mid] > target) e = mid-1;
    				else s = mid+1;
    			}
    			return -1;
    		}else {//the second half of the array is  shorted in reverse order..
    			s = max_index+1;
    			e = arr.length-1;
    			while(s <= e) {
    				int mid = s + (e-s)/2;
    				//System.out.println("mid = "+mid);
    				if(arr[mid] == target) return mid;
    				if(arr[mid] > target) s = mid+1;
    				else e = mid-1;
    			}
    			return -1;
    		}
    	}else if (max_index ==0  ) {
    		s = max_index;
			e = arr.length-1;
			while(s <= e) {
				int mid = s + (e-s)/2;
				//System.out.println("mid = "+mid);
				if(arr[mid] == target) return mid;
				if(arr[mid] > target) s = mid+1;
				else e = mid-1;
			}
    	}else {
    		s= 0;
			e = max_index;
			while(s <= e) {
				int mid = s + (e-s)/2;
				//System.out.println("mid = "+mid);
				if(arr[mid] == target) return mid;
				if(arr[mid] > target) e = mid-1;
				else s = mid+1;
			}
    	}
    	 return -1;
    }
     
    /*
     * Problem : Search in rotated sorted array..
     * https://www.callicoder.com/rotated-sorted-array-search/
     * Input: nums = [8, 11, 13, 15, 1, 4, 6], target = 1
	   Output: 4
     */
     public static int searchInRotatedSortedArray(int [] arr, int target) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	   if(arr[mid] == target) return mid;
    	    if( arr[s] <= arr[mid]) {//left array is sorted.
    		   if(target  >= arr[s] && target <= arr[mid] ) e = mid-1; //element exist between start and mid index.
    		   else  s = mid + 1;
    	   }else {// right sub-array is sorted..
    		   	if(target >= arr[mid] && target <= arr[e]) s = mid+1;
    		   	else e = mid-1;
    	   }
    	 }
    	 return -1;
     }
     
     /*
      * Find the Minimum element in a Rotated Sorted Array
      * https://www.callicoder.com/find-minimum-element-in-rotated-sorted-array/
      */
     public static int minInRotatedArray(int [] arr) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	   //if the middle ele.. is smaller than previous element.. than its a pivot(minimum)
    	   if( mid > 0 && arr[mid] < arr[mid-1]) return arr[mid];
    	   //if middle is greater than next than next is the pivot (minimum )
    	   if(mid  < arr.length-1  && arr[mid] > arr[mid+1]) {
    		   return arr[mid+1];
    	   }
    	   if(arr[s] <= arr[mid]) {//left sub-array is sorted,so pivot(min element ) is on the right side.
    		   s = mid+1;
    	   }else {//right array is sorted so pivot(min element ) is on the left side.
    		   e = mid-1;
    	   }
    	 }
    	 return -1;
     }
     
    /*
     * rotation count..
     * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a096ffba30a80b3d62a94c
     * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.

		You can assume that the array does not have any duplicates.
		
		Example 1:
		
		Input: [10, 15, 1, 3, 8]
		Output: 2
		Explanation: The array has been rotated 2 times.
		
     */
     
     public static int rotationCount(int [] arr) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	   //if the middle ele.. is smaller than previous element.. than its a pivot(minimum)
    	   if( mid > 0 && arr[mid] < arr[mid-1]) return mid;
    	   //if middle is greater than next than next is the pivot (minimum )
    	   if(mid  < arr.length-1  && arr[mid] > arr[mid+1]) {
    		   return mid+1;
    	   }
    	   if(arr[s] <= arr[mid]) {//left sub-array is sorted,so pivot(min element ) is on the right side.
    		   s = mid+1;
    	   }else {//right array is sorted so pivot(min element ) is on the left side.
    		   e = mid-1;
    	   }
    	 }
    	 return -1;
     }
     
     public static long power(int x , int n) {
    	 //base case : when the power is 0 the value becomes 1
    	 if( n == 0 )return 1l;
    	 if( (n & 1) == 1) {// n is odd
    		 return x*power(x,n/2)*power(x,n/2);
    	 }else {
    		 return power(x,n/2)*power(x,n/2);
    	 }
    		 
     }
     public static boolean isValidSquare(int x) {
    	 int e = x/2;
    	 int s = 1;
    	 while ( s < e) {
    		 int mid = s + (e-s)/2;
    		 int product = mid*mid;
    		 if(product == x) return true;
    		 if( product > x) e = mid-1;
    		 else s = mid+1;
    	 }
    	 
    	 return false;
     }
     //https://www.geeksforgeeks.org/search-almost-sorted-array/
     /*
      * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
		Output: 2 
		Explanation: Output is index of 40 in given array i.e. 2
		
		Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
		Output: -1
      */
     public static int searchInNearlyShortedArray(int [] arr ,int target) {
    	 int s = 0;
    	 int e = arr.length-1;
    	 while(s <= e) {
    	   int mid = s+ (e-s)/2;
    	   if (arr[mid] == target) return mid;
    	   else  if(mid-1 >=0 && arr[mid-1] == target) {
    		   return mid-1;
    	   }
    	   else if (mid+1 <= arr.length-1 && arr[mid+1] == target) {
    		   return  mid+1;
    	   }
    	   if( arr[mid] > target) e = mid-2;
    	   else s = mid+2;
    	   
    	 }
    	 return -1;
     }
     
     public static Node rearrange(Node odd)
     {
         if (odd == null || odd.next == null) return odd;
        
         Node  head1= null,head2 = null;
         Node tail1 = null,tail2 = null;
         Node temp = odd;
         int i = 1;
         while(temp != null) {
        	 Node t = temp;
        	 temp = temp.next;
        	 if(i%2 != 0) {
        		if(head1 == null) {
        			head1 = tail1 = t;
        		}
        		else tail1.next = t;
        		tail1 = t;
        	 }else {
        		 if( head2 == null) {
        			 t.next = null;
        			 head2  = t;
        		 }else {
        			 t.next = head2;
        			 head2= t;
        		 }
        	 }
        	 
        	i++; 
         }
         tail1.next = head2;
         return head1;
   
     }
}

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
    public String toString() {
    	return "[" +this.data+"]";
    }
}