package ds500problems.dp;

import java.util.HashMap;
import java.util.Map;

/*
 https://www.techiedelight.com/0-1-knapsack-problem/
 In the 0–1 Knapsack problem, we are given a set of items,
 each with a weight and a value, and we need to determine the number of each item to include in a collection 
 so that the total weight is less than or equal to a given limit 
 and the total value is as large as possible.
 Input:
 
	value = [ 20, 5, 10, 40, 15, 25 ]
	weight = [ 1, 2, 3, 8, 7, 4 ]
	int W = 10
	 
	Output: Knapsack value is 60
	 
	value = 20 + 40 = 60
	weight = 1 + 8 = 9 < W


*/	 

public class Knapsack0_1Problem {

	public static void main(String[] args) {
		// input: a set of items, each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = { 1, 2, 3, 8, 7, 4 };
 
        // knapsack capacity
        int W = 10;
 
        System.out.println("Knapsack value is " +
        		knasackRecursion(v, w, v.length - 1, W));
       
     // create a map to store solutions to a subproblem
        Map<String, Integer> lookup = new HashMap<>();
 
        System.out.println("Knapsack  value is " +
        		knapsack(v, w, v.length - 1, W,lookup));
	}
  
 //Solution 1
/*
 *  use recursion
 *  1. Include the current item in the knapsack and recur for 
 *     remaining items with knapsack’s decreased capacity. 
 *     If the capacity becomes negative, do not recur or return.
 *  2. Exclude the current item from the knapsack and recur for the remaining items.
 *  3. Finally return the maximum of include/exclude.    
 */
	
	// Values (stored in array `values`)
    // Weights (stored in array `weight`)
    // Total number of distinct items `n`
    // Knapsack capacity `W`
	
public static int knasackRecursion(int [] values , int [] weight, int n , int W) {
	// base case: Negative capacity
	    if (W < 0) {
	        return Integer.MIN_VALUE;
	    }
	
	    // base case: no items left or capacity becomes 0
	    if (n < 0 || W == 0) {
	        return 0;
	    }
	 // Case 1. Include current item `values[n]` in the knapsack and recur for
      // remaining items `n-1` with decreased capacity `W-weight[n]`
 
	    int include = values[n] + knasackRecursion(values, weight, n-1, W-weight[n]);
	  //case 2. exclude current item 'values[n] in the knapsack and recur for the remaining item.
	    int exclude = knasackRecursion(values, weight,n-1,W);
	    return Integer.max(include, exclude);
}
	//Solution 2 Using memorization top down approach
	// also called DP problem.
	//Values (stored in array `v`)
	// Weights (stored in array `w`)
	// Total number of distinct items `n`
	// Knapsack capacity `W`
	//Time complexity O(n.w) and space complexity is also same.
	
	public static int knapsack(int[] v, int[] w, int n, int W,
	        Map<String, Integer> lookup)
	{
	// base case: Negative capacity
	if (W < 0) {
	return Integer.MIN_VALUE;
	}
	
	// base case: no items left or capacity becomes 0
	if (n < 0 || W == 0) {
	return 0;
	}
	
	// construct a unique map key from dynamic elements of the input
	String key = n + "|" + W;
	
	// if the subproblem is seen for the first time, solve it and
	// store its result in a map
	if (!lookup.containsKey(key))
	{
	// Case 1. Include current item `n` in knapsack (v[n]) and recur
	// for remaining items `n-1` with decreased capacity `W-w[n]`
	int include = v[n] + knapsack(v, w, n - 1, W - w[n], lookup);
	
	// Case 2. Exclude current item `v[n]` from the knapsack and recur for
	// remaining items `n-1`
	int exclude = knapsack(v, w, n - 1, W, lookup);
	
	// assign the max value we get by including or excluding the current item
	lookup.put(key, Integer.max(include, exclude));
	}
	
	// return solution to the current subproblem
	return lookup.get(key);
	}
}
