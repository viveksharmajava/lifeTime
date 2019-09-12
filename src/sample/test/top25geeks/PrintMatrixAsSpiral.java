package sample.test.top25geeks;

/**
 * 
 * @author viveksharma
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * Print a given matrix in spiral form
 * Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
	Output: 
	1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
 *
 */

public class PrintMatrixAsSpiral {

	public static void main(String[] args) {
		int R = 3; 
        int C = 6; 
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } }; 
        
        
        printSpiral(R, C, a);
        int b[][] = { { 1, 2, 3, 4},
        		      { 5, 6 ,7,8}, 
        		      {9,10,11,12},
        		      {13,14,15,16}
                   };
       System.out.println();
        printSpiral(4, 4, b);
	}
	public static void printSpiral(int m ,int n, int[][]input) {
		
		/*
		 *  k - starting row index 
			m - ending row index 
			l - starting column index 
			n - ending column index 
		 */
		
		int i , k=0, l =0;
		
		while(k < m && l < n) {
			
			// Print the first row from the remaining rows  
			
			for( i = l ; i < n ;i++) {
				System.out.print(input[k][i]+" ");
			}
			k++;
			//Print last column from remaining column
			
			for(i = k ; i < m ; i++) {
				System.out.print(input[i][n-1]+" ");
			}
			n--;
			
			//print last row from the remaining row
			if(k<m) {
				for(i= n-1; i >=l; i--) {
					System.out.print(input[m-1][i]+" ");
				}
				m--;
			}
			
			if( l < n) {
				for( i = m-1 ; i >= k; i--) {
					System.out.print(input[i][l]+" ");
				}
				l++;
				
			}
		}
	}

}
