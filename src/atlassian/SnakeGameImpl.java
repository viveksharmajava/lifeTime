package atlassian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeGameImpl {

	public static void main(String[] args) {
     int m =  20;
     int n = 20;
     List< int []> snake = new ArrayList<>();
     snake.add(new int [] {4,3});
     snake.add(new int [] {4,4});
     snake.add(new int [] {4,5});
     System.out.println(snake);
     for(int [] arr : snake) {
    	 System.out.println(Arrays.toString(arr));
     }
     boolean gameOver = snakeMove(snake,m,n,"top");
     System.out.println("after move");
    // System.out.println(Arrays.toString(snake.toArray()));
     for(int [] arr : snake) {
    	 System.out.println(Arrays.toString(arr));
     }
     System.out.println(gameOver);
     gameOver = snakeMove(snake,m,n,"bottom");
    
     System.out.println("after move");
     for(int [] arr : snake) {
    	 System.out.println(Arrays.toString(arr));
     }
     
     System.out.println(gameOver);
     
     
	}
    int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	public static boolean snakeMove(List<int[]> snake , int rows ,int cols, String direction ) {
		//int [] direction = snake.getLast();
		int moves = 0;
		//int rows = board.length;
		//int cols = board[0].length;
		int[] lastPostion = snake.getLast();
		if("top".equalsIgnoreCase(direction)) {
			int i = lastPostion[0]-1;
			int j = lastPostion[1];
			
			if(gotHit(snake, i,j)) return true;
			moves++;
			if(i >=0 && i < rows) {
				if(moves == 5 ) moves = 0;
				else
					snake.removeFirst();
				
				snake.add(new int[] {i,j});
			}else if(i < 0){
				if(moves == 5 ) moves = 0;
				else snake.removeLast();
				
				snake.add(new int[] {rows-i,j});
			}
			
		}
		else if("bottom".equalsIgnoreCase(direction)) {
			int i = lastPostion[0]+1;
			int j = lastPostion[1];
			
			if(gotHit(snake, i,j)) return true;
			moves++;
			if(i >=0 && i < rows) {
				if(moves == 5 ) moves = 0;
				else
					snake.removeFirst();
				
				snake.add(new int[] {i,j});
			}else if(i >= rows){
				if(moves == 5 ) moves = 0;
				else snake.removeLast();
				snake.addFirst(new int[] {i-rows,j});
			}
		}
        else if("left".equalsIgnoreCase(direction)) {
        	int i = lastPostion[0];
			int j = lastPostion[1]-1;
			
			if(gotHit(snake, i,j)) return true;
			moves++;
			if(j >=0 ) {
				if(moves == 5 ) moves = 0;
				else
					snake.removeLast();
				
				snake.add(new int[] {i,j});
			}else if(j < 0){
				if(moves == 5 ) moves = 0;
				else snake.removeFirst();
				
				snake.add(new int[] {i,cols-j});
			}
		}
        else if("right".equalsIgnoreCase(direction)) {
        	int i = lastPostion[0];
			int j = lastPostion[1]+1;
			
			if(gotHit(snake, i,j)) return true;
			moves++;
			if(j < cols ) {
				if(moves == 5 ) moves = 0;
				else
					snake.removeFirst();
				
				snake.add(new int[] {i,j});
			}else if(j >= cols){
				if(moves == 5 ) moves = 0;
				else snake.removeFirst();
				
				snake.add(new int[] {i,j-cols});
			}
		}else {
			//invalid direction
		}
		
		return false;
	}
	
	private int  makeAMove(int moves ,List< int []> snake ,int rows ,int cols ,int i , int j) {
		if(i >=0 && i < rows) {
			if(moves == 5 ) moves = 0;
			else
				snake.removeFirst();
			
			snake.add(new int[] {i,j});
		}else if(i < 0){
			if(moves == 5 ) moves = 0;
			else snake.removeLast();
			
			snake.add(new int[] {rows-i,j});
		}
		return moves;
	}
	
	private static boolean gotHit(List< int []> snake  , int i ,int j){
		for(int [] position : snake) {
			if(position[0] == i && position[1] == j) return true;
		}
		return false;
	}
}
