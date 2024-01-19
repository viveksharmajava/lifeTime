package designguru.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		int []arr = {1, 2, 3, 4, 6};
		printPairWithGivenSum(arr,6);
		int []arr2 = {2, 5, 9, 11};
		printPairWithGivenSum(arr2,11);
		
		int [] square = {-2, -1, 0, 2, 3};
		System.out.println(Arrays.toString(makeSquares(square)));
	}
	
	public static void printPairWithGivenSum(int[] arr, int sum){
		int s = 0 , e = arr.length-1;
		while(s < e) {
			int p = arr[s] + arr[e];
			if(p == sum) {
				System.out.println("pair ="+arr[s]+", "+arr[e]);
				s++;
				e--;
			}
			if( p > sum) e--;
			else s++;
		}
	}
	public static int[] makeSquares(int[] arr) {
	    int n = arr.length;
	    int[] squares = new int[n];
	    // TODO: Write your code here
	    int s = 0;
	    int e = n-1;
	    int j = n-1;
	    while(s < e && j >=0 ){
	      if(arr[s] * arr[s]  > arr[e] *arr[e] ){
	        squares[j] = arr[s] * arr[s];
	        s++;
	      }else{
	        squares[j] = arr[e] * arr[e];
	        e--;
	      }
	      j--;
	    }
	    return squares;
	  }
	
	public static  void triplet0Sum(int [] arr) {
		Set < Pair>  triplet = new HashSet <Pair>();
		HashMap <Integer, LinkedList<Integer>> map = new HashMap  <Integer, LinkedList<Integer>>();
		
		
	}

}


