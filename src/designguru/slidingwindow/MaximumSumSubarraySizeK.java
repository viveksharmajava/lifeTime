package designguru.slidingwindow;


public class MaximumSumSubarraySizeK {

	public static void main(String[] args) {
		int k = 2;
		int [] arr = {2, 3, 4, 1, 5};
		maxSumSubArray(arr,k);
	}
	
	public static void maxSumSubArray(int [] arr , int k) {
		
		if (arr.length < k) return;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0 ; i < k ; i++) {
			sum += arr[i];
		}
		max = sum;
		int m, n;
		m = 0 ; n= k-1;
		for(int i = k ; i < arr.length ; i++) {
			sum = sum + arr[i] - arr[i-k];
			if(sum > max) {
				max = sum;
				m = i-k+1;
				n= i;
			}
		}
	   System.out.println("Max sum ="+max +" sub array at  ="+m+" .... "+n); ;
	}

}
