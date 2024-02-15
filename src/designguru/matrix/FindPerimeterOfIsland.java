package designguru.matrix;

public class FindPerimeterOfIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int mat[][] = {{0, 1, 0, 0, 0}, 
                {1, 1, 1, 0, 0}, 
                {1, 0, 0, 0, 0}};
                 
 System.out.println(findperimeter(mat));
	}
   

	  public static  int findperimeter(int[][] matrix) {

	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    int countribution = 0;

	    for (int i = 0; i < rows; i++) {
	      for (int j = 0; j < cols; j++) {
	        if (matrix[i][j] == 1) { // only if the cell is a land
	          // we have found an island
	         // totalIslands++;
	         // visitIslandDFS(matrix, i, j);
	          countribution += ( 4 -  numofneighbour(matrix, i, j));
	        }
	      }
	    }
	    return countribution;
	  }


	  static int numofneighbour(int mat[][], 
              int i, int j) 
	  {
		int C = mat[0].length;
		int R = mat.length;
		
		int count = 0;
		
		// UP
		if (i > 0 && mat[i - 1][j] == 1)
		count++;
		
		// LEFT
		if (j > 0 && mat[i][j - 1] == 1)
		count++;
		
		// DOWN
		if (i < R - 1 && mat[i + 1][j] == 1)
		count++;
		
		// RIGHT
		if (j < C - 1 && mat[i][j + 1] == 1)
		count++;
		
		return count;
	}
}
