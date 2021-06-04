package ds500problems.matrix;

import java.util.Arrays;
import java.util.List;

public class MatrixProblems {

	public static void main(String[] args) {
    System.out.println(numberOfPaths(2,3));
    System.out.println(numberOfPaths(2,2));
    int [][] input =  {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
	
    lowestMatchingElement(input);
    
	}
	
	/*
	 * Count all possible paths from top left to bottom right 
	 * of a mXn matrix
	 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	 *Input :  m = 2, n = 2;
		Output : 2
		There are two paths
		(0, 0) -> (0, 1) -> (1, 1)
		(0, 0) -> (1, 0) -> (1, 1)
		
		Input :  m = 2, n = 3;
		Output : 3
		There are three paths
		(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
		(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
		(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
	 */
	
	public static int numberOfPaths(int m , int n) {
		
		if( m== 1 || n == 1) return 1;
		return numberOfPaths(m-1,n) + numberOfPaths(m,n-1);
		//+numberOfPaths(m-1,n-1) if diagonal move allowed.
		
	}
 
 /*
  * given an MxN matrix where each row is sorted in ascending order.
  * Findout lowest matching element.
  * input  {{1,2,3,4,5}
  *         {2,4,5,8,10}
  *         {3,5,7,9,11}
  *         {1,3,5,7,9}
  *         }
  */

	public static void lowestMatchingElement(int [][] input) {
		int elem ;
		int row = input.length;
		int column = input[0].length;
		for(int c = 0 ; c < column ; c++) {
			elem = input[0][c];
			boolean matched = true;
			for(int j = 1 ; j < row ; j++) {
				boolean found = false;
			  if(elem == input[j][c]) continue;
			  else if(elem > input[j][c]) {
				  for (int k = c+1 ; k < column ; k++) {
					  if(elem == input[j][k]) {
						  found = true;
						  break;
					  }
				  }
			  } else {
				  
				  for (int k = c-1 ; k >=0  ; k--) {
					  if(elem == input[j][k]) {
						  found = true;
						  break;
					  }
				  }  
			  }
			  if(!found) {
				  matched = false;
				  break;
			  }
			}
		  if(matched) {
			  System.out.println("lowest common element is ="+elem);
		  }
		}
		
	}

}
