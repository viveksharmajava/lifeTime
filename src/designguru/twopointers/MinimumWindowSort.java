package designguru.twopointers;
/*
 * https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */
import java.util.ArrayList;
import java.util.Collections;

public class MinimumWindowSort {

	public static void main(String[] args) {
	
		String s1 = "abc";
		 String s2 = new String("abc");
		 String s3 = "abc";
		 System.out.println(s1 == s2);
		 System.out.println(s1 == s3); 
		 
		 String s4 = "a"+(new String("bc"));
		 System.out.println(s1 == s4); 
		 System.out.println(s2 == s4); 
		 
	 int [] arr = {1, 3, 2, 0, -1, 7, 10};
	  ArrayList <Integer> list = new ArrayList<>();
	  list.add(1);
	  list.add(3);
	  list.add(2);
	  list.add(0);
	  list.add(-1);
	  list.add(7);
	  list.add(10);
	 System.out.println(minLength(list));
	 
	 unsortedCanddiate(arr);
	 
	 
	 
	 
	 StringBuffer sb1 = new StringBuffer("abc");
	 StringBuffer sb2 = new StringBuffer("abc");
	 if(sb1.equals(sb2)) {
		 System.out.println("Equal");
	 }else {
		 System.out.println("Not equal.");
	 }
	 
	}
	 
	// function performing calculation
	/* Approach 1: 
	   Idea/Intuition:
	   > make a temporary array of the same size, sort the elements & store 
	   to temp array.
	   > iterate both the arrays from start if you find unmatched store it s.
	   > iterate both the arrays from end if you find unmatched store it to e.
	   > e-s+1 , will be window size of unsorted array.
	 * Time Complexity : O(NLog(N)) , where N is the size of given array 
	   Space Complexity : O(N) , Space for temporary array temp .
	   
	   
	 */
    public static int minLength(ArrayList<Integer> arr) {
        // temporary array equal to given array
        ArrayList<Integer> temp = new ArrayList<Integer>(arr);
        // sorting the temporary array
        Collections.sort(temp);
        // initializing indices
        int s = 0, e = 0;
        // checking the unequal element from start and storing
        // it in s variable
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != temp.get(i)) {
                s = i;
                break;
            }
        }
        // checking the unequal element from end and storing it
        // in e variable
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) != temp.get(i)) {
                e = i;
                break;
            }
        }
        // returning minimum length
        return (e - s + 1);
    }
   
    /*
     * Approach 2:https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
       Idea/Intuition: 
       1. Find the candidate unsorted subarray:
          > scan from left to right and find the first element which is greater than
            next element and store the index to s.
          > scan from right to left and find the first element which is lesser than
            next element, store the index to e.
       2. Check if sorting the candidate sub-array ([s... e]) will make entire array sorted or not.
          If not then include more elements to the sub-array.
         a > find the minimum and maximum value in sub-array [s..e]. let minimum is min and max is maximum.
         b > find the first element if there is any in [0... s-1] which is greater than min.
            change s to the index of greater element in [0... s-1] .
         c > find the last element in the sub-array[e+1....n-1] which is lesser than the max.
            change e to the index of last lesser elements in sub-array[e+1....n-1] ..
            
       3. sub-array with  window size[s... e] is unsorted sub-array.
       
     */
    
    public static void unsortedCanddiate(int [] arr) {
    	
    	int s , e=arr.length-1;
    	int start = 0 ,  end = arr.length-1;
    	
    	for(s=0 ; s < e; s++) {
    		if(arr[s] > arr[s+1])break;
    	}
    	if(s == e) {
    		System.out.println("The complete array is sorted");
            return;
    	}
    	for(e = arr.length-1 ; e > 0 ; e--) {
    		if(arr[e] < arr[e-1]) break;
    	}
    	// step 2(a) of above algo
    	int max ,min;
    	max = min = arr[s];
    	for(int m = s+1; m <= e ; m++) {
    		if(arr[m]> max) max = arr[m];
    		if(arr[m] < min) min = arr[m];
    	}
    	
    	// step  2 b
    	for(int i = 0; i < s; i++) {
    		if(arr[i] > min) {
    			s = i;
    			break;
    		}
    	}
    	
    	// step 2 c
    	for(int i = arr.length-1 ; i > e ; i--) {
    		if ( arr[i] < max) {
    			e = i;
    			break;
    		}
    		
    	}
    	// step 3 of above algo
        System.out.println(" The unsorted subarray which"+
                           " makes the given array sorted lies"+
                         "  between the indices "+s+" and "+e);
        return;
    }
    
}
