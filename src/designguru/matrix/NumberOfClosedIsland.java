package designguru.matrix;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberOfClosedIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [][] matrix = new int[][] {
	            { 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 0 },
	            { 0, 1, 0, 1, 0 },
	            { 0, 1, 0, 0, 0 },
	            { 0, 0, 0, 0, 1 }
	        };
	System.out.println("The number of closed Islands = "+countClosedIslands(matrix));
	}
	
	 public static  int countClosedIslands(int[][] matrix) {

		    int rows = matrix.length;
		    int cols = matrix[0].length;
		    int totalIslands = 0;

		    for (int i = 0; i < rows; i++) {
		      for (int j = 0; j < cols; j++) {
		        if (matrix[i][j] == 1) { // only if the cell is a land
		          // we have found an island
		          totalIslands++;
		          AtomicBoolean isClosed = new AtomicBoolean(true);
		          System.out.println("isClosed ="+isClosed.get());
		          visitIslandDFS(matrix, i, j,totalIslands+1,isClosed);
		          System.out.println("isClosed ="+isClosed.get());
		          if(isClosed.get() != true){
		        	  totalIslands--;
		          }
		        }
		      }
		    }
		    return totalIslands;
		  }
		  

	  private static void visitIslandDFS(int[][] matrix, int x, int y,int islandNumber,AtomicBoolean isClosed) {
	    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
	    	isClosed.set(false);//since it is touching to boundary so it can't be a closed island ..
	    	return;
	    }
	    if (matrix[x][y] == 0 ||  matrix[x][y] != 1)
	      return; // return, if it is a water cell
        
	    matrix[x][y] = islandNumber; // mark the cell visited by making with island number,

	    // recursively visit all neighboring cells (horizontally & vertically)
	    visitIslandDFS(matrix, x + 1, y,islandNumber,isClosed); // lower cell
	    visitIslandDFS(matrix, x - 1, y,islandNumber,isClosed); // upper cell
	    visitIslandDFS(matrix, x, y + 1,islandNumber,isClosed); // right cell
	    visitIslandDFS(matrix, x, y - 1,islandNumber,isClosed); // left cell
	  }

}
