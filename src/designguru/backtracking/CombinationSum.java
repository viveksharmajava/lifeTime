package designguru.backtracking;

import java.util.*;

/*
 * Problem: Given an array of distinct positive integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * Input: candidates = [2, 3, 6, 7], target = 7  
	Output: [[2, 2, 3], [7]]  
    Explanation: The elements in these two combinations sum up to 7.
    https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63d58068c98b37360a523ad4
 */
public class CombinationSum {

	public static void main(String[] args) {
		// Test case 1
	    int[] candidates = { 2, 3, 6, 7 };
	    int target = 7;
	    System.out.println(combinations(candidates, target)); // expected output: [[2, 2, 3], [7]]

	}
   
	@Override
	public boolean equals(Object o){
		return true;
	}
	public static List < List<Integer>> combinations(int [] candidates , int target){
		List < List<Integer>> res = new ArrayList <>();
		backtrack(candidates , 0 , target ,new ArrayList <Integer>(), res);
		return res;
		
		
	}

	private static void backtrack(int[] candidates, int start, int target,ArrayList <Integer> comb,  List<List<Integer>> res) {
     //base case , if target becomes 0 then return the response.
		if(target == 0) {
			res.add(new ArrayList(comb));
			return;
		}
		//iterate through candidate array starting from  given index..
		for(int i = start; i < candidates.length; i++) {
			//if the current candidate is greater than the remaining target move on to next.
			if(target < candidates[i]) continue;
			comb.add(candidates[i]);
			backtrack(candidates,i , target- candidates[i],comb, res);
			comb.remove(comb.size()-1);
		}
	}
}

