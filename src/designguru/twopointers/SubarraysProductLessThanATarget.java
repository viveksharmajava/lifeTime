package designguru.twopointers;

import java.util.Arrays;

public class SubarraysProductLessThanATarget {

	public static void main(String[] args) {
      int [] arr = { 2, 5, 3, 10};
      subArrayProduct(arr,30);
      System.out.println();
	}
	
	public static void subArrayProduct(int []arr , int target) {
		
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] < target) {
				System.out.println(arr[i]);
				int product = arr[i];
				int j = i+1;
				while(j < arr.length ) {
					product *=arr[j];
					if(product < target) {
					  System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j+1)));
					  j++;
					}else {
						break;
					}
				}
			}else {
				break;
			}
		}
	}

}
