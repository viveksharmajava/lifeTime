package designguru.knapsack;

import java.util.Arrays;

/*
 * Problem : https://www.techiedelight.com/0-1-knapsack-problem/
 * Solution : https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
 * value = [ 20, 5, 10, 40, 15, 25 ]
 * weight = [ 1, 2, 3, 8, 7, 4 ]
 * int W = 10 
 * Output: Knapsack value is 60 
 * value = 20 + 40 = 60
 * weight = 1 + 8 = 9 < W
 */
public class _0_1_Knapsack_Memoization {

	public static void main(String[] args) {
		 int [] val = { 20, 5, 10, 40, 15, 25};
	     int [] weight  = {1, 2, 3, 8, 7, 4 };
	     int W = 10;
	     int len = val.length-1;
	     int [][] memoize = new int [val.length+1][W+1];
	     for(int i=0 ;i <memoize.length; i++ ) {
	    	 for(int j=0 ;j < memoize[0].length; j++ ) {
		    	 memoize[i][j] = -1;
		     }
	     }
	     //Arrays.fill(memoize, -1);
	    System.out.println("Knapsack value is  "+knapsackMemoization(val,weight,W,len,memoize));	     
	}
	public static int knapsackMemoization(int [] val, int [] w, int W , int n ,int [][] memoization) {
		if( W == 0 || n < 0) return 0;
		if(memoization[n][W] !=-1) return memoization[n][W];
		if( w[n] <= W) {
		int include = val[n] + knapsackMemoization(val,w, W-w[n],n-1,memoization);
		int exlcude = knapsackMemoization(val,w, W,n-1,memoization);
		return  memoization[n][W] = Math.max(include, exlcude);
		}else {
			return memoization[n][W] = knapsackMemoization(val,w, W,n-1,memoization);
		}
	}
}
