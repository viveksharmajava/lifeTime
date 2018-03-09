package sample.test.problems.array.rotation;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/array-rotation/
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
 * output  arr[] = [3, 4, 5, 6, 7, 1, 2]
 */
public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7,8};
		int arr2[] = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
		
		/*int [] output = rotatedArray(arr, 2);
		for(int i=0 ; i<arr.length ; i++){
			System.out.println(arr[i]);
		}
		rotatedArray2(arr ,3);
		*/
		
		//gcdRotation(arr,4);
		gcdRotation(arr2 ,3);
		for(int i=0 ; i<arr2.length ; i++){
			System.out.println(arr2[i]);
		}
	}
	
	//using a temp array
	public static int [] rotatedArray(int [] input , int d){
		int [] temp = new int[d];
		for(int i=0;i<d; i++){
			temp[i] = input[0];
		 for(int j=0 ; j< input.length-1 ; j++){
			 input [j] = input[j+1];
		 }
		 
		}
		 for(int i=d-1;i>=0; i--){
			 input[input.length-(d-i)] = temp[i];
		}
		return input;
	}
	
	//using 2 ArrayList 
		public static Object [] rotatedArray2(int [] input , int d){
			
			ArrayList <Integer> arr1 = new ArrayList<Integer>();
			ArrayList <Integer> arr2 = new ArrayList<Integer>();
			
			 for(int j=0 ; j< input.length ; j++){
				 if( j < d) arr1.add(input[j]);
				 else arr2.add(input[j]);
			 }
			 arr2.addAll(arr1);
			 System.out.println(arr2);
			return arr2.toArray();
		}
		
 //using juggling approach GCD ( Greatest Common divident)
		public static void gcdRotation(int [] input , int d){
			int gcd  = 1;
			for(int i = 1; i <= input.length && i <= d; ++i)
	        {
	            // Checks if i is factor of both integers
	            if(input.length % i==0 && d % i==0)
	                gcd = i;
	        }
			System.out.println("\nt gcd="+gcd);
			for(int i=0;i < gcd ; i++){
				int temp = input[i]; ;
				for(int j=i ; j < input.length ; j+=gcd){
				  input[j] = input[(j+gcd)%input.length];
				}
				input[input.length+i -gcd ] = temp;
			}
			
		}

}
