package ds500problems.Interviews;
import java.util.Arrays;

import  ds500problems.array.ThreeWayPartition;
import ds500problems.matrix.MatrixProblems;
import ds500problems.recursion.RecursionBasedProblems;;
public class MicrosoftInterviews {

	public static void main(String[] args) {
		//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
		System.out.println(MatrixProblems.numberOfPaths(2, 3));
		System.out.println();
		//https://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/
		RecursionBasedProblems.printPattern(16, 16, -1);
		//Sort an array of 0s, 1s and 2s
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

		deutschNationFlagSort(A);
		System.out.println("deutschNationFlagSort");
		
		System.out.println(Arrays.toString(A));
	}
    //Sort an array of 0s, 1s and 2s
	public static int [] deutschNationFlagSort(int [] input){
		
		int start =0 , mid = 0;
		int end = input.length-1;
		int pivot = 1;
		while(mid <= end) {
			if(input[mid] < pivot) // current element is 
			  {
				ThreeWayPartition.swap(input, start, mid);
				  ++mid;
				  ++start;
				  
			}
			else if (input[mid] > pivot) {
				ThreeWayPartition.swap(input, mid, end);
				end--;
			}
			else {
				++mid;
			}
			  
			    
		}
		return input;
	}
	
}
