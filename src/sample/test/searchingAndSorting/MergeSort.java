package sample.test.searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	public static void main(String[] args)  throws IOException{

		/*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=in.readLine()) != null){
			
		}*/
		
		int [] arr1 = {2,34,60};
		int [] arr2 = {5,6,9 ,10 ,12};
		int [] output  = mergeSort(arr1, arr2);
		int [] array = new int [4];
		array[0] = 5;
		System.out.println("size="+array.length);
		for(int i=0; i<output.length; i++){
			
			System.out.println(output[i]);
		}
	}
	
	public static int [] mergeSort(int []array1 ,int []array2) {
		
		int l1 = array1.length;
		int l2= array2.length;
		int []outputArr =  new int[l1+l2];
		int i=0;
		int j=0;
		int k=0;
		while( i<l1 && j < l2){
			
		   if(array1[i] <= array2[j]){
			   outputArr[k++] = array1[i++]; 
		   }else{
			   outputArr[k++] = array2[j++];
		   }
		  
		}
		if( i < l1){
			while( i<l1){
				
					   outputArr[k] = array1[i]; 
					   i++;
				       k++;
				}
		}
		else if(j < l2){
			while( j<l2){
				
				   outputArr[k] = array2[j]; 
				   j++;
			       k++;
			}
			
		}
		return outputArr;
	}
	
}
