package ds500problems.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 https://www.techiedelight.com/0-1-knapsack-problem/
 In the 0–1 Knapsack problem, we are given a set of items,
 each with a weight and a value, and we need to determine the number
 of each item to include in a collection 
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
// 
//        System.out.println("Knapsack value is " +
//        		knasackRecursion(v, w, v.length - 1, W));
//       
     // create a map to store solutions to a subproblem
       
        
//        System.out.println("Knapsack  value is " +
//        		knapsack(v, w, v.length - 1, W,lookup));
//	
        int val[] = {360, 83, 59, 130, 431, 67, 230, 52, 93, 125, 670, 892, 600, 38, 48, 147,
                78, 256, 63, 17, 120, 164, 432, 35, 92, 110, 22, 42, 50, 323, 514, 28, 87, 73, 78, 15, 26,
                78, 210, 36, 85, 189, 274, 43, 33, 10, 19, 389, 276, 312};
        int wt[] = {7, 0, 30, 22, 80, 94, 11, 81, 70, 64, 59, 18, 0, 36, 3, 8, 15, 42, 9,
                0, 42, 47, 52, 32, 26, 48, 55, 6, 29, 84, 2, 4, 18, 56, 7, 29, 93, 44, 71, 3, 86, 66, 31,
                65, 0, 79, 20, 65, 52, 13};
        int WS = 850;
        int n = val.length;
        for(int i = 0 ; i< 20 ; i++) {
         Map<String, Integer> lookup = new HashMap<>();
        System.out.println(
        		knapsack(val, wt, val.length - 1, 850,lookup));
//        System.out.println("knasackRecursion value is " +       		knasackRecursion(val, wt, val.length - 1, 850));
        SortedSet <Integer> indexes = new TreeSet();
        printknapSack(WS, wt, val, n,indexes);
        }
        //System.out.println("items included=\n"+indexes);
	//[0, 1, 3, 4, 6, 10, 11, 12, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 29, 30, 31, 32, 34, 38, 39, 41, 42, 44, 47, 48, 49]
    //[0, 1, 3, 4, 6, 10, 11, 12, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 29, 30, 31, 32, 34, 38, 39, 41, 42, 44, 47, 48, 49]
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
	
	
	// A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
    // Prints the items which are put
    // in a knapsack of capacity W
    static void printknapSack(int W, int wt[],
                             int val[], int n,SortedSet<Integer> index)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
 
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] +
                              K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
 
        // stores the result of Knapsack
        int res = K[n][W];
       System.out.println(res);
 
        w = W;
        for (i = n; i > 0 && res > 0; i--) {
 
            // either the result comes from the top
            // (K[i-1][w]) or from (val[i-1] + K[i-1]
            // [w-wt[i-1]]) as in Knapsack table. If
            // it comes from the latter one/ it means
            // the item is included.
            if (res == K[i - 1][w])
                continue;
            else {
 
                // This item is included.
            //    System.out.print(wt[i - 1] + " ");
                index.add(i-1);
                // Since this weight is included its
                // value is deducted
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }
    }
}
