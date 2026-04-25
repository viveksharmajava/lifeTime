package ds500problems.sortingsearching;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
     int [] arr = {1, 1, 2, 2, 4, 4, 10, 10, 10};
     sort(arr,10);
     System.out.println("After count sort ="+Arrays.toString(arr));
	}
      public static void sort(int [] arr,int k) {
    	  int [] count = new int[k+1];
    	  for(int n : arr) {
    		  count[n]++;
    	  }
    	  int m  = 0;
    	  for(int i=0; i < count.length;i++) {
    		  if(count[i] !=0) {
    			  int temp = count[i];
    			  while(temp-- > 0) {
    				  arr[m++] = i;
    			  }
    		  }
    	  }
      }
}
