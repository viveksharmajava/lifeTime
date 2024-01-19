package designguru.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

/*
 * Triplet Sum Close to Target 
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638f7323ae53511bdc364dab
 * Input: [-1, 0, 2, 3], target=3 
 *  Output: 2
 * Explanation: There are two triplets whose sum is less than the target:
 * [-1, 0, 3], [-1, 0, 2] 0, 0, 1, 1, 2, 6 : 5 
 */
public class TripletNearToTarget {

	public static void main(String[] args) {
     
		int [] arr = {2,2,2};
		System.out.println("hello"+triplet2Pointers(arr,6));
	    //System.out.println(findTripletWithSumNearToTarget(arr,6));
		System.out.println("triplet2Pointersdsfd ="+triplet2Pointers(arr,6));
		//System.out.println(tripletUsingKnapsackAlgo(arr,arr.length,0,0,100));
	}
	
	public static int  findTripletWithSumNearToTarget(int []arr, int target) {
		
		//Arrays.parallelSort(arr);
		TreeMap<Integer, List<Integer>> hm = new TreeMap<Integer, List<Integer>>();
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
				int diff =  target-(arr[i]+arr[j]);
				if(hm.containsKey(diff)){
					for(int index : hm.get(diff)) {
						if( i != index  && j != index) {
							tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
							//System.out.println("Triplet is ["+i+","+index+","+j+"]");
						}
					}
				}else {
					Integer ceil = hm.ceilingKey(diff);
					Integer floor = hm.floorKey(diff);
					if(ceil == null && floor == null) continue;
					else if(ceil == null && floor != null) {

						for(int index : hm.get(floor)) {
							if( i != index  && j != index) {
								tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
								//System.out.println("Triplet is ["+i+","+index+","+j+"]");
							}
						}
					
					}
					else if(ceil != null && floor == null) {
						for(int index : hm.get(ceil)) {
							if( i != index  && j != index) {
								tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
								//System.out.println("Triplet is ["+i+","+index+","+j+"]");
							}
						}
					}
					else {
						for(int index : hm.get(ceil)) {
							if( i != index  && j != index) {
								tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
								//System.out.println("Triplet is ["+i+","+index+","+j+"]");
							}
						}
						for(int index : hm.get(floor)) {
							if( i != index  && j != index) {
								tripletSet.add(new Pair(arr[i],arr[j],arr[index]));
								//System.out.println("Triplet is ["+i+","+index+","+j+"]");
						}
					}
					
				}
			}
		}
		}
		int min = Integer.MAX_VALUE ;
		int val = Integer.MAX_VALUE;
		for(Pair  p : tripletSet) {
			int s = p.indexes[0] +  p.indexes[1] +  p.indexes[2];
			// s = Math.abs(target - s);
			if( min >  Math.abs(target - s) ) {
				val = s;
				min = Math.abs(target - s);
			}
		}
		System.out.println("tripletSet ="+tripletSet);
		return val;
	}
public static int tripletUsingKnapsackAlgo(int [] arr, int n , int sum, int count,int target) {
		
		if ( count == 3 || n == 0 ) return sum;
		// recur with including and excluding the current element
		 return Math.min(Math.abs(target- tripletUsingKnapsackAlgo(arr, n-1, sum+arr[n-1],count+1,target)) ,
				Math.abs(target-tripletUsingKnapsackAlgo(arr , n-1, sum , count,target)));
	}
//ragu's
public static int triplet2Pointers(int []arr, int targetSum) {int max = Integer.MIN_VALUE;
int n = arr.length;
Arrays.parallelSort(arr);
for(int i=0;i<=n-3;i++) {
	int start=i+1;
	int end = n-1;
	
	while(start<end) {
		int curSum = arr[i]+arr[start]+arr[end];
		if(curSum==targetSum) {
			return targetSum;
		}
		if(curSum<targetSum) {
			if(curSum>max) {
				max=curSum;
			}
			start++;
		} else {
			end --;
		}
		
	}
}
return max;
}
}
