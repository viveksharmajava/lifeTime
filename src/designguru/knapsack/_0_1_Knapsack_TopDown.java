package designguru.knapsack;

import java.util.Arrays;

public class _0_1_Knapsack_TopDown {

	public static void main(String[] args) {
        
		 int [] val = { 20, 5, 10, 40, 15, 25};
	     int [] weight  = {1, 2, 3, 8, 7, 4 };
	     int W = 10;
	    System.out.println("Knapsack_topdown value is  "+knapsackMemoization(val,weight,W));	     
	
	}
	public static int knapsackMemoization(int [] val, int [] w, int W ) {
		 int [][] t = new int [val.length+1][W+1]; //since array by default is initialized with 0
		 for(int i=1; i <= val.length; i++) {
			 for(int j= 1; j <= W; j++) {
				 if(w[i-1] <= j) {
					t[i][j]  = Math.max(val[i-1]+ t[i-1][j-w[i-1]], t[i-1][j]);
				 }else {
					 t[i][j]  =  t[i-1][j];
				 }
			 }
		 }
		 return t[val.length][W];
		
	}
}
