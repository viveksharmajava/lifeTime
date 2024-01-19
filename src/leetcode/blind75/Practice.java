package leetcode.blind75;

import java.util.Arrays;

public class Practice {
	
	
	
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	      int len = nums1.length + nums2.length;
	      int mid = len/2;
	      boolean isEven = false;
	      if(len%2==0) isEven = true;
	      int c=0 , a= 0, b = 0;
	      double median=0.0;
	    //  Math.min(3, b);
	      while( c <= mid && (a < nums1.length && b < nums2.length)){
	          if( nums1[a] < nums2[b]){
	              if(isEven && c == mid-1) median += nums1[a];
	              else if( c == mid) median += nums1[a];
	              a++;
	              c++;
	          }else{
	              if(isEven && c == mid-1) median += nums2[b];
	              else if( c == mid) median += nums2[b];
	              b++;
	              c++; 
	          }
	      }
	     if( c <= mid){
	         if( a < nums1.length && b == nums2.length){
	             while(c <= mid && a < nums1.length){
	                if(isEven && c == mid-1) median += nums1[a];
	                else if( c == mid) median += nums1[a];
	                a++;
	                c++; 
	             }
	         }
	         else  if( b < nums2.length && a == nums1.length){
	             while(c <= mid && b < nums2.length){
	                if(isEven && c == mid-1) median += nums2[b];
	                else if( c == mid) median += nums2[b];
	                b++;
	                c++; 
	             }
	         }
	     }  
	     if(isEven) return median/2;
	     return median;
	        
	    }
	 
	  public static int maxArea(int[] height) {
	        
	        int max_so_far = 1;
	      
	        return max_so_far;
	    }
	public static void main(String[] args) {
		
		int [] height = {2,3,4,5,18,17,6};//{1,8,6,2,5,4,8,3,7};
		System.out.println("maxArea="+maxArea(height));
		int m1[] = {1,2};
		int m2[] = {3,4};
		double d  = findMedianSortedArrays(m1,m2);
		System.out.println(d);
		
		int [] array = {1,1,1,0,1,1,0,0,0,2,2,0,2,0,1,2,2};
		int start = 0 , mid=0, end = array.length-1;
		int pivot = 1;
		while(mid < end) {
			if(array[mid] < pivot) {
				swap(array, start , mid);
				mid++;
				start++;
			}
			else if ( array[mid] > pivot) {
				swap(array, mid , end);
				end--;
			}else {
				mid++;
			}
		}
		System.out.println(Arrays.toString(array));
		int X[] = { 1, 4, 7, 8, 10 };
		int Y[] = { 2, 3, 9 };
		int i = 0;
		int j = 0;
		int temp;
		while( i < X.length && j < Y.length) {
			if( X[i] > Y[j]) {
				temp = X[i];
				X[i]  = Y[j];
				Y[j] = temp;
				int k = j;
				while(k+1 < Y.length && Y[j] >  Y[k+1]) {
					temp = Y[k];
					Y[k] = Y[k+1];
					Y[k+1] = temp;
					k++;
				}
				
				
			}
			i++;
		}
		
		System.out.println("X "+Arrays.toString(X));
		System.out.println("Y "+Arrays.toString(Y));
	}
	// Utility function to swap elements `A[i]` and `A[j]` in the array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
