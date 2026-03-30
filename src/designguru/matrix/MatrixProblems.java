package designguru.matrix;

import java.util.concurrent.atomic.AtomicInteger;

public class MatrixProblems {

	public static void main(String[] args) {
		 int[][] grid = { { 1, 1, 0, 1, 1 },
                          { 1, 1, 0, 0, 0 },
                          { 0, 0, 0, 0, 1 },
                          { 1, 1, 1, 1, 1 }
                };
 
 System.out.println("The number of distinct Islands ="+countIslands(grid));
	}
	
	
	public static int countIslands(int [][] matrix) {
		int total_islands = 0;
		int max_so_far =0;
		for(int i =0 ; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 1) {//we found islands. fill it with  some color to avoid duplication..
					total_islands++;
					AtomicInteger area = new AtomicInteger(0);
					countIslands(matrix,i,j,area);
					if(max_so_far < area.get()) {
						max_so_far = area.get();
					}
				}
			}
		}
		System.out.println("max_so_far ="+max_so_far);
		return total_islands;
	}
	
    private  static void countIslands(int [][] matrix, int i ,int j,AtomicInteger area) {
		 if( i < 0 || i > matrix.length-1 || j < 0 || j > matrix[0].length-1) return;
		 if(matrix[i][j] == 0) return;
		 if(matrix[i][j] == 1) {
			 matrix[i][j]= 0;//fill it with water
			 area.set(area.get()+1);
		 }
		 //left move
		 countIslands(matrix, i,j-1,area);
		 //right move
		 countIslands(matrix, i,j+1,area);
		 //top/up move
		 countIslands(matrix, i-1,j,area);
		 countIslands(matrix, i+1,j,area);
		 //down move
	}
    
   

}
