package designguru.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638f6ff2ae53511bdc36490d
 *  Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
	
	Example 1:
	
	Input: [-3, 0, 1, 2, -1, 1, -2]
	Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
	Explanation: There are four unique triplets whose sum is equal to zero. smallest sum.'
	Example 2:
	
	Input: [-5, 2, -1, -2, 3]
	Output: [[-5, 2, 3], [-2, -1, 3]]
	Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

	public static void main(String[] args) {
    
		int [] arr = {-3, 0, 1, 2, -1, 1, -2} ;
		//triplet0Sum(arr);
		System.out.println("searchTriplets ="+searchTriplets(arr));//best solution
		int [] arr2 = {2, 7, 4, 0, 9, 5, 1, 3};
	//	System.out.println("tripletUsingKnapsackAlgo ="+tripletUsingKnapsackAlgo(arr2,arr2.length, 6, 0));
	}

	public static List<List<Integer>> searchTriplets(int [] arr){
		 List<List<Integer>> triplets = new ArrayList<>();
		 Arrays.sort(arr);
		 
		 for(int i =0 ; i < arr.length-2; i++){
			 if(i > 0 && arr[i] == arr[i-1])continue;
			 searchPair(arr,-arr[i],i+1 , triplets);
		 }
		 return triplets;
		
	}
	private static void searchPair(int[] arr, int target, int left,
			List<List<Integer>> triplets) {
		
		   int right = arr.length-1;
		   while(left < right){
			   int sum = arr[left] +arr[right];
			   if(target == sum){
				   triplets.add(Arrays.asList(-target , arr[left],arr[right]));
				   left++;
				   right--;
				   while(left < right && arr[left] == arr[left-1]) {
					   left++;//skip same element to avoid duplicate triplet
				   }
				   while(left < right && arr[right]== arr[right+1]){
					   right--;//skip same element to avoid duplicate triplet
				   }
			   }
			   else if( sum > target){
				   right--;
			   }else{
				   left++;
			   }
			  
		   }
	}

	public static void triplet0Sum(int [] arr) {
		
		//Arrays.parallelSort(arr);
		HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < arr.length;i++) {
			
			if(hm.containsKey(arr[i])) {
				hm.get(arr[i]).add(i);
			}
			
			else{
				ArrayList <Integer> values = new ArrayList <Integer>();
				values.add(i);
				hm.put(arr[i], values);
			}
		}
		
		HashSet < Pair> tripletSet = new HashSet <Pair>();
		
		for(int i = 0; i < arr.length-1;i++) {
			for(int j=i+1; j < arr.length; j ++) {
				if(hm.containsKey(-(arr[i]+arr[j]))){
					for(int index : hm.get(-(arr[i]+arr[j]))) {
						if( i != index  && j != index) {
							tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
							//System.out.println("Triplet is ["+i+","+index+","+j+"]");
						}
					}
				}
			}
		}
		
	//	System.out.println("tripletSet ="+tripletSet);
	}
	
	 // Naive recursive function to check if triplet exists in an array
    // with the given sum
	//https://www.techiedelight.com/find-triplet-given-with-given-sum/
	public static boolean tripletUsingKnapsackAlgo(int [] arr, int n , int target, int count) {
		
		if ( count == 3 || target == 0) return true;
		if( count == 3 || n == 0 || target < 0) return false;
		// recur with including and excluding the current element
		 return tripletUsingKnapsackAlgo(arr, n-1, target-arr[n-1],count+1) || 
				tripletUsingKnapsackAlgo(arr , n-1, target , count);
	}
}

class Pair{
	int [] indexes = new int [3] ;
	
	Pair(int i , int j , int k){
		indexes[0]= i;
		indexes[1] = j;
		indexes[2] = k;
		Arrays.parallelSort(indexes);
		System.out.println(Arrays.toString(indexes));
	}
	@Override
	public boolean equals(Object  o) {
		if(!(o instanceof Pair) ) return false;
		Pair ob = (Pair)o;
		if( this.indexes[0] == ob.indexes[0] && this.indexes[1]== ob.indexes[1] 
			&& this.indexes[2] == ob.indexes[2]) return true;
		return false;
		
	}
	@Override
	public int hashCode() {
		//String s = ""+indexes[0]+""+indexes[1]+""+indexes[2];
		//return s.hashCode();
		return 100;
	}
	
	public String toString() {
		return "["+indexes[0]+","+indexes[1]+","+indexes[2]+"]";
	}
	
}
