package designguru.twopointers;

import java.util.Arrays;
import java.util.Comparator;

public class QuadrupleSum {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 1, 2 };
	    int X = 91;
	 
	    // Function call
	    quadrupleSum(arr, X);
	}
	
	public  static void quadrupleSum(int [] arr,int sum) {
		
		int i , j ;
		int len = arr.length;
		int size  = (len*(len-1))/2;
		
		PairSum [ ] pairs = new PairSum[size];
		int k = 0;
		for( i = 0 ; i < len-1; i++) {
			for( j = i+1; j < len ; j++) {
				 pairs[k++] = new PairSum(arr[i],arr[j]);
			}
		}
		//sort the pairsum array
		
		Arrays.parallelSort(pairs, new Comparator<PairSum>() {
			
			public int compare(PairSum pair1, PairSum pair2) {
				return (pair1.sum - pair2.sum);
			}
		});
		
		i = 0;
		j = size-1;
		while(i < j) {
			if(sum == (pairs[i].sum+pairs[j].sum)) {
				if(noCommon(pairs[i], pairs[j])) {
					System.out.println(pairs[i].first+" "
				    +pairs[i].second+" "+pairs[j].first+" "
				    +pairs[j].second
				    
				    
				);
				return;	
				}
			}//eo_fi
			else if(sum > (pairs[i].sum+pairs[j].sum)) {
				i++;
			}else {
				j--;	
			}
			
		}
	}
	// Function to check if two given pairs
	  // have any common element or not
	  static boolean noCommon(PairSum a, PairSum b)
	  {
	    if (a.first == b.first || a.first == b.second
	        || a.second == b.first || a.second == b.second)
	      return false;
	 
	    return true;
	  }
	
}

class PairSum{
	int sum;
	int first,second;
	PairSum(int i , int j){
		this.first = i;
		this.second = j;
		this.sum = i+j;
	}
	
	
	
}