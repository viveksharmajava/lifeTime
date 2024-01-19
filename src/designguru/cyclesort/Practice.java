package designguru.cyclesort;

import java.util.Arrays;
import java.util.HashSet;

public class Practice {

	public static void main(String[] args) {
		System.out.println("\n findMissingNumber \n ");
		int [] arr = { 2,2};
		findMissingNumber(arr);
		int [] arr5 = {1, 2, 4};
		findMissingNumber(arr5);
		 
		 int [] arr6 = {2, 3, 1, 8, 2, 3, 5, 1};
		 findMissingNumber(arr6);
		 int [ ] arr7 = {1, 4, 4, 3, 2};
		 findMissingNumber(arr7);
		 int [] array = {-3, 1, 5, 4, 2};
		 System.out.println("first missingPositiveNumber \n");
		 System.out.println(firstMisstingNumber(array));
		 int [ ] array2 = {3, -1, 4, 5, 5 };
		 System.out.println(" FirstK_Missing_Positiv_Numbers \n");
		 FirstK_Missing_Positiv_Numbers(array2,3);
		 int [ ] array3 = {-2,-3,4 };
		 System.out.println(" FirstK_Missing_Positiv_Numbers \n");
		 FirstK_Missing_Positiv_Numbers(array3,2);
		 
		 int [ ] array4 = {2,3,4 };
		 System.out.println(" FirstK_Missing_Positiv_Numbers \n");
		 FirstK_Missing_Positiv_Numbers(array4,3);
	}
	
	public static  void findMissingNumber(int [] arr) {
		int pos = 0;	
		while(pos < arr.length) {
			if(arr[pos] < arr.length && arr[pos] != arr[arr[pos]-1]) {
				swap(arr , pos ,arr[pos]-1);
			}else {
				pos++;
			}
		}
		
		System.out.println("Arrays after sorting ="+Arrays.toString(arr));
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] != i+1) {
			  System.out.println("\n The missing number is "+(i+1));
			  System.out.println("\n The repeating  number is "+arr[i]);
			  
			}
		}
		}
	
	 public static int firstMisstingNumber(int [] arr) {
		 //1. convert  < 0 and > n to n+1
		 int n = arr.length;
		 for(int i = 0 ; i < n ; i++) {
			 if(arr[i] <= 0 || arr[i] > n) arr[i] = n+1;
			 
		 }
		 
		 // 2. replace number with their index *(-1) since all numbers are in range 1... N+1
		 for(int i = 0 ; i < n ; i++) {
			int num = Math.abs(arr[i]);
			 if(num> n) continue;
			 num = num-1;
			 if(arr[num] > 0 )   arr[num] = arr[num] * (-1);
		 }
		 // 3. traverse the array to find the first positive  missing 
		 for(int i = 0 ; i < n ; i++) {
			 if(arr[i] > 0 ) return i+1;
		 }
		 // 4. when all numbers are present.
		 return n+1;
	 }
	 public static void  FirstK_Missing_Positiv_Numbers(int [] arr , int k){
		 HashSet <Integer> set = new HashSet<>();
		 for(int i=0; i < arr.length; i++) {
			 if(arr[i]>0) set.add(arr[i]);
		 }
		 
		 int f =0;
		 for(int i=0; i < arr.length+k; i++) {
			 if(!set.contains(i+1)) {
				 f++;
				 System.out.println(i+1);
				 if(f == k) return;
			 }
		 
		 } 
	 }
	 private static void swap(int [] arr , int i, int j) {
		 int temp = arr[i];
		 arr[i] = arr[j];
		 arr[j] = temp;
	 }
	 
}
