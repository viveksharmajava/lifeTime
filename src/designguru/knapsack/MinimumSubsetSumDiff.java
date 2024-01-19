package designguru.knapsack;

public class MinimumSubsetSumDiff {

	public static void main(String[] args) {
		 int [] arr1 = { 5,3,9,7,2 , 1,6 }; //sum = 33
	        
	        double sum =(double) 33/2;
	        System.out.println(sum);
	       double d =  min_subset(arr1,sum,6);
	       System.out.println("minimum_subsetsum "+(d*2));
	       int [] arr2 = { 5,3,9,7,2 , 0,6 };
	       d =  min_subset(arr2,16,6);
	       System.out.println("minimum_subsetsum "+(d*2));

	}
	public static double min_subset(int [] arr , double W , int n) {
		if  ( n == 0 || W  == 0 ) return W;
		       
		  double include =    min_subset(arr , W- arr[n] , n-1);
		  double exclude =  min_subset(arr , W , n-1);
		  return Math.min ( Math.abs(include) , Math.abs(exclude));
	}
}
