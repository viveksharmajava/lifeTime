package designguru.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		int [][] matrix = new int[][] {
		            { 0, 1, 1, 1, 0 },
		            { 0, 0, 0, 1, 1 },
		            { 0, 1, 1, 1, 0 },
		            { 0, 1, 1, 0, 0 },
		            { 0, 0, 0, 0, 0 }
		        };
		System.out.println("The number of Islands = "+countIslands(matrix));
	}
	
	


/*
 *  Problem statement: Given a 2D array (i.e., a matrix) containing 
 *  only 1s (land) and 0s (water), count the number of islands in it.
	An island is a connected set of 1s (land) and is surrounded by either
 	an edge or 0s (water). Each cell is considered connected to other cells 
	horizontally or vertically (not diagonally).
 * 
*/

	  public static  int countIslands(int[][] matrix) {

	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    int totalIslands = 0;

	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        if (matrix[i][j] == 1) { // only if the cell is a land
	          // we have found an island
	          totalIslands++;
	         // visitIslandDFS(matrix, i, j);
	          visitIslandsBFS(matrix, i, j);
	        }
	      }
	    }
	    return totalIslands;
	  }
	  
	  private static void visitIslandsBFS(int[][] matrix, int x, int y){
		  Queue < int [] > neighbours = new LinkedList<>();
		  neighbours.add(new int[]{x,y});
		  while(! neighbours.isEmpty()){
			  int row  = neighbours.peek()[0];
			  int col = neighbours.peek()[1];
			  neighbours.remove();
			  
			  if( row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) continue;
			  if(matrix[row][col] == 0) continue;
			  matrix[row][col] = 0;
			  neighbours.add(new int[]{row+1,col});
			  neighbours.add(new int[]{row-1,col});
			  neighbours.add(new int[]{row,col+1});
			  neighbours.add(new int[]{row,col-1});
			  
			  
		  }
		  
		  
	  }

	  private static void visitIslandDFS(int[][] matrix, int x, int y) {
	    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
	      return; // return, if it is not a valid cell
	    if (matrix[x][y] == 0)
	      return; // return, if it is a water cell

	    matrix[x][y] = 0; // mark the cell visited by making it a water cell

	    // recursively visit all neighboring cells (horizontally & vertically)
	    visitIslandDFS(matrix, x + 1, y); // lower cell
	    visitIslandDFS(matrix, x - 1, y); // upper cell
	    visitIslandDFS(matrix, x, y + 1); // right cell
	    visitIslandDFS(matrix, x, y - 1); // left cell
	  }

	 
}
