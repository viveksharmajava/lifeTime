package leetcode.blind75;

import java.util.Arrays;

public class Problem_3_ProductOfArrayExceptSelf {

	public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(Arrays.toString(arrayProduct(arr)));
	}
	
	public static int[] arrayProduct(int [] arr){
		int len = arr.length;
		int []left = new int[len];
		int [ ] right = new int[len];
		left[0] = 1;
		right[len-1] =1;
		for(int i = 1; i < len; i++){
			left[i] = left[i-1] * arr[i-1];
		}
		for(int i = len-2; i >=0; i--){
			right[i] = right[i+1] *  arr[i+1];
			
		}
		
		for(int i = 0 ; i < len ; i++){
			arr[i] = left[i]*right[i];
		}
		return arr;
		
		
	}

}
