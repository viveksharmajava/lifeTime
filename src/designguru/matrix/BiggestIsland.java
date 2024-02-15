package designguru.matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BiggestIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("maxAreaIsland = "+maxAreaIsland(new int[][] {
            { 1, 1, 1, 1, 1 },
            { 1, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
        }));

	}
	
	  public static  int maxAreaIsland(int[][] matrix) {

		    int rows = matrix.length;
		    int cols = matrix[0].length;
		    int totalIslands = 0;
             int max_area = 0;
		    for (int i = 0; i < rows; i++) {
		      for (int j = 0; j < cols; j++) {
		        if (matrix[i][j] == 1) { // only if the cell is a land
		          // we have found an island
		          totalIslands++;
		         // visitIslandDFS(matrix, i, j);
		          AtomicInteger area = new AtomicInteger(0);
		          visitIslandsBFS(matrix, i, j,area);
		          if(area.get() > max_area) max_area = area.get();
		        }
		      }
		    }
		    return max_area;
		  }
		  
		  private static void visitIslandsBFS(int[][] matrix, int x, int y,AtomicInteger area){
			  Queue < int [] > neighbours = new LinkedList<>();
			  neighbours.add(new int[]{x,y});
			  while(! neighbours.isEmpty()){
				  int row  = neighbours.peek()[0];
				  int col = neighbours.peek()[1];
				  neighbours.remove();
				  
				  if( row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) continue;
				  if(matrix[row][col] == 0) continue;
				  matrix[row][col] = 0;
				  area.set(area.get()+1);
				  neighbours.add(new int[]{row+1,col});
				  neighbours.add(new int[]{row-1,col});
				  neighbours.add(new int[]{row,col+1});
				  neighbours.add(new int[]{row,col-1});
				  
				  
			  }
		  }
}
