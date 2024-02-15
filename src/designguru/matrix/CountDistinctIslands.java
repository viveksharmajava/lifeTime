package designguru.matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * https://www.geeksforgeeks.org/find-the-number-of-distinct-islands-in-a-2d-matrix/
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638c920fa19edaace544c805
 * {{1, 1, 0, 0, 0}, 
	1, 1, 0, 0, 0}, 
	0, 0, 0, 1, 1}, 
	0, 0, 0, 1, 1}
   }
 * 
 */
public class CountDistinctIslands {

	public static void main(String[] args) {
		// Given Inputs
	    int[][] grid = { { 1, 1, 0, 1, 1 },
	                    { 1, 0, 0, 0, 0 },
	                    { 0, 0, 0, 0, 1 },
	                    { 1, 1, 0, 1, 1 }
	                   };
	    
	    System.out.println("The number of distinct Islands ="+distinctIslands(grid));
	}
	  public static  int distinctIslands(int[][] matrix) {

		    int rows = matrix.length;
		    int cols = matrix[0].length;
		    int totalIslands = 0;
           int max_area = 0;
           HashMap <Integer,LinkedList <Pair> > islands = new  HashMap<Integer,LinkedList <Pair>  > ();
		    for (int i = 0; i < rows; i++) {
		      for (int j = 0; j < cols; j++) {
		        if (matrix[i][j] == 1) { // only if the cell is a land
		          // we have found an island
		         // totalIslands++;
		         // visitIslandDFS(matrix, i, j);
		          AtomicInteger area = new AtomicInteger(0);
		          visitIslandsBFS(matrix, i, j,area);
		          if(islands.containsKey(area.get())){
		        	  boolean isSame = false;
		        	  for(Pair p : islands.get(area.get())){
		        		  isSame=  symmatric( matrix, p.x,p.y,Math.abs(p.x-i),  i ,  j, Math.abs(p.y-j),new AtomicInteger(area.get()));
		        	      if(isSame ) break;
		        	  }
		        	 
		        	  if(!isSame){
		        	     totalIslands++;
		        	    islands.get(area.get()).add(new Pair(i,j));
		        	  }
		          }else{
		        	  totalIslands++;
		        	  if(!islands.containsKey(area.get())){
		        		  islands.put(area.get(),new LinkedList<Pair>());
		        	  }
		        	  islands.get(area.get()).add(new Pair(i,j));
		          }
		        }
		      }
		    }
		    return totalIslands;
		  }
		  
		  private static boolean symmatric(int[][] matrix,
			int r,int c, int val, int i, int j,int val2 , AtomicInteger size) {
			  if( size.get() == 0 ) return true;
			  
			  if( size.get() >0 && ( r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length 
		    	 ||  i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ) ) return false;
		     
		      if(Math.abs(r-i) == val && Math.abs(c-j)== val2 && matrix[i][j] == matrix[r][c] ){
		    	  size.set(size.get()-1);
		    	  
		      }
		     // else return false;
		      return symmatric(matrix,r+1,c,val,i+1,j,val2,size) ||  symmatric(matrix,r-1,c,val,i-1,j,val2,size) ||
		    		  symmatric(matrix,r,c+1,val,i,j+1,val2,size) ||  symmatric(matrix,r,c-1,val,i,j-1,val2,size);
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

class Pair{
	 int x, y;
	 Pair(int x, int y){
		 this.x = x;
		 this.y = y;
		 
}
}