package designguru.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFilling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
		 System.out.println(Arrays.deepToString(
			        new int[][] {
			            { 0, 1, 1, 1, 0 },
			            { 0, 0, 0, 1, 1 },
			            { 0, 1, 1, 1, 0 },
			            { 0, 1, 1, 0, 0 },
			            { 0, 0, 0, 0, 0 }
			        }));

		 System.out.println("\n"+Arrays.deepToString(floodFill(
			        new int[][] {
			            { 0, 1, 1, 1, 0 },
			            { 0, 0, 0, 1, 1 },
			            { 0, 1, 1, 1, 0 },
			            { 0, 1, 1, 0, 0 },
			            { 0, 0, 0, 0, 0 }
			        }, 1, 3, 2)));

		 
		   System.out.println("\n second example");
		   
		   System.out.println(Arrays.deepToString(
			        new int[][] {
			            { 0, 0, 0, 0, 0 },
			            { 0, 0, 0, 0, 0 },
			            { 0, 0, 1, 1, 0 },
			            { 0, 0, 1, 0, 0 },
			            { 0, 0, 1, 0, 0 }
			        }));
		   
			    System.out.println("\n"+Arrays.deepToString(floodFill(
			        new int[][] {
			            { 0, 0, 0, 0, 0 },
			            { 0, 0, 0, 0, 0 },
			            { 0, 0, 1, 1, 0 },
			            { 0, 0, 1, 0, 0 },
			            { 0, 0, 1, 0, 0 }
			        }, 3, 2, 5)));
	}
	
	public static int[][] floodFill(int [][] matrix, int r,int c, int color){
		floodFillingDFS(matrix, r,c,matrix[r][c],color);
		return matrix;
	}
	  static void floodFillingDFS(int[][] matrix, int x, int y,int oldcolor,int color){
		 
			  if( x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
			  if(matrix[x][y] != oldcolor ) return;
			  matrix[x][y] = color;
			  floodFillingDFS(matrix, x+1,y,oldcolor,color);
			  floodFillingDFS(matrix, x-1,y,oldcolor,color);
			  floodFillingDFS(matrix, x,y+1,oldcolor,color);
			  floodFillingDFS(matrix, x,y-1,oldcolor,color);
			  
			  
		  }

}
