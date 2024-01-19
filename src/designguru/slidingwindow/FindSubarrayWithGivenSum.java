package designguru.slidingwindow;

import java.util.Arrays;

public class FindSubarrayWithGivenSum {

	public static void main(String[] args) {
    int [] arr = {1, 4};
    int target = 1;
    subArrayWithGivenSum(arr,target);
	}
	
	public static void subArrayWithGivenSum(int [] arr, int target) {
		
		int sum_so_far = 0;
		int start = 0;
		int end = -1;
		for(int i = 0 ; i < arr.length ; i++) {
			sum_so_far += arr[i];
			if( sum_so_far  == target) {
				end = i;
				break;
			}
			else if(sum_so_far  > target) {
				int temp = sum_so_far, k = start;
				while( temp != target &&  k < i) {
					temp -= arr[k];
					k++;
				}
				if(temp == target) {
					start = k;
					end = i;
					break;
				}else {
					start = i;
					end = -1;
					sum_so_far = arr[i];
				}
			}
		}
		if(end !=-1) {
			System.out.println("Subaray "+Arrays.toString(Arrays.copyOfRange(arr, start, end+1)));
		}
		else {
			System.out.println("target does not exist");
		}
	}

}
