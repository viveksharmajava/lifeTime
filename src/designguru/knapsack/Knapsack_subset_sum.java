package designguru.knapsack;

import java.util.Collections;

public class Knapsack_subset_sum {

	public static void main(String[] args) {
        int [] arr = {1, 3, 4, 8}; int S=12;
       // System.out.println("subset_sum ="+subset_sum(arr,S));
        System.out.println(" subsetsum ="+subsetsum(arr,S,arr.length-1));
        
        int [] arr1 = { 5,3,9,7,2 , 1,6 }; //sum = 33
        
        double sum =(double) 33/2;
        System.out.println(sum);
       double d =  min_subset(arr1,sum,6);
       System.out.println("minimum_subsetsum "+(d*2));
	}

	//not working...
	public static boolean subset_sum(int []arr , int W) {
		boolean [][] t = new boolean[arr.length+1][W+1];
		for(int j=0; j < t[0].length; j++) {
			t[0][j] = false;
		}
		for(int i=0; i < t.length; i++) {
			t[i][0] = true;
		}
		
		//System.out.println(t[3][3]);
		 for(int i=1; i <= arr.length; i++) {
			 for(int j= 1; j <= W; j++) {
				 if(arr[i-1] <= j) {
					 t[i][j] = t[i][j-arr[i-1]] || t[i-1][j];
				 }else {
					 t[i][j] =t[i-1][j];
				 }
			 }
		 }	 
		 return t[arr.length][W];
		
	}
	
	public static boolean subsetsum(int []arr , int W,int n) {
		if( W == 0 ) return true;
		if( n < 0) return false;
		if( arr[n] <= W) {
		 return subsetsum(arr, W-arr[n],n-1) || 
		subsetsum(arr, W,n-1);
		}else {
			return subsetsum(arr, W,n-1);
		}
	}
	
	public static double min_subset(int [] arr , double W , int n) {
		if  ( n == 0 || W  == 0 ) return W;
		       
		  double include =    min_subset(arr , W- arr[n] , n-1);
		  double exclude =  min_subset(arr , W , n-1);
		  return Math.min ( Math.abs(include) , Math.abs(exclude));
	}
}
